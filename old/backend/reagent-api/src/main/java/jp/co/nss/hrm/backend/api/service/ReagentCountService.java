package jp.co.nss.hrm.backend.api.service;

import jp.co.nss.hrm.backend.api.dto.ReagentCount;
import jp.co.nss.hrm.backend.api.dto.ReagentEcharts;
import jp.co.nss.hrm.backend.model.ReagentCollect;

import java.util.List;

public interface ReagentCountService {

    List<ReagentEcharts> chartLine(String username);

    List<ReagentEcharts> chartBar(String username);

    List<ReagentEcharts> chartPie(String username);

    ReagentCount getCount(String username);

    ReagentCount getHomeCount(String username);

    String getBranch(String username);

    List<ReagentEcharts> chartBarTop(String username);

}


