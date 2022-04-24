package com.assoft.aspweb.service.cache;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asopdomain.exchange.common.Utils;
import com.assoft.asopUtil.common.tool.util.ObjectSerializer;
import com.assoft.asopUtil.common.tool.util.jedis.RedisUtil;

import com.assoft.aspweb.service.bussiness.AppCataService;
import com.assoft.aspweb.service.common.LocalService;
import com.soft.cms.spring.SpringContext;
import com.soft.web.common.FasadeSession;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * session的redis服务
 * @author wzj
 */
@Service
public class SessionRedisService {
	JedisPool pool = null;  
	
	private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    public static final String REDIS_LOCK_KEY="REDIS_LOCK_KEY";
	
	@Autowired
	LocalService localService;
	
	
	@Autowired
	AppCataService appCataService;
	
	/**
	    * 初始化redis
	 */
	public void init() {
		Map<String, String> configMap=localService.gainConfig().getRedisMap();
		if(configMap!=null) {
			initPool(configMap);
		}	
	}
	
	
	/**
	 * 根据属性名获取会话值
	 * @param request
	 * @param attrName
	 * @return
	 */
	public Object loadAttrFromSession(HttpServletRequest request,String attrName) {
		String tokenName="asop_redis_token";
		String token=request.getParameter(tokenName);
		if(token==null) {
			HttpSession httpSession=localService.gainSession(request);
			if(httpSession!=null) {
				token=(String)httpSession.getAttribute(tokenName);
				if(Utils.isEmpty(token)) {
					return httpSession.getAttribute(attrName);
				}
			}
		}else {
			request.getSession().setAttribute(tokenName, token);//设置token
		}

		FasadeSession fasadeSession=getSessionByToken(token);
		if(fasadeSession!=null) {
			 return fasadeSession.getAttribute(attrName);
		}
		return null;
	}
	
	
	
	/**
	 * @param request
	 * @param attrName
	 * @param object
	 */
	public void setAttrToSession(HttpServletRequest request,String attrName,Serializable object) {
		String token=request.getParameter("asop_redis_token");
		if(token==null) {
			 request.getSession().setAttribute(attrName, object);
			 return;
		}
		SessionRedisService sessionRedisService=SpringContext.getClassNameLowerService(SessionRedisService.class);
		sessionRedisService.gainSession(request).setAttribute(attrName, object);
	}
	

	/**
	   *        根据token获取共享session
	 * @param token
	 * @return
	 */
	public FasadeSession  getSessionByToken(String token){
		if (pool == null) {
			return null;
		}
		return (FasadeSession) getObj(token);
	}
	
	
	public String putSession2Redis(String token,FasadeSession session) {

		session.setAttribute("redis_token", token);
		setObj(token, session);
		return token;
		
	}
	
	
	public FasadeSession gainSession(HttpServletRequest request) {
		if(pool==null) {
			return null;
		}
		String token=gainToken(request);
        FasadeSession session=null;
        if(Utils.isEmpty(token)) {
        	return null;
        }else if(token.startsWith("redis_")) {
        	session=getSessionByToken(token);
        }
        return session;
     
	}
	
	
	
	
	
	
	
	 /**
     * 尝试获取分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    private  boolean tryGetDistributedLock(String lockKey, String requestId, int expireTime) {
    	if(pool==null) {
    		return false;
    	}
    	Jedis jedis=pool.getResource();
          //2.9.0版本
        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        //3.0.1版本
    	//String result = jedis.set(lockKey, requestId,SetParams.setParams().nx().px(expireTime));
    	
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
 
    }
    
    
    
private static final Long RELEASE_SUCCESS = 1L;
    
    /**
     * 释放分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public  boolean releaseDistributedLock(String lockKey, String requestId) {
    	Jedis jedis=pool.getResource();
    	try{
 
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
 
        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }}catch (Exception e) {
			// TODO: handle exception
		}finally {
			//返还到连接池  
			RedisUtil.returnResource(pool, jedis);  
		}
        return false;
 
    }
 
	
	
	private Object  getFasadeSessionAttr(HttpServletRequest request,String attrName){
		 FasadeSession session=gainSession(request);
		 if(session!=null) {
			 return session.getAttribute(attrName);
		 }
		 return null;
		 
	}
	
	
	
	
public void putSessionAttr(HttpServletRequest request,String attrName,Serializable value) {
		  String name=attrName;
		  if(pool==null) {
			  FasadeSession session=gainSession(request);
			  session.setAttribute(name, value);
			  return;	
		  }
		 
		  putSession2Redis(request, name, value);
	}
	
	
	private void putSession2Redis(HttpServletRequest request,String name,Serializable value) {
		 String requestId=UUID.randomUUID().toString();

		  String token=gainToken(request);
		//取锁
		  while(true) {
				
				 if(tryGetDistributedLock(token, requestId, 10*1000	)){
						break;
				  }
		   }
		  
		  //
		  FasadeSession session=gainSession(request);
			
			  session.setAttribute(name, value);
		  
		  
		   setObj(token, value);
		   
		  releaseDistributedLock(token, requestId);
	}
	
	
	
	
	
	
	
	private String gainToken(HttpServletRequest request) {
		String token=request.getParameter("asop_redis_token");
		return token;
	}


	/**
	 * 通过key获取value值
	 * @param key 键
	 * @return
	 */
	private  Object getObj(String key){
        Jedis jedis = null; 
      
        try { 
        	Object result=null;
            jedis = pool.getResource();  
            byte[] cons=jedis.get(key.getBytes("UTF-8"));
            if(cons!=null){
            	result=ObjectSerializer.readObj(cons);
            }
            return result;
        } catch (Exception e) {  
			// 释放redis对象
			if(pool!=null){
				pool.returnBrokenResource(jedis);
			}
            e.printStackTrace();  
        } finally {  
            //返还到连接池  
            RedisUtil.returnResource(pool, jedis);  
        }  
		return null;
	}
	
	
	
	private  void initPool(Map<String, String> configMap) {
    	try{
    	  JedisPoolConfig config = new JedisPoolConfig();  
          //控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；  
          config.setMaxIdle(1024); 
          config.setMaxTotal(1024);
          config.setMinIdle(20);
          //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；  
          config.setMaxWaitMillis(1000 * 10);  
          //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；  
          config.setTestOnBorrow(true);
          String masterUrl = configMap.get("redis.host");
			String masterPort = configMap.get("redis.port");
			String password = configMap.get("redis.password");
          //String masterUrl = "192.168.1.247";
          /*String masterUrl = "127.0.0.1";
			String masterPort = "6379";
			String password = "assoft";*/
			
			 int timeOut = 1000;
			  int dataBase = 0;
			
			
          pool = new JedisPool(config, masterUrl, Integer.parseInt(masterPort), timeOut, password, dataBase); 
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
		
	}
	
	/**
	 * 根据key设置value值并设置一定的期限
	 * @param key 键
	 * @param value 值
	 * @param expireSencond 过期期限（单位：s）
	 */
	public  void setObj(String key, Object value){
        Jedis jedis = null;  
        try {  
            jedis = pool.getResource(); 
            byte[] cons=ObjectSerializer.write(value);
            jedis.set(key.getBytes("UTF-8"), cons);
            //jedis.set(key, value);
        } catch (Exception e) {  
			// 释放redis对象
			if(pool!=null){
				pool.returnBrokenResource(jedis);
			}
            e.printStackTrace();  
        } finally {  
            //返还到连接池  
            RedisUtil.returnResource(pool, jedis);  
        }  
	}
	

}
