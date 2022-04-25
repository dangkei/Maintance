package com.assoft.doc.common.actionextend;

  import java.util.List;
import java.util.Map;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.doc.common.form.ZfbConfig;


public interface SettingExtendAction {



	ActionResultInfo<String> wirteJs(List<ZfbConfig> list, String jsPath);

}
