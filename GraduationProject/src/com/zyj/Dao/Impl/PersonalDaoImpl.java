package com.zyj.Dao.Impl;

import com.zyj.Dao.PersonalDao;
import com.zyj.Pojo.*;
import com.zyj.database.MyPoolConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName PersonalDaoImpl
 * @Auther: YaJun
 * @Date: 2021 - 04 - 03 - 18:16
 * @Description: com.zyj.Dao.Impl
 * @version: 1.0
 */

public class PersonalDaoImpl implements PersonalDao {

    QueryRunner runner = new QueryRunner(MyPoolConnectionUtils.getDataSource());

    @Override
    public List<RiskCity_Temp> queryRegionLevel(String date) {
        try {
            String sql = "select sum(Increment_Confirmed) as 'sumConfirmed',cname as 'cname' from (select * from covid19_data where Last_Update < ? limit 0,434) b GROUP BY cname";
            return runner.query(sql,new BeanListHandler<RiskCity_Temp>(RiskCity_Temp.class),date);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void removeAllRiskCityData() {
        try {
            // 截断表---删除表中所有数据，且重新从 1 开始计数
            String sql = "truncate risk_city";
            runner.update(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void addRiskData(String risk_desc, String cname) {
        try {
            String sql = "insert into risk_city values(null,?,?)";
            runner.update(sql,risk_desc,cname);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Health_Record> queryHealthRecord(String uid,String date) {
        try {
            String sql = "select * from healthrecord where uid = ? and curr_time <= '" + date + "' limit 0,3";
            return runner.query(sql,new BeanListHandler<Health_Record>(Health_Record.class),uid);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void removeHealthCodeByUid(String uid) {
        try {
            String sql = "delete from health_code where uid = ?";
            runner.update(sql,uid);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void addHealthCode(String healthStatus, String uid) {
        try {
            String sql = "insert into health_code values(null,?,?)";
            runner.update(sql,healthStatus,uid);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Health_Code queryHealthCodeByUid(String uid) {
        try {
            String sql = "select * from health_code where uid = ?";
            return runner.query(sql,new BeanHandler<Health_Code>(Health_Code.class),uid);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int queryPageTotalCountForRiskCity() {
        try {
            String sql = "select count(*) from risk_city";
            Number number = (Number) runner.query(sql, new ScalarHandler());
            return number.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<RiskCity> queryAllRiskCity(int StartIndex, int pageSize) {
        try {
            String sql = "select * from risk_city limit ?,?";
            return runner.query(sql,new BeanListHandler<RiskCity>(RiskCity.class),StartIndex,pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<City> queryAllCity() {
        try {
            String sql = "select * from city";
            return runner.query(sql,new BeanListHandler<City>(City.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String queryCOVIDIndexByCname(String city) {
        try {
            String sql = "select risk_desc from risk_city where cname = ?";
            String risk_desc = (String) runner.query(sql, new ScalarHandler(), city);
            return risk_desc;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean addHealthRecord(Health_Record health_record) {
        try {
            String sql = "insert into healthrecord values(null,?,?,?,?,?)";
            int i = runner.update(sql, health_record.getCurr_time(), health_record.getHealth_status(), health_record.getName(), health_record.getCname(), health_record.getUid());
            return i > 0 ? true : false;
//            String newSql = "insert into healthrecord values(null,?,?,?,?,?)";
//
//            int i = runner.update(newSql,health_record.getCurr_time(),health_record.getHealth_status(),health_record.getName(),health_record.getCname(),health_record.getUid());
//            return i > 0 ? true :false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getCause()+"\t"+e.getMessage());
        }
    }

    @Override
    public int queryHealthRecordPageTotalCountByUid(String uid) {
        try {
            String sql = "select count(*) from healthrecord where uid = ?";
            Number number = (Number) runner.query(sql, new ScalarHandler(), uid);
            return number.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Health_Record> queryPageItemsByUid(int startIndex, int pageSize, String uid) {
        try {
            String sql = "select * from healthrecord where uid = ? limit ?,?";
            return runner.query(sql,new BeanListHandler<Health_Record>(Health_Record.class),uid,startIndex,pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
