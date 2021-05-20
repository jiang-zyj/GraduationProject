package com.zyj.Service;

import com.zyj.Pojo.City;
import com.zyj.Pojo.Scenic;

import java.util.List;

/**
 * @ClassName ScenicService
 * @Auther: YaJun
 * @Date: 2021 - 03 - 30 - 10:16
 * @Description: com.zyj.Service
 * @version: 1.0
 */
public interface ScenicService {
    /**
     * 通过城市查询景区信息个数
     * @param city
     * @return
     */
    int queryScenicByCity(String city);


    /**
     * 查询景区分页数据
     * @param city
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<Scenic> queryItemsByPage(String city, int startIndex, int pageSize);


    /**
     * 查询所有城市
     * @return
     */
    List<City> queryAllCity();

    /**
     * 通过 LayUI 查询总记录数
     * @return
     */
    int queryScenicTotalCountForLayUI(Scenic searchScenic);

    /**
     * LaaUI 查询分页的数据
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<Scenic> queryScenicItemsForLayUI(int startIndex, int pageSize, Scenic searchScenic);

    /**
     * 添加景区信息
     * @param scenic
     * @return
     */
    boolean saveScenic(Scenic scenic);

    /**
     * 批量删除景区信息
     * @param ids
     * @return
     */
    boolean batchDeleteScenic(String ids);

    /**
     * 修改景区信息
     * @param scenic
     * @return
     */
    boolean editScenic(Scenic scenic);

    /**
     * 删除景区信息
     * @param sid
     * @return
     */
    boolean deleteScenicBySid(int sid);
}
