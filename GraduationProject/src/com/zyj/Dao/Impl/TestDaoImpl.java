package com.zyj.Dao.Impl;

import com.zyj.Dao.TestDao;
import com.zyj.Pojo.Test;
import com.zyj.database.MyPoolConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName TestDaoImpl
 * @Auther: YaJun
 * @Date: 2021 - 04 - 29 - 16:36
 * @Description: com.zyj.Dao.Impl
 * @version: 1.0
 */
public class TestDaoImpl implements TestDao {

    QueryRunner runner = new QueryRunner(MyPoolConnectionUtils.getDataSource());

    @Override
    public int queryPageTotalCountForTest(Test test) {
        try {
            String sql = "select count(*) from t_user where 1 = 1 ";
            if (test != null) {
                String t_name = test.getT_name();
                if (t_name != null || t_name.length() != 0) {
                    sql += "and t_name=" + t_name;
                }
            }
            Number number = (Number) runner.query(sql, new ScalarHandler());
            return number.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Test> queryPageItemsForTest(int startIndex, int pageSize, Test test) {
        try {
            String sql = "select * from t_user where 1 = 1 ";
            if (test != null) {
                String t_name = test.getT_name();
                if (t_name != null) {
                    sql += "and t_name=" + t_name;
                }
            }
            sql += " limit ?,?";
            return runner.query(sql, new BeanListHandler<Test>(Test.class),startIndex,pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
