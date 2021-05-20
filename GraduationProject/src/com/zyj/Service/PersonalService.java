package com.zyj.Service;

import com.zyj.Pojo.City;
import com.zyj.Pojo.Health_Code;
import com.zyj.Pojo.Health_Record;
import com.zyj.Pojo.RiskCity;

import java.util.List;

/**
 * @ClassName PersonalService
 * @Auther: YaJun
 * @Date: 2021 - 04 - 03 - 18:10
 * @Description: com.zyj.Service
 * @version: 1.0
 */
public interface PersonalService {

    /**
     * 删除风险城市中所有的数据
     */
    void removeAllRiskCityData();

    /**
     * 通过当前日期，查询最近十四天的疫情总感染人数，并评级
     * @param date
     */
    void queryRegionLevel(String date);

    /**
     * 通过 Session 中的 uid 和参数 date 来查询对应用户最近三次打卡的打卡记录
     * @param uid
     * @param date
     * @return
     */
    List<Health_Record> queryHealthRecord(String uid,String date);

    /**
     * 通过用户身份证号删除对应的健康码
     * @param uid
     */
    void removeHealthCodeByUid(String uid);

    /**
     * 为用户添加健康码
     */
    void addHealthCode(String healthStatus, String uid);


    /**
     * 通过 uid 查询对应的健康码
     * @param uid
     * @return
     */
    Health_Code queryHealthCodeByUid(String uid);

    /**
     * 查询风险城市总数
     * @return
     */
    int queryPageTotalCountForRiskCity();

    /**
     * 查询所有风险城市数据
     * @param date
     * @return
     */
    List<RiskCity> queryAllRiskCity(String date, int StartIndex, int pageSize);


    /**
     * 查询所有城市
     * @return
     */
    List<City> queryAllCity();

    /**
     * 查询所在城市新冠疫情值
     * @param city
     * @return
     */
    double queryCOVIDIndexByCname(String city, String date);

    /**
     * 添加打卡记录
     * @param health_record
     * @return
     */
    boolean addHealthRecord(Health_Record health_record);

    /**
     * 查询用户打卡记录的总记录数
     * @return
     */
    int queryHealthRecordPageTotalCountByUid(String uid);

    /**
     * 根据用户id查询打卡记录分页数据
     * @param startIndex
     * @param pageSize
     * @param uid
     * @return
     */
    List<Health_Record> queryPageItemsByUid(int startIndex, int pageSize, String uid);
}
