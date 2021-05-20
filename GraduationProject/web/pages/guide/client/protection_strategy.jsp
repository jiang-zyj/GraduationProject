<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/1
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/jsAndCss.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>防护攻略</title>

    <style type="text/css">
        li {
            list-style: none;
        }
    </style>
</head>
<%-- 动态遍历所有的防护攻略 --%>
<%--<script type="text/javascript">--%>
<%--    $.post({--%>
<%--        url: "guide?action=queryAllStrategy",--%>
<%--        data: {},--%>
<%--        success: function (data) {--%>
<%--            var i = "";--%>
<%--            $.each(data, function (index, obj) {--%>
<%--                i += "<li role='presentation'><a href = 'pages/guide/client/protection_method.jsp?strategy_name=" + obj.strategy_name + "'>" + obj.strategy_name + "</a></li>";--%>
<%--            });--%>
<%--            $("#strategy").html(i);--%>
<%--        },--%>
<%--        dataType: "json"--%>
<%--    });--%>
<%--</script>--%>

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
        <c:forEach items="${sessionScope.strategy}" var="i">
            <li role="presentation">
                <a href="guide?action=queryAllPMethod&strategy_name=${i.strategy_name}" onclick="showNav()">${i.strategy_name}</a>
            </li>
        </c:forEach>
        <%--        <li role="presentation" class="active"><a href="#">Home</a></li>--%>
        <%--        <li role="presentation"><a href="#">Profile</a></li>--%>
        <%--        <li role="presentation"><a href="#">Messages</a></li>--%>
    </ul>
</center>
<div class="container" id="page_nav">
    <%--        <div class="col-md-1"></div>--%>
    <div class="col-md-12">
        <table class="table table-hover" style="vertical-align: center">
            <th><h3>防护方法序号</h3></th>
            <th><h3>防护方法</h3></th>

            <c:forEach items="${requestScope.page.items}" var="i" varStatus="s">
                <tr>
                    <td><h3>${s.count}</h3></td>
                    <%-- 查询该方法下的所有问题 --%>
                    <td><a href="guide?action=querySProbByMName&method_name=${i.method_name}"><h3>${i.method_name}</h3></a></td>
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
