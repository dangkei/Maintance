package com.assoft.velocity.beangenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BeanGeneratorBaseInfo implements Serializable{
	
	
	
	public BeanGeneratorBaseInfo(String rootPath,String pkgName,String className){
	    classNameInfo=new ClassNameInfo();
		classNameInfo.setClassName(className);
		classNameInfo.setPkgName(pkgName);
		this.rootPath=rootPath;
	}
	
	
	private String rootPath;

	private ClassNameInfo classNameInfo;//类名字信息
	
	private List<BeanVariable> vaList=new ArrayList<BeanVariable>();  //类属性列表

	
	
	public GeneratorBaseInfo buildGeneratorBaseInfo(String velocityCon){
		GeneratorBaseInfo baseInfo=new GeneratorBaseInfo();
		baseInfo.setClassNameInfo(classNameInfo);
		baseInfo.setRootPath(rootPath);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("vaList", vaList);
		baseInfo.setParams(map);
		baseInfo.setVelocityCon(velocityCon);
		
		return baseInfo;
		
	}
	
	
	/**
	 * 添加String类型变量
	 * @param name
	 * @param des
	 */
	public void appendStringVa(String name,String des){
		if(!isEmpty(name)){
			BeanVariable bv=JavaBeanGeneartorUtil.buildStringVariable(name,des);
			vaList.add(bv);
		}
	
	}
	
	/**
	 * 添加int类型变量
	 * @param name
	 * @param des
	 */
	public void appendIntVa(String name,String des){
		if(!isEmpty(name)){
			BeanVariable bv=JavaBeanGeneartorUtil.buildIntegerVariable(name,des);
			vaList.add(bv);
		}
	}
	
	/**
	 * 添加List<String>类型变量
	 * @param name
	 * @param des
	 */
	public void appendListStringVa(String name,String des){
		if(!isEmpty(name)){
			BeanVariable bv=JavaBeanGeneartorUtil.buildListStringVariable(name,des);
			vaList.add(bv);
		}
	}
	
	/**
	 * 添加javaBean变量
	 * @param bv
	 */
	public void appendVa(BeanVariable bv){
		if(bv!=null){
			vaList.add(bv);
		}
	}
	
	
	private boolean isEmpty(String str){
		return str == null || str.trim().length() <= 0;
	}
	

	public ClassNameInfo getClassNameInfo() {
		return classNameInfo;
	}

	public void setClassNameInfo(ClassNameInfo classNameInfo) {
		this.classNameInfo = classNameInfo;
	}

	


	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}
	
	
}
