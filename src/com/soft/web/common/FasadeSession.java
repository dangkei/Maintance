package com.soft.web.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/*模拟Session/序列化Session*/
public class FasadeSession  implements Serializable{


	private static final long serialVersionUID = 1L;
	
	Map<String, Serializable> map=new HashMap<String, Serializable>();
	


	public Serializable getAttribute(String attributeName) {
		return map.get(attributeName);
	}

	public void setAttribute(String attributeName,Serializable value) {
		map.put(attributeName, value);
	}

	
	
	
	
	


	
	

}
