<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/13
  Time: 11:38
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
<link type="text/css" rel="stylesheet" href="${basePath}/LayUIManager/css/layui.css">
<script src="${basePath}/LayUIManager/layui.js" charset="utf-8"></script>

