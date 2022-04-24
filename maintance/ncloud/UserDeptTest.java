package ncloud;

import java.util.List;

import org.junit.Test;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.cloud.common.action.DeptAction;
import com.assoft.cloud.common.action.UserAction;
import com.assoft.cloud.common.actionextend.DeptExtendAction;
import com.assoft.cloud.common.actionextend.UserExtendAction;
import com.assoft.cloud.common.schema.AschemaDept;
import com.assoft.cloud.common.schema.AschemaUser;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.rpc.client.rmi.AsopRmiClientENV;
import com.soft.web.action.base.ConResponseListInfo;

public class UserDeptTest {
	//private static String NCLOUD_RMI_URL = "10.171.251.245:1065";
	private static String NCLOUD_RMI_URL = "http:192.12.200.114:8080/ncloud";
	/*
	 * private static String NCLOUD_RMI_URL = "10.171.251.245:1065"; private
	 * static String DOC_RMI_URL = "10.171.251.246:1070"; private static String
	 * FLOW_RMI_URL = "10.171.251.245:1064";
	 */

	public static void main(String[] args) {
		processCloudData();
	}

	@Test
	public void test() {
		processCloudData();
	}
	private static void processCloudData() {
		DeptAction deptAction = AsopRmiClientENV.gainRemoteProxy(
				NCLOUD_RMI_URL, DeptAction.class);
		DeptExtendAction deptExtendAction = AsopRmiClientENV.gainRemoteProxy(
				NCLOUD_RMI_URL, DeptExtendAction.class);
		
		UserAction userAction = AsopRmiClientENV.gainRemoteProxy(
				NCLOUD_RMI_URL, UserAction.class);
		UserExtendAction userExtendAction = AsopRmiClientENV.gainRemoteProxy(
				NCLOUD_RMI_URL, UserExtendAction.class);
		
		//PrintDeptUsers(deptAction,userAction,"/1152477095729074177/1152477404157218817/1152477500001259521/1152477513171374081");
		PrintAllDeptUser(deptAction,userAction,"qyllhj");//"qjjxxhj");
		
		

	}
	
	
	private static void PrintAllDeptUser(DeptAction deptAction,UserAction userAction, String shortName){
		List<AschemaDept> depts = getChildDeptsByName(deptAction, shortName);
		for(AschemaDept dept:depts) {
			System.out.println("### "+dept.getName());
			System.out.println("----------------------------------------------------------------------");
			System.out.print("| 单位");
			
			System.out.println("|姓名|登录名|电话|");
			System.out.println("|---|---|---|----------------------------------------------------------------------|");
			PrintDeptUsers(deptAction,userAction,dept);
		}
	}
	
	
	/*
	 * 导出部门人员列表
	 * */
	private static void PrintDeptUsers(DeptAction deptAction,UserAction userAction, AschemaDept dept) {
		// 公文已办id

		List<AschemaUser> users = getDeptUserByDeptDn(userAction,dept.getDn());
		for(AschemaUser user:users){
			//System.out.println("dept:"+user.getDept());
			//System.out.println("dn"+dept.getDn());
			//System.out.println(dept.getFatherId());
			//System.out.println("fullMetaName:"+dept.getFullMetaName());
			//System.out.println(dept.getFullName());
			//System.out.println(dept.getShortName());
			
			System.out.print("|	");
			System.out.print(dept.getName());
			System.out.print("	|	");
			System.out.print(user.getUserName());
			System.out.print("	|	");
			System.out.print(user.getLoginName());
			System.out.print("	|	");
			System.out.print(user.getPhone());
			System.out.println("	|	");
		}

		System.out.println("------------------------------------------------------------------------------------");
	}
	
	


	/*
	 * 根据部门id获得部门中文名
	 * */
	
	private static AschemaDept getDeptNameById(DeptAction deptAction,String id){
		//System.out.println(id);
		AschemaDept condition = new AschemaDept();
		condition.setDn("");
		AsopQueryRequestParam param = AsopQueryRequestParam.buildDefaultTextParam("name", "-1");
		AsopQueryRequestParam p = AsopQueryRequestParam.buildDefaultTextParam("ele_shortName", id);
		param.addParam(p, AsopQueryRequestParam.OCCUR_SHOULD);
	
		
		AschemaDept dept = deptAction.loadDept(condition, param);
		return dept;
	}
	
	
	/*
	 * 根据部门id导出所有部门内人员
	 * */
	private static List<AschemaUser> getDeptUserByDeptDn(UserAction userAction, String deptId){
		ConditionDomainSchema<AschemaUser> condition= new ConditionDomainSchema<AschemaUser>();
		AschemaUser schema = new AschemaUser();
		schema.setDept(deptId);
		condition.setSchema(schema);
		ActionResultInfo<ConResponseListInfo<AschemaUser>> info = userAction.listUsers(condition, new PageInfo(200));
		
		return info.getResult().getContents();
	}
	
	/*
	 * 根据部门id导出所有部门内人员
	 * */
	private static AschemaDept getDeptByName(DeptAction deptAction, String shortName){
		AschemaDept schema = new AschemaDept();
		AsopQueryRequestParam param =AsopQueryRequestParam.buildDefaultTextParam("name", "-1");
		param.addParam(AsopQueryRequestParam.buildDefaultTextParam("ele_shortName", shortName),AsopQueryRequestParam.OCCUR_SHOULD);
		return deptAction.loadDept(schema, param);
	}
	
	private static List<AschemaDept> getChildDeptsByName(DeptAction deptAction,String shortName){
		AschemaDept dept = getDeptByName(deptAction, shortName);

		//System.out.println("|      |     |"+dept.getName()+"|           |");
		//System.out.println(dept.getName());
		//System.out.println("|-|-|-|---------------------------------------------------------------------------------|");
		
		ConditionDomainSchema<AschemaDept> condition = new ConditionDomainSchema<AschemaDept>();
		AschemaDept schema = new AschemaDept();
		schema.setDn(dept.getDn());
		condition.setSchema(schema);

		return deptAction.listDepts(condition, new PageInfo(20)).getResult().getContents();	
	}

}

	