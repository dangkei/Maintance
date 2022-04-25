package com.assoft.doc.common.actionextend;

import java.util.List;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.asopdomain.exchange.domain.AsopDomain;
import com.asopdomain.exchange.domain.LuceneDomain;

public interface SyncDbExtendAction {

	boolean removeChache(AsopDomain asopDomain);

	boolean removeLuceneChache(AsopDomain asopDomain);

	ActionResultInfo<String> deleteData(List<String> ids);

	ActionResultInfo<String> removeLuceneData(List<String> ids, boolean rebuild);

	LuceneDomain buildLuceneDomain(AsopDomain domain);

	boolean saveDomainAttr(String docReceiveId);



}
