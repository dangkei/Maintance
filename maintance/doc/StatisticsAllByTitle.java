package doc;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.action.DocReceiveAction;
import com.assoft.doc.common.schema.AschemaDocReceive;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.rpc.client.rmi.AsopRmiClientENV;
import com.soft.web.action.base.ConResponseListInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author liuyanchao
 * @date 2020-07-03 2:27 下午
 */
public class StatisticsAllByTitle {

    private static String DOC_RMI_URL = "10.171.251.241:1070";

    private static String CI = "内部";
    public static void main(String[] args) {
        DocReceiveAction docReceiveAction = AsopRmiClientENV.gainRemoteProxy(DOC_RMI_URL, DocReceiveAction.class);

        AschemaDocReceive docReceive = new AschemaDocReceive();
        docReceive.setTitle(CI);
        ConditionDomainSchema conditionDomainSchema = new ConditionDomainSchema();
        conditionDomainSchema.setSchema(docReceive);


        PageInfo pageInfo = new PageInfo(700);


        ActionResultInfo<ConResponseListInfo<AschemaDocReceive>> actionResultInfo = docReceiveAction.listDocReceives(conditionDomainSchema, pageInfo);
        ConResponseListInfo<AschemaDocReceive> result = actionResultInfo.getResult();



        List<AschemaDocReceive> list = result.getContents();

        HashSet<String> docTitleSet = new HashSet<>();



        list.stream().forEach(doc->{
            docTitleSet.add(doc.getTitle());
        });

        docTitleSet.stream().forEach(s->{
            System.out.println(s);
        });

        System.out.println("包含《"+CI+"》重复 "+list.size()+" 条");
        System.out.println("包含《"+CI+"》共计 "+docTitleSet.size()+" 条");




    }

}
