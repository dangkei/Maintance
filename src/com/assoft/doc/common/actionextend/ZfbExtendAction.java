package com.assoft.doc.common.actionextend;

  import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.doc.common.schema.AschemaReceiveSign;
import com.assoft.file.asopdb.po.PageInfo;
import com.soft.web.action.base.ConResponseListInfo;


public interface ZfbExtendAction {



	ActionResultInfo<ConResponseListInfo<AschemaReceiveSign>> listSigns(
			String docReceiveId, PageInfo pageInfo);

}
