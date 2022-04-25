package com.assoft.doc.common.constant;

public class Constants {
	public static final String SUCCESS = "1";
	public static final String URGENCY_NORMAL = "3";//紧急程度  平件:3 急件:2 特急:1
	public static final String URGENCY_EMERGENCY = "2";//紧急程度  平件:3 急件:2 特急:1 
	public static final String URGENCY_EXTRA = "1";//紧急程度  平件:3 急件:2 特急:1 
	public static final String SCAN_FILE = "1";//是否是扫描文件  是:1 否:0 
	public static final String NOT_SCAN_FILE = "0";//是否是扫描文件  是:1 否:0 
	public static final String STATUS_HANDELING = "1";//状态  0:草稿 1:办理中 2:办理完成 3:归档 4:撤回 5:退回
	public static final String STATUS_DRAFT = "0";//状态  0:草稿 1:办理中 2:办理完成 3:归档 4:撤回 5:退回
	public static final String STATUS_COMPLETE = "2";//状态  0:草稿 1:办理中 2:办理完成 3:归档 4:撤回 5:退回
	public static final String STATUS_ARCHIVE = "3";//状态  0:草稿 1:办理中 2:办理完成 3:归档 4:撤回 5:退回
	public static final String STATUS_WITHDRAW = "4";//状态  0:草稿 1:办理中 2:办理完成 3:归档 4:撤回 5:退回
	public static final String STATUS_BACK = "5";//状态  0:草稿 1:办理中 2:办理完成 3:归档 4:撤回 5:退回
	public static final String STATUS_DEL ="9";//状态  0:草稿 1:办理中 2:办理完成 3:归档 4:撤回 5:退回 9:删除 
	public static final String STAFF_TYPE_ADMIN = "admin";//管理员
	public static final String STAFF_TYPE_SECURITY = "security";//机要员
	public static final String STAFF_TYPE_LEADER = "leader";//主管文书工作领导
	public static final String STAFF_TYPE_ORDINARY = "ordinary";//普通人员
	public static final String TODO_TAG_DOC= "公文";
	public static final String TODO_TAG_BRIEFING = "信息简报";
	public static final String TODO_TAG_MEETING = "会议通知";
	public static String SEND_DOC_TYPE_DEPT = "1";//发文类型  1:部门发文 2:人员发文 
	public static String SEND_DOC_TYPE_USER = "2";//发文类型  1:部门发文 2:人员发文 
	public static String TODO_TYPE_UNION = "1";//待办类型  0:非联合待办 1:联合待办 NOTE：1.非联合待办指的是，一人处理完毕后，该待办即消失2.联合待办指的是所有人处理完毕后，待办才消失
	public static String TODO_TYPE_NO_UNION = "0";//待办类型  0:非联合待办 1:联合待办 NOTE：1.非联合待办指的是，一人处理完毕后，该待办即消失2.联合待办指的是所有人处理完毕后，待办才消失
	public static final String DOC_TYPE_DOC = "doc";//公文类型：doc：公文；notice：通知；breif：简报
	public static final String DOC_TYPE_NOTICE = "meeting";//公文类型：doc：公文；meeting：会议通知；breifing：简报
	public static final String DOC_TYPE_BRIEFING = "briefing";//公文类型：doc：公文；meeting：会议通知；breifing：简报
	public static final String DOC_TYPE_REMIND = "remind";//二次提醒
	public static final String DOC_TYPE_FILE = "file";//公文类型：doc：公文；meeting：会议通知；breifing：简报
	public static final String RECEIVE_DOC_TYPE_RECEIVE = "1";//办文类型  1:收文 2:发文
	public static final String RECEIVE_DOC_TYPE_SEND = "2";//办文类型  1:收文 2:发文
	public static final String RECEIPT_DEFAULT = "0";//默认没有回执
	public static final String RECEIPT_SUCCESS = "1";//回执成功
	
