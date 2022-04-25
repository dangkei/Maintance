package com.assoft.doc.common.actionextend;


import java.util.List;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.aspweb.common.value.UserProperty;
import com.assoft.cloud.common.schema.AschemaUser;
import com.assoft.cloudclient.common.AsopUser;
import com.assoft.doc.common.form.TreeNode;
import com.assoft.doc.common.schema.AschemaPersonTree;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.soft.web.action.base.ConResponseListInfo;

public interface PersonListExtendAction {

	public List<TreeNode> listDeptsByFatherDn(String faterDn);
	
	public ConResponseListInfo<AschemaUser> listUsersByCurrDept(AsopUser condition,PageInfo pageInfo,String title,UserProperty userProperty);


	ActionResultInfo<AschemaPersonTree> saveNewPersonTree(AsopUser user, AschemaPersonTree entity);
	
	
	public ConResponseListInfo<TreeNode> listUsers(AsopUser condition,PageInfo pageInfo, String title,UserProperty userProperty);
	
	public ActionResultInfo<ConResponseListInfo<AschemaPersonTree>> listPersonTrees(ConditionDomainSchema<AschemaPersonTree> condition,PageInfo pageInfo);

	ConResponseListInfo<TreeNode> viewTree(AsopUser user, AschemaPersonTree entity);

	ActionResultInfo<String> remove(String createLoginName);

	public ActionResultInfo<String> defaultSet(AsopUser gainSessionUser);
	
	public ActionResultInfo<AschemaPersonTree> loadSet(AsopUser asopUser);
	
	public void updateTree(String loginName);
	
}
