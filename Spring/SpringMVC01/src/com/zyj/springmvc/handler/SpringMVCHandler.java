package com.zyj.springmvc.handler;

import com.zyj.springmvc.beans.User;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName SpringMVCHandler
 * @Auther: YaJun
 * @Date: 2021 - 03 - 27 - 16:05
 * @Description: com.zyj.springmvc.handler
 * @version: 1.0
 */
@Controller
//@RequestMapping(value = "/springmvc")
public class SpringMVCHandler {

    /**
     * 测试原生的 Servlet API
     *
     * @return
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("request:" + req);   // 转发操作
        System.out.println("response:" + resp); // 重定向操作    将数据写给客户端
        // 转发
//        req.getRequestDispatcher("WEB-INF/views/success.jsp").forward(req, resp);

        // 重定向
        resp.sendRedirect("www.baidu.com");

        // 向客户端写数据
        resp.getWriter().write("Hello SpringJMVC");

    }

    /**
     * 测试 POJO
     *
     * @return
     */
    @RequestMapping("/testPOJO")
    public String testPOJO(User user) {
        System.out.println("user:" + user);
        return "success";
    }


    /**
     * @CookieValue 映射 cookie 信息到请求对象的形参中
     */
    @RequestMapping("testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String SessionID) {
        System.out.println("sessionId:" + SessionID);
        return "success";
    }

    /**
     * @RequestHeader 映射请求头信息到请求处理方法的形参中
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept-Language") String acceptLanguage) {
        System.out.println("acceptLanguage:" + acceptLanguage);
        return "success";
    }

    /**
     * @RequestParam 映射请求参数到请求处理方法的形参
     * 1、如果请求参数名与形参名一致，则可以省略 @RequestParam 的指定 (建议不要省略)
     * 2、@RequestParam 注解标注的形参必须要赋值。必须要从请求对象中获取到对应的请求参数
     * 可以使用 required 来设置为不是必须的。(好像不需要使用 required 就能实现)
     * 3、可以使用 defaultValue 来指定一个默认值取代 null
     * 好像 2,3 都没啥用，SpringMVC好像已经做好了这个
     * 客户端的请求：testRequestParam?username=Tom&age=22
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("username") String username, @RequestParam(value = "/age", required = false, defaultValue = "0") int age) {
        // web: request.getParameter()  request.getParameterMap()
        System.out.println(username + "," + age);
        return "success";
    }


    /**
     * REST PUT
     */
    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    public String testRestPUT() {
        System.out.println("REST PUT");
        // 可以通过重定向来跳转页面，但是这样会导致 request 域中的数据清空，且不能跳到 WEB-INF 目录下的页面
        return "redirect:test1.jsp";
    }

    /**
     * REST POST
     */
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String testRestPOST() {
        System.out.println("REST POST");
        return "success";
    }

    /**
     * REST DELETE
     * <p>
     * 可以通过原生的 request 或者 response 对象来进行重定向
     * 即在方法的参数列表中加入 HttpServletRequest req, HttpServletResponse resp
     * 当然 返回值改为 void
     * <p>
     * 或者使用 ../ 来跳到上一层目录
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public String testRestDELETE(@PathVariable("id") Integer id) {
        System.out.println("REST DELETE:" + id);
        return "redirect:../test2.jsp";
    }

    /**
     * REST GET
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String testRestGET(@PathVariable("id") Integer id) {
        System.out.println("REST GET:" + id);
        return "success";
    }


    /**
     * REST风格
     * 带占位符的 URL
     * <p>
     * 浏览器：http://localhost:8080/SpringMVC01/testPathVariable/admin/1001
     */
    @RequestMapping(value = "/testPathVariable/{name}/{id}")
    public String testPathVariable(@PathVariable("name") String name, @PathVariable("id") Integer id) {
        System.out.println(name + ":" + id);

        return "success";
    }

    /**
     * @RequsetMapping 映射请求参数与请求头
     * <p>
     * params：username=tom&age=22
     * 可以通过指定参数名来要求请求必须携带某些参数，在其中，支持一下简单的表达式
     * 如 !username 不能有 username 这个参数
     * username != xxx
     * username = xxx
     * <p>
     * headers：与 params 一样，可以要求请求携带某些请求头信息。也是数组类型，同样支持简单的表达式
     */
    @RequestMapping(value = "/testRequestMappingParamsAndHeaders", params = {"username", "age=22"}, headers = {"Accept-language"})
    public String testRequestMappingParamsAndHeaders() {
        return "success";
    }

    /**
     * @RequestMapping method 映射请求方式
     * <p>
     * 通过 method 来处理映射请求方式
     * RequestMethod.GET
     * RequestMethod.POST
     * 如果想处理多种请求方式，则可以通过数组的方式来解决，因为在定义中 method 就是一个数组
     * method = {RequestMethod.GET,RequestMethod.POST}
     */
    @RequestMapping(value = "testRequestMappingMethod", method = {RequestMethod.GET, RequestMethod.POST})
    public String testRequestMappingMethod() {
        return "success";
    }

    /**
     * @RequestMapping 可以标注到类和方法上
     * 如果类上与方法上都有该注解，则访问路径需要变为 类上注解路径 + 方法上注解路径
     * 即 访问地址需变为 springmvc/testRequestMapping
     */
    @RequestMapping(value = "testRequestMapping")
    public String testRequestMapping() {
        return "success";
    }
}
