package com.assoft.aspweb.service.common;

import java.util.HashMap;

import org.springframework.stereotype.Service;
/*aspWebCommon5.7*/
@Service
public class LocalElementIndexHandlerCustomService {

	
	private HashMap<String,String> appElementIndexHandlerMap=new HashMap<String, String>();
	
	
	
	public String loadCustomElementIndexHandlerName(String schemaName,String elementShortname) {
		String key=buildElementIndexKey(schemaName, elementShortname);
		return appElementIndexHandlerMap.get(key);
	}
	
	
	public void putCustomElementIndexHandlerName(String schemaName,String elementShortname,Class clazz) {
		String key=buildElementIndexKey(schemaName, elementShortname);
		String name=loadSimpleName(clazz);
		appElementIndexHandlerMap.put(key, name);
	}
	
	public int loadAppIndexHandlerSize() {
		return appElementIndexHandlerMap.size();
	}
	
	private String loadSimpleName(Class clazz) {
		String name=clazz.getSimpleName();
		char first=Character.toLowerCase(name.charAt(0));
		name=first+name.substring(1);
		return name;
	}
	
	private String buildElementIndexKey(String schemaName,String elementShortname) {
		String name="handler_"+schemaName+"_"+elementShortname;
		return name;
	}
}
