package com.zyj.spring.tx.annotation.Service;

import java.util.List;

/**
 * @ClassName Cashier
 * @Auther: YaJun
 * @Date: 2021 - 03 - 21 - 23:45
 * @Description: com.zyj.spring.tx.annotation.Service
 * @version: 1.0
 */
public interface Cashier {  // 结账

    // 模拟多本书的操作
    public void checkOut(String name, List<String> isbns);

}