	public static final String RECEIPT_TYPE_NO = "0";// 0:不回执 1:回执 2:强制回执 
	public static final String RECEIPT_TYPE_YES = "1";//0:不回执 1:回执 2:强制回执 
	public static final String RECEIPT = "1";//签收  1:已回执 0:未回执 
	public static final String UNRECEIPT = "0";//签收  1:已回执 0:未回执 
	
	
	public static final String SIGN = "1";//签收  1:已签收 0:未签收 
	public static final String UNSIGN = "0";//签收  1:已签收 0:未签收 
	public static final String BUTTTON_FINISH_NAME = "完成";
	public static final String BUTTTON_USERSELECT_NAME = "转交";
	public static final String BUTTTON_USERSELECT_GOV_NAME = "交报送科室";
	public static final String BUTTTON_BACK_NAME = "退回";
	public static final String BUTTTON_WITHDRAW_NAME = "撤回";
	public static final String FLOW_BRIEFING_RECV = "briefingReceive";
	public static final String FLOW_BRIEFING_SEND = "briefingSend";
	public static final String FLOW_MEETING_RECV = "meetingReceive";
	public static final String FLOW_MEETING_SEND = "meetingSend";
	public static final String FLOW_DOC_SEND = "docSend";
	public static final String FLOW_DOC_RECV = "docReceive";
	public static final String APPROVAL_NAME = "批办单";
	public static final String OPTYPE_DOC = "1";//处理"操作类型opType",opType （1：待办公文，2：已办公文； 3：待收文件； 4：已收文件；5：待收通知；6：已收通知；7：待收公告； 8：已收公告）
	public static final String OPTYPE_DOC_DONE = "2";//处理"操作类型opType",opType （1：待办公文，2：已办公文； 3：待收文件； 4：已收文件；5：待收通知；6：已收通知；7：待收公告； 8：已收公告）
	public static final String OPTYPE_MEETING = "5";//处理"操作类型opType",opType （1：待办公文，2：已办公文； 3：待收文件； 4：已收文件；5：待收通知；6：已收通知；7：待收公告； 8：已收公告）
	public static final String OPTYPE_MEETING_DONE = "6";//处理"操作类型opType",opType （1：待办公文，2：已办公文； 3：待收文件； 4：已收文件；5：待收通知；6：已收通知；7：待收公告； 8：已收公告）
	public static final String OPTYPE_BRIEFING = "9";//处理"操作类型opType",opType （1：待办公文，2：已办公文； 3：待收文件； 4：已收文件；5：待收通知；6：已收通知；7：待收公告； 8：已收公告）
	public static final String OPTYPE_BRIEFING_DONE = "10";//处理"操作类型opType",opType （1：待办公文，2：已办公文； 3：待收文件； 4：已收文件；5：待收通知；6：已收通知；7：待收公告； 8：已收公告）
//	public static final String OPTYPE_BRIEFING = "7";//处理"操作类型opType",opType （1：待办公文，2：已办公文； 3：待收文件； 4：已收文件；5：待收通知；6：已收通知；7：待收公告； 8：已收公告）
//	public static final String OPTYPE_BRIEFING_DONE = "8";//处理"操作类型opType",opType （1：待办公文，2：已办公文； 3：待收文件； 4：已收文件；5：待收通知；6：已收通知；7：待收公告； 8：已收公告）
	public static final String SIGN_STATUS_WITHDRAW = "2";//收文状态  1:已签收 0:未签收  2:已撤回；3：已退回
	public static final String SIGN_STATUS_YES = "1";//收文状态  1:已签收 0:未签收  2:已撤回；3：已退回
	public static final String SIGN_STATUS_NO = "0";//收文状态  1:已签收 0:未签收  2:已撤回；3：已退回
	public static final String SIGN_STATUS_BACK = "3";//收文状态  1:已签收 0:未签收  2:已撤回；3：已退回
	
	public static final String RECEIPT_STATUS_WITHDRAW = "2";//回执状态  1:已回执 0:未回执   2:已撤回；
	public static final String RECEIPT_STATUS_YES = "1";//回执状态  1:已回执 0:未回执   2:已撤回；
	public static final String RECEIPT_STATUS_NO = "0";//回执状态  1:已回执 0:未回执   2:已撤回；
	public static final String OPINION_HANDLING = "proposedOpinions";//拟办意见
	public static final String OPINION_LEADER = "leader";//区长
	public static final String OPINION_BRANCHLEADER = "branchLeader";//分管领导
	public static final String OPINION_DIRECTOR = "director";//科室主任
	public static final String RESEARCH_COMMONT = "1";//研提意见
	public static final String IS_APPROVAL_CONTENT_UNION = "0";//0 表示正文合并（批办单） 不涉及到相关文档的合并            1 表示正文合并以及相关文档的合并 以及批判断的合并
	public static final String IS_APPROVAL_RELATION_UNION = "1";//0 表示正文合并（批办单） 不涉及到相关文档的合并            1 表示正文合并以及相关文档的合并 以及批判断的合并
	public static final String ID_SPLIT_STR = ",";
	public static final String RECYCLE_STATUS_NORMAL = "0";//0：正常，1：删除
	public static final String RECYCLE_STATUS_REMOVE = "1";//0：正常，1：删除
	public static final String OPINION_SELECT_NAME = "对外转发";
	public static final String OPINION_RESEARCH_COMMENT_NAME = "研提意见";
	public static final String OPERATOR_TYPE_RESEARCH_COMMENT = "1";//操作类型  1:研提意见 2:对外转发 3:正常完成 名称
	public static final String OPERATOR_TYPE_SELECT = "2";//操作类型  1:研提意见 2:对外转发 3:正常完成 名称
	public static final String OPERATOR_TYPE_NORMAL = "3";//操作类型  1:研提意见 2:对外转发 3:正常完成 名称
	
	
	public static final String SMS_CONTNET_TODO_DOC = "您有新的【待办公文】，标题为《{0}》（{1}）";
	public static final String SMS_CONTNET_TODO_MEETING = "您有新的【会议通知】，标题为《{0}》（{1}）";
	public static final String SMS_CONTNET_TODO_BRIEFING = "您有新的【信息简报】，标题为《{0}》（{1}）";
	public static final String SMS_CONTNET_TODO_REMIND = "政府办提醒您，您有尚未反馈的【公文】，标题为《{0}》（{1}）";

	
	public static final String REMOVE_TYPE_TODO="todo";
	public static final String REMOVE_TYPE_DONE="done";
	
