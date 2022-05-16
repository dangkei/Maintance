package doc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.doc.common.action.BriefingReceiveAction;
import com.assoft.doc.common.action.BriefingSendAction;
import com.assoft.doc.common.action.MeetingReceiveAction;
import com.assoft.doc.common.action.MeetingSendAction;
import com.assoft.doc.common.schema.AschemaBriefingReceive;
import com.assoft.doc.common.schema.AschemaBriefingSend;
import com.assoft.doc.common.schema.AschemaMeetingReceive;
import com.assoft.doc.common.schema.AschemaMeetingSend;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.rpc.client.rmi.AsopRmiClientENV;


/*
 * 更新会议批办正文及附件工具
 * */
public class UpdateBriefingTest {
	private static String DOC_RMI_URL = "http:192.12.200.109:8081/doc";
	
	/*private static String NCLOUD_RMI_URL = "10.171.251.245:1065";
	private static String DOC_RMI_URL = "10.171.251.246:1070";
	private static String FLOW_RMI_URL = "10.171.251.245:1064";*/
	
	@Test
	public static void main(String[] args) {
		processDocSendOrReceive();
	}
	
	private static void processDocSendOrReceive() {
		BriefingReceiveAction meetingReceiveExtentAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, BriefingReceiveAction.class);
		BriefingSendAction meentingSendExtentAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, BriefingSendAction.class);
		updateBriefingReceive(meetingReceiveExtentAction, meentingSendExtentAction);
	}

	
	/**
	 * 给公文添加正文和附件等
	 */
	private static void updateBriefingReceive(BriefingReceiveAction briefingReceiveExtentAction, BriefingSendAction briefingSendExtentAction) {
		//公文收文id
		String briefingReceiveId = "1519932251020754945";
		
		ActionResultInfo<AschemaBriefingReceive> resultInfo = briefingReceiveExtentAction.loadBriefingReceive(briefingReceiveId);
		AschemaBriefingReceive docReceive = resultInfo.getResult();  //获得收文文档实例

		ActionResultInfo<AschemaBriefingSend> briefingSendResultInfo = briefingSendExtentAction.loadBriefingSend(docReceive.getDocSendId());
		AschemaBriefingSend docSend = briefingSendResultInfo.getResult();	//获得发文文档实例
		
		//docReceive.setDocTitle("吉宁等同志关于报请审定《北京市人民政府 中国电子科技集团有限公司战略合作协议》的请示的批示");
		//docSend.setDocTitle("吉宁等同志关于报请审定《北京市人民政府 中国电子科技集团有限公司战略合作协议》的请示的批示");
		
		//docReceive.setFromUnitName("市政府办公厅");
		//docReceive.setFromUnitNameName("市政府办公厅");
		//docReceive.setDocCodeValue("通财经建文〔2020〕457号");
		//docSend.setDocCodeValue("通财经建文〔2020〕457号");
		List<String> list= new ArrayList<>();//Arrays.asList("dmh");
		List<String> names=new ArrayList<>();//Arrays.asList("董明慧");

		docReceive.setTransmitUser(list);
		docReceive.setTransmitUserName(names);
		
		System.out.println(docReceive.getTransmitUser().toString());
		System.out.println(docReceive.getTransmitUserName().toString());
		
		System.out.println(docReceive.getReceiveUser().toString());
		System.out.println(docReceive.getReceiveUserName().toString());
		Map<String, List<AssoftFileObj>> eleFileMap = new HashMap<>();		//文件列表对象
		buildFileMap(eleFileMap, docSend);
		//addFileMapForDocBody(eleFileMap);				//更新简报正文
		//addFileMapForDocBodyFile(eleFileMap);			//更新简报正文预览
		//addFileMapForAttach(eleFileMap);				//更新简报附件
		
		briefingSendExtentAction.updateBriefingSend(docSend,eleFileMap);    //更新发文 , eleFileMap
		briefingReceiveExtentAction.updateBriefingReceive(docReceive);		//更新收文
		System.out.println("<---------信息简报处理完毕------------>");
	}
	
	/*替换简报正文*/
	private static void addFileMapForDocBody(Map<String, List<AssoftFileObj>> eleFileMap) {
		List<AssoftFileObj> fileObjs = new ArrayList<>();
		fileObjs.add(build("e://doc/", "通州区出现局部散发病例后社区（村）应急处置措施（第二版）修订(4)(1) - 副本", ".docx"));
		//fileObjs.add(build("e://doc/", "行政1910号", ".pdf"));
		

		eleFileMap.put("docBody", fileObjs);
		System.out.println("简报正文替换完毕！");
	}
	
	//替换会议正文预览
	private static void addFileMapForDocBodyFile(Map<String, List<AssoftFileObj>> eleFileMap) {
		List<AssoftFileObj> fileObjs = new ArrayList<>();
		fileObjs.add(build("e://doc/", "通州区出现局部散发病例后社区（村）应急处置措施（第二版）修订(4)(1) - 副本", ".pdf"));
		//fileObjs.add(build("e://doc/", "行政1910号", ".pdf"));
		
		eleFileMap.put("docBodyFile", fileObjs);
		System.out.println("简报正文预览替换完毕！");
	}
	
	
	//更新会议附件文件
	private static void addFileMapForAttach(Map<String, List<AssoftFileObj>> eleFileMap) {
		List<AssoftFileObj> fileObjs = new ArrayList<>();
		fileObjs.add(build("e://doc/", "行政1910号", ".pdf"));
		//fileObjs.add(build("d://doc/", "1492附件2", ".xls"));
		//fileObjs.add(build("d://doc/", "附件3：办公用房数据统计表", ".xls"));
		//fileObjs.add(build("d://doc/", "附件4：办公用房数据统计表", ".xls"));

		//eleFileMap.put("docAttach", fileObjs);
		System.out.println("简报附件替换完毕！");
	}
	public static AssoftFileObj build(String path, String title,String suffix){
		AssoftFileObj fileObj = new AssoftFileObj();
		String filePath = path+title+suffix;
		
		try {
			byte[] contents = FileUtils.readFileToByteArray(new File(filePath));
			if(contents != null) {
				//FileUtils.writeByteArrayToFile(new File("e:/convert/1" + index + fileObj.getSuffix()), contents);
				fileObj.setContents(contents);
				fileObj.setFilePath("");
				fileObj.setId("");
			}
			fileObj.setFileName(title+suffix);
			fileObj.setSuffix(suffix);
			fileObj.setTextName(title);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileObj;
	}

	
	
	/**
	 * 
	 * @param emap
	 * @param meetingSend
	 */
	private static void buildFileMap(Map<String, List<AssoftFileObj>> emap, AschemaBriefingSend meetingSend) {
		List<AssoftFileObj> docBody = meetingSend.getDocBody();
		if(docBody != null && docBody.size() > 0) {
			emap.put("docBody", docBody);
		}
		
		List<AssoftFileObj> docBodyFile = meetingSend.getDocBodyFile();
		if(docBodyFile != null && docBodyFile.size() > 0) {
			
			emap.put("docBodyFile", docBodyFile);
		}
		
		List<AssoftFileObj> docAttach = meetingSend.getDocAttach();
		if(docAttach != null && docAttach.size() > 0) {
			//emap.put("docAttach", docAttach);
		}
		
		List<AssoftFileObj> docApprovalFile= meetingSend.getDocApprovalFile();
		if(docApprovalFile != null && docApprovalFile.size() > 0) {
			emap.put("docApprovalFile", docApprovalFile);
		}
		//List<AssoftFileObj> docRelationFile = meetingSend.getMeetingRelationFile();
		//if(docRelationFile != null && docRelationFile.size() > 0) {
		//	emap.put("docRelationFile", docRelationFile);
		//}
	}
}
