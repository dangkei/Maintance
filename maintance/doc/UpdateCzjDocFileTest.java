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
import com.assoft.czjDoc.common.action.DocReceiveAction;
import com.assoft.czjDoc.common.action.DocSendAction;
import com.assoft.czjDoc.common.schema.AschemaDocReceive;
import com.assoft.czjDoc.common.schema.AschemaDocSend;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.rpc.client.rmi.AsopRmiClientENV;

public class UpdateCzjDocFileTest {
	// private static String DOC_RMI_URL = "192.12.200.109:1070";
	//private static String DOC_RMI_URL = "http:192.12.200.109:8081/doc";
	private static String DOC_RMI_URL = "http:192.12.200.115:8084/czjDoc";
	//private static String DOC_RMI_URL = "http:10.171.251.241:8081/doc";
	// private static String DOC_RMI_URL = "10.171.251.241:1070";

	/*
	 * private static String NCLOUD_RMI_URL = "10.171.251.245:1065"; private static
	 * FLOW_RMI_URL = "10.171.251.245:1064";
	 */

	/**
	 * 给公文添加正文和附件等
	 */
	private static void updateDocReceive(DocReceiveAction docReceiveExtentAction, DocSendAction docSendExtentAction) {
		// 公文收文id
		String docReceiveId = "1473197325810720770"; // 1314367586263113730

		ActionResultInfo<AschemaDocReceive> resultInfo = docReceiveExtentAction.loadDocReceive(docReceiveId);
		AschemaDocReceive docReceive = resultInfo.getResult(); // 获得收文文档实例

		ActionResultInfo<AschemaDocSend> docSendResultInfo = docSendExtentAction.loadDocSend(docReceive.getDocSendId());
		AschemaDocSend docSend = docSendResultInfo.getResult(); // 获得发文文档实例
		// 处理内容
		// docSend.setDocCodeValue("");
		// docReceive.setDocCodeValue("");
		// docReceive.setFromUnitNameName("北京市商务局等");
		// docReceive.setFromUnitName("北京市商务局等");
		// docSend.setReceiversName(Arrays.asList("郑浩䓍"));
		// docSend.setReceivers(Arrays.asList("zh"));
		// docSend.setReceivedUnitName(null);
	    //docReceive.setDocNo("4611");
		// docSend.setDocTitle("关于印发《创建“基本无违建区”工作周动态（第八期）》的通知");
		// docReceive.setDocTitle("关于印发《创建“基本无违建区”工作周动态（第八期）》的通知");
		// docReceive.setSendUser("zh");
		// docReceive.setRegDate("2021-12-15");
		// docReceive.setSendUserName("郑浩");
		// docReceive.setReceivedUser(null);
		// docReceive.setReceivedUserName(null);
		//docReceive.setRemarks(docReceive.getDealRes());
		//docSend.setRemarks(docReceive.getDealRes());
		// docReceive.setDealRes("");;
		// docSend.setDealRes("");
		// 处理文件
		Map<String, List<AssoftFileObj>> eleFileMap = new HashMap<>(); // 文件列表对象
		buildFileMap(eleFileMap, docSend);
		// addFileMapForDocBody(eleFileMap); // 更新公文正文
	    // addFileMapForDocBodyFile(eleFileMap); // 更新公文正文预览
		// addFileMapForAttach(eleFileMap); //更新附件
		// addFileMapForDocRelationFile(eleFileMap); //更新相关收文
		// addFileMapForDocApprovalFile(eleFileMap); //更新打印批办单文件
		//addFileMapForDocApprovalZip(eleFileMap); //领导圈阅文件

		//docSendExtentAction.updateDocSend(docSend ,eleFileMap); // ,eleFileMap); //更新发文
		//docReceiveExtentAction.updateDocReceive(docReceive); // 更新收文
		System.out.println("<---------公文处理完毕------------>");
	}

	/* 替换公文正文 */
	private static void addFileMapForDocBody(Map<String, List<AssoftFileObj>> eleFileMap) {
		List<AssoftFileObj> fileObjs = new ArrayList<>();
		fileObjs.add(build("e://doc/", "通发改文199号-关于2022年区属投资任务分解提请区政府常务会审议的请示 (1)", ".pdf"));
		//fileObjs.add(build("e://doc/", "附件：关于广渠路东延工程京津公路路口节点改造的请示", ".docx"));
		eleFileMap.put("docBody", fileObjs);
		System.out.println("正文替换完毕！");
	}

