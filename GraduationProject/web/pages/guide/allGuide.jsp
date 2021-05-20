<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/3/30
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/jsAndCss.jsp"%>
<html>
<head>
    <title>疫情指南功能</title>
</head>

<body>
<%-- 静态包含头部分 --%>
<%@include file="../common/head.jsp"%>
<c:if test="${param.msg != null and param.msg == 'NoCount'}">
    <script type="text/javascript">
        alert("该模块没有数据！请添加数据后再进行操作！");
    </script>
</c:if>
    <a href="#">防护攻略模块管理</a><br>
    <a href="guide?action=treatment">就医方法模块管理</a><br>

    <a href="#">口罩使用模块管理</a><br>
    <a href="#">心理疏导模块管理</a><br>

</body>
</html>
