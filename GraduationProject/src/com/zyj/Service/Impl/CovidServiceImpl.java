package com.zyj.Service.Impl;

import com.zyj.Dao.CovidDao;
import com.zyj.Dao.Impl.CovidDaoImpl;
import com.zyj.Pojo.COVID19_Data;
import com.zyj.Pojo.City;
import com.zyj.Service.CovidService;

import java.util.List;

/**
 * @ClassName CovidServiceImpl
 * @Auther: YaJun
 * @Date: 2021 - 04 - 13 - 18:19
 * @Description: com.zyj.Service.Impl
 * @version: 1.0
 */
public class CovidServiceImpl implements CovidService {

    CovidDao dao = new CovidDaoImpl();

    @Override
    public int queryCovidTotalCountForLayUI(COVID19_Data searchData) {
        return dao.queryCovidTotalCountForLayUI(searchData);
    }

    @Override
    public List<COVID19_Data> queryCovidItemsForLayUI(int startIndex, int pageSize, COVID19_Data searchData) {
        return dao.queryCovidItemsForLayUI(startIndex,pageSize,searchData);
    }

    @Override
    public boolean saveCovidData(COVID19_Data data) {
        return dao.saveCovidData(data);
    }

    @Override
    public boolean batchDeleteCovidData(String ids) {
        return dao.batchDeleteCovidData(ids);
    }

    @Override
    public boolean editCovidData(COVID19_Data data) {
        return dao.editCovidData(data);
    }

    @Override
    public boolean deleteCovidDataByCovid_id(int covid_id) {
        return dao.deleteCovidDataByCovid_id(covid_id);
    }

    @Override
    public List<City> queryAllCity() {
        return dao.queryAllCity();
    }

    @Override
    public List<COVID19_Data> queryCovidIncrement_ConfirmedData() {
        return dao.queryCovidIncrement_ConfirmedData();
    }

    @Override
    public List<COVID19_Data> queryCovidDeathsData() {
        return dao.queryCovidDeathsData();
    }

    @Override
    public List<COVID19_Data> queryCovidIncrement_DeathsData() {
        return dao.queryCovidIncrement_DeathsData();
    }

    @Override
    public List<COVID19_Data> queryCovidRecoveredData() {
        return dao.queryCovidRecoveredData();
    }

    @Override
    public List<COVID19_Data> queryCovidIncrement_RecoveredData() {
        return dao.queryCovidIncrement_RecoveredData();
    }

    @Override
    public List<COVID19_Data> queryCovidCityConfirmedData() {
        return dao.queryCovidCityConfirmedData();
    }

    @Override
    public List<COVID19_Data> queryCovidData() {
        return dao.queryCovidData();
    }
}
