<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/29
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
    pageContext.setAttribute("basePath", basePath);
%>
<base href="<%=basePath%>">
<script type="text/javascript" src="layui/lay/dest/layui.all.js"></script>
<script type="text/javascript" src="../js/login.js"></script>
<script type="text/javascript" src="../jsplug/jparticle.jquery.js"></script>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css" href="../css/login.css" media="all">
