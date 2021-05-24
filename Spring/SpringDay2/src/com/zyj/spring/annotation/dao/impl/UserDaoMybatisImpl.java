package com.zyj.spring.annotation.dao.impl;

import com.zyj.spring.annotation.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserDaoMybatisImpl
 * @Auther: YaJun
 * @Date: 2021 - 03 - 20 - 16:57
 * @Description: com.zyj.spring.annotation.Dao.impl
 * @version: 1.0
 */
@Repository
public class UserDaoMybatisImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("UserDao Mybatis...");
    }
}
