<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
    <meta charset="utf-8">
    <meta content="webkit" name="renderer"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
    <meta content="no-cache" http-equiv="Pragma"/>
    <meta http-equiv="Expires" content="0"/>
    <meta content="width=device-width, initial-scale=1, user-scalable=1" name="viewport"/>
    <title>曾亚军ERP</title>
    <meta name="keywords" content="ERP,ERP系统,进销存,进销存系统" />
    <meta name="description" content="ERP系统,进销存系统" />
    <%-- 静态包含js、css、base --%>
    <%@include file="../../common/jsAndCss.jsp"%>
</head>
<body class="hold-transition login-page">

<%-- <%
	request.getParameter("msg");
%> --%>

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

<body class="wrapper">
    <!--[if lte IE 9]><a style="position:absolute;top:0;left:0;z-index:100000;display:block;width:100%;font-size:14px;
    color:#F00;text-decoration:none;background-color:#faffb3;text-align:center;" href="js/upbw/index.html" target="_blank">
    您的浏览器版本过低或在兼容模式下，导致打开速度过慢，提升速度您可以切换到极速模式或升级为最新版，点击此处查看详情。</a>
    <![endif]-->
    <!--[if lte IE 8]><script>window.location.href = '/js/static/upbw/index.html';</script><![endif]-->
    <link rel="stylesheet" href="js/modules/sys/sysLogin.css">
    <div class="login-box">
        <div class="login-logo">
            <a href="/">
                <b>曾亚军ERP</b>
                <small>V1.0</small>
            </a>
        </div>


        <form action="user?action=login" method="post">
            <input type="hidden" value="${param.msg}">
            <div class="login-box-body">
                <div class="form-group has-feedback">
                    <span class="glyphicon glyphicon-user form-control-feedback" title="登录账号"></span>
                    <input type="text" id="loginName" name="uid" value="" class="form-control required"
                           data-msg-required="请填写登录账号." placeholder="登录账号"/>
                </div>
                <div class="form-group has-feedback">
                <span class="glyphicon glyphicon-lock form-control-feedback"
                      title="登录密码，鼠标按下显示密码"
                      onmousedown="$('#password').attr('type','text')"
                      onmouseup="$('#password').attr('type','password')">
                </span>
                    <input type="password" id="password" name="password" value="" class="form-control required"
                           data-msg-required="请填写登录密码." placeholder="登录密码" autocomplete="off"/>
                </div>

                <div class="form-group has-feedback">
                    <span class="glyphicon glyphicon-picture form-control-feedback" title="验证码"></span>
                    <img src="imgs" alt="加载失败" onclick="reloadImg()">

                    <input type="text" id="codes" name="codes" size="4" class="form-control required"
                           data-msg-required="请填写验证码" placeholder="验证码" />
                </div>

                <div class="form-group">
                    <div class="mt5 icheck">
                        <label title="公共场所慎用,下次不需要再填写帐号">
                            <input type="checkbox" id="rememberUserCode" name="remember" value="rem" class="form-control" data-style="minimal-grey">记住账号</label> &nbsp;
                        <label title="公共场所慎用,下次不需要再填写帐号和密码">
                            <input type="checkbox" id="rememberMe"  name="auto_login" value="auto_login" class="form-control" data-style="minimal-grey"> 自动登录</label>
                    </div>
                </div>

                <div class="form-group">
                    <input type="hidden" name="__url" value="">
                    <button type="submit" class="btn btn-primary btn-block btn-flat"
                            id="btnSubmit" data-loading="登录验证成功，正在进入..."
                            data-login-valid="正在验证登录，请稍候...">立即登录
                    </button>
                </div>
        </form>
            <div class="row">
                <div class="col-xs-12">
                    <a href="register.html" class="pull-left"><b>[ 立即注册 ]</b></a>
                    <div class="dropdown pull-right">
                        <a href="http://www.huaxiaerp.com/" class="dropdown-toggle" target="_blank">
                            <b><i class="fa icon-globe"></i> 官方网站</b>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="login-copyright">
            © 2021-2030 曾亚军ERP - Powered By
            <a style="color:#00458a;" href="http://www.huaxiaerp.com/" target="_blank">官方网站</a>
        </div>
    </div>
</body>

<a id="scroll-up" href="#" class="btn btn-sm"><i class="fa fa-angle-double-up"></i></a>
<script src="js/bootstrap/js/bootstrap.min.js"></script>
<script src="js/select2/4.0/select2.js"></script>
<script src="js/select2/4.0/i18n/zh_CN.js"></script>
<script src="js/layer/3.1/layer.js"></script>
<script src="js/jquery-validation/1.16/jquery.validate.js"></script>
<script src="js/jquery-validation/1.16/localization/messages_zh_CN.js"></script>
<script src="js/jquery-validation/1.16/jquery.validate.extend.js"></script>
<script src="js/common/jsherp.js"></script>
<script src="js/common/i18n/jsherp_zh_CN.js"></script>
<script src="js/common/common.js"></script>
<script src="js/md5/md5.js"></script>
<script src="js/modules/sys/sysLogin.js"></script>