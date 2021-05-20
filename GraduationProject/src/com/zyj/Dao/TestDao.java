package com.zyj.Dao;

import com.zyj.Pojo.Test;

import java.util.List;

/**
 * @ClassName TestDao
 * @Auther: YaJun
 * @Date: 2021 - 04 - 29 - 16:35
 * @Description: com.zyj.Dao
 * @version: 1.0
 */
public interface TestDao {
    int queryPageTotalCountForTest(Test test);

    List<Test> queryPageItemsForTest(int startIndex, int pageSize, Test test);
}
