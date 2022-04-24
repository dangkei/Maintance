package com.assoft.car.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.car.common.schema.AschemaCar;
import com.soft.web.action.base.ConResponseListInfo;

public interface CarAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaCar>> listCars(ConditionDomainSchema<AschemaCar> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaCar> listCars(AschemaCar condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaCar loadCar(AschemaCar condition,AsopQueryRequestParam param);
	public int loadNum(AschemaCar condition,AsopQueryRequestParam param);
	public String removeCars(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaCar>> listCars(ConditionDomainSchema<AschemaCar> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeCars(List<String> idList);
	
	public ActionResultInfo<AschemaCar> loadCar(String id);
	
	public ActionResultInfo<AschemaCar> saveNewCar(AschemaCar entity);
	
	public ActionResultInfo<AschemaCar> saveNewCar(AschemaCar entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateCar(AschemaCar entity);
	public ActionResultInfo<String> updateCar(AschemaCar entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
