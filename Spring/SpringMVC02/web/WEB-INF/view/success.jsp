<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/14
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hello 欢迎来到success.jsp页面</h1>

    username:${requestScope.username}
    <br>
    password:${requestScope.password}
    <br>
    loginMsg:${requestScope.loginMsg}
</body>
</html>
