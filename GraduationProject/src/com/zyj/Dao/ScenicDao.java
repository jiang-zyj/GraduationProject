package com.zyj.Dao;

import com.zyj.Pojo.City;
import com.zyj.Pojo.Scenic;

import java.util.List;

/**
 * @ClassName ScenicDao
 * @Auther: YaJun
 * @Date: 2021 - 03 - 30 - 13:29
 * @Description: com.zyj.Dao
 * @version: 1.0
 */
public interface ScenicDao {
    int queryScenicByCity(String city);


    List<Scenic> queryItemsByPage(String city, int startIndex, int pageSize);

    List<City> queryAllCity();

    int queryScenicTotalCountForLayUI(Scenic searchScenic);

    List<Scenic> queryScenicItemsForLayUI(int startIndex, int pageSize, Scenic searchScenic);

    boolean saveScenic(Scenic scenic);

    boolean batchDeleteScenic(String ids);

    boolean editScenic(Scenic scenic);

    boolean deleteScenicBySid(int sid);
}
