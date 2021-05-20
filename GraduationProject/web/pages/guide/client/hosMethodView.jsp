<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/26
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../common/jsAndCss.jsp" %>
<html>
<head>
    <title></title>
</head>
<script type="text/javascript">
    function showNav() {
        $("#page_nav").css("display","block");
    }
</script>
<body>
<%-- 静态包含头部分 --%>
<%@include file="../../common/head.jsp"%>
<center>
    <ul class="nav nav-tabs nav-justified" id="strategy">
        <c:forEach items="${sessionScope.rationals}" var="i">
            <li role="presentation">
                <a href="guide?action=queryAllHosProbByHName&h_name=${i.h_name}" onclick="showNav()">${i.h_name}</a>
            </li>
        </c:forEach>
    </ul>
</center>
<div class="container" id="page_nav">
    <%--        <div class="col-md-1"></div>--%>
    <div class="col-md-12">
        <table class="table table-hover" style="vertical-align: center">
            <tr>
                <th><h3>就医问题</h3></th>
                <th><h3>医生回答</h3></th>
                <th><h3>医生信息</h3></th>
                <th><h3>所属就医方法</h3></th>
            </tr>
            <c:forEach items="${requestScope.page.items}" var="i" varStatus="s">
                <tr>
                    <td><h3>${i.treat_prob}</h3></td>
                    <td><h3>${i.treat_ans}</h3></td>
                    <td><h3>${i.d_doctorInfo}</h3></td>
                    <td><h3>${i.h_name}</h3></td>
                </tr>
            </c:forEach>

        </table>
        <tr>
            <%--静态包含分页条--%>
            <%@include file="../../common/page_nav.jsp" %>
        <tr>
        </tr>
    </div>
</div>
</body>
</html>
