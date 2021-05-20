package com.zyj.Servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyj.Pojo.COVID19_Data;
import com.zyj.Pojo.City;
import com.zyj.Pojo.Page;
import com.zyj.Pojo.Scenic;
import com.zyj.Service.CovidService;
import com.zyj.Service.Impl.CovidServiceImpl;
import com.zyj.Utils.BackLayUIInfo;
import com.zyj.bean.LayUIResponse;
import com.zyj.converters.ConvertBean;
import com.zyj.https.BaseServlet;
import com.zyj.https.WebUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ${NAME}
 * @Auther: YaJun
 * @Date: 2021 - 04 - 13 - 18:13
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet("/covid")
public class CovidServlet extends BaseServlet {

    CovidService covidService = new CovidServiceImpl();

    /**
     * 查询每个城市总感染人数
     * @param request
     * @param response
     */
    protected void queryCovidCityConfirmedData(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<COVID19_Data> list = covidService.queryCovidCityConfirmedData();
//            JSONObject jsonObject = new JSONObject();
//            // 存储城市
//            List<String> city = new ArrayList<>();
//            for (int i = 0; i < list.size(); i++) {
//                city.add(list.get(i).getCityConfirmedSum());
//            }
//            // 存储总感染人数
//            List<Integer> cityConfirmedSum = new ArrayList<>();
//            for (int i = 0; i < list.size(); i++) {
//                cityConfirmedSum.add(list.get(i).getIncrement_RecoveredSum());
//            }
//            // 存入 JsonObject 对象中
//            jsonObject.put("city", city);
//            jsonObject.put("cityConfirmedSum", cityConfirmedSum);
            // 写回页面
            String jsonString = JSON.toJSONString(list);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        /**
         * 查询全国每天新增痊愈人数
         * @param request
         * @param response
         */
    protected void queryCovidIncrement_RecoveredData(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<COVID19_Data> list = covidService.queryCovidIncrement_RecoveredData();
            JSONObject jsonObject = new JSONObject();
            // 存储时间
            List<Date> last_Update = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                last_Update.add(list.get(i).getLast_Update());
            }

            // 存储总感染人数
            List<Integer> increment_Recovered = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                increment_Recovered.add(list.get(i).getIncrement_RecoveredSum());
            }
            // 存入 JsonObject 对象中
            jsonObject.put("last_Update", last_Update);
            jsonObject.put("increment_Recovered", increment_Recovered);
            // 写回页面
            String jsonString = JSON.toJSONString(jsonObject);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        /**
         * 查询全国总痊愈人数
         * @param request
         * @param response
         */
    protected void queryCovidRecoveredData(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<COVID19_Data> list = covidService.queryCovidRecoveredData();
            JSONObject jsonObject = new JSONObject();
            // 存储时间
            List<Date> last_Update = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                last_Update.add(list.get(i).getLast_Update());
            }

