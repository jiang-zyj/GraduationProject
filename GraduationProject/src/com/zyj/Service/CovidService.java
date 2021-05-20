package com.zyj.Service;

import com.zyj.Pojo.COVID19_Data;
import com.zyj.Pojo.City;

import java.util.List;

/**
 * @ClassName CovidService
 * @Auther: YaJun
 * @Date: 2021 - 04 - 13 - 18:19
 * @Description: com.zyj.Service
 * @version: 1.0
 */
public interface CovidService {

    /**
     * 使用 LayUI 查询疫情数据表总信息数
     *
     * @return
     */
    int queryCovidTotalCountForLayUI(COVID19_Data searchData);

    /**
     * 使用 LayUI 查询疫情数据表分页数据
     *
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<COVID19_Data> queryCovidItemsForLayUI(int startIndex, int pageSize, COVID19_Data searchData);

    /**
     * 添加疫情数据
     * @param data
     * @return
     */
    boolean saveCovidData(COVID19_Data data);

    /**
     * 批量删除疫情数据
     * @param ids
     * @return
     */
    boolean batchDeleteCovidData(String ids);

    /**
     * 编辑疫情数据
     * @param data
     * @return
     */
    boolean editCovidData(COVID19_Data data);

    /**
     * 通过 covid_id 删除疫情数据
     * @param covid_id
     * @return
     */
    boolean deleteCovidDataByCovid_id(int covid_id);

    /**
     * 查询所有城市
     * @return
     */
    List<City> queryAllCity();

    /**
     * 查询所有疫情数据
     * @return
     */
    List<COVID19_Data> queryCovidData();

    /**
     * 查询全国每天的新增感染人数
     * @return
     */
    List<COVID19_Data> queryCovidIncrement_ConfirmedData();

    /**
     * 查询全国总死亡人数
     * @return
     */
    List<COVID19_Data> queryCovidDeathsData();

    /**
     * 查询全国每天的新增死亡人数
     * @return
     */
    List<COVID19_Data> queryCovidIncrement_DeathsData();

    /**
     * 查询全国总痊愈人数
     * @return
     */
    List<COVID19_Data> queryCovidRecoveredData();

    /**
     * 查询全国每天的新增痊愈人数
     * @return
     */
    List<COVID19_Data> queryCovidIncrement_RecoveredData();

    /**
     * 查询每个省市的总感染人数
     * @return
     */
    List<COVID19_Data> queryCovidCityConfirmedData();
}
