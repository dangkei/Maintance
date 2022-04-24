package doc;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.cloudclient.common.AsopUser;
import com.assoft.doc.common.action.DocReceiveAction;
import com.assoft.doc.common.action.DocSendAction;
import com.assoft.doc.common.action.ReceiveSignAction;
import com.assoft.doc.common.actionextend.DocSendExtendAction;
import com.assoft.doc.common.constant.Constants;
import com.assoft.doc.common.schema.AschemaDocReceive;
import com.assoft.doc.common.schema.AschemaDocSend;
import com.assoft.doc.common.schema.AschemaReceiveSign;
import com.assoft.doc.service.infrastructure.DocSendEntityService;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.rpc.client.rmi.AsopRmiClientENV;
/*
 * 补发待办
 * */
public class DeptLostTest {
	private static String DOC_RMI_URL = "10.171.251.241:1070";
	static DocSendAction docSendAction =  AsopRmiClientENV.gainRemoteProxy( DOC_RMI_URL, DocSendAction.class);
	DocSendExtendAction docSendExtendAction = AsopRmiClientENV.gainRemoteProxy( DOC_RMI_URL, DocSendExtendAction.class);
	static DocReceiveAction docReceiveAction = AsopRmiClientENV.gainRemoteProxy( DOC_RMI_URL, DocReceiveAction.class);
	static ReceiveSignAction receiveSignAction = AsopRmiClientENV.gainRemoteProxy( DOC_RMI_URL, ReceiveSignAction.class);
	public static void main(String[] args) {
		AschemaDocSend result = docSendAction.loadDocSend("1326092533545066498").getResult();
		saveNewDocSend(result);
	}
	public static ActionResultInfo<AschemaDocSend> saveNewDocSend(AschemaDocSend entity) {
		try {
			if(entity != null) {
                //发送公文接收
                AschemaDocReceive aschemaDocReceive = saveReceiveDoc(entity, null, true,null);
                if(StringUtils.isBlank(aschemaDocReceive.getId())){
                	return null;
                }
                System.out.println("recievId:"+aschemaDocReceive.getId());
                asyncDocCreate(entity,aschemaDocReceive);
			}
			return new ActionResultInfo<AschemaDocSend>(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return ActionResultInfo.buildErrorResultInfo(e.getMessage());
		}
	}
	 private static void asyncDocCreate(AschemaDocSend entity,AschemaDocReceive aschemaDocReceive) {
	        //发待办
	        if(Constants.SEND_DOC_TYPE_DEPT.equals(entity.getSendDocType())) {
	            try {
	                //代办 TODO
	                saveTodo( aschemaDocReceive, entity,DocSendEntityService.schemaName());
	            }catch (Exception e) {
	            }
	            // 未回执和未签收保存
	            saveReceiptOrSign(aschemaDocReceive, entity,  Constants.DOC_TYPE_DOC);

	        }
	    }
	 public static void saveTodo(AschemaDocReceive aschemaDocReceive, AschemaDocSend aschemaDocSend,
				String contentSchema) {
		 
		 System.out.println("待办内容标题:"+aschemaDocSend.getDocTitle());
		 System.out.println("实体标识："+aschemaDocReceive.getId());
		 
	 }
			
	 public static void saveReceiptOrSign(AschemaDocReceive docReceive, AschemaDocSend docsend,  String docTypeDoc) {
		 AschemaReceiveSign condition = new AschemaReceiveSign();
		 condition.setDocSendId(docsend.getId());
		 List<AschemaReceiveSign> contents = receiveSignAction.listReceiveSigns(condition, new PageInfo(2000), null).getContents();
		 System.out.println("一共找到签收记录："+contents.size()+"条");
		 for (AschemaReceiveSign aschemaReceiveSign : contents) {
			 aschemaReceiveSign.setDocReceiveId(docReceive.getId());
			 receiveSignAction.updateReceiveSign(aschemaReceiveSign);
		 }
			
		}
	public static AschemaDocReceive saveReceiveDoc(AschemaDocSend entity, AschemaDocReceive docReceive, boolean isDelete, String docSourceId) {
		AschemaDocReceive aschemaDocReceive = buildDocReceive(entity);
		if(Constants.SEND_DOC_TYPE_DEPT.equals(entity.getSendDocType())) {
			aschemaDocReceive.setReceiveDocType(Constants.RECEIVE_DOC_TYPE_RECEIVE);
		} else {
			aschemaDocReceive.setReceiveDocType(Constants.RECEIVE_DOC_TYPE_SEND);
		}
		if(isDelete) {
			//保证列表里不查出这条记录,逻辑删除
			aschemaDocReceive.setRecycleStatus("1");
		}
		
		if(docReceive != null && StringUtils.isNotBlank(docReceive.getId())) {
			docSourceId = StringUtils.isNotBlank(docSourceId) ? docSourceId : entity.getId();
			aschemaDocReceive.setDocSourceId(docSourceId);
			//aschemaDocReceive.setDocSendId(entity.getId());
			aschemaDocReceive.setDocSendId("");
		}
		if(StringUtils.isNotBlank(docSourceId)) {
			aschemaDocReceive.setDocSourceId(docSourceId);
		}
		try {
			aschemaDocReceive =	docReceiveAction.saveNewDocReceive(aschemaDocReceive).getResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aschemaDocReceive;
	}
	private static AschemaDocReceive buildDocReceive(AschemaDocSend entity) {
		if(entity == null) return null;
		AschemaDocReceive aschemaDocReceive = new AschemaDocReceive();
		aschemaDocReceive.setDocSendId(entity.getId());
		aschemaDocReceive.setDocTitle(entity.getDocTitle());
		String sendDocType = entity.getSendDocType();
		
		if(Constants.SEND_DOC_TYPE_DEPT.equals(sendDocType)) {
			//aschemaDocReceive.setFromUnitName(entity.getSendUnit().get(0));
			List<String> sendUnit = entity.getSendUnit();
			if(sendUnit != null && sendUnit.size() > 0)
				aschemaDocReceive.setFromUnitName(sendUnit.get(sendUnit.size() - 1));
			if(entity.getSendUnitName() != null && entity.getSendUnitName().size() > 0)
				aschemaDocReceive.setFromUnitNameName(entity.getSendUnitName().get(0));
			aschemaDocReceive.setReceiveDeptUnit(entity.getReceiveUnit());
			aschemaDocReceive.setIsReceipt(entity.getIsReceipt());
			aschemaDocReceive.setReceipt(Constants.RECEIPT_DEFAULT);
		} else if(Constants.SEND_DOC_TYPE_USER.equals(sendDocType)) {
			aschemaDocReceive.setSendUser(entity.getSendUser().get(0));
			aschemaDocReceive.setReceiveUser(entity.getReceivers());
			
		}
		String scanFile=entity.getScanFile();
		if(StringUtils.isBlank(scanFile)){
			scanFile=Constants.NOT_SCAN_FILE;
		}
		
		aschemaDocReceive.setScanFile(scanFile);
		aschemaDocReceive.setUrgency(entity.getUrgency());
		aschemaDocReceive.setStatus(Constants.STATUS_HANDELING);
		aschemaDocReceive.setSendDocType(sendDocType);
		aschemaDocReceive.setDocCodeValue(entity.getDocCodeValue());
		return aschemaDocReceive;
	}

}
