package doc;

import com.assoft.asopUtil.common.tool.util.Utils;
import com.assoft.car.common.action.CarAction;
import com.assoft.car.common.schema.AschemaCar;
import com.assoft.chapter.common.action.ChapterAction;
import com.assoft.chapter.common.schema.AschemaChapter;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.contract.common.action.ContractAction;
import com.assoft.contract.common.schema.AschemaContract;
import com.assoft.doc.common.action.BriefingSendAction;
import com.assoft.doc.common.action.DocSendAction;
import com.assoft.doc.common.action.MeetingSendAction;
import com.assoft.doc.common.schema.AschemaBriefingSend;
import com.assoft.doc.common.schema.AschemaDocSend;
import com.assoft.doc.common.schema.AschemaMeetingSend;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.fileTransfer.common.action.FileTransferAction;
import com.assoft.fileTransfer.common.schema.AschemaFileTransfer;
import com.assoft.hotline.common.action.HotlineSendAction;
import com.assoft.hotline.common.schema.AschemaHotlineSend;
import com.assoft.leave.common.action.LeaveAction;
import com.assoft.leave.common.schema.AschemaLeave;
import com.assoft.rpc.client.rmi.AsopRmiClientENV;
import com.soft.web.action.base.ConResponseListInfo;
/*
 * 统计所有公文数量
 * */
public class StatisticsAllByDate {

	// private static String NCLOUD_RMI_URL = "10.171.251.248:1065";
	// private static String DOC_RMI_URL = "10.171.251.241:1070";
	private static String DOC_RMI_URL = "http:192.12.200.109:8081/doc";
	// private static String FLOW_RMI_URL = "10.171.251.247:1064";
	// private static String TODO_RMI_URL = "10.171.251.242:1063";
	// private static String CHAPTER_RMI_URL = "192.12.200.116:1072";
	private static String CHAPTER_RMI_URL = "http:192.12.200.116:8082/chapter";
	private static String CAR_RMI_URL = "http:192.12.200.116:8081/car";
	private static String LEAVE_RMI_URL = "http:192.12.200.108:8084/leave";
	private static String CONTRACT_RMI_URL = "http:192.12.200.116:8083/contract";
	private static String FILE_RMI_URL = "http:192.12.200.108:8081/fileTransfer";
	private static String HOTLINE_RMI_URL = "http:192.12.200.108:8083/hotline";

