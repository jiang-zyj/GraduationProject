package Spring.zyj.ss.Listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ClassName MyServletContextListener
 * @Auther: YaJun
 * @Date: 2021 - 04 - 18 - 11:22
 * @Description: Spring.zyj.ss.Listener
 * @version: 1.0
 */
public class MyServletContextListener implements ServletContextListener {

    /**
     * 当监听到 ServletContext 被创建，则执行该方法
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 1. 创建 SpringIOC 容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. 将 SpringIOC 容器对象绑定到 ServletContext 中
        ServletContext sc = sce.getServletContext();

        sc.setAttribute("applicationContext", ctx);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
