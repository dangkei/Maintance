package doc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.doc.common.action.DocReceiveAction;
import com.assoft.doc.common.action.DocSendAction;
import com.assoft.doc.common.schema.AschemaDocReceive;
import com.assoft.doc.common.schema.AschemaDocSend;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.rpc.client.rmi.AsopRmiClientENV;

public class UpdateDocFileTest {
	// private static String DOC_RMI_URL = "192.12.200.109:1070";
	private static String DOC_RMI_URL = "http:192.12.200.109:8081/doc";
	//private static String DOC_RMI_URL = "http:192.12.200.115:8085/yllhjDoc";
	//private static String DOC_RMI_URL = "http:192.12.200.115:8084/czjDoc";
	//private static String DOC_RMI_URL = "http:10.171.251.241:8081/doc";
	// private static String DOC_RMI_URL = "10.171.251.241:1070";

	/**
	 * 给公文添加正文和附件等
	 */
	private static void updateDocReceive(DocReceiveAction docReceiveExtentAction, DocSendAction docSendExtentAction) {
		// 公文收文id
		String docReceiveId = "1518046609529704449"; // 1507237513679343617

		ActionResultInfo<AschemaDocReceive> resultInfo = docReceiveExtentAction.loadDocReceive(docReceiveId);
		AschemaDocReceive docReceive = resultInfo.getResult(); // 获得收文文档实例

		ActionResultInfo<AschemaDocSend> docSendResultInfo = docSendExtentAction.loadDocSend(docReceive.getDocSendId());
		AschemaDocSend docSend = docSendResultInfo.getResult(); // 获得发文文档实例
		// 处理内容
		// docSend.setDocCodeValue("通司文〔2022〕48号");
		// docReceive.setDocCodeValue("通司文〔2022〕48号");
		// docReceive.setFromUnitNameName("北京市通州区交通局");
		// docReceive.setFromUnitName("北京市通州区交通局");
		// docSend.setReceiversName(Arrays.asList("郑浩䓍"));
		// docSend.setReceivers(Arrays.asList("zh"));
		// docSend.setReceivedUnitName(null);
	    // docReceive.setDocNo("1386");
		// docSend.setDocTitle("关于向市物资保障及保供稳价组报送区级政务储备摸底和储备计划编制情况的请示");
	    // docReceive.setDocTitle("关于向市物资保障及保供稳价组报送区级政务储备摸底和储备计划编制情况的请示");
		// docReceive.setSendUser("zh");
		// docReceive.setRegDate("2022-04-01");
		// docReceive.setSendUserName("郑浩");
		// docReceive.setReceivedUser(null);
		// docReceive.setReceivedUserName(null);
		// docSend.setDealRes("拟转城管委、财政局，请国凯同志阅示。机要保密科30/3");
		// docReceive.setDealRes("拟转城管委、财政局，请国凯同志阅示。机要保密科30/3");
		// docReceive.setRemarks("");
		// docSend.setRemarks("");
		// docSend.setReceivers(Arrays.asList("maguokai", "geqi", "ndc","geqi","dyj"));
		// docSend.setReceiversName(Arrays.asList("马国凯","葛琦", "倪德才", "葛琦","董亦军"));
		// 处理文件
		Map<String, List<AssoftFileObj>> eleFileMap = new HashMap<>(); // 文件列表对象
		buildFileMap(eleFileMap, docSend);
		 addFileMapForDocBody(eleFileMap); // 更新公文正文
	     addFileMapForDocBodyFile(eleFileMap); // 更新公文正文预览
		// addFileMapForAttach(eleFileMap); //更新附件
		// addFileMapForDocRelationFile(eleFileMap); //更新相关收文
		// addFileMapForDocApprovalFile(eleFileMap); //更新打印批办单文件
		// addFileMapForDocApprovalZip(eleFileMap); //领导圈阅文件

		docSendExtentAction.updateDocSend(docSend ,eleFileMap); // ,eleFileMap); //更新发文
		docReceiveExtentAction.updateDocReceive(docReceive); // 更新收文
		System.out.println("<---------公文处理完毕------------>");
	}

	/* 替换公文正文 */
	private static void addFileMapForDocBody(Map<String, List<AssoftFileObj>> eleFileMap) {
		List<AssoftFileObj> fileObjs = new ArrayList<>();
		fileObjs.add(build("e://doc/", "行政1742替换", ".pdf"));
		//fileObjs.add(build("e://doc/", "行政350", ".pdf"));
		eleFileMap.put("docBody", fileObjs);
		System.out.println("正文替换完毕！");
	}

	// 替换正文预览
	private static void addFileMapForDocBodyFile(Map<String, List<AssoftFileObj>> eleFileMap) {
		List<AssoftFileObj> fileObjs = new ArrayList<>();
		fileObjs.add(build("e://doc/", "行政1742替换", ".pdf"));
		//fileObjs.add(build("e://doc/", "行政350", ".pdf"));

		eleFileMap.put("docBodyFile", fileObjs);
		System.out.println("正文预览替换完毕！");
	}

