<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/7
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/jsAndCss.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">

    // function fun() {
    //     $.post({
    //         url:"scenic?action=queryScenicByPage&city=" + $("#search").val(),
    //         data:{},
    //         success:function (data) {
    //
    //         },
    //         dataType:"json"
    //     });
    // }
</script>
<body>
<%-- 静态包含头部分 --%>
<%@include file="../common/head.jsp"%>
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

    <p class="navbar-text navbar-static-top">输入城市名</p>
    <form class="navbar-form navbar-left" role="search" action="scenic?action=queryScenicByPage" } method="post">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="请输入城市名" name="cname" value="" id="search">
        </div>
        <button type="submit" class="btn btn-default">搜索</button>
    </form>
</nav>
<div class="container">
    <div class="col-md-12">
        <table class="table table-hover">
            <th><h3>景区名</h3></th>
            <th><h3>景区图片</h3></th>
            <th><h3>景区地址</h3></th>
            <th><h3>营业时间</h3></th>
            <th><h3>是否开放</h3></th>
            <th><h3>是否需要预约</h3></th>
            <c:forEach items="${requestScope.page.items}" var="i" varStatus="s">
                <tr>
                    <td><h3>${i.scenic_name}</h3></td>
                    <td><img src="${i.scenic_pic}" alt="加载失败" style="height: 80px;width: 100px" class="img-rounded">
                    </td>
                    <td><h3>${i.business_hours}</h3></td>
                    <td><h3>${i.scenic_addr}</h3></td>
                    <td><h3>${i.scenic_opened}</h3></td>
                    <td><h3>${i.scenic_flag}</h3></td>
                </tr>
            </c:forEach>

        </table>

            <%--静态包含分页条--%>
            <%@include file="../common/page_nav.jsp" %>
    </div>
</div>
</body>
</html>
