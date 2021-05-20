<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/26
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>谣言信息</title>
    <%@include file="../../common/jsAndCss.jsp" %>
</head>
<body>
<%-- 静态包含头部分 --%>
<%@include file="../../common/head.jsp"%>
<nav class="navbar navbar-default">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
<%--        <a class="navbar-brand" href="#">返回上一级</a>--%>
    </div>

    <p class="navbar-text navbar-static-top">选择谣言分类</p>
    <div class="dropdown">
        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="true">
            请选择谣言分类
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="guide?action=queryAllRumor&t_ensure='真'">真</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="guide?action=queryAllRumor&t_ensure='假'">假</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="guide?action=queryAllRumor&t_ensure='不确定'">不确定</a></li>
        </ul>
    </div>
</nav>
<div class="container">
        <div class="col-md-12">
            <table class="table table-hover">
                <th><h3>谣言编号</h3></th>
                <th><h3>谣言</h3></th>
                <th><h3>医生简答</h3></th>
                <th><h3>医生详答</h3></th>
                <th><h3>医生信息</h3></th>
                <th><h3>谣言真假性</h3></th>
                <c:forEach items="${requestScope.page.items}" var="i" varStatus="s">
                    <tr>
                        <td><h3>${i.rid}</h3></td>
                        <td><h3>${i.r_question}</h3></td>
                        <td><h3>${i.r_shortAnswer}</h3></td>
                        <td><h3>${i.r_answer}</h3></td>
                        <td><h3>${i.d_doctorInfo}</h3></td>
                        <td><h3>${i.t_ensure}</h3></td>
                    </tr>
                </c:forEach>
            </table>

            <%--静态包含分页条--%>
            <%@include file="../../common/page_nav.jsp" %>
        </div>
</div>
</body>
</html>
