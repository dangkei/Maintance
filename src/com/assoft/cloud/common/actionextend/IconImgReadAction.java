package com.assoft.cloud.common.actionextend;

/**
 * 读默认图片
 * @author wzj
 *
 */
public interface IconImgReadAction {

	public String readFilePath(String icon);
	
	public String readGroupTypeImgPath(String icon);
	
	/**
	 * 皮肤
	 * @param icon
	 * @return
	 */
	public String readSkinImgPath(String icon);
}