	public static final String THOROUGH_DEL_SUFFIX="_del";//彻底删除后缀
	
	public static final String DONE_DOC = "doneDoc";
	
	
	/*以下是操作日志需要用到的常量*/
	public static final String RECORD_MAP_METHOD_KEY="method";//方便知道走的哪个请求
	public static final String RECORD_MAP_ACTION_KEY="actionName";//自定义action，需要传参ationName
	public static final String RECORD_DOC_SEND="docSend";
	public static final String RECORD_DOC_RECEIVE="docReceive";
	public static final String RECORD_MEETING_SEND="meetingSend";
	public static final String RECORD_MEETING_RECEIVE="meetingReceive";
	public static final String RECORD_BRIEFING_SEND="briefingSend";
	public static final String RECORD_BRIEFING_RECEIVE="briefingReceive";
	public static final String RECORD_ACTION_FILESCAN="fileScan";
	public static final String RECORD_ACTION_FILESCAN_NAME="外来文件上传";
	public static final String RECORD_ACTION_CREATE_DRAFT="draftCreate";
	public static final String RECORD_ACTION_CREATE_DRAFT_NAME="草稿保存";
	public static final String RECORD_ACTION_UPDATE_DRAFT="draftUpdate";
	public static final String RECORD_ACTION_UPDATE_DRAFT_NAME="草稿更新";
	public static final String RECORD_ACTION_DEPT_DRAFT="draftSendDept";
	public static final String RECORD_ACTION_DEPT_DRAFT_NAME="草稿发送（单位）";
	public static final String RECORD_ACTION_USER_DRAFT="draftSendUser";
	public static final String RECORD_ACTION_USER_DRAFT_NAME="草稿发送（人员）";
	public static final String RECORD_ACTION_DEPT_CREATE="deptCreate";
	public static final String RECORD_ACTION_DEPT_CREATE_NAME="发文拟稿（单位）";
	public static final String RECORD_ACTION_USER_CREATE="userCreate";
	public static final String RECORD_ACTION_USER_CREATE_NAME="发文拟稿（人员）";
	public static final String RECORD_ACTION_FINISH="finish";
	public static final String RECORD_ACTION_FINISH_NAME="完成";
	public static final String RECORD_ACTION_DEPT_SELECT="deptSelect";
	public static final String RECORD_ACTION_DEPT_SELECT_NAME="转交单位";
	public static final String RECORD_ACTION_USER_SELECT="userSelect";
	public static final String RECORD_ACTION_USER_SELECT_NAME="转交人员";
	public static final String RECORD_ACTION_DEPT_TO_USER="deptToUser";
	public static final String RECORD_ACTION_DEPT_TO_USER_NAME="单位转内部收文";
	public static final String RECORD_ACTION_WITHDRAW="withdraw";
	public static final String RECORD_ACTION_WITHDRAW_NAME="撤回";
	public static final String RECORD_ACTION_BACK="back";
	public static final String RECORD_ACTION_BACK_NAME="退回";
	public static final String RECORD_ACTION_REMOVE_TODO_OR_DONE="removeTodoOrDone";
	public static final String RECORD_ACTION_REMOVE_TODO_OR_DONE_NAME="删除";
	public static final String RECORD_ACTION_RESTORE_TODO_OR_DONE="restoreTodoOrDone";
	public static final String RECORD_ACTION_RESTORE_TODO_OR_DONE_NAME="还原";
	public static final String RECORD_ACTION_REMOVE_THOROUGH="removeThorough";
	public static final String RECORD_ACTION_REMOVE_THOROUGH_NAME="彻底删除";
	public static final String RECORD_ACTION_UPDATE="update";
	public static final String RECORD_ACTION_UPDATE_NAME="更新";
	public static final String DEL_TYPE_REMOVE = "删除";
	public static final String DEL_TYPE_REMOVE_THOROUGH = "彻底删除";
	
	public static final String DEPT_TREE_KEY="tree:deptTree";
	public static final String USER_TREE_DEPTS_KEY="tree:userTree:depts:{0}";//通用型：人员列表中的部门集合:unitId
	public static final String USER_TREE_USERS_KEY="tree:userTree:users:{0}";//通用型：人员列表中的人员集合:unitId
	
	public static final String USER_TREE_CUSTOM_DEPTS_KEY="tree:userTreeCustom:depts:{0}";//自定义：人员列表中的部门集合 :loginName
	public static final String USER_TREE_CUSTOM_USERS_KEY="tree:userTreeCustom:users:{0}";//自定义：人员列表中的人员集合 :loginName
} 
