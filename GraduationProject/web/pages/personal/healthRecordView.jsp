<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/26
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人健康打卡记录表</title>
    <%@include file="../common/jsAndCss.jsp" %>

</head>
<body>
<%-- 静态包含头部分 --%>
<%@include file="../common/head.jsp"%>
    <center><h1>个人健康打卡记录</h1></center>
    <div class="container">
        <div class="col-md-12">
            <table class="table table-hover">
                <th><h3>身份证号</h3></th>
                <th><h3>姓名</h3></th>
                <th><h3>打卡时间</h3></th>
                <th><h3>打卡城市</h3></th>

                <c:forEach items="${requestScope.page.items}" var="i" varStatus="s">
                    <tr>
                        <td><h3>${i.uid}</h3></td>
                        <td>${i.name}</td>
                        <td><h3>${i.curr_time}</h3></td>
                        <td><h3>${i.cname}</h3></td>
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
