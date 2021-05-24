package com.zyj.spring.tx.annotation.Service.impl;

import com.zyj.spring.tx.annotation.Dao.BookShopDao;
import com.zyj.spring.tx.annotation.Service.BookShopService;
import com.zyj.spring.tx.annotation.exception.UserAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName BookShopServiceImpl
 * @Auther: YaJun
 * @Date: 2021 - 03 - 21 - 23:05
 * @Description: com.zyj.spring.tx.annotation.Service.impl
 * @version: 1.0
 */
@Transactional  // 对当前类中所有方法都起作用
@Service
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    // @Transaction 可以标到类上，也可以标到方法上，如果类与方法上都有该注解，则方法上的优先。
    // 因为可能在个别方法上要做一些额外的配置
    // 只对当前方法起作用

    /**
     * 事务属性
     *      1、事务的传播行为 propagation：一个事务方法被另外一个事务方法调用时，当前的事务如何使用事务
     *          Propagation.REQUIRED    默认值。 不设置它的传播行为
     *          Propagation.REQUIRES_NEW    将调用者的事务挂起，重新开启事务来使用
     *      2、事务的隔离级别 isolation：
     *              1 读未提交 READ_COMMITTED     脏读
     *              2 读已提交 READ_COMMITTED     不可重复读
     *              4 可重复读 REPEATABLE_READ     幻读
     *              8 串行化   SERIALIZABLE     效率低
     *      在 Mysql 中默认的事务隔离级别是 可重复读 REPEATABLE_READ，在这其实使用 读已提交 READ_COMMITTED 就足够了
     *      3、事务的回滚与不回滚：默认情况下，Spring 会对所有的运行时异常进行事务回滚操作
     *          回滚：
     *          rollbackFor
     *          rollbackForClassName
     *          不回滚：
     *          noRollbackFor
     *          noRollbackForClassName
     *
     *      4、事务的只读设置：
     *          readOnly：
     *              true：只读     代表着只会对数据库进行读取操作，不能做修改操作
     *                      如果【确保】当前的事务只有读取操作，就有必要设置为只读
     *                      可以帮助数据库引擎优化事务
     *                      注意：如果设置为只读，Spring 不会对该事务进行加锁操作，如果实际操作是修改，将会抛出以下的异常
     *                      PreparedStatementCallback; SQL [update book_stock set stock = stock - 1 where isbn = ? ]; Connection is read-only. Queries leading to data modification are not allowed; nested exception is java.sql.SQLException: Connection is read-only. Queries leading to data modification are not allowed
     *              false：非只读（读写）
     *
     *      5、事务的超时设置：设置事务在强制回滚之前可以占用的时间
     *          timeout：
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,/*noRollbackFor = {UserAccountException.class}*/readOnly = false,timeout = 3)
    public void buyBook(String name, String isbn) {

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        int price = bookShopDao.findPrice(isbn);

        bookShopDao.updateStock(isbn);

        bookShopDao.updateUserAccount(name, price);

    }
}