	private static String START_DATE = "20210901";
	private static String END_DATE = "20210930";

//	@Test
//	public void test() throws IOException {		
//		Time();
//	}
	public static void main(String[] args) {
		DocSendAction docSendAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, DocSendAction.class);
		BriefingSendAction briefingSendAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, BriefingSendAction.class);
		MeetingSendAction meetingSendAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, MeetingSendAction.class);
		/**********/

		ChapterAction chapterAction = AsopRmiClientENV.gainRemoteProxy(CHAPTER_RMI_URL, ChapterAction.class);
		CarAction carAction = AsopRmiClientENV.gainRemoteProxy(CAR_RMI_URL, CarAction.class);
		LeaveAction leaveAction = AsopRmiClientENV.gainRemoteProxy(LEAVE_RMI_URL, LeaveAction.class);
		ContractAction contractAction = AsopRmiClientENV.gainRemoteProxy(CONTRACT_RMI_URL, ContractAction.class);
		FileTransferAction fileTransferAction = AsopRmiClientENV.gainRemoteProxy(FILE_RMI_URL,
				FileTransferAction.class);
		HotlineSendAction hotLineAction = AsopRmiClientENV.gainRemoteProxy(HOTLINE_RMI_URL, HotlineSendAction.class);

		ConResponseListInfo<AschemaDocSend> docConResponseListInfo2 = docSendAction.listDocSends(new AschemaDocSend(),
				new PageInfo(10), buildTimeParam(START_DATE, END_DATE));
		ConResponseListInfo<AschemaBriefingSend> briefingConResponseListInfo2 = briefingSendAction
				.listBriefingSends(new AschemaBriefingSend(), new PageInfo(10), buildTimeParam(START_DATE, END_DATE));
		ConResponseListInfo<AschemaMeetingSend> meetingConResponseListInfo2 = meetingSendAction
				.listMeetingSends(new AschemaMeetingSend(), new PageInfo(10), buildTimeParam(START_DATE, END_DATE));

		System.out.print("2021年4月份：");
		System.out.print("公文批办：" + docConResponseListInfo2.getPageInfo().getTotalContentNum());
		System.out.print(";会议通知：" + meetingConResponseListInfo2.getPageInfo().getTotalContentNum());
		System.out.println(";信息简报：" + briefingConResponseListInfo2.getPageInfo().getTotalContentNum());

		ConResponseListInfo<AschemaChapter> chapterConResponseListInfo = chapterAction
				.listChapters(new AschemaChapter(), new PageInfo(10), buildTimeParam(START_DATE, END_DATE));
		ConResponseListInfo<AschemaCar> carConResponseListInfo = carAction.listCars(new AschemaCar(), new PageInfo(10),
				buildTimeParam(START_DATE, END_DATE));
		ConResponseListInfo<AschemaLeave> leaveConResponseListInfo = leaveAction.listLeaves(new AschemaLeave(),
				new PageInfo(10), buildTimeParam(START_DATE, END_DATE));
		ConResponseListInfo<AschemaContract> contractConResponseListInfo = contractAction
				.listContracts(new AschemaContract(), new PageInfo(10), buildTimeParam(START_DATE, END_DATE));

		ConResponseListInfo<AschemaHotlineSend> hotLineConResponseListInfo = hotLineAction
				.listHotlineSends(new AschemaHotlineSend(), new PageInfo(10), buildTimeParam(START_DATE, END_DATE));
		ConResponseListInfo<AschemaFileTransfer> fileTransferConResponseListInfo = fileTransferAction
				.listFileTransfers(new AschemaFileTransfer(), new PageInfo(10), buildTimeParam(START_DATE, END_DATE));

		System.out.print("2021年4月份：");
		System.out.print("用印：" + chapterConResponseListInfo.getPageInfo().getTotalContentNum());
		System.out.print(" 用车：" + carConResponseListInfo.getPageInfo().getTotalContentNum());
		System.out.print(" 请假：" + leaveConResponseListInfo.getPageInfo().getTotalContentNum());
		System.out.print(" 合同：" + contractConResponseListInfo.getPageInfo().getTotalContentNum());
		System.out.print(" 诉求工单：" + hotLineConResponseListInfo.getPageInfo().getTotalContentNum());
		System.out.print(" 文件传输：" + fileTransferConResponseListInfo.getPageInfo().getTotalContentNum());

	}

	private static AsopQueryRequestParam buildTimeParam(String startTime, String endTime) {
		startTime = startTime + "000000";
		endTime = endTime + "240000";
		AsopQueryRequestParam param = AsopQueryRequestParam.buildDefaultTextParam("name", "-1");

		AsopQueryRequestParam p1 = new AsopQueryRequestParam();
		p1.setName("createTime");
		p1.setOccur(AsopQueryRequestParam.OCCUR_MUST);
		p1.setType("number");

		if (Utils.isEmpty(startTime)) {
			p1.setMin(Double.MIN_VALUE);
		} else {
			p1.setMin(Double.parseDouble(startTime));
		}

		p1.setMinInclusive(true);

		if (Utils.isEmpty(endTime)) {
			p1.setMax(Double.MAX_VALUE);
		} else {
			p1.setMax(Double.parseDouble(endTime));
		}

		p1.setMaxInclusive(false);

		param.addParam(p1, AsopQueryRequestParam.OCCUR_MUST);
		return param;
	}
}
