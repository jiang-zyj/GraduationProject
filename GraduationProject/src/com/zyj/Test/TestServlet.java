package com.zyj.Test;

import com.zyj.https.BaseServlet;

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
 * @Date: 2021 - 04 - 10 - 20:32
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet(name = "test")
public class TestServlet extends BaseServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();

    }
}
