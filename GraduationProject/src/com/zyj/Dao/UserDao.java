package com.zyj.Dao;

import com.zyj.Pojo.City;
import com.zyj.Pojo.User;

import java.util.List;

/**
 * @ClassName UserDao
 * @Auther: YaJun
 * @Date: 2021 - 03 - 29 - 17:38
 * @Description: com.zyj.Dao
 * @version: 1.0
 */
public interface UserDao {
    /**
     * 查询用户是否存在（登录）
     * @param user
     * @return
     */
    boolean queryUser(User user);

    /**
     * 查询邮箱是否被注册
     * @param email
     * @return
     */
    User checkEmail(String email);

    /**
     * 查询用户身份证号是否被注册
     * @param uid
     * @return
     */
    User checkUid(String uid);

    /**
     * 添加用户激活码
     * @param user
     */
    void addUserCode(User user);

    User loginByUid(User user);

    int queryUserTotalCountForLayUI(User user);

    List<User> queryUserItemsForLayUI(int startIndex, int pageSize,User user);

    List<City> loadAllCname();

    boolean batchDeleteUser(String uidStr);

    boolean editUser(User user);

    boolean deleteUserByUid(String uid);
}
