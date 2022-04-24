package doc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.doc.common.action.DoneDocAction;
import com.assoft.doc.common.schema.AschemaDocReceive;
import com.assoft.doc.common.schema.AschemaDocSend;
import com.assoft.doc.common.schema.AschemaDoneDoc;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.rpc.client.rmi.AsopRmiClientENV;
import com.assoft.todo.common.action.TodoAction;
import com.assoft.todo.common.schema.AschemaTodo;
import com.soft.web.action.base.ConResponseListInfo;

public class UpdateDocDoneFileTest {
	// private static String DOC_RMI_URL = "10.171.251.241:1070";

	private static String DOC_RMI_URL = "http:192.12.200.109:8081/doc";
	private static String TODO_RMI_URL = "http:192.12.200.110:8081/todo";

	// Stack stack;

	/*
	 * private static String NCLOUD_RMI_URL = "10.171.251.245:1065"; private static
	 * String DOC_RMI_URL = "10.171.251.246:1070"; private static String
	 * FLOW_RMI_URL = "10.171.251.245:1064";
	 */

	public static void main(String[] args) {
		 processDoneDoc();
		//processTodoDoc();
	}

	@Test
	public void test() {
		processDoneDoc();
	}

	private static void processDoneDoc() {
		DoneDocAction doneDocAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, DoneDocAction.class);
		updateDoneDoc(doneDocAction);
	}

	private static void processTodoDoc() {
		TodoAction todoAction = AsopRmiClientENV.gainRemoteProxy(TODO_RMI_URL, TodoAction.class);
		updateTodoDoc(todoAction);
	}

	/**
	 * 
	 */
	private static void updateTodoDoc(TodoAction todoAction) {
		// 公文已办id
		// String doneDocId = "1394616467852476417"; // "1349275654901735425"; //
		// 1314367586263113730
		String receiveUsers = "zl";

		AschemaTodo todo = new AschemaTodo();
		todo.setReceiveUsers(Arrays.asList(receiveUsers));
		ConditionDomainSchema conditionDomainSchema = new ConditionDomainSchema();
		conditionDomainSchema.setSchema(todo);
		PageInfo pageInfo = new PageInfo(100);
		ActionResultInfo<ConResponseListInfo<AschemaTodo>> result = todoAction.listTodos(conditionDomainSchema, pageInfo);
		List<AschemaTodo> todoList = result.getResult().getContents();
		
		for(AschemaTodo todo1:todoList) {
				System.out.println(todo1.getTitle());
		}
		
		
		System.out.println("<---------公文已办处理完毕------------>");
	}

	/**
	 * 
	 */
	private static void updateDoneDoc(DoneDocAction doneDocAction) {
		// 公文已办id
		String doneDocId = "1506874971161370625"; // "1349275654901735425"; // 1314367586263113730

		ActionResultInfo<AschemaDoneDoc> resultInfo = doneDocAction.loadDoneDoc(doneDocId);
		AschemaDoneDoc doneDoc = resultInfo.getResult(); // 获得已办文档实例

		// doneDocAction.loadDoneDoc(doneDoc, param);
		//doneDoc.setDocNo("1386");
		//doneDoc.setFromUnitName("2022年冬奥会和冬残奥会北京市运行保障指挥部城市运行及环境保障组");
		//doneDoc.setFromUnitNameName("2022年冬奥会和冬残奥会北京市运行保障指挥部城市运行及环境保障组");
		//doneDoc.setDocTitle("关于加强本市餐饮单位醇基液体燃料使用安全管理工作的通知");
		doneDocAction.updateDoneDoc(doneDoc);

		System.out.println("<---------公文已办处理完毕------------>");
	}

}
