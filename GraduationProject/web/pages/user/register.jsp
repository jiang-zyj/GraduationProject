<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/3/25
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%-- 静态包含 引用的 js 和 css 文件 --%>
    <%@include file="../common/jsAndCss.jsp"%>
</head>




<script type="text/javascript">

    // 给邮箱添加 Ajax 校验
    $.validator.addMethod("checkEmail", function (value, element, params) {
        // 定义一个变量用于接收返回值
        var flag = false;
        // 发起 Servlet 请求
        $.ajax({
            type: "POST",
            url: "user?action=checkEmail",
            // 设置为 同步，插件与异步处理有冲突
            async: false,
            data: {email: value},
            success: function (data) {
                flag = data;
            },
            dataType: "json"
        });
        return flag;
    });
    // 给用户身份证号添加 Ajax 校验
    $.validator.addMethod("checkUid",function (value, element, params) {
        var flag = false;

        $.ajax({
            type: "POST",
            url:"user?action=checkUid",
            async: false,
            data: {uid:value},
            dataType: "json",
            success: function (data) {
                flag = data;
            }
        });
        return flag;
    });

    $(function () {
        $("#register").validate({
            rules: {
                "uid":{
                    required:true,
                    rangelength:[18,18],
                    checkUid:true
                },
                "name": {
                    required: true,
                    rangelength: [1, 10]
                },
                "email": {
                    required: true,
                    email: true,
                    checkEmail: true,
                    rangelength:[4,20]
                },
                "password": {
                    required: true,
                    rangelength: [5, 10]
                },
                "password2": {
                    required: true,
                    equalTo: "#password"
                },
                "address":{
                    required:true,
                    rangelength:[2,10]
                },
                "tel":{
                    required:true,
                    rangelength:[11,11]
                }
            },
            messages: {
                "uid":{
                    required:"身份证号不能为空",
                    rangelength:"身份证号为18位",
                    checkUid:"该身份证已被注册"
                },
                "name": {
                    required: "用户名不能为空",
                    rangelength: "长度为6-10"
                },
                "email": {
                    required: "邮箱不能为空",
                    email: "请输入正确的邮箱格式",
                    checkEmail: "该邮箱已被注册",
                    rangelength:"邮箱号过长"
                },
                "password": {
                    required: "密码不能为空",
                    rangelength: "长度为5-10位"
                },
                "password2": {
                    required: "确认密码不能为空",
                    equalTo: "两次密码不一致"
                },
                "address":{
                    required:true,
                    rangelength:"您输入的地址过长"
                },
                "tel":{
                    required:true,
                    rangelength:"请输入正确的手机号"
                }
            }
        });
    });
</script>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <center><h1>注册账号</h1></center>
            <form id="register" class="form-horizontal" action="user?action=register" method="post">
                <div class="form-group">
                    <label>身份证号：</label>
                    <input type="text" class="form-control" id="uid" name="uid">
                </div>
                <div class="form-group">
                    <label>用户名：</label>
                    <input type="text" class="form-control" id="name" name="name">
                </div>
                <div class="form-group">
                    <label>密码：</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <div class="form-group">
                    <label>确认密码</label>
                    <input type="password" class="form-control" id="password2" name="password2">
                </div>
                <div class="form-group">
                    <label>性别：</label>
                </div>
                <div class="radio">

                    <label>
                        <input type="radio" name="sex" id="optionsRadios1" value="男" checked>
                        男
                    </label>
                    &nbsp;
                    &nbsp;
                    <label>
                        <input type="radio" name="sex" id="optionsRadios2" value="女">
                        女
                    </label>
                </div>
                <div class="form-group">
                    <label>现居城市：</label>
                    <input type="text" class="form-control" id="address" aria-describedby="emailHelp"
                           name="address">
                </div>
                <div class="form-group">
                    <label>手机号：</label>
                    <input type="text" class="form-control" id="tel" aria-describedby="emailHelp"
                           name="tel">
                </div>
                <div class="form-group">
                    <label>邮箱：</label>
                    <input type="email" class="form-control" id="email" aria-describedby="emailHelp"
                           name="email">
                </div>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="submit" class="btn btn-primary">注册</button>
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
                <button type="reset" class="btn btn-primary">重置</button>
            </form>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>

</body>
</html>
