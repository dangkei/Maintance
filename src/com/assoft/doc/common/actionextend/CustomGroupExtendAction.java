package com.assoft.doc.common.actionextend;


import java.util.List;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.cloudclient.common.AsopUser;
import com.assoft.doc.common.form.TreeNode;
import com.assoft.doc.common.schema.AschemaCustomGroup;
import com.soft.web.action.base.ConResponseListInfo;

public interface CustomGroupExtendAction {
	
	public ActionResultInfo<ConResponseListInfo<TreeNode>> listCustomGroups(AschemaCustomGroup condition,PageInfo pageInfo,AsopUser user);
	
	public ActionResultInfo<ConResponseListInfo<AschemaCustomGroup>> listCustomGroups(ConditionDomainSchema<AschemaCustomGroup> condition,PageInfo pageInfo);
	
	public ActionResultInfo<AschemaCustomGroup> loadCustomGroup(String id);
	
	public ActionResultInfo<AschemaCustomGroup> saveNewCustomGroup(AschemaCustomGroup entity);
	
	public ActionResultInfo<String> updateCustomGroupName(AschemaCustomGroup entity);
	
	public ActionResultInfo<String> updateCustomGroupList(String id, List<String> list,String groupType);

	public ActionResultInfo<String> removeCustomGroupList(String id, List<String> list, String groupType);
	
}
