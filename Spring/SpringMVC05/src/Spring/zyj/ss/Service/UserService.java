package Spring.zyj.ss.Service;

import Spring.zyj.ss.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Auther: YaJun
 * @Date: 2021 - 04 - 18 - 11:50
 * @Description: Spring.zyj.ss.Service
 * @version: 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserService() {
        System.out.println("UserService");
    }


    public void hello() {
        userDao.hello();
    }
}
