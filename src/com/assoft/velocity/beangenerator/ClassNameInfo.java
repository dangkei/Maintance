package com.assoft.velocity.beangenerator;

import java.io.Serializable;

/**
 * 生产的java类的信息
 * @author wzj
 *
 */
public class ClassNameInfo implements Serializable {


	
	private String pkgName;//java 的包名
	
	private String className;//类名

	public String getPkgName() {
		return pkgName;
	}

	public void setPkgName(String pkgName) {
		this.pkgName = pkgName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	
	
}
