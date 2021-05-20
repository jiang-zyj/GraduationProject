<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/9
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>风险城市</title>
    <%@include file="../common/jsAndCss.jsp"%>
</head>
<body>
<%-- 静态包含头部分 --%>
<%@include file="../common/head.jsp"%>
<div class="container">
    <%--        <div class="col-md-1"></div>--%>
    <div class="col-md-12">
        <table class="table table-hover">
            <%--            <th><h3>序号</h3></th>--%>
            <th><h3>序号</h3></th>
            <th><h3>风险城市</h3></th>
            <th><h3>风险程度</h3></th>
            <c:forEach items="${requestScope.page.items}" var="i" varStatus="s">
                <tr>
                    <td><h3>${s.count}</h3></td>
                    <td><h3>${i.cname}</h3></td>
                    <td><h3>${i.risk_desc}</h3></td>
                </tr>
            </c:forEach>

        </table>
        <tr>
            <%--静态包含分页条--%>
            <%@include file="../common/page_nav.jsp"%>
        <tr>
        </tr>
    </div>
</div>
</body>
</html>