	// 替换正文预览
	private static void addFileMapForDocBodyFile(Map<String, List<AssoftFileObj>> eleFileMap) {
		List<AssoftFileObj> fileObjs = new ArrayList<>();
		fileObjs.add(build("e://doc/", "通发改文199号-关于2022年区属投资任务分解提请区政府常务会审议的请示 (1)", ".pdf"));
		//fileObjs.add(build("e://doc/", "附件：关于广渠路东延工程京津公路路口节点改造的请示", ".pdf"));

		eleFileMap.put("docBodyFile", fileObjs);
		System.out.println("正文预览替换完毕！");
	}

	// 更新附件文件
	private static void addFileMapForAttach(Map<String, List<AssoftFileObj>> eleFileMap) {
		
		List<AssoftFileObj> fileObjs = new ArrayList<>();
		fileObjs.add(build("e://doc/", "区属项目分解任务汇报12222023征求意见稿", ".doc"));
		//fileObjs.add(build("e://doc/", "以此为准459号附件2", ".pdf"));
		//fileObjs.add(build("e://doc/", "81附件3：运河商务区十四五规划任务分解表12.06", ".xlsx"));
		//fileObjs.add(build("e://doc/", "81附件4：关于运河商务区建设发展第十四个五年规划征求各委办局意见修改情况的说明12.06", ".docx"));		
		//fileObjs.add(build("e://doc/", "81附件5：司法局合法性审查2021.10.18", ".pdf"));
		//fileObjs.add(build("e://doc/", "通新城建管文〔2021〕81号附件5：司法局合法性审查2021.10.18", ".pdf"));
		//fileObjs.add(build("e://doc/", "附件6：区规自回复意见", ".pdf"));
		//fileObjs.add(build("e://doc/", "附件7：发改委回复意见", ".pdf"));
		//fileObjs.add(build("e://doc/", "附件8：代拟稿-北京市通州区人民政府关于确认通州区张湾镇村、立禅庵、唐小庄、施园、宽街及南许场村棚户区改造项目土地开发一片区项目范围内国有土地上非住宅房屋征收项目符合征收条件的批复", ".docx"));
		//fileObjs.add(build("e://doc/", "287通住建委文〔2021〕287号附件", ".doc"));
		//fileObjs.add(build("e://doc/", "印发请示附件4-关于《通州区海绵城市建设管理办法（征求意见稿）》合法性审查意见汇总和反馈", ".doc"));
		//fileObjs.add(build("e://doc/", "附件5", ".jpg"));
		//fileObjs.add(build("e://doc/", "附件6：北京城市副中心城市更新2022年拟实施项目清单", ".xlsx"));
		//fileObjs.add(build("e://doc/", "361 附件5 于家务消防站规划实施方案2021-1027", ".pdf"));
		//fileObjs.add(build("e://doc/", "附件4", ".xlsx"));


		eleFileMap.put("docAttach", fileObjs);
		System.out.println("附件替换完毕！");
	}

	// 替换相关收文
	private static void addFileMapForDocRelationFile(Map<String, List<AssoftFileObj>> eleFileMap) {
		List<AssoftFileObj> fileObjs = new ArrayList<>();
		//fileObjs.add(build("e://doc/", "103关于申请拨付2021年北京市总部企业奖励资金的请示", ".pdf"));
		// fileObjs.add(build("e://doc/", "通城市管理委文49号关于北京环境有限公司将持有通州京环公司股权划转到北京环卫集团的请示", ".pdf"));
		// fileObjs.add(build("d://doc/", "通州区农村乱占耕地建房摸底排查工作简报第4期20201019", ".pdf"));
		eleFileMap.put("docRelationFile", fileObjs);
		System.out.println("相关收文替换完毕！--》");
	}

	// 替换打印批办单文件
	private static void addFileMapForDocApprovalFile(Map<String, List<AssoftFileObj>> eleFileMap) {
		List<AssoftFileObj> fileObjs = new ArrayList<>();
		fileObjs.add(build("e://doc/", "0", ".jpg"));

		eleFileMap.put("docApprovalFile", fileObjs);
		System.out.println("打印批办单文件替换完毕！--》");
	}
	// 替换打印批办单文件
	private static void addFileMapForDocApprovalZip(Map<String, List<AssoftFileObj>> eleFileMap) {
		List<AssoftFileObj> fileObjs = new ArrayList<>();
		fileObjs.add(build("e://doc/", "领导圈阅：秦涛;秦涛", ".zip"));

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
