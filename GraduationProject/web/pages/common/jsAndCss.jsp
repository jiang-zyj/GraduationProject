<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/3/29
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
    pageContext.setAttribute("basePath", basePath);
%>
<base href="<%=basePath%>">
<script type="text/javascript" src="static/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="static/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="static/js/messages_cn.js"></script>
<script type="text/javascript" src="static/js/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="static/css/bootstrap.css">
<link rel="stylesheet" href="static/css/bootstrap-theme.css">
<link rel="shortcut icon" href="static/images/favicon.ico" type="image/x-icon"/>
<%--<script src="static/js/jquery/jquery-1.12.4.min.js"></script>--%>
<!--[if lt IE 9]><script src="static/js/common/h5fix.min.js"></script><![endif]-->
<%--<link rel="stylesheet" href="static/css/fonts/font-icons.min.css">--%>
<%--<link rel="stylesheet" href="static/js/bootstrap/css/bootstrap.min.css">--%>
<%--<link rel="stylesheet" href="static/js/select2/4.0/select2.css">--%>
<%--<link rel="stylesheet" href="static/js/icheck/1.0/minimal/grey.css">--%>
<%--<link rel="stylesheet" href="static/js/adminlte/css/AdminLTE.min.css">--%>
<%--<link rel="stylesheet" href="static/css/jsherp.css">--%>
<%--<link rel="stylesheet" href="static/js/adminlte/css/skins/skin-blue-light2.css">--%>
