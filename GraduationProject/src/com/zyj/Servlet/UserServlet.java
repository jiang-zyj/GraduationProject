package com.zyj.Servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyj.Pojo.City;
import com.zyj.Pojo.Page;
import com.zyj.Pojo.User;
import com.zyj.Service.Impl.UserServiceImpl;
import com.zyj.Service.UserService;
import com.zyj.Utils.BackLayUIInfo;
import com.zyj.Utils.ComputerUtils;
import com.zyj.bean.LayUIResponse;
import com.zyj.converters.ConvertBean;
import com.zyj.https.BaseServlet;
import com.zyj.https.WebUtils;
import com.zyj.mail.MailUtils;
import com.zyj.string.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @ClassName ${NAME}
 * @Auther: YaJun
 * @Date: 2021 - 03 - 29 - 17:25
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {

    UserService userService = new UserServiceImpl();
    private PrintWriter writer;
    private String path;


    /**
     * 管理员登出后台系统
     *
     * @param req
     * @param resp
     */
    public String managerLogout(HttpServletRequest req, HttpServletResponse resp) {
        // 将Session作用域中的数据销毁，并返回到登录页面
        req.getSession().removeAttribute("userManager");
        return "r:LayUIManager/login.jsp";
    }

    /**
     * 通过 uid 删除用户信息
     *
     * @param req
     * @param resp
     */
    public void deleteUserByUid(HttpServletRequest req, HttpServletResponse resp) {
        // 获取 uid
        String uid = req.getParameter("uid");
        // 调用业务层方法
        boolean flag = userService.deleteUserByUid(uid);
        BackLayUIInfo.getDeleteInfo(resp, flag);
    }

    /**
     * 修改用户信息
     *
     * @param req
     * @param resp
     */
    public void editUser(HttpServletRequest req, HttpServletResponse resp) {
        // 获取参数,封装为用户对象
        User user = ConvertBean.toBeans(User.class, req.getParameterMap());
        // 调用业务层
        boolean flag = userService.editUser(user);
        BackLayUIInfo.getEditInfo(resp, flag);
    }

    /**
     * Ajax 请求，批量删除用户信息
     *
     * @param req
     * @param resp
     */
    public void batchDeleteUser(HttpServletRequest req, HttpServletResponse resp) {
        // 获取字符串参数 uidStr
        String uidStr = req.getParameter("uidStr");
        // 调用业务层删除数据
        boolean flag = userService.batchDeleteUser(uidStr);
        BackLayUIInfo.getBatchDeleteInfo(resp, flag);
    }

    /**
     * Ajax 请求，添加用户信息
     *
     * @param req
     * @param resp
     */
    public void addUser(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // 获取参数并将其封装为 User 对象
            User user = ConvertBean.toBeans(User.class, req.getParameterMap());
            // 调用业务层添加用户信息
            boolean flag = userService.login(user);
            BackLayUIInfo.getAddInfo(resp, flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Ajax 请求，查询所有城市信息
     *
     * @param req
     * @param resp
     */
    public void loadAllCname(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // 调用业务层查询所有的城市信息
            List<City> cities = userService.loadAllCname();
            // 将数据返回到浏览器
            String jsonString = JSON.toJSONString(cities);
            resp.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过 LayUI 查询所有用户信息
     *
     * @param req
     * @param resp
     */
    public void queryUserForLayUI(HttpServletRequest req, HttpServletResponse resp) {

        try {
            // 获取 page、limit 参数
            int pageNo = WebUtils.parseInt(req.getParameter("page"), 1);
            int pageSize = WebUtils.parseInt(req.getParameter("limit"), Page.PAGE_SIZE);

            // 获取条件查询的参数，为了方便之后升级迭代，将其封装为 User 对象
            User user = ConvertBean.toBeans(User.class, req.getParameterMap());

            // 查询用户表总记录数
            int pageTotalCount = userService.queryUserTotalCountForLayUI(user);

            // 创建 Page 对象
            Page<User> page = new Page<>(pageNo, pageSize, pageTotalCount);

            // 查询用户分页数据
            List<User> list = userService.queryUserItemsForLayUI(page.getStartIndex(), pageSize, user);

            // 将数据响应给客户端
            LayUIResponse layUIResponse = new LayUIResponse(0, list, pageTotalCount);
            String jsonString = JSON.toJSONString(layUIResponse);
            resp.getWriter().write(jsonString);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void checkUid(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // 获取参数
            String uid = req.getParameter("uid");
            // 调用 Service 层进行 检查邮箱 业务操作
            boolean b = userService.checkUid(uid);
            // 将 b 转为 json
            String jsonString = JSON.toJSONString(b);
            // 返回给 回调函数
            writer = resp.getWriter();
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void checkEmail(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // 获取参数
            String email = req.getParameter("email");
            // 调用 Service 层进行 检查邮箱 业务操作
            boolean b = userService.checkEmail(email);
            // 将 b 转为 json
            String jsonString = JSON.toJSONString(b);
            // 返回给 回调函数
            writer = resp.getWriter();
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String register(HttpServletRequest req, HttpServletResponse resp) {
        // 获取表单信息
        User user = ConvertBean.toBeans(User.class, req.getParameterMap());
        // 调用 Service 处理登录业务
        boolean b = userService.login(user);
        path = "pages/user/";
        if (b) {    // 如果用户存在

            // 获取激活码并输入到用户信息中
            String uuid64 = UUIDUtils.getUUID64();
            user.setCode(uuid64);
            userService.addUserCode(user);
            // 发送验证码并跳转到注册与登录的中转页面
            String to = user.getEmail();
            Object content = "<a href='http://" + ComputerUtils.getHostIp() + ":8080/GraduationProject/pages/user/verify.jsp?uuid64=" + uuid64 + "'>点击此处激活账户</a>";

            String title = "新冠疫情服务平台";
            MailUtils.sendMail(to, content, title);
            // 跳转到 激活页面

            return path + "verify.jsp";
        }
        return path + "login.jsp";
    }

    /**
     * 管理员登录
     *
     * @param req
     * @param resp
     * @return
     */
    public String managerLogin(HttpServletRequest req, HttpServletResponse resp) {
        User user = ConvertBean.toBeans(User.class, req.getParameterMap());
        User dbUser = userService.loginByUid(user);

        if (dbUser != null) {
            if (user.getPassword().equals(dbUser.getPassword())) {
                // 将用户信息存到 session 域中
                req.getSession().setAttribute("userManager", dbUser);
                // 登录成功,跳转到首页
                return "f:backManager/index.jsp";
            } else {
                // 密码错误
                return "f:LayUIManager/login.jsp?msg=passFail";
            }
        } else {    // 账号错误
            return "f:LayUIManager/login.jsp?msg=accountFail";
        }
    }

    /**
     * 用户登录
     *
     * @param req
     * @param resp
     * @return
     */
    public String login(HttpServletRequest req, HttpServletResponse resp) {
        // 获取参数封装成对象
        User user = ConvertBean.toBeans(User.class, req.getParameterMap());
        // 获取 记住账号
        String remember = req.getParameter("remember");
        // 调用业务层方法判断 :User
        User u = userService.loginByUid(user);
        // 获取 自动登录的值
        String auto_login = req.getParameter("auto_login");

        // 判断验证码
        // 取出 Session 作用域中的验证码文本
//        String codes = (String) req.getSession().getAttribute("codes");
        // 获取验证码
        /*String info = req.getParameter("codes");
        if (!codes.equalsIgnoreCase(info)) {
            return "f:login.jsp?msg=验证码错误";
        }*/
        if (u != null) {
            if (user.getPassword().equals(u.getPassword())) {
                // 判断是否勾选了记住账号
                if ("rem".equals(remember)) {
                    // 保存 cookie
                    Cookie account = new Cookie("account", u.getName());
                    Cookie pass = new Cookie("pass", u.getPassword());

                    account.setMaxAge(60 * 60 * 24 * 7);
                    pass.setMaxAge(60 * 60 * 24 * 7);
                    resp.addCookie(account);
                    resp.addCookie(pass);
                }

                // 判断是否勾选了自动登录
                if ("auto_login".equals(auto_login)) {
                    // 保存 cookie
                    Cookie auto_account = new Cookie("auto_account", u.getName());
                    Cookie auto_pass = new Cookie("auto_pass", u.getPassword());

                    auto_account.setMaxAge(60 * 60 * 24 * 7);
                    auto_pass.setMaxAge(60 * 60 * 24 * 7);
                    resp.addCookie(auto_account);
                    resp.addCookie(auto_pass);
                }

                // 将用户信息存到 session 域中
                req.getSession().setAttribute("user", u);
                // 登录成功,跳转到首页
                return "f:index.jsp";
            } else {
                // 密码错误
                return "f:pages/user/login.jsp?msg=passFail";
            }
        } else {    // 账号错误
            return "f:pages/user/login.jsp?msg=accountFail";
        }
    }
}
