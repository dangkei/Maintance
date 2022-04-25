package com.assoft.cloud.common.actionextend;

import java.util.List;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.cloud.common.schema.AschemaConfigData;

public interface ConfigDataExtendAction {

	/**
	 * 列出全部配置数据
	 * @return
	 */
	public List<AschemaConfigData> listAllConfigDatas();
	
	/**
	 * 导入配置数据
	 * @param configDatas
	 * @return
	 */
	public ActionResultInfo<String> importConfigDatas(List<AschemaConfigData> configDatas);
	
	public String appName();
}
