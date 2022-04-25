package com.assoft.aspweb.action.webmain;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.asopdomain.exchange.common.Utils;

public class MySessionContext {

	  private static MySessionContext instance;  
      private HashMap<String,HttpSession> sessionMap;  

      private MySessionContext() {  
          sessionMap = new HashMap<String,HttpSession>();  
      }  

      public static MySessionContext getInstance() {  
          if (instance == null) {  
              instance = new MySessionContext();  
          }  
          return instance;  
      }  

      public synchronized void addSession(String token,HttpSession session) {  
          if (session != null&&!Utils.isEmpty(token)) {  
        	  session.setAttribute("token", token);
              sessionMap.put(token, session);  
          }  
      }  

      public synchronized void delSession(HttpSession session) {  
          if (session != null) {
        	  String token=(String)session.getAttribute("token");
        	  if(token!=null)
              sessionMap.remove(token);  
          }  
      }  

      public synchronized HttpSession getSession(String sessionID) {  
          if (sessionID == null) {  
              return null;  
          }  
          return sessionMap.get(sessionID);  
      }  

  }  