	// 更新附件文件
	private static void addFileMapForAttach(Map<String, List<AssoftFileObj>> eleFileMap) {
		
		List<AssoftFileObj> fileObjs = new ArrayList<>();
		fileObjs.add(build("e://doc/", "附件1  京应急发【2019】35号 进一步加强区级森林消防综合应急救援队伍能力建设的意见(文)", ".pdf"));
		fileObjs.add(build("e://doc/", "附件2   《通州区进一步加强区级森林消防综合应急救援队伍能力建设方案》通政办发〔2020〕8号", ".pdf"));
		fileObjs.add(build("e://doc/", "附件3   区政府第68次常务会会议纪要", ".pdf"));
		fileObjs.add(build("e://doc/", "附件4 区森林消防综合应急救援队伍基地规划建设方案", ".pdf"));	
		fileObjs.add(build("e://doc/", "以此为准 附件5  区森林消防救援基地装修改造及配备设备设施费用情况表", ".pdf"));		
		fileObjs.add(build("e://doc/", "以此为准 附件6  队伍训练器械费用表", ".pdf"));
		//fileObjs.add(build("e://doc/", "附件4-3-其他23间冷库台账", ".pdf"));
		//fileObjs.add(build("e://doc/", "附件4-4-交通局4间冷库台账", ".pdf"));
		//fileObjs.add(build("e://doc/", "附件4-5-城管局117间冷库台账", ".pdf"));
		//fileObjs.add(build("e://doc/", "附件4-6-市场局365间冷库台账", ".pdf"));
		//fileObjs.add(build("e://doc/", "附件4-7-商务局96间冷库台账", ".pdf"));
		//fileObjs.add(build("e://doc/", "附件4-8-农业局1间冷库台账", ".pdf"));
		//fileObjs.add(build("e://doc/", "总台账651", ".pdf"));
		//fileObjs.add(build("e://doc/", "361 附件5 于家务消防站规划实施方案2021-1027", ".pdf"));
		//fileObjs.add(build("e://doc/", "附件4", ".xlsx"));


		eleFileMap.put("docAttach", fileObjs);
		System.out.println("附件替换完毕！");
	}

	// 替换相关收文
	private static void addFileMapForDocRelationFile(Map<String, List<AssoftFileObj>> eleFileMap) {
		List<AssoftFileObj> fileObjs = new ArrayList<>();
		//fileObjs.add(build("e://doc/", "行政752", ".pdf"));
		//fileObjs.add(build("e://doc/", "相关收文2", ".pdf"));
		// fileObjs.add(build("d://doc/", "通州区农村乱占耕地建房摸底排查工作简报第4期20201019", ".pdf"));
		eleFileMap.put("docRelationFile", fileObjs);
		System.out.println("相关收文替换完毕！--》");
	}

	// 替换打印批办单文件
	private static void addFileMapForDocApprovalFile(Map<String, List<AssoftFileObj>> eleFileMap) {
		List<AssoftFileObj> fileObjs = new ArrayList<>();
		fileObjs.add(build("e://doc/", "1517053546573398018", ".jpg"));

		eleFileMap.put("docApprovalFile", fileObjs);
		System.out.println("打印批办单文件替换完毕！--》");
	}
	// 替换打印批办单文件
	private static void addFileMapForDocApprovalZip(Map<String, List<AssoftFileObj>> eleFileMap) {
		List<AssoftFileObj> fileObjs = new ArrayList<>();
		//fileObjs.add(build("e://doc/", "ReceiveDoc,1486230168618930177", ".zip"));

		eleFileMap.put("approvalZip", fileObjs);
		System.out.println("更新领导圈阅完毕！--》");
	}
	

	public static AssoftFileObj build(String path, String title, String suffix) {
		AssoftFileObj fileObj = new AssoftFileObj();
		String filePath = path + title + suffix;

		try {
			byte[] contents = FileUtils.readFileToByteArray(new File(filePath));
			if (contents != null) {
				// FileUtils.writeByteArrayToFile(new File("e:/convert/1" + index +
				// fileObj.getSuffix()), contents);
				fileObj.setContents(contents);
				fileObj.setFilePath("");
				fileObj.setId("");
			}
			fileObj.setFileName(title + suffix);
			fileObj.setSuffix(suffix);
			fileObj.setTextName(title);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileObj;
	}

	/**
	 * 
	 * @param emap
	 * @param docSend
	 */
	private static void buildFileMap(Map<String, List<AssoftFileObj>> emap, AschemaDocSend docSend) {
		List<AssoftFileObj> docBody = docSend.getDocBody();
		if (docBody != null && docBody.size() > 0) {
			emap.put("docBody", docBody);
		}

		List<AssoftFileObj> docBodyFile = docSend.getDocBodyFile();
		if (docBodyFile != null && docBodyFile.size() > 0) {

			emap.put("docBodyFile", docBodyFile);
		}

		List<AssoftFileObj> docAttach = docSend.getDocAttach();
		if (docAttach != null && docAttach.size() > 0) {
			emap.put("docAttach", docAttach);
		}

		List<AssoftFileObj> docApprovalFile = docSend.getDocApprovalFile();
		if (docApprovalFile != null && docApprovalFile.size() > 0) {
			emap.put("docApprovalFile", docApprovalFile);
		}
		List<AssoftFileObj> docRelationFile = docSend.getDocRelationFile();
		if (docRelationFile != null && docRelationFile.size() > 0) {
			emap.put("docRelationFile", docRelationFile);
		}
		List<AssoftFileObj> docApprovalZip = docSend.getApprovalZip();
		if (docApprovalZip != null && docApprovalZip.size() > 0) {
			emap.put("approvalZip", docApprovalZip);
		}
	}

	public static void main(String[] args) {
		processDocSendOrReceive();
	}

	@Test
	public void test() {
		processDocSendOrReceive();
	}

	private static void processDocSendOrReceive() {
		DocReceiveAction docReceiveExtentAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, DocReceiveAction.class);
		DocSendAction docSendExtentAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, DocSendAction.class);
		updateDocReceive(docReceiveExtentAction, docSendExtentAction);
	}

}
