package com.zyj.Dao;

import com.zyj.Pojo.*;

import java.util.List;

/**
 * @ClassName PersonalDao
 * @Auther: YaJun
 * @Date: 2021 - 04 - 03 - 18:16
 * @Description: com.zyj.Dao
 * @version: 1.0
 */
public interface PersonalDao {
    List<RiskCity_Temp> queryRegionLevel(String date);

    void removeAllRiskCityData();

    void addRiskData(String risk_desc, String cname);

    List<Health_Record> queryHealthRecord(String uid,String date);

    void removeHealthCodeByUid(String uid);

    void addHealthCode(String healthStatus, String uid);


    Health_Code queryHealthCodeByUid(String uid);

    int queryPageTotalCountForRiskCity();

    List<RiskCity> queryAllRiskCity(int StartIndex, int pageSize);


    List<City> queryAllCity();

    String queryCOVIDIndexByCname(String city);

    boolean addHealthRecord(Health_Record health_record);

    int queryHealthRecordPageTotalCountByUid(String uid);

    List<Health_Record> queryPageItemsByUid(int startIndex, int pageSize, String uid);
}
