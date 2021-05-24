package Spring.zyj.ss.Servlet;

import Spring.zyj.ss.beans.Person;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ${NAME}
 * @Auther: YaJun
 * @Date: 2021 - 04 - 18 - 11:20
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 访问到 SpringIOC 容器中的 person 对象
        // 从 ServletContext 对象中获取 SpringIOC 容器对象

        ServletContext sc = getServletContext();

        ApplicationContext ctx = (ApplicationContext) sc.getAttribute("applicationContext");

        Person person = ctx.getBean("person", Person.class);

        person.sayHello();
    }
}
