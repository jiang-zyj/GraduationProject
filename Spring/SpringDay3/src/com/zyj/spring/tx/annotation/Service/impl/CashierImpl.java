package com.zyj.spring.tx.annotation.Service.impl;

import com.zyj.spring.tx.annotation.Dao.BookShopDao;
import com.zyj.spring.tx.annotation.Service.BookShopService;
import com.zyj.spring.tx.annotation.Service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName CashierImpl
 * @Auther: YaJun
 * @Date: 2021 - 03 - 21 - 23:46
 * @Description: com.zyj.spring.tx.annotation.Service.impl
 * @version: 1.0
 */
@Service
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

    @Transactional
    public void checkOut(String name, List<String> isbns) {
        for (String isbn : isbns) {
            bookShopService.buyBook("Tom", isbn);
        }
    }
}
