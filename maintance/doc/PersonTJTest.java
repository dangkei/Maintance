package doc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.assoft.asopUtil.common.tool.util.Utils;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.action.BriefingReceiveAction;
import com.assoft.doc.common.action.BriefingSendAction;
import com.assoft.doc.common.action.DocReceiveAction;
import com.assoft.doc.common.action.MeetingReceiveAction;
import com.assoft.doc.common.action.MeetingSendAction;
import com.assoft.doc.common.actionextend.DocSendExtendAction;
import com.assoft.doc.common.actionextend.DoneDocExtendAction;
import com.assoft.doc.common.constant.Constants;
import com.assoft.doc.common.schema.AschemaBriefingReceive;
import com.assoft.doc.common.schema.AschemaBriefingSend;
import com.assoft.doc.common.schema.AschemaDocReceive;
import com.assoft.doc.common.schema.AschemaDocSend;
import com.assoft.doc.common.schema.AschemaDoneDoc;
import com.assoft.doc.common.schema.AschemaMeetingReceive;
import com.assoft.doc.common.schema.AschemaMeetingSend;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.rpc.client.rmi.AsopRmiClientENV;
import com.soft.web.action.base.ConResponseListInfo;
/*
 * 统计个人一段时间内公文数量
 * */
public class PersonTJTest {
	
	//private static String NCLOUD_RMI_URL = "10.171.251.248:1065";
	private static String DOC_RMI_URL = "10.171.251.241:1070";
	//private static String FLOW_RMI_URL = "10.171.251.247:1064";
	//private static String TODO_RMI_URL = "10.171.251.242:1063";
	//private static String CHAPTER_RMI_URL = "10.171.251.229:1072";
	//private static String CAR_RMI_URL = "10.171.251.229:1073";
	//private static String LEAVE_RMI_URL = "10.171.251.63:1074";
	//private static String CONTRACT_RMI_URL = "10.171.251.229:1075";
	
	private static String START_DATE = "20201201";
	private static String END_DATE = "20201230";
	private static String loginName = "zhaoran5680";
	
//	@Test
//	public void test() throws IOException {
//		
//		Time();
//		
//	}
	public static void main(String[] args) {
		DocSendExtendAction docSendAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, DocSendExtendAction.class);
		DocReceiveAction docReceiveAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, DocReceiveAction.class);
		BriefingSendAction briefingSendAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, BriefingSendAction.class);
		BriefingReceiveAction briefingReceiveAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, BriefingReceiveAction.class);
		MeetingSendAction meetingSendAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, MeetingSendAction.class);
		MeetingReceiveAction meetingReceiveAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, MeetingReceiveAction.class);
		
		DoneDocExtendAction doneDocAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, DoneDocExtendAction.class);
		
		
		/**********/
		

		
		AschemaDocSend condition1 = new AschemaDocSend();
		AschemaDocReceive condition11 = new AschemaDocReceive();
		AschemaBriefingSend condition2 =new AschemaBriefingSend();
		AschemaBriefingReceive condition22 =new AschemaBriefingReceive();
		AschemaMeetingSend condition3 =new AschemaMeetingSend();
		AschemaMeetingReceive condition33 =new AschemaMeetingReceive();
		AschemaDoneDoc condition4 = new AschemaDoneDoc();
		
		condition1.setSendUser(Arrays.asList("zhaoran5680"));
		//condition1.setSendUserName(Arrays.asList("赵然5680"));
		condition11.setReceivedUser(Arrays.asList(loginName));
		condition2.setSendUser(Arrays.asList(loginName));
		condition22.setReceivedUser(Arrays.asList(loginName));
		condition3.setSendUser(Arrays.asList(loginName));
		condition33.setReceivedUser(Arrays.asList(loginName));
		condition4.setDocType("meeting");
		//condition4.setReceivedUser(Arrays.asList("zhaoran5680"));
		
		
		
		ConResponseListInfo<AschemaDocSend> docConResponseListInfo2 = docSendAction.listDocSends(condition1, new PageInfo(10), buildTimeParam(START_DATE,END_DATE));
		ConResponseListInfo<AschemaBriefingSend> briefingConResponseListInfo2 = briefingSendAction.listBriefingSends(condition2, new PageInfo(10), buildTimeParam(START_DATE,END_DATE));
		ConResponseListInfo<AschemaMeetingSend> meetingConResponseListInfo2 = meetingSendAction.listMeetingSends(condition3, new PageInfo(10), buildTimeParam(START_DATE,END_DATE));
		
		ConResponseListInfo<AschemaDocReceive> docConResponseListInfo1 = docReceiveAction.listDocReceives(condition11, new PageInfo(10), buildTimeParam(START_DATE,END_DATE));
		ConResponseListInfo<AschemaBriefingReceive> briefingConResponseListInfo1 = briefingReceiveAction.listBriefingReceives(condition22, new PageInfo(10), buildTimeParam(START_DATE,END_DATE));
		ConResponseListInfo<AschemaMeetingReceive> meetingConResponseListInfo1 = meetingReceiveAction.listMeetingReceives(condition33, new PageInfo(10), buildTimeParam(START_DATE,END_DATE));
		
		ConResponseListInfo<AschemaDoneDoc> doneConResponseListInfo = doneDocAction.listDoneDocs(condition4, new PageInfo(10), buildTimeParam(START_DATE,END_DATE));
		
		
		
		System.out.println("12月份：");
		System.out.println("公文Send："+docConResponseListInfo2.getPageInfo().getTotalContentNum());
		System.out.println("会议Send："+meetingConResponseListInfo2.getPageInfo().getTotalContentNum());
		System.out.println("简报Send："+briefingConResponseListInfo2.getPageInfo().getTotalContentNum());
		System.out.println("公文Receive："+docConResponseListInfo1.getPageInfo().getTotalContentNum());
		System.out.println("会议Receive："+meetingConResponseListInfo1.getPageInfo().getTotalContentNum());
		System.out.println("简报Receive："+briefingConResponseListInfo1.getPageInfo().getTotalContentNum());
		/**/
		
		System.out.println("已办："+doneConResponseListInfo.getPageInfo().getTotalContentNum());
		
		
	}
	
	private static AsopQueryRequestParam buildTimeParam(String startTime,String endTime) {
		startTime=startTime+"000000";
		endTime=endTime+"240000";
		AsopQueryRequestParam param = AsopQueryRequestParam.buildDefaultTextParam("name", "-1");
		
		AsopQueryRequestParam p1 = new AsopQueryRequestParam();
		p1.setName("createTime");
		p1.setOccur(AsopQueryRequestParam.OCCUR_MUST);
		p1.setType("number");
		
		if(Utils.isEmpty(startTime)) {
			p1.setMin(Double.MIN_VALUE);
		}else {
			p1.setMin(Double.parseDouble(startTime));
		}
	
		p1.setMinInclusive(true);
		
		if(Utils.isEmpty(endTime)) {
			p1.setMax(Double.MAX_VALUE);
		}else {
			p1.setMax(Double.parseDouble(endTime));
		}
	
		p1.setMaxInclusive(false);
		
		param.addParam(p1, AsopQueryRequestParam.OCCUR_MUST);
		return param;
	}
}
