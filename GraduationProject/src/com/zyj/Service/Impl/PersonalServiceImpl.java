package com.zyj.Service.Impl;

import com.zyj.Dao.Impl.PersonalDaoImpl;
import com.zyj.Dao.PersonalDao;
import com.zyj.Pojo.*;
import com.zyj.Service.PersonalService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

/**
 * @ClassName PersonalServiceImpl
 * @Auther: YaJun
 * @Date: 2021 - 04 - 03 - 18:10
 * @Description: com.zyj.Service.Impl
 * @version: 1.0
 */

public class PersonalServiceImpl implements PersonalService {

    PersonalDao dao = new PersonalDaoImpl();

    @Override
    public void removeAllRiskCityData() {
        dao.removeAllRiskCityData();
    }

    @Override
    public void queryRegionLevel(String date) {
            List<RiskCity_Temp> list = dao.queryRegionLevel(date);
            // 遍历临时表中的数据，判断城市的风险等级，并存入数据库中
            for (RiskCity_Temp riskCity_temp : list) {
                RiskCity riskCity = new RiskCity();
                Integer sumConfirmed = riskCity_temp.getSumConfirmed();
                String cname = riskCity_temp.getCname();
                if (sumConfirmed == 0) { // 低风险
                    // 为风险城市表插入数据
                    String risk_desc = "low";
                    dao.addRiskData(risk_desc, cname);
                } else if (sumConfirmed > 0 && sumConfirmed < 50) { // 中等风险
                    String risk_desc = "middle";

                    dao.addRiskData(risk_desc, cname);
                } else {    //高风险
                    String risk_desc = "high";
                    dao.addRiskData(risk_desc, cname);
                }
            }
    }

    @Override
    public List<Health_Record> queryHealthRecord(String uid, String date) {
        return dao.queryHealthRecord(uid, date);
    }

    @Override
    public void removeHealthCodeByUid(String uid) {
        dao.removeHealthCodeByUid(uid);
    }

    @Override
    public void addHealthCode(String healthStatus, String uid) {
        dao.addHealthCode(healthStatus, uid);
    }

    @Override
    public Health_Code queryHealthCodeByUid(String uid) {
        return dao.queryHealthCodeByUid(uid);
    }

    @Override
    public int queryPageTotalCountForRiskCity() {
        return dao.queryPageTotalCountForRiskCity();
    }

    @Override
    public List<RiskCity> queryAllRiskCity(String date, int StartIndex, int pageSize) {
        List<RiskCity_Temp> list = dao.queryRegionLevel(date);
        // 遍历临时表中的数据，判断城市的风险等级，并存入数据库中
        for (RiskCity_Temp riskCity_temp : list) {
            RiskCity riskCity = new RiskCity();
            Integer sumConfirmed = riskCity_temp.getSumConfirmed();
            String cname = riskCity_temp.getCname();
            if (sumConfirmed == 0) { // 低风险
                // 为风险城市表插入数据
                String risk_desc = "low";
                dao.addRiskData(risk_desc, cname);
            } else if (sumConfirmed > 0 && sumConfirmed < 50) { // 中等风险
                String risk_desc = "middle";

                dao.addRiskData(risk_desc, cname);
            } else {    //高风险
                String risk_desc = "high";
                dao.addRiskData(risk_desc, cname);
            }
        }
        // 查询数据
        return dao.queryAllRiskCity(StartIndex,pageSize);
    }

    @Override
    public List<City> queryAllCity() {
        return dao.queryAllCity();
    }

    @Override
    public double queryCOVIDIndexByCname(String city, String date) {
        // 删除并更新风险城市表
        removeAllRiskCityData();
        queryRegionLevel(date);
        // 查询所在城市风险程度
        String riskLevel = dao.queryCOVIDIndexByCname(city);
        if ("high".equals(riskLevel)) {
            return 10.0;
        } else if ("middle".equals(riskLevel)) {
            return 5.0;
        } else {
            return 0.0;
        }
    }

    @Override
    public boolean addHealthRecord(Health_Record health_record) {
        return dao.addHealthRecord(health_record);
    }

    @Override
    public int queryHealthRecordPageTotalCountByUid(String uid) {
        return dao.queryHealthRecordPageTotalCountByUid(uid);
    }

    @Override
    public List<Health_Record> queryPageItemsByUid(int startIndex, int pageSize, String uid) {
        return dao.queryPageItemsByUid(startIndex,pageSize,uid);
    }


}
