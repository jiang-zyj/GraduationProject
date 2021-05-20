package com.zyj.Dao.Impl;

import com.zyj.Dao.UserDao;
import com.zyj.Pojo.City;
import com.zyj.Pojo.User;
import com.zyj.database.MyPoolConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName UserDaoImpl
 * @Auther: YaJun
 * @Date: 2021 - 03 - 29 - 17:38
 * @Description: com.zyj.Dao.Impl
 * @version: 1.0
 */
public class UserDaoImpl implements UserDao {

    // 获取数据源
    QueryRunner runner = new QueryRunner(MyPoolConnectionUtils.getDataSource());

    @Override
    public boolean queryUser(User user) {
        try {
            String sql = "insert into user values (?,?,?,?,?,?,?,?,?)";
            int i = runner.update(sql, user.getUid(), user.getName(),
                    user.getPassword(), user.getSex(), user.getAddress(), user.getTel(), user.getCode(), user.getEmail(), user.getStatus());
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public User checkEmail(String email) {
        try {
            String sql = "select * from user where email = ?";
            return runner.query(sql, new BeanHandler<User>(User.class), email);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public User checkUid(String uid) {
        try {
            String sql = "select * from user where uid = ?";
            return runner.query(sql, new BeanHandler<User>(User.class), uid);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void addUserCode(User user) {
        try {
            String sql = "update user set code = ? where uid = ?";
            runner.update(sql, user.getCode(), user.getUid());
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public User loginByUid(User user) {
        try {
            String sql = "select * from user where uid = ? or email = ?";
            return runner.query(sql, new BeanHandler<User>(User.class), user.getUid(), user.getEmail());
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int queryUserTotalCountForLayUI(User user) {
        try {
            String sql = "select count(*) from user where 1 = 1 ";
            if (user != null) {
                String uid = user.getUid();
                if (uid != null) {
                    sql += "and uid like '%" + uid + "%'";
                }
            }
            Number number = (Number) runner.query(sql, new ScalarHandler());
            return number.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<User> queryUserItemsForLayUI(int startIndex, int pageSize,User user) {
        try {
            String sql = "select * from user where 1 = 1 ";
            if (user != null) {
                String uid = user.getUid();
                if (uid != null) {
                    sql += "and uid like '%" + uid + "%'";
                }
            }
            sql += " limit ?,?";
            return runner.query(sql, new BeanListHandler<User>(User.class), startIndex, pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<City> loadAllCname() {
        try {
            String sql = "select * from city";
            return runner.query(sql, new BeanListHandler<City>(City.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean batchDeleteUser(String uidStr) {
        try {
            String sql = "delete from user where uid in (" + uidStr + ")";
            int i = runner.update(sql);
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean editUser(User user) {
        try {
            String sql = "update user set uid = ?,name = ?,password = ?,sex = ?,address = ?,tel = ?, email = ? where uid = ?";
            int i = runner.update(sql, user.getUid(), user.getName(),
                    user.getPassword(), user.getSex(), user.getAddress(), user.getTel(), user.getEmail(), user.getUid());
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean deleteUserByUid(String uid) {
        try {
            String sql = "delete from user where uid = ?";
            int i = runner.update(sql, uid);
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
