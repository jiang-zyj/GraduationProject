package com.zyj.Test;

import com.zyj.database.MyPoolConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @ClassName DaoImplTest
 * @Auther: YaJun
 * @Date: 2021 - 03 - 28 - 14:40
 * @Description: com.zyj.Test
 * @version: 1.0
 */
public class DaoImplTest {

    static QueryRunner runner = new QueryRunner(MyPoolConnectionUtils.getDataSource());
    public static void main(String[] args) {
        /*try {

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/
    }

}
