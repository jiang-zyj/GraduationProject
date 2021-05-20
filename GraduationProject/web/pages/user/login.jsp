<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/3/28
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 静态包含头文件 --%>
<%@include file="../common/jsAndCss.jsp" %>

<html>
<head>
    <title>Title</title>

</head>
<c:if test="${param.msg!=null and param.msg=='accountFail'}">
    <script type="text/javascript">
        alert("账号不存在！");
    </script>
</c:if>
<c:if test="${param.msg!=null and param.msg=='passFail'}">
    <script type="text/javascript">
        alert("密码错误！");
    </script>
</c:if>

<script type="text/javascript">
    function reloadImg() {
        location.href = "imgs";
    }
</script>
<body>

<div class="container">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <center> <h1>登录系统</h1></center>
        <form class="form-horizontal" action="user?action=login" method="post">
            <div class="form-group">
                <label>账号</label>
                <input type="text" class="form-control" id="uid" placeholder="请输入身份证号或者邮箱号" name="uid">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">密码</label>
                <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码">
            </div>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn btn-default">登录</button>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="reset" class="btn btn-default">重置</button>
        </form>
    </div>
    <div class="col-md-2"></div>
</div>


</body>
</html>
