<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/1
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/jsAndCss.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>防护问题</title>
</head>
<body>
<%-- 静态包含头部分 --%>
<%@include file="../../common/head.jsp"%>
<center><h1>防护问题</h1></center>
<div class="container" id="page_nav">
    <div class="col-md-12">
        <table class="table table-hover" style="vertical-align: center">
            <tr>
                <th><h3>防护问题</h3></th>
                <th><h3>医生回答</h3></th>
                <th><h3>医生信息</h3></th>
                <th><h3>所属防护方法</h3></th>
            </tr>
            <c:forEach items="${requestScope.page.items}" var="i" varStatus="s">
                <tr>
                    <td><h3>${i.problem_question}</h3></td>
                    <td><h3>${i.problem_answer}</h3></td>
                    <td><h3>${i.d_doctorInfo}</h3></td>
                    <td><h3>${i.method_name}</h3></td>
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
