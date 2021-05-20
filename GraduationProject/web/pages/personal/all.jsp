<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/1
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 静态包含头部分 --%>
<%@include file="../common/head.jsp"%>
    <%-- 跳转到一个打卡页面 --%>
    <a href="#">健康打卡</a>

    <%-- 遍历该用户的打卡记录（通过传参，或者获取Sesssion中的用户信息） --%>
    <a href="#">查看健康打卡记录</a>

    <%-- 通过疫情数据与风险程度的判断规则，计算各地的风险程度，并遍历该表 --%>
    <a href="#">查看各地疫情风险程度</a>
</body>
</html>
