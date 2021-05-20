package com.zyj.Service.Impl;

import com.zyj.Dao.Impl.ScenicDaoImpl;
import com.zyj.Dao.ScenicDao;
import com.zyj.Pojo.City;
import com.zyj.Pojo.Scenic;
import com.zyj.Service.ScenicService;

import java.util.List;

/**
 * @ClassName ScenicServiceImpl
 * @Auther: YaJun
 * @Date: 2021 - 03 - 30 - 10:16
 * @Description: com.zyj.Service.Impl
 * @version: 1.0
 */
public class ScenicServiceImpl implements ScenicService {

    ScenicDao dao = new ScenicDaoImpl();


    @Override
    public int queryScenicByCity(String city) {
        return dao.queryScenicByCity(city);
    }

    @Override
    public List<Scenic> queryItemsByPage(String city, int startIndex, int pageSize) {
        return dao.queryItemsByPage(city,startIndex,pageSize);
    }

    @Override
    public List<City> queryAllCity() {
        return dao.queryAllCity();
    }

    @Override
    public int queryScenicTotalCountForLayUI(Scenic searchScenic) {
        return dao.queryScenicTotalCountForLayUI(searchScenic);
    }

    @Override
    public List<Scenic> queryScenicItemsForLayUI(int startIndex, int pageSize, Scenic searchScenic) {
        return dao.queryScenicItemsForLayUI(startIndex,pageSize,searchScenic);
    }

    @Override
    public boolean saveScenic(Scenic scenic) {
        return dao.saveScenic(scenic);
    }

    @Override
    public boolean batchDeleteScenic(String ids) {
        return dao.batchDeleteScenic(ids);
    }

    @Override
    public boolean editScenic(Scenic scenic) {
        return dao.editScenic(scenic);
    }

    @Override
    public boolean deleteScenicBySid(int sid) {
        return dao.deleteScenicBySid(sid);
    }
}
