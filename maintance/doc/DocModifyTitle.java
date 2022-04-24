package doc;

import java.util.List;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.action.DocReceiveAction;
import com.assoft.doc.common.action.DocSendAction;
import com.assoft.doc.common.action.DoneDocAction;
import com.assoft.doc.common.schema.AschemaDocReceive;
import com.assoft.doc.common.schema.AschemaDocSend;
import com.assoft.doc.common.schema.AschemaDoneDoc;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.rpc.client.rmi.AsopRmiClientENV;

public class DocModifyTitle {
	//公文RMI
	private static String DOC_RMI_URL = "http:192.12.200.109:8081/doc";
	//private static String DOC_RMI_URL = "http:10.171.251.236:8081/doc";
	//收文id
	static String docReceiveId = "1408341827379027970"; // 1314367586263113730
	//收文id
	static String doneId = "1390488400258011137"; // 1314367586263113730
	//新标题
	static String newTitle = "关于对《北京市文物局征求＜北京市鼓励社会力量兴办博物馆的若干意见（征求意见稿）＞及＜北京市社会力量兴办博物馆专项资金管理办法（征求意见稿）＞意见的函》的回复意见"; // 1314367586263113730
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DocReceiveAction docReceiveExtentAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, DocReceiveAction.class);
		DocSendAction docSendExtentAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, DocSendAction.class);
		updateDocReceive(docReceiveExtentAction, docSendExtentAction);
		
		DoneDocAction doneDocAction = AsopRmiClientENV.gainRemoteProxy(	DOC_RMI_URL, DoneDocAction.class);
		//updateDoneDoc(doneDocAction);
	}

	private static void updateDocReceive(DocReceiveAction docReceiveExtentAction, DocSendAction docSendExtentAction) {
		ActionResultInfo<AschemaDocReceive> resultInfo = docReceiveExtentAction.loadDocReceive(docReceiveId);
		AschemaDocReceive docReceive = resultInfo.getResult(); // 获得收文文档实例

		ActionResultInfo<AschemaDocSend> docSendResultInfo = docSendExtentAction.loadDocSend(docReceive.getDocSendId());
		AschemaDocSend docSend = docSendResultInfo.getResult(); // 获得发文文档实例

		docSend.setDocTitle(newTitle);
		docReceive.setDocTitle(newTitle);
		//docSend.setDocCodeValue("京建发[2021]172号");
		//docReceive.setDocCodeValue("京建发[2021]172号");
		docSendExtentAction.updateDocSend(docSend); // ,eleFileMap); //更新发文
		docReceiveExtentAction.updateDocReceive(docReceive); // 更新收文
		System.out.println("<---------公文处理完毕------------>");
	}
	
	private static void updateAllDoneDoc(DoneDocAction doneDocAction) {
		AschemaDoneDoc doneDoc = new AschemaDoneDoc();
		doneDoc.setDocReceiveId(docReceiveId);
		AsopQueryRequestParam param=AsopQueryRequestParam.buildDefaultTextParam("name", "-1");
		List<AschemaDoneDoc>  doneList =doneDocAction.listDoneDocs(doneDoc, new PageInfo(100), param).getContents();
		
		for(AschemaDoneDoc entity:doneList) {
			entity.setTitle(newTitle);
			doneDocAction.updateDoneDoc(entity);
		}
	}
	
	private static void updateDoneDoc(DoneDocAction doneDocAction) {

		ActionResultInfo<AschemaDoneDoc> resultInfo = doneDocAction.loadDoneDoc(doneId);
		AschemaDoneDoc doneDoc = resultInfo.getResult(); // 获得已办文档实例

		doneDoc.setDocTitle(newTitle);
		doneDocAction.updateDoneDoc(doneDoc);
		
		System.out.println("<---------公文已办处理完毕------------>");
	}
}