            // 存储总感染人数
            List<Integer> recovered = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                recovered.add(list.get(i).getRecoveredSum());
            }
            // 存入 JsonObject 对象中
            jsonObject.put("last_Update", last_Update);
            jsonObject.put("recovered", recovered);
            // 写回页面
            String jsonString = JSON.toJSONString(jsonObject);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        /**
         * 查询全国每天的新增死亡人数
         * @param request
         * @param response
         */
    protected void queryCovidIncrement_DeathsData(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<COVID19_Data> list = covidService.queryCovidIncrement_DeathsData();
            JSONObject jsonObject = new JSONObject();
            // 存储时间
            List<Date> last_Update = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                last_Update.add(list.get(i).getLast_Update());
            }

            // 存储总感染人数
            List<Integer> increment_Deaths = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                increment_Deaths.add(list.get(i).getIncrement_DeathsSum());
            }
            // 存入 JsonObject 对象中
            jsonObject.put("last_Update", last_Update);
            jsonObject.put("increment_Deaths", increment_Deaths);
            // 写回页面
            String jsonString = JSON.toJSONString(jsonObject);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        /**
         * 查询全国每天的死亡人数
         *
         * @param request
         * @param response
         */
    protected void queryCovidDeathsData(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<COVID19_Data> list = covidService.queryCovidDeathsData();
            JSONObject jsonObject = new JSONObject();
            // 存储时间
            List<Date> last_Update = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                last_Update.add(list.get(i).getLast_Update());
            }

            // 存储总感染人数
            List<Integer> deaths = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                deaths.add(list.get(i).getDeathsSum());
            }
            // 存入 JsonObject 对象中
            jsonObject.put("last_Update", last_Update);
            jsonObject.put("deaths", deaths);
            // 写回页面
            String jsonString = JSON.toJSONString(jsonObject);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询全国每天的新增感染人数
     *
     * @param request
     * @param response
     */
    protected void queryCovidIncrement_ConfirmedData(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<COVID19_Data> list = covidService.queryCovidIncrement_ConfirmedData();
            JSONObject jsonObject = new JSONObject();
            // 存储时间
            List<Date> last_Update = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                last_Update.add(list.get(i).getLast_Update());
            }

            // 存储总感染人数
            List<Integer> increment_Confirmed = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                increment_Confirmed.add(list.get(i).getIncrement_ConfirmedSum());
            }
            // 存入 JsonObject 对象中
            jsonObject.put("last_Update", last_Update);
            jsonObject.put("Increment_Confirmed", increment_Confirmed);
            // 写回页面
            String jsonString = JSON.toJSONString(jsonObject);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询全国累计的总感染人数
     *
     * @param request
     * @param response
     */
    protected void queryCovidConfirmedData(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 查询所有疫情数据
            List<COVID19_Data> list = covidService.queryCovidData();
            JSONObject jsonObject = new JSONObject();

            // 存储时间
            List<Date> last_Update = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                last_Update.add(list.get(i).getLast_Update());
            }
            // 存储总感染人数
            List<Integer> confirmedSum = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                confirmedSum.add(list.get(i).getConfirmedSum());
            }
            // 存入 JsonObject 对象中
            jsonObject.put("last_Update", last_Update);
            jsonObject.put("confirmedSum", confirmedSum);

            String jsonString = JSON.toJSONString(jsonObject);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有城市
     *
     * @param request
     * @param response
     */
    protected void queryAllCities(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 调用业务层查询所有城市
            List<City> cities = covidService.queryAllCity();
            // 传递给浏览器
            String jsonString = JSON.toJSONString(cities);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除疫情数据
     *
     * @param req
     * @param resp
     */
    protected void deleteCovidDataByCovid_id(HttpServletRequest req, HttpServletResponse resp) {
        // 获取 covid_id
        int covid_id = WebUtils.parseInt(req.getParameter("covid_id"), 0);
        // 调用业务层删除该条疫情数据
        boolean flag = covidService.deleteCovidDataByCovid_id(covid_id);
        BackLayUIInfo.getDeleteInfo(resp, flag);
    }

    /**
     * 编辑疫情数据
     *
     * @param req
     * @param resp
     */
    protected void editCovidData(HttpServletRequest req, HttpServletResponse resp) {
        // 获取表单参数，封装为谣言对象
        COVID19_Data data = ConvertBean.toBeans(COVID19_Data.class, req.getParameterMap());
        // 调用业务层实现添加
        boolean flag = covidService.editCovidData(data);
        // 通过响应传输给客户端
        BackLayUIInfo.getEditInfo(resp, flag);
    }

    /**
     * 批量删除疫情数据
     *
     * @param req
     * @param resp
     */
    protected void batchDeleteCovidData(HttpServletRequest req, HttpServletResponse resp) {
        // 获取 id 字符串
        String ids = req.getParameter("ids");
        // 调用业务层方法删除所有选中的数据
        boolean flag = covidService.batchDeleteCovidData(ids);
        BackLayUIInfo.getBatchDeleteInfo(resp, flag);
    }

    /**
     * 添加疫情数据
     *
     * @param req
     * @param resp
     */
    protected void addCovidData(HttpServletRequest req, HttpServletResponse resp) {
        // 获取表单参数，封装为谣言对象
        COVID19_Data data = ConvertBean.toBeans(COVID19_Data.class, req.getParameterMap());
        // 调用业务层实现添加
        boolean flag = covidService.saveCovidData(data);
        BackLayUIInfo.getAddInfo(resp, flag);
    }

    /**
     * 通过 LayUI 查询疫情数据
     *
     * @param req
     * @param resp
     */
    protected void queryCovidDataForLayUI(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // 获取 page、limit 参数
            int pageNo = WebUtils.parseInt(req.getParameter("page"), 1);
            int pageSize = WebUtils.parseInt(req.getParameter("limit"), Page.PAGE_SIZE);

            // 将条件查询封装为对象
            COVID19_Data searchData = ConvertBean.toBeans(COVID19_Data.class, req.getParameterMap());
            // 获取疫情数据表总记录数
            int pageTotalCount = covidService.queryCovidTotalCountForLayUI(searchData);

            // 创建 Page 对象
            Page<COVID19_Data> page = new Page<>(pageNo, pageSize, pageTotalCount);

            // 查询疫情数据表分页数据
            List<COVID19_Data> list = covidService.queryCovidItemsForLayUI(page.getStartIndex(), pageSize, searchData);

            System.out.println(list);
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("code", 0);
//            jsonObject.put("data", list);
//            jsonObject.put("count", pageTotalCount);
//
//            resp.getWriter().write(jsonObject.toString());
            // 响应数据回客户端
            LayUIResponse layUIResponse = new LayUIResponse(0, list, pageTotalCount);
            String jsonString = JSON.toJSONString(layUIResponse);
            resp.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
