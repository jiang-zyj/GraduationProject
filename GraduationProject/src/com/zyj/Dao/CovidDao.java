package com.zyj.Dao;

import com.zyj.Pojo.COVID19_Data;
import com.zyj.Pojo.City;

import java.util.List;

/**
 * @ClassName CovidDao
 * @Auther: YaJun
 * @Date: 2021 - 04 - 13 - 18:21
 * @Description: com.zyj.Dao
 * @version: 1.0
 */
public interface CovidDao {

    int queryCovidTotalCountForLayUI(COVID19_Data searchData);

    List<COVID19_Data> queryCovidItemsForLayUI(int startIndex, int pageSize, COVID19_Data searchData);

    boolean saveCovidData(COVID19_Data data);

    boolean batchDeleteCovidData(String ids);

    boolean editCovidData(COVID19_Data data);

    boolean deleteCovidDataByCovid_id(int covid_id);

    List<City> queryAllCity();

    List<COVID19_Data> queryCovidData();

    List<COVID19_Data> queryCovidIncrement_ConfirmedData();

    List<COVID19_Data> queryCovidDeathsData();

    List<COVID19_Data> queryCovidIncrement_DeathsData();

    List<COVID19_Data> queryCovidRecoveredData();

    List<COVID19_Data> queryCovidIncrement_RecoveredData();

    List<COVID19_Data> queryCovidCityConfirmedData();
}
