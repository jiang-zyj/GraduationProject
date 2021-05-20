package com.zyj.Dao.Impl;

import com.zyj.Dao.ScenicDao;
import com.zyj.Pojo.City;
import com.zyj.Pojo.Scenic;
import com.zyj.database.MyPoolConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName ScenicDaoImpl
 * @Auther: YaJun
 * @Date: 2021 - 03 - 30 - 13:29
 * @Description: com.zyj.Dao.Impl
 * @version: 1.0
 */
public class ScenicDaoImpl implements ScenicDao {

    QueryRunner runner = new QueryRunner(MyPoolConnectionUtils.getDataSource());

    @Override
    public int queryScenicByCity(String city) {
        try {
            String sql = "select count(*) from scenic where cname = ?";
            Number i = (Number) runner.query(sql, new ScalarHandler(), city);
            return i.intValue() > 0 ? i.intValue() : -1;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Scenic> queryItemsByPage(String city, int startIndex, int pageSize) {
        try {
            String sql = "select * from scenic,city where scenic.cname = city.cname and scenic.cname = ? limit ?,?";
            return runner.query(sql,new BeanListHandler<Scenic>(Scenic.class),city,startIndex,pageSize);
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
    public int queryScenicTotalCountForLayUI(Scenic searchScenic) {
        try {
            String sql = "select count(*) from scenic where 1 = 1 ";
            if (searchScenic != null) {
                String cname = searchScenic.getCname();
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
    public List<Scenic> queryScenicItemsForLayUI(int startIndex, int pageSize, Scenic searchScenic) {
        try {
            String sql = "select * from scenic where 1 = 1 ";
            if (searchScenic != null) {
                String cname = searchScenic.getCname();
                if (cname != null) {
                    sql += "and cname = '" + cname + "'";
                }
            }
            sql += " limit ?,?";
            return runner.query(sql, new BeanListHandler<Scenic>(Scenic.class),startIndex,pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean saveScenic(Scenic s) {
        try {
            String sql = "insert into scenic values(null,?,?,?,?,?,?,?)";

            int i = runner.update(sql, s.getScenic_name(), s.getScenic_pic(), s.getScenic_addr(), s.getBusiness_hours(), s.getScenic_opened(), s.getScenic_flag(), s.getCname());
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean batchDeleteScenic(String ids) {
        try {
            String sql = "delete from scenic where sid in (" + ids + ")";
            int i = runner.update(sql);
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean editScenic(Scenic s) {
        try {
            String sql = "update scenic set scenic_name = ?, scenic_pic = ?, scenic_addr = ?, business_hours = ?, scenic_opened = ?, scenic_flag = ?, cname = ? where sid = ?";
            int i = runner.update(sql,s.getScenic_name(),s.getScenic_pic(),s.getScenic_addr(),s.getBusiness_hours(),s.getScenic_opened(),s.getScenic_flag(),s.getCname(),s.getSid());
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean deleteScenicBySid(int sid) {
        try {
            String sql = "delete from scenic where sid = ?";
            int i = runner.update(sql, sid);
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
