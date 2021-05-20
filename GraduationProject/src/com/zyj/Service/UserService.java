package com.zyj.Service;

import com.zyj.Pojo.City;
import com.zyj.Pojo.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Auther: YaJun
 * @Date: 2021 - 03 - 29 - 17:32
 * @Description: com.zyj.Service
 * @version: 1.0
 */
public interface UserService {
    boolean login(User user);

    boolean checkEmail(String email);

    boolean checkUid(String uid);

    void addUserCode(User user);

    /**
     * 用户通过 Uid或Email 判断是否存在该用户
     * @param user
     * @return
     */
    User loginByUid(User user);

    /**
     * 通过 LayUI 查询用户表总记录数
     * @return
     */
    int queryUserTotalCountForLayUI(User user);

    /**
     * 通过 LayUI 查询用户表分页数据
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<User> queryUserItemsForLayUI(int startIndex, int pageSize,User user);

    /**
     * 查询所有城市信息
     * @return
     */
    List<City> loadAllCname();

    /**
     * 通过 uidStr 批量删除
     * @param uidStr
     * @return
     */
    boolean batchDeleteUser(String uidStr);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    boolean editUser(User user);

    /**
     * 通过 uid 删除用户
     * @param uid
     * @return
     */
    boolean deleteUserByUid(String uid);
}
