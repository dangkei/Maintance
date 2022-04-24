package com.assoft.doc.common.actionextend;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.doc.common.schema.AschemaCommonOpinion;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.soft.web.action.base.ConResponseListInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author:YanchaoLiu
 * @Description: 常用意见
 * @date:Created in 15:43 2019/12/2
 */
public interface CommonOpinionExtendAction {


    /**
     * 列表
     * @param conditionDomainSchema
     * @param pageInfo
     * @return
     */
    ActionResultInfo<ConResponseListInfo<AschemaCommonOpinion>> listCommonOpinions(ConditionDomainSchema<AschemaCommonOpinion> conditionDomainSchema, PageInfo pageInfo);

    /**
     * 新增常用意见
     * @param entity
     * @param emap
     * @return
     */
    ActionResultInfo<AschemaCommonOpinion> saveNewCommonOpinion(AschemaCommonOpinion entity, Map<String, List<AssoftFileObj>> emap);

    /**
     * 删除
     * @param list
     * @return
     */
    ActionResultInfo<String> removeCommonOpinions(List<String> list);

    /**
     * 顺序上调
     * @param id
     */
    ActionResultInfo<ConResponseListInfo<AschemaCommonOpinion>> upSort(String id,String loginName,PageInfo pageInfo);

    /**
     * 顺序下调
     * @param id
     */
    ActionResultInfo<ConResponseListInfo<AschemaCommonOpinion>> downSort(String id,String loginName,PageInfo pageInfo);


}
