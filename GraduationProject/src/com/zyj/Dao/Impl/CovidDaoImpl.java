package com.zyj.Dao.Impl;

import com.zyj.Dao.CovidDao;
import com.zyj.Pojo.COVID19_Data;
import com.zyj.Pojo.City;
import com.zyj.database.MyPoolConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName CovidDaoImpl
 * @Auther: YaJun
 * @Date: 2021 - 04 - 13 - 18:21
 * @Description: com.zyj.Dao.Impl
 * @version: 1.0
 */
public class CovidDaoImpl implements CovidDao {

    QueryRunner runner = new QueryRunner(MyPoolConnectionUtils.getDataSource());

    @Override
    public int queryCovidTotalCountForLayUI(COVID19_Data searchData) {
        try {
            String sql = "select count(*) from covid19_data where 1 = 1 ";
            if (searchData != null) {
                String cname = searchData.getCname();
                if (cname != null) {
                    sql += "and cname = '" + cname + "'";
                }
            }
            Number number = (Number) runner.query(sql, new ScalarHandler());
            return number.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<COVID19_Data> queryCovidItemsForLayUI(int startIndex, int pageSize, COVID19_Data searchData) {
        try {
            String sql = "select * from covid19_data where 1 = 1 ";
            if (searchData != null) {
                String cname = searchData.getCname();
                if (cname != null) {
                    sql += "and cname = '" + cname + "'";
                }
            }
            sql += " limit ?,?";
            return runner.query(sql,new BeanListHandler<COVID19_Data>(COVID19_Data.class),startIndex,pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean saveCovidData(COVID19_Data d) {
        try {
            String sql = "insert into covid19_data values(null,?,?,?,?,?,?,?,?,?)";
            int i = runner.update(sql, d.getCountryOrRegion(), d.getLast_Update(), d.getConfirmed(), d.getDeaths(), d.getRecovered(), d.getIncrement_Confirmed(), d.getIncrement_Deaths(), d.getIncrement_Recovered(), d.getCname());
            return i > 0 ? true :false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean batchDeleteCovidData(String ids) {
        try {
            String sql = "delete from covid19_data where covid_id in (" + ids + ")";
            int i = runner.update(sql);
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean editCovidData(COVID19_Data d) {
        try {
            String sql = "update covid19_data set countryOrRegion = ?, last_Update = ?, confirmed = ?, deaths = ?, recovered = ?, increment_Confirmed = ?, increment_Deaths = ?, increment_Recovered = ?, cname = ? where covid_id = ?";
            int i = runner.update(sql,d.getCountryOrRegion(),d.getLast_Update(),d.getConfirmed(),d.getDeaths(),d.getRecovered(),d.getIncrement_Confirmed(),d.getIncrement_Deaths(),d.getIncrement_Recovered(),d.getCname(),d.getCovid_id());
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean deleteCovidDataByCovid_id(int covid_id) {
        try {
            String sql = "delete from covid19_data where covid_id = ?";
            int i = runner.update(sql, covid_id);
            return i > 0 ? true : false;
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
    public List<COVID19_Data> queryCovidData() {
        try {
            String sql = "select sum(confirmed) as confirmedSum , last_Update from covid19_data group by last_Update";
            return runner.query(sql,new BeanListHandler<COVID19_Data>(COVID19_Data.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<COVID19_Data> queryCovidIncrement_ConfirmedData() {
        try {
            String sql = "select sum(increment_Confirmed) as increment_ConfirmedSum , last_Update from covid19_data group by last_Update";
            return runner.query(sql,new BeanListHandler<COVID19_Data>(COVID19_Data.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<COVID19_Data> queryCovidDeathsData() {
        try {
            String sql = "select sum(deaths) as deathsSum , last_Update from covid19_data group by last_Update";
            return runner.query(sql,new BeanListHandler<COVID19_Data>(COVID19_Data.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<COVID19_Data> queryCovidIncrement_DeathsData() {
        try {
            String sql = "select sum(increment_Deaths) as increment_DeathsSum , last_Update from covid19_data group by last_Update";
            return runner.query(sql,new BeanListHandler<COVID19_Data>(COVID19_Data.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<COVID19_Data> queryCovidRecoveredData() {
        try {
            String sql = "select sum(recovered) as recoveredSum , last_Update from covid19_data group by last_Update";
            return runner.query(sql,new BeanListHandler<COVID19_Data>(COVID19_Data.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<COVID19_Data> queryCovidIncrement_RecoveredData() {
        try {
            String sql = "select sum(increment_Recovered) as increment_RecoveredSum , last_Update from covid19_data group by last_Update";
            return runner.query(sql,new BeanListHandler<COVID19_Data>(COVID19_Data.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<COVID19_Data> queryCovidCityConfirmedData() {
        try {
            String sql = "select sum(confirmed) as cityConfirmedSum , cname from covid19_data group by cname";
            return runner.query(sql,new BeanListHandler<COVID19_Data>(COVID19_Data.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
