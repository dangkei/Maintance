package com.assoft.cloud.common.value;


/**
 * 桌面服务
 * @author wzj
 *
 */
public class DeskServiceItem extends DeskItem {
	
	
	private static final long serialVersionUID = 1L;
	
	private String imgPath;//图片路径
	private String id;//serviceId
	
	private String isNew;//新
	
	private boolean disabled=false;//没权限
	
	public DeskServiceItem(){
		this.type="service";
	}
	
	
	
	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getIsNew() {
		return isNew;
	}



	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}



	public boolean isDisabled() {
		return disabled;
	}



	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}



	


	

	

}
