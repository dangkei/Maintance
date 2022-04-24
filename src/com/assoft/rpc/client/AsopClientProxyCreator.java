package com.assoft.rpc.client;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;



/**
 * 客户端的每个对象代理类的生成器
 * @author wzj
 *
 */
public abstract  class AsopClientProxyCreator {
         private  String serverUrl;//服务端web地址
         
      
        
         protected int timeout=10*1000*60;//超时时间 10分钟
         
         public  String gainServerUrl(){
        	 if(serverUrl==null){
        		 serverUrl=loadServerUrl();
        	 }
        	 return serverUrl;
         }
         
         
         public  abstract String loadServerUrl();
         
         public abstract String gainTransferType();
         
 
         /**
          * 获取代理类
          * @param clazz
          * @return
          */
         public <E>  E gainProxy(Class<E> clazz){
        	 
        	 String tranferType=gainTransferType();
        	 E proxy= (E)ClientDAO.gainProxy(tranferType,clazz.getName());
             if(proxy==null){
            	  proxy=(E) ClientDAO.generateProxy(tranferType,clazz,gainServerUrl(),timeout);
				
             }
             return proxy; 
         }
         
//         /**
//          * 获取代理类
//          * @param clazz
//          * @return
//          */
//         public  <E>  E gainJDKProxy(Class<E> clazz){
//        	 String url=gainServerUrl();
//        	
//        	 String tranferType=gainTransferType();
//        	 E proxy= (E)dao.gainProxy(tranferType,clazz.getName());
//             if(proxy==null){
//            	  proxy=(E)dao.generateJDKProxy(tranferType,clazz,timeout);
//				
//             }
//             return proxy; 
//         }
//         
//        
//         public <E>  E gainJDKPkProxy(Class<E> clazz){
//        	 
//        	 String tranferType=gainTransferType();
//        	 E proxy= (E)JDKPkClientDao.gainProxy(tranferType,clazz.getName());
//             if(proxy==null){
//            	  proxy=(E)JDKPkClientDao.generateJDKProxy(tranferType,clazz,gainServerUrl(),timeout);
//				
//             }
//             return proxy; 
//         }
         
       
}
