package com.zyj.Test;

import com.zyj.database.MyPoolConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName ConnectionTest
 * @Auther: YaJun
 * @Date: 2021 - 03 - 28 - 14:15
 * @Description: com.zyj.Test
 * @version: 1.0
 */
public class ConnectionTest {
    public static void main(String[] args) throws SQLException {
        // 获取数据源
        DataSource dataSource = MyPoolConnectionUtils.getDataSource();
//        Connection connection = MyPoolConnectionUtils.getConnection();
//        System.out.println(connection);
//        String sql = "insert into users values('432503199901175932','曾亚军3','123123','男','湖南娄底','18374869111',null,'2412305937@qq.com')";
        String sql = "insert into `user` values(null,'123','123')";
        QueryRunner runner = new QueryRunner(dataSource);
        int update = runner.update(sql);
        System.out.println(update);
        // 输出数据源
//        System.out.println(dataSource);
        // com.mchange.v2.c3p0.ComboPooledDataSource...... 测试正常
    }
}
