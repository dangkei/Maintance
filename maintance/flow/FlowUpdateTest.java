package flow;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.flow.common.action.ActivityInstanceActionAction;
import com.assoft.flow.common.schema.AschemaActivityInstanceAction;
import com.assoft.rpc.client.rmi.AsopRmiClientENV;

public class FlowUpdateTest {
	
	private static String FLOW_RMI_URL = "10.171.251.247:1064";
//	@Test
//	public void test() throws IOException {
//		
//		Time();
//		
//	}
public static void main(String[] args) {
	ActivityInstanceActionAction action =  AsopRmiClientENV.gainRemoteProxy(FLOW_RMI_URL, ActivityInstanceActionAction.class);
	ActionResultInfo<AschemaActivityInstanceAction> loadActivityInstanceAction = action.loadActivityInstanceAction("1369558632236158977");
	AschemaActivityInstanceAction condtionAction = loadActivityInstanceAction.getResult();
	condtionAction.setOpinion(" &amp;nbsp;&amp;nbsp;&amp;nbsp; 请阳波、郑皓同志阅示。机要保密科10/3 ");
	action.updateActivityInstanceAction(condtionAction);

}
	
}
