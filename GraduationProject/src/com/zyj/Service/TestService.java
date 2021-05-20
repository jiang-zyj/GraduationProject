package com.zyj.Service;

import com.zyj.Pojo.Test;

import java.util.List;

/**
 * @ClassName TestService
 * @Auther: YaJun
 * @Date: 2021 - 04 - 29 - 16:34
 * @Description: com.zyj.Service
 * @version: 1.0
 */
public interface TestService {

    /**
     * 查询 pageTotalCount
     * @param test
     * @return
     */
    int queryPageTotalCountForTest(Test test);

    /**
     * 查询分页数据
     * @param startIndex
     * @param pageSize
     * @param test
     * @return
     */
    List<Test> queryPageItemsForTest(int startIndex, int pageSize, Test test);
}
