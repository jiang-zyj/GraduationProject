package com.zyj.Filter;

import com.zyj.Pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyFilter
 * @Auther: YaJun
 * @Date: 2021 - 04 - 29 - 9:54
 * @Description: com.zyj.Filter
 * @version: 1.0
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        /**
         * 根据实际的需求实现放行
         */
        // 向下转型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 设置字符集编码
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        System.out.println("进入MyFilter【doFilter】");


        String servletPath = request.getServletPath();
//        System.out.println("用户请求路径：" + servletPath);

        // 判断用户的请求
//        if (servletPath.startsWith("/LayUIManager")) {
            // 获取 Session 作用域中的 User 对象
            User user = (User) request.getSession().getAttribute("user");
            // 判断 User 对象
//            if (user != null) {
////                response.sendRedirect(request.getContextPath() + "/LayUIManager/index/index.jsp");
//                response.sendRedirect(request.getContextPath() + servletPath);
//                System.out.println(request.getContextPath() + servletPath);
//                chain.doFilter(servletRequest, servletResponse);
//                return;
//            } else {
//                response.sendRedirect(request.getContextPath() + "/index.jsp");
//            }
            if (user == null) {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
//            System.out.println("访问后台");
//        } else {
//            System.out.println("访问其他路径");
//        }


        chain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
