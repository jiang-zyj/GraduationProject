package com.zyj.spring.annotation.dao.impl;

import com.zyj.spring.annotation.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserDaoImpl
 * @Auther: YaJun
 * @Date: 2021 - 03 - 18 - 15:02
 * @Description: com.zyj.spring.annotation.Dao.impl
 * @version: 1.0
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void addUser() {
        System.out.println("UserDao Jdbc ...");
    }
}
