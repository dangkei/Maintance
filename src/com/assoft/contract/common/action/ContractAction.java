package com.assoft.contract.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.contract.common.schema.AschemaContract;
import com.soft.web.action.base.ConResponseListInfo;

public interface ContractAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaContract>> listContracts(ConditionDomainSchema<AschemaContract> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaContract> listContracts(AschemaContract condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaContract loadContract(AschemaContract condition,AsopQueryRequestParam param);
	public int loadNum(AschemaContract condition,AsopQueryRequestParam param);
	public String removeContracts(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaContract>> listContracts(ConditionDomainSchema<AschemaContract> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeContracts(List<String> idList);
	
	public ActionResultInfo<AschemaContract> loadContract(String id);
	
	public ActionResultInfo<AschemaContract> saveNewContract(AschemaContract entity);
	
	public ActionResultInfo<AschemaContract> saveNewContract(AschemaContract entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateContract(AschemaContract entity);
	public ActionResultInfo<String> updateContract(AschemaContract entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
