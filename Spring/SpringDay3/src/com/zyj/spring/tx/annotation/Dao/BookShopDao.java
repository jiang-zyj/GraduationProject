package com.zyj.spring.tx.annotation.Dao;

/**
 * @ClassName BookShopDao
 * @Auther: YaJun
 * @Date: 2021 - 03 - 21 - 22:44
 * @Description: com.zyj.spring.tx.annotation.Dao
 * @version: 1.0
 */
public interface BookShopDao {


    // 根据书号查询书的价格
    public int findPrice(String isbn);

    // 更新书的库存
    public void updateStock(String isbn);

    // 更新用户的余额
    public void updateUserAccount(String username, Integer price);
}
