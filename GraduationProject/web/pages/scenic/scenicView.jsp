<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/3/30
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../common/jsAndCss.jsp"%>
</head>
<body>
<%-- 静态包含头部分 --%>
<%@include file="../common/head.jsp"%>
<div class="container">
    <div class="col-md-12">
        <table class="table table-hover">
            <th><h3>景区名</h3></th>
            <th><h3>景区图片</h3></th>
            <th><h3>景区地址</h3></th>
            <th><h3>营业时间</h3></th>
            <th><h3>是否开放</h3></th>
            <th><h3>是否需要预约</h3></th>
            <th colspan="2"><h3>操作</h3></th>

            <c:forEach items="${requestScope.page.items}" var="i" varStatus="s">
                <tr>
                    <td><h3>${i.scenic_name}</h3></td>
                    <td><img src="${i.scenic_pic}" alt="加载失败" style="height: 80px;width: 100px" class="img-rounded"></td>
                    <td><h3>${i.business_hours}</h3></td>
                    <td><h3>${i.scenic_addr}</h3></td>
                    <td><h3>${i.scenic_opened}</h3></td>
                    <td><h3>${i.scenic_flag}</h3></td>
                    <td><h3><a href="#">删除</a></h3></td>
                    <td><h3><a href="#">更新</a></h3></td>
                </tr>
            </c:forEach>

        </table>
        <tr>
            <span class="label label-primary"><a href="pages/guide/addTreatProb.jsp">添加</a></span>
            <td><a href="pages/guide/addTreatProb.jsp">添加</a></td>
        </tr>
        <tr>
            <%--静态包含分页条--%>
            <%@include file="../common/page_nav.jsp"%>
        <tr>
        </tr>
    </div>

</div>
</body>
</html>
