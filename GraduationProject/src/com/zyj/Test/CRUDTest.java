package com.zyj.Test;

import com.zyj.Pojo.Page;
import com.zyj.Pojo.Test;
import com.zyj.Service.Impl.TestServiceImpl;
import com.zyj.Service.TestService;
import com.zyj.converters.ConvertBean;
import com.zyj.https.BaseServlet;
import com.zyj.https.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName CRUDTest
 * @Auther: YaJun
 * @Date: 2021 - 04 - 29 - 16:21
 * @Description: com.zyj.Test
 * @version: 1.0
 */
@WebServlet("/test")
public class CRUDTest extends BaseServlet {

    TestService testService = new TestServiceImpl();


    protected String searchUser(HttpServletRequest req, HttpServletResponse resp) {
        // 获取 pageNo 与 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        // 获取条件查询，将其封装为对象
        Test test = ConvertBean.toBeans(Test.class, req.getParameterMap());

        // 查询 pageTotalCount
        int pageTotalCount = testService.queryPageTotalCountForTest(test);
        // 创建 Page 对象
        Page page = new Page(pageNo, pageSize, pageTotalCount);

        // 查询分页数据
        List<Test> list = testService.queryPageItemsForTest(page.getStartIndex(),pageSize,test);

        // 封装分页数据
        page.setItems(list);
        // 设置 url 路径
        StringBuilder sb = new StringBuilder("test?action=searchUser");
        sb.append("&t_name=" + test.getT_name());
        page.setUrl(sb.toString());
        // 将 page 对象存入 request 域中
        req.setAttribute("page", page);
        // 转发到 jsp 页面
        return "f:user.jsp";
    }
}
