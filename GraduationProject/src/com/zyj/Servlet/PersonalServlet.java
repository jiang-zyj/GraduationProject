package com.zyj.Servlet;

import com.alibaba.fastjson.JSON;
import com.zyj.Pojo.*;
import com.zyj.Service.Impl.PersonalServiceImpl;
import com.zyj.Service.PersonalService;
import com.zyj.Utils.QrcodeUtils;
import com.zyj.https.BaseServlet;
import com.zyj.https.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ${NAME}
 * @Auther: YaJun
 * @Date: 2021 - 04 - 01 - 15:27
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet("/personal")
public class PersonalServlet extends BaseServlet {

    PersonalService personalService = new PersonalServiceImpl();
    private String uid;


    /**
     * 查询用户打卡信息
     * @param req
     * @param resp
     * @return
     */
    protected String queryHealthRecord(HttpServletRequest req, HttpServletResponse resp) {
        // 查询所有并分页
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        // 获取 Session 中的 user 对象
        User user = (User) req.getSession().getAttribute("user");

        // 设置总记录数
        int pageTotalCount = personalService.queryHealthRecordPageTotalCountByUid(user.getUid());
        // 声明 Page 对象
        Page<Health_Record> page = new Page<Health_Record>(pageNo, pageSize, pageTotalCount);
        // 查询分页的数据
        List<Health_Record> items = personalService.queryPageItemsByUid(page.getStartIndex(), pageSize, user.getUid());
        // 存入分页数据
        page.setItems(items);
        // 设置 url 访问路径
        page.setUrl("personal?action=queryHealthRecord");
        // 将 page 对象放入 request 域中
        req.setAttribute("page", page);
        // 请求转发到展示页面数据
        return "f:pages/personal/healthRecordView.jsp";

    }
        /**
         * 健康打卡表单提交，判断新冠疫情值，并保存到打卡记录表中
         *
         * @param req
         * @param resp
         * @return
         */
    protected String healthClockIn(HttpServletRequest req, HttpServletResponse resp) {
        // 获取表单参数
        String city = req.getParameter("city");
        String touch = req.getParameter("touch");
        String[] symptom = req.getParameterValues("symptom");
        String curr_temperature = req.getParameter("curr_temperature");

        // 计算新冠疫情值
        // 定义 double 类型的属性
        Double newTouch = 0.0;
        Double newSymptom = 0.0;
        double newTemperature = 0.0;
        // 计算用户所在城市新冠疫情值（需要重新删除并更新风险城市表）
        String date = getString();
        double cname = personalService.queryCOVIDIndexByCname(city,date);
        // 计算用户接触新冠疫情值
        newTouch = Double.parseDouble(touch);
        // 计算用户症状新冠疫情值
        for (String s : symptom) {
            newSymptom += Double.parseDouble(s);
        }
        // 计算用户当前温度新冠疫情值
        Double temperature = Double.parseDouble(curr_temperature);
        // 正常人体温一般在 36°C - 37°C
        if (temperature > 36.0 && temperature < 37.0) {
            newTemperature = 0.0;
        } else {
            newTemperature = 10.0;
        }
        Double health_status = cname + newTouch + newSymptom + newTemperature;
        // 声明打卡记录表，并封装数据
        Health_Record health_record = new Health_Record();
        User user = (User) req.getSession().getAttribute("user");
        health_record.setCurr_time(new Date());
        health_record.setHealth_status(health_status);
        health_record.setName(user.getName());
        health_record.setCname(city);
        health_record.setUid(user.getUid());

        // 将打卡记录对象存入到打卡记录表中
        boolean b = personalService.addHealthRecord(health_record);
        if (b) {
            // 提交成功，返回首页
            return "f:index.jsp?msg=clockInSuccess";
        } else {
            // 提交失败，返回到打卡页面中
            return "f:pages/personal/healthClockIn.jsp?msg=clockInFail";
        }
    }

    /**
     * AJAX请求，查询所有城市
     * @param req
     * @param resp
     * @return
     */
    protected void queryAllCity(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // 调用业务层查询所有城市
            List<City> cities = personalService.queryAllCity();
            // 返回给请求
            String jsonString = JSON.toJSONString(cities);
            resp.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询风险城市   封装成页对象
     *
     * @param req
     * @param resp
     * @return
     */
    protected String queryRiskCity(HttpServletRequest req, HttpServletResponse resp) {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        // 计算风险城市总数
        int pageTotalCount = personalService.queryPageTotalCountForRiskCity();
        // 调用业务层查询所有风险城市
        // 先删除风险城市表中所有数据
        personalService.removeAllRiskCityData();

        // 封装为 Page 对象
        Page<RiskCity> page = new Page<>(pageNo, pageSize, pageTotalCount);
        // 获取当前时间，并将日期格式化为 yyyy-MM-dd，与数据库的日期一致
        String date = getString();
        // 更新疫情风险城市表  --- 并返回分页后的疫情风险城市数据
        List<RiskCity> list = personalService.queryAllRiskCity(date, page.getStartIndex(), page.getPageSize());
        // 将分页数据存入Page对象中
        page.setItems(list);
        // 设置 URL 访问路径
        page.setUrl("personal?action=queryRiskCity");
        // 将 Page 对象存入到 request 域中
        req.setAttribute("page", page);
        // 转发到风险城市显示页面
        return "f:pages/personal/riskCity_view.jsp";
    }

    /**
     * 查询健康码
     *
     * @param req
     * @param resp
     */
    protected String queryHealthCode(HttpServletRequest req, HttpServletResponse resp) {
        // 第一步，先删除风险城市表中的所有数据
        personalService.removeAllRiskCityData();
        // 第一步，先查询地区疫情等级（十四天的数据）
        // 获取当前时间，并将日期格式化为 yyyy-MM-dd，与数据库的日期一致
        String date = getString();
        // 更新疫情风险城市表
        personalService.queryRegionLevel(date);

        // 通过 Session 中的 user 来获取对应的用户打卡记录
        User user = (User) req.getSession().getAttribute("user");
        // 通过 uid 来查询用户的打卡记录（最近三天）    :Health_Record
        uid = user.getUid();
        List<Health_Record> list = personalService.queryHealthRecord(uid, date);
        // 判断条件，如果健康打卡表中的数据条数少于三条，则提示用户请先去打卡,并返回到首页
        if (list == null || list.size() < 3) {
            return "f:index.jsp?msg=healthRecordVeryLittle";
        }

        // 查看健康码

        // 将之前用户的健康码删除
        personalService.removeHealthCodeByUid(uid);
        // 判断最近三天的健康打卡情况(累加最近三天的健康状态)
        Double status = 0.0;
        for (Health_Record record : list) {
            status += record.getHealth_status();
        }

        // 定义字符串描述健康码状态
        String healthStatus = "";
        if (status > 90.0) {    // 高风险
            // 将健康码状态写入到表中
            healthStatus = "high";
            personalService.addHealthCode(healthStatus, uid);
        } else if (status < 90.0 && status > 30) {  // 中风险
            healthStatus = "middle";
            personalService.addHealthCode(healthStatus, uid);
        } else {    // 低风险
            healthStatus = "low";
            personalService.addHealthCode(healthStatus, uid);
        }

        // 将新的健康码表对应的描述写成二维码并输出到页面上
        // 通过 uid 查询新的健康码
        Health_Code code = personalService.queryHealthCodeByUid(uid);
        // 将健康码对象存入 Session 作用域中
        req.getSession().setAttribute("code", code);

        // 转发到健康码页面
        return "f:healthCode";
    }

    private String getString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());
        return date;
    }
}
