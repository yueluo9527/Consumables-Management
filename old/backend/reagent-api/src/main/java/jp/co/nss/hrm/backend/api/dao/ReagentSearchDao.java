package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.model.ReagentSearch;

import java.util.List;

public interface ReagentSearchDao {


    List<ReagentSearch> searchByDouble(String key1,String key2);
}
