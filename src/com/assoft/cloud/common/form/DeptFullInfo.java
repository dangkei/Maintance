package com.assoft.cloud.common.form;

import java.io.Serializable;
import java.util.List;

import com.assoft.cloud.common.schema.AschemaDept;

/**
 * 关于组织机构的全信息
 * @author wzj
 *
 */
public class DeptFullInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AschemaDept dept;
	
	private List<AschemaDept> fatherDepts;


	public AschemaDept getDept() {
		return dept;
	}


	public List<AschemaDept> getFatherDepts() {
		return fatherDepts;
	}


	public void setDept(AschemaDept dept) {
		this.dept = dept;
	}


	public void setFatherDepts(List<AschemaDept> fatherDepts) {
		this.fatherDepts = fatherDepts;
	}
	
	
	
	
	

}
