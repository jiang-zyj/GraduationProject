package com.zyj.Service.Impl;

import com.zyj.Dao.Impl.TestDaoImpl;
import com.zyj.Dao.TestDao;
import com.zyj.Pojo.Test;
import com.zyj.Service.TestService;

import java.util.List;

/**
 * @ClassName TestServiceImpl
 * @Auther: YaJun
 * @Date: 2021 - 04 - 29 - 16:35
 * @Description: com.zyj.Service.Impl
 * @version: 1.0
 */
public class TestServiceImpl implements TestService {

    TestDao dao = new TestDaoImpl();

    @Override
    public int queryPageTotalCountForTest(Test test) {
        return dao.queryPageTotalCountForTest(test);
    }

    @Override
    public List<Test> queryPageItemsForTest(int startIndex, int pageSize, Test test) {
        return dao.queryPageItemsForTest(startIndex,pageSize,test);
    }
}
