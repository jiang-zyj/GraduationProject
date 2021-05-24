package Spring.zyj.ss.Dao;

import org.springframework.stereotype.Repository;

/**
 * @ClassName UserDao
 * @Auther: YaJun
 * @Date: 2021 - 04 - 18 - 11:50
 * @Description: Spring.zyj.ss.Dao
 * @version: 1.0
 */
@Repository
public class UserDao {

    public UserDao() {
        System.out.println("UserDao");
    }

    public void hello() {
        System.out.println("UserDao Hello...");
    }
}
