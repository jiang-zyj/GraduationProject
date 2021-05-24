package com.zyj.spring.tx.annotation.Dao.impl;

import com.zyj.spring.tx.annotation.Dao.BookShopDao;
import com.zyj.spring.tx.annotation.exception.BookStockException;
import com.zyj.spring.tx.annotation.exception.UserAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @ClassName BookShopDaoImpl
 * @Auther: YaJun
 * @Date: 2021 - 03 - 21 - 22:47
 * @Description: com.zyj.spring.tx.annotation.Dao.impl
 * @version: 1.0
 */
@Repository
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int findPrice(String isbn) {
        String sql = "select price from book where isbn = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }

    @Override
    public void updateStock(String isbn) {
        // 判断库存是否足够
        String sql = "select stock from book_stock where isbn = ?";
        Integer stock = jdbcTemplate.queryForObject(sql, Integer.class, isbn);

        if (stock <= 0) {
            throw new BookStockException("库存不足...");
        }

        sql = "update book_stock set stock = stock - 1 where isbn = ? ";
        jdbcTemplate.update(sql, isbn);
    }

    @Override
    public void updateUserAccount(String username, Integer price) {
        // 判断余额是否足够
        String sql = "select balance from account where username = ?";
        Integer balance = jdbcTemplate.queryForObject(sql, Integer.class, username);

        if (balance < price) {
            throw new UserAccountException("余额不足...");
        }

        sql = "update account set balance = balance - ? where username = ?";
        jdbcTemplate.update(sql, price, username);
    }
}
