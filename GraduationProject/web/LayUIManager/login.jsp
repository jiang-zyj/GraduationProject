<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/29
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>LarryCMS后台登录</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <!-- load css -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/LayUIManager/common/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/LayUIManager/css/login.css" media="all">
</head>


<body>
<div class="layui-canvs"></div>
<div class="layui-layout layui-layout-login">
    <h1>
        <strong>新冠疫情管理系统后台</strong>
        <em>Management System</em>
    </h1>
    <form action="../user?action=managerLogin" method="post">
        <div class="layui-user-icon larry-login">
            <input type="text" placeholder="账号" class="login_txtbx" name="uid"/>
        </div>
        <div class="layui-pwd-icon larry-login">
            <input type="password" placeholder="密码" class="login_txtbx" name="password"/>
        </div>
<%--        <div class="layui-val-icon larry-login">--%>
<%--            <div class="layui-code-box">--%>
<%--                <input type="text" id="code" name="code" placeholder="验证码" maxlength="4" class="login_txtbx">--%>
<%--                <img src="images/verifyimg.png" alt="" class="verifyImg" id="verifyImg" onClick="javascript:this.src='xxx'+Math.random();">--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="layui-submit larry-login">
            <input type="submit" value="立即登陆" class="submit_btn"/>
        </div>
        <div class="layui-login-text">
            <p>© 2020-2021 ZYJ 版权所有</p>
<%--            <p>鄂xxxxxx</p>--%>
        </div>
    </form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/LayUIManager/common/layui/lay/dest/layui.all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/LayUIManager/js/login.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/LayUIManager/jsplug/jparticle.jquery.js"></script>
<script type="text/javascript">
    $(function(){
        $(".layui-canvs").jParticle({
            background: "#141414",
            color: "#E6E6E6"
        });
    });
</script>

<%--<c:if test="${requestScope.msg != null and requestScope.msg = 'passFail'}">--%>
<%--    <script type="text/javascript">--%>
<%--        alert("密码不正确");--%>
<%--        // layer.msg("登录账号不能为空，请输入", {time:1000, icon:5, shift:6}, function () {--%>
<%--        //     // alert(111);--%>
<%--        // });--%>
<%--    </script>--%>
<%--</c:if>--%>
<%--<c:if test="${requestScope.msg != null and requestScope.msg = 'accountFail'}">--%>
<%--    <script type="text/javascript">--%>
<%--        alert("账号不正确");--%>
<%--    </script>--%>
<%--</c:if>--%>
</body>
</html>
