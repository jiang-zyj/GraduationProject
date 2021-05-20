package com.zyj.Servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyj.Pojo.City;
import com.zyj.Pojo.Page;
import com.zyj.Pojo.Protection_Problem;
import com.zyj.Pojo.Scenic;
import com.zyj.Service.Impl.ScenicServiceImpl;
import com.zyj.Service.ScenicService;
import com.zyj.Utils.BackLayUIInfo;
import com.zyj.converters.ConvertBean;
import com.zyj.https.BaseServlet;
import com.zyj.https.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName ${NAME}
 * @Auther: YaJun
 * @Date: 2021 - 03 - 30 - 9:08
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet("/scenic")
public class ScenicServlet extends BaseServlet {

    ScenicService scenicService = new ScenicServiceImpl();


    /**
     * 删除景区信息
     *
     * @param req
     * @param resp
     */
    protected void deleteScenicBySid(HttpServletRequest req, HttpServletResponse resp) {
        // 获取 sid
        int sid = WebUtils.parseInt(req.getParameter("sid"), 0);
        // 调用业务层删除该条景区信息
        boolean flag = scenicService.deleteScenicBySid(sid);
        BackLayUIInfo.getDeleteInfo(resp, flag);
    }

    /**
     * 修改景区信息
     *
     * @param req
     * @param resp
     */
    protected void editScenic(HttpServletRequest req, HttpServletResponse resp) {
        // 获取表单参数，封装为谣言对象
        Scenic scenic = ConvertBean.toBeans(Scenic.class, req.getParameterMap());
        // 调用业务层实现添加
        boolean flag = scenicService.editScenic(scenic);
        // 通过响应传输给客户端
        BackLayUIInfo.getEditInfo(resp, flag);
    }

    /**
     * 批量删除景区信息
     *
     * @param req
     * @param resp
     */
    protected void batchDeleteScenic(HttpServletRequest req, HttpServletResponse resp) {
        // 获取 id 字符串
        String ids = req.getParameter("ids");
        // 调用业务层方法删除所有选中的数据
        boolean flag = scenicService.batchDeleteScenic(ids);
        BackLayUIInfo.getBatchDeleteInfo(resp, flag);
    }

    /**
     * 添加景区信息
     *
     * @param req
     * @param resp
     */
    protected void addScenic(HttpServletRequest req, HttpServletResponse resp) {
        // 获取表单参数，封装为谣言对象
        Scenic scenic = ConvertBean.toBeans(Scenic.class, req.getParameterMap());
        // 调用业务层实现添加
        boolean flag = scenicService.saveScenic(scenic);
        BackLayUIInfo.getAddInfo(resp, flag);
    }

    /**
     * Ajax 查询所有城市信息
     *
     * @param req
     * @param resp
     */
    protected void queryAllCities(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // 调用业务层查询所有城市
            List<City> cities = scenicService.queryAllCity();
            // 传递给浏览器
            String jsonString = JSON.toJSONString(cities);
            resp.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过 LayUI 查询所有景区信息
     *
     * @param req
     * @param resp
     */
    protected void queryScenicForLayUI(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // 获取 page 与 limit 参数
            int pageNo = WebUtils.parseInt(req.getParameter("page"), 1);
            int pageSize = WebUtils.parseInt(req.getParameter("limit"), Page.PAGE_SIZE);

            // 将条件查询封装到对象中
            Scenic searchScenic = ConvertBean.toBeans(Scenic.class, req.getParameterMap());
            //声明 pageTotalCount，用于记录总记录数
            int pageTotalCount = scenicService.queryScenicTotalCountForLayUI(searchScenic);
            // 通过有参构造声明page对象
            Page<Scenic> page = new Page<>(pageNo, pageSize, pageTotalCount);
            // 查询分页的数据
            List<Scenic> list = scenicService.queryScenicItemsForLayUI(page.getStartIndex(), pageSize, searchScenic);

            // 将相应数据写回 LayUI
            // 传递 code、data、count
            // code 为响应状态码， 0 为查询成功，其他为查询失败
            // data 为响应数据，即 list(items)
            // count 为总记录数
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("data", list);
            jsonObject.put("count", pageTotalCount);

            resp.getWriter().write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 加载所有城市
     *
     * @param req
     * @param resp
     */
    protected void queryAllCity(HttpServletRequest req, HttpServletResponse resp) {
        // 查询所有城市
        List<City> cities = scenicService.queryAllCity();
        // 放入 request 域中
        req.setAttribute("cities", cities);
    }

    /**
     * 查询所有景点信息
     */
    protected void queryAll(HttpServletRequest req, HttpServletResponse resp) {

    }

    /**
     * 通过选择城市查询景区信息（进行分页处理）分页
     *
     * @param req
     * @param resp
     */
    protected void queryScenicByPage(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // 获取传进来的pageNo和pageSize
            int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
            int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

            String cname = req.getParameter("cname");

            //声明 pageTotalCount，用于记录总记录数
            int pageTotalCount = 0;
            // 判断 city 是否为空（即为空则查询所有，不为空查询 city 对应的景区信息）因为该查询只有一个，所以可以不通过Map实现
            if (cname != null) {
                // 调用 Service 层进行查询业务处理，将返回结果放入page对象中
                pageTotalCount = scenicService.queryScenicByCity(cname);
            } else {    // 查询所有景区信息
                req.getRequestDispatcher("scenic?action=queryAll");
            }
            // 将查询城市的值回显到页面中
            req.setAttribute("cname", cname);
            // 通过有参构造声明page对象
            Page<Scenic> page = new Page<>(pageNo, pageSize, pageTotalCount);
            // 查询分页的数据
            List<Scenic> list = scenicService.queryItemsByPage(cname, page.getStartIndex(), pageSize);
            // 封装到 page 对象中
            page.setItems(list);
            // 设置url访问路径
            StringBuilder sb = new StringBuilder("scenic?action=queryScenicByPage");
            sb.append("&cname=" + cname);
            page.setUrl(sb.toString());
            // 将 page 对象存入 request 域中
            req.setAttribute("page", page);
            // 转发到景区显示页面
            req.getRequestDispatcher("/pages/scenic/chooseScenic.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
