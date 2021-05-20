<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/3
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/jsAndCss.jsp"%>
<%--<%@include file="../../common/jsAndCss.jsp"%>--%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="static/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="static/jquery.validate.min.js"></script>
    <script type="text/javascript" src="static/messages_cn.js"></script>
    <link rel="stylesheet" href="static/css/bootstrap.css">
    <link rel="stylesheet" href="static/css/bootstrap-theme.css">
    <link rel="shortcut icon" href="static/images/favicon.ico" type="image/x-icon"/>
</head>
<%-- 静态包含头部分 --%>
<%@include file="../../common/head.jsp"%>
<body>
        <center>
        <br><br><br><br>
        <form class="form-horizontal" style="horiz-align: center">
            <fieldset disabled>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="inputEmail3" placeholder="Email" value="${sessionScope.user.name}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">身份证号</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputPassword3" placeholder="Password" value="${sessionScope.user.uid}">
                    </div>
                </div>
            </fieldset>
        </form>
        <img src="code${sessionScope.fileName}" alt="加载失败">
<%--        <img src="${sessionScope.filePath} '/' ${sessionScope.fileName}" alt="加载失败">--%>
        </center>
</body>
</html>
