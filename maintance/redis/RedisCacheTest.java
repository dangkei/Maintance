package redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import com.assoft.asopUtil.common.tool.util.jedis.RedisUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisCacheTest {

	static Map<String, String> keyMap = new HashMap<String, String>();

	public static void main(String[] args) {
		initPool();
		//keys("tree:deptTree");
		//keys("userAgents:loginName:chenlin");
		delKey("tree:deptTree");								// 清部门地址树缓存
		
		//delKey("tree:userTreeCustom:depts:jinyan");    	//{0} 自定义：人员列表中的部门集合 :loginName
		//delKey("tree:userTreeCustom:users:liubin3387");
		//delKey("userAgents:loginName:wanghui");    		//{0} 更新收文员 :loginName

		delKey("tree:userTree:depts:1152477542657331202");    //{0} 通用型：人员列表中的部门集合:unitId
		delKey("tree:userTree:users:1152477542657331202");  //
		//delKey("app:doc:com.assoft.giss.common.entity.AsopCata:1260497931354542082");// 精确删除
		//delKey("app:doc:com.assoft.giss.common.entity.AsopCata:1260445205262249986");//精确删除
		// delkeys(key);//模糊删除
		// keys(key);//模糊查询
		pool.close();
		
		LinkedList l ;
		
		ArrayList b ;
		Vector a ;
	}


	private static int timeOut = 5000;
	private static int dataBase = 0;
	private static JedisPool pool = null;
	
	@SuppressWarnings("deprecation")
	public static void delKey(String key) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			System.out.println(jedis.exists(key));
			jedis.del(key);
	
			System.out.println(jedis.exists(key));
			System.out.println("*********end********");

		} catch (Exception e) {
			// 释放redis对象
			if (pool != null) {
				pool.returnBrokenResource(jedis);
			}
			e.printStackTrace();
		} finally {
			// 返还到连接池
			RedisUtil.returnResource(pool, jedis);
		}

	}

	@SuppressWarnings("deprecation")
	public static void keys(String key) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			Set<String> set = jedis.keys("*" + key + "*");
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				String keyStr = it.next();
				System.out.println(jedis.get(keyStr));

			}
			System.out.println("*********end********");

		} catch (Exception e) {
			// 释放redis对象
			if (pool != null) {
				pool.returnBrokenResource(jedis);
			}
			e.printStackTrace();
		} finally {
			// 返还到连接池
			RedisUtil.returnResource(pool, jedis);
		}

	}

	@SuppressWarnings("deprecation")
	public static void delkeys(String key) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			Set<String> set = jedis.keys("*" + key + "*");
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				String keyStr = it.next();
				System.out.println(jedis.exists(keyStr));
				jedis.del(keyStr);
				System.out.println(jedis.exists(keyStr));

			}
			System.out.println("*********end********");

		} catch (Exception e) {
			// 释放redis对象
			if (pool != null) {
				pool.returnBrokenResource(jedis);
			}
			e.printStackTrace();
		} finally {
			// 返还到连接池
			RedisUtil.returnResource(pool, jedis);
		}

	}

	/**
	 * 根据key设置value值
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 */
	@SuppressWarnings("deprecation")
	public static void set(String key, String value) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = RedisUtil.getPool();
			jedis = pool.getResource();
			jedis.set(key, value);
		} catch (Exception e) {
			// 释放redis对象
			if (pool != null) {
				pool.returnBrokenResource(jedis);
			}
			e.printStackTrace();
		} finally {
			// 返还到连接池
			returnResource(pool, jedis);
		}
	}

	/**
	 * 返还到连接池
	 * 
	 * @param pool
	 * @param redis
	 */
	@SuppressWarnings("deprecation")
	public static void returnResource(JedisPool pool, Jedis redis) {
		if (redis != null && pool != null) {
			pool.returnResource(redis);
		}
	}


	public static void initPool() {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			// 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
			config.setMaxIdle(1024);
			config.setMaxTotal(1024);
			config.setMinIdle(20);
			// 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
			config.setMaxWaitMillis(1000 * 10);
			// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
			config.setTestOnBorrow(true);
			/*
			 * String masterUrl = configMap.get("redis.host"); String masterPort
			 * = configMap.get("redis.port"); String password =
			 * configMap.get("redis.password");
			 */
			// String masterUrl = "192.168.1.247";
			//String masterUrl = "10.171.251.241";
			String masterUrl = "192.12.200.109";
			String masterPort = "6379";
			String password = "assoft";

			// System.out.println("masterUrl=" + masterUrl + "***masterPort=" +
			// masterPort + "****password=" + password);
			pool = new JedisPool(config, masterUrl,
					Integer.parseInt(masterPort), timeOut, password, dataBase);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
