package com.zyj.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;

/**
 * @ClassName UserDao
 * @Auther: YaJun
 * @Date: 2021 - 03 - 21 - 20:12
 * @Description: com.zyj.spring.jdbc
 * @version: 1.0
 */

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate npjt;

    public void insertUser(User user) {
        String sql = "insert into user values(null,:username,:password)";
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
        npjt.update(sql, paramSource);
    }

}
