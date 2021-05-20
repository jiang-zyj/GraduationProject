<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/3/28
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="pages/common/jsAndCss.jsp"%>
<html>
  <head>
    <title>$Title$</title>
  </head>

  <body>
    <%
      // 转发到首页
      request.getRequestDispatcher("/pages/index/index.jsp").forward(request, response);
    %>
  </body>
</html>
