package com.zyj.spring.annotation.service.impl;

import com.zyj.spring.annotation.dao.UserDao;
import com.zyj.spring.annotation.dao.impl.UserDaoImpl;
import com.zyj.spring.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Auther: YaJun
 * @Date: 2021 - 03 - 18 - 15:01
 * @Description: com.zyj.spring.annotation.Service.impl
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {


    /**
     * @Autowired 完成 bean 属性的自动装配
     *
     * 工作机制：
     *      首先会使用 byType 的方式进行自动装配，如果能唯一匹配，则装配成功
     *      如果匹配到多个兼容类型的 bean，不会立马抛异常，还会尝试使用 byName 的
     *      方式进行唯一性确定。
     *      如果能唯一确定，则装配成功，如果不能唯一确定，则装配失败，抛出异常
     *
     *  默认情况下，使用 @Autowired 标注的属性必须被装配，如果装配不了，也会抛出异常
     *  可以使用 required = false 来设置不是必须被装配的
     *
     *  如果匹配到多个兼容类型的 bean，可以使用 @Qualifier 进一步指定要装配的 bean 的 id 值
     *      格式：@Qualifier("userDaoMybatisImpl")，指定类名，其中类名首字母必须要小写
     *
     * @Autowired @Qualifier 注解既标识在成员变量上，也可标注在对应的 set 方法上
     */
    @Autowired(required = false)   // 自动装配 byName、byType
    @Qualifier("userDaoMybatisImpl")
    private UserDao userDao;


    /*@Autowired(required = false)   // 自动装配 byName、byType
    @Qualifier("userDaoMybatisImpl")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    @Override
    public void handleAddUser() {
        // 处理业务
        userDao.addUser();
    }
}
