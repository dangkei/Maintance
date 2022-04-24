package com.assoft.doc.common.actionextend;

  import java.util.List;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.asopdomain.exchange.domain.AsopDomain;
import com.assoft.aspweb.common.value.UserProperty;
import com.assoft.cloud.common.schema.AschemaDept;
import com.assoft.cloudclient.common.AsopUser;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.form.TreeNode;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.flow.common.form.UserActivityInfo;
import com.assoft.flow.common.schema.AschemaActivityInstanceAction;
import com.assoft.giss.common.value.AssoftFileObj;
import com.soft.web.action.base.ConResponseListInfo;

import javax.servlet.http.HttpServletRequest;

public interface DocExtendAction {
  
	public ConResponseListInfo<AschemaDept> listDepts(AschemaDept condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ConResponseListInfo<TreeNode> listDepts(AschemaDept condition,PageInfo pageInfo);
	public ConResponseListInfo<TreeNode> listDeptsByCache(AschemaDept condition,PageInfo pageInfo);
	public ConResponseListInfo<TreeNode> listUsers(AsopUser condition,PageInfo pageInfo, String title);
	public ConResponseListInfo<TreeNode> listUsersForFlow(AsopUser condition,PageInfo pageInfo, String title, String activityId);

	public ConResponseListInfo<TreeNode> listUsersForFlow(AsopUser condition,PageInfo pageInfo, String title, String activityId, UserProperty userProperty);
	public ConResponseListInfo<TreeNode> listUsersForFlowCache(AsopUser condition,PageInfo pageInfo, String title, String activityId, UserProperty userProperty);

	
	public ActionResultInfo<UserActivityInfo> loadUserActivityInfo(String activityId, boolean start, UserProperty userProperty);

	public ConResponseListInfo<AschemaActivityInstanceAction> listInstanceActions(String activityInstanceId,
			List<String> flowStatues, UserProperty userProperty);
	
	public String loadUserInfo(String loginName);

	/**
	 * 收文撤回(包括公文，会议通知，信息简报)
	 * @param receiveId
	 * @param docType
	 * @param user
	 * @return
	 */
	public ActionResultInfo<String> withdraw(String receiveId, String docType, AsopUser user);

	/**
	 * 根据类型区更新公文（会议通知，信息简报）的创建时间
	 * @param id
	 * @param type docSend,docReceive,meetingSend,meetingReceive, briefingSend, briefingReceive
	 * @param createTime
	 * @return
	 */
	public ActionResultInfo<String> updateEntityForCreateTime(String id, String type, String createTime);
	/**
	 * 更新对象
	 * @param asopDomain
	 * @return
	 */
	public ActionResultInfo<AsopDomain> updateEntityForManual(AsopDomain asopDomain);
	
	/**
	 * 对于丢失domain_attr表进行修复
	 * @param asopDomain
	 * @return
	 */
	public ActionResultInfo<AsopDomain> saveDomainAttr(AsopDomain asopDomain);
	
	/**
	 * 目前用于，接口推送的文，重新构建一篇文，把该文删除掉
	 * @param sendId
	 * @param docType
	 * @param status
	 * @return
	 */
	public ActionResultInfo<String> updateSend(String sendId, String docType, String status);
	
	public ActionResultInfo<String> canSendDept(String contentId, String contentSchema);


	/**
	 * 附件预览
	 * @param fileObj
	 * @return
	 */
    ActionResultInfo<AssoftFileObj> docAttachView(AssoftFileObj fileObj);

	/**
	 * 二次提醒
	 * @param id
	 * @param asopUser
	 * @return
	 */
	ActionResultInfo<String> remind(String id, AsopUser asopUser);
	/**
	 * 督办
	 * @param id
	 * @param asopUser
	 * @return
	 */
	ActionResultInfo<String> supervise(String recever, String text,String docReceiveId, AsopUser asopUser);

	/**
	 * 流程附件预览
	 * @param fileObj
	 * @param request
	 * @return
	 */
	ActionResultInfo<AssoftFileObj> flowFileDownload(AssoftFileObj fileObj, HttpServletRequest request);

	public String loadTempFileDir();
}
