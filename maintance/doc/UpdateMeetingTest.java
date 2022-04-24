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
import com.assoft.doc.common.action.MeetingReceiveAction;
import com.assoft.doc.common.action.MeetingSendAction;
import com.assoft.doc.common.schema.AschemaMeetingReceive;
import com.assoft.doc.common.schema.AschemaMeetingSend;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.rpc.client.rmi.AsopRmiClientENV;


/*
 * 更新会议批办正文及附件工具
 * */
public class UpdateMeetingTest {
	private static String DOC_RMI_URL = "10.171.251.241:1070";
	
	/*private static String NCLOUD_RMI_URL = "10.171.251.245:1065";
	private static String DOC_RMI_URL = "10.171.251.246:1070";
	private static String FLOW_RMI_URL = "10.171.251.245:1064";*/
	
	@Test
	public void test() {
		processDocSendOrReceive();
	}
	
	private void processDocSendOrReceive() {
		MeetingReceiveAction meetingReceiveExtentAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, MeetingReceiveAction.class);
		MeetingSendAction meentingSendExtentAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, MeetingSendAction.class);
		updateMeetingReceive(meetingReceiveExtentAction, meentingSendExtentAction);
	}

	
	/**
	 * 给公文添加正文和附件等
	 */
	private void updateMeetingReceive(MeetingReceiveAction meetingReceiveExtentAction, MeetingSendAction meetingSendExtentAction) {
		//公文收文id
		String meetingReceiveId = "1333981897881128962";
		
		ActionResultInfo<AschemaMeetingReceive> resultInfo = meetingReceiveExtentAction.loadMeetingReceive(meetingReceiveId);
		AschemaMeetingReceive meetingReceive = resultInfo.getResult();  //获得收文文档实例

		ActionResultInfo<AschemaMeetingSend> meetingSendResultInfo = meetingSendExtentAction.loadMeetingSend(meetingReceive.getDocSendId());
		AschemaMeetingSend meetingSend = meetingSendResultInfo.getResult();	//获得发文文档实例
		
		//docReceive.setDocCodeValue("通财经建文〔2020〕457号");
		//docSend.setDocCodeValue("通财经建文〔2020〕457号");
		
		Map<String, List<AssoftFileObj>> eleFileMap = new HashMap<>();		//文件列表对象
		buildFileMap(eleFileMap, meetingSend);
		addFileMapForDocBody(eleFileMap);				//更新会议正文
		addFileMapForDocBodyFile(eleFileMap);			//更新会议正文预览
		addFileMapForAttach(eleFileMap);				//更新会议附件
		
		meetingSendExtentAction.updateMeetingSend(meetingSend, eleFileMap);    //更新发文
		meetingReceiveExtentAction.updateMeetingReceive(meetingReceive);		//更新收文
		System.out.println("<---------会议处理完毕------------>");
	}
	
	/*替换会议正文*/
	private void addFileMapForDocBody(Map<String, List<AssoftFileObj>> eleFileMap) {
		List<AssoftFileObj> fileObjs = new ArrayList<>();
		fileObjs.add(build("d://doc/", "92常务会红头封面市场食品药品39", ".doc"));
		fileObjs.add(build("d://doc/", "装订材料要求2", ".doc"));
		

		eleFileMap.put("docBody", fileObjs);
		System.out.println("会议正文替换完毕！");
	}
	
	//替换会议正文预览
	private void addFileMapForDocBodyFile(Map<String, List<AssoftFileObj>> eleFileMap) {
		List<AssoftFileObj> fileObjs = new ArrayList<>();
		fileObjs.add(build("d://doc/", "92常务会红头封面市场食品药品39", ".pdf"));
		//fileObjs.add(build("d://doc/", "装订材料要求2", ".pdf"));
		
		eleFileMap.put("docBodyFile", fileObjs);
		System.out.println("会议正文预览替换完毕！");
	}
	
	
	//更新会议附件文件
	private void addFileMapForAttach(Map<String, List<AssoftFileObj>> eleFileMap) {
		List<AssoftFileObj> fileObjs = new ArrayList<>();
		fileObjs.add(build("d://doc/", "以此为准", ".png"));
		//fileObjs.add(build("d://doc/", "1492附件2", ".xls"));
		//fileObjs.add(build("d://doc/", "附件3：办公用房数据统计表", ".xls"));
		//fileObjs.add(build("d://doc/", "附件4：办公用房数据统计表", ".xls"));

		eleFileMap.put("docAttach", fileObjs);
		System.out.println("会议附件替换完毕！");
	}
	public AssoftFileObj build(String path, String title,String suffix){
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
	private void buildFileMap(Map<String, List<AssoftFileObj>> emap, AschemaMeetingSend meetingSend) {
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
			emap.put("docAttach", docAttach);
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
