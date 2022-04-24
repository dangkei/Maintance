package car;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.car.common.actionextend.CarExtendAction;
import com.assoft.car.common.schema.AschemaCar;
import com.assoft.doc.common.action.DocReceiveAction;
import com.assoft.doc.common.action.DocSendAction;
import com.assoft.doc.common.schema.AschemaDocReceive;
import com.assoft.doc.common.schema.AschemaDocSend;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.rpc.client.rmi.AsopRmiClientENV;

public class UpdateCarFileTest {
	private static String CAR_RMI_URL = "10.171.251.229:1073";

	
	public static void main(String[] args){
		processDocSendOrReceive();
	}
	
	@Test
	public void test() {
		processDocSendOrReceive();
	}
	
	private static void processDocSendOrReceive() {
		CarExtendAction docReceiveExtentAction = AsopRmiClientENV.gainRemoteProxy(CAR_RMI_URL, CarExtendAction.class);

		updateDocReceive(docReceiveExtentAction);
	}

	
	/**
	 * 给公文添加正文和附件等
	 */
	private static void updateDocReceive(CarExtendAction carAction) {
		//公文收文id
		String docReceiveId = "1361555306378723329";  //1314367586263113730
		
		ActionResultInfo<AschemaCar> resultInfo = carAction.loadCar(docReceiveId);
		AschemaCar docReceive = resultInfo.getResult();  //获得收文文档实例
		docReceive.setStartTime(docReceive.getUseDate());	


		carAction.updateCar(docReceive);		//车辆申请
		System.out.println("<---------车辆申请处理完毕------------>");
	}
	

}
