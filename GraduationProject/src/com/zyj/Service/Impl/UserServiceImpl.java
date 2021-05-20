package com.zyj.Service.Impl;

import com.zyj.Dao.Impl.UserDaoImpl;
import com.zyj.Dao.UserDao;
import com.zyj.Pojo.City;
import com.zyj.Pojo.User;
import com.zyj.Service.UserService;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Auther: YaJun
 * @Date: 2021 - 03 - 29 - 17:32
 * @Description: com.zyj.Service.Impl
 * @version: 1.0
 */

public class  UserServiceImpl implements UserService {

    UserDao dao = new UserDaoImpl();

    @Override
    public boolean login(User user) {
        // 调用 Dao 层查询用户是否存在
        return dao.queryUser(user);
    }

    @Override
    public boolean checkEmail(String email) {
        // 调用 Dao 层查询邮箱是否已注册
        User u = dao.checkEmail(email);
        // true 为邮箱可用（未被注册）
        return u == null ? true : false;
    }

    @Override
    public boolean checkUid(String uid) {
        // 调用 Dao 层查询邮箱是否已注册
        User u = dao.checkUid(uid);
        // true 为邮箱可用（未被注册）
        return u == null ? true : false;
    }

    @Override
    public void addUserCode(User user) {
        // 添加用户的 code 值
        dao.addUserCode(user);
    }

    @Override
    public User loginByUid(User user) {
        return dao.loginByUid(user);
    }

    @Override
    public int queryUserTotalCountForLayUI(User user) {
        return dao.queryUserTotalCountForLayUI(user);
    }

    @Override
    public List<User> queryUserItemsForLayUI(int startIndex, int pageSize,User user) {
        return dao.queryUserItemsForLayUI(startIndex,pageSize,user);
    }

    @Override
    public List<City> loadAllCname() {
        return dao.loadAllCname();
    }

    @Override
    public boolean batchDeleteUser(String uidStr) {
        return dao.batchDeleteUser(uidStr);
    }

    @Override
    public boolean editUser(User user) {
        return dao.editUser(user);
    }

    @Override
    public boolean deleteUserByUid(String uid) {
        return dao.deleteUserByUid(uid);
    }

}
