<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/5/7
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>LarryCMS后台管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <!-- load css -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backManager/common/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backManager/common/global.css" media="all">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backManager/css/adminstyle.css" media="all">


</head>
<!-- 加载js文件-->
<script type="text/javascript" src="${pageContext.request.contextPath}/backManager/common/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/backManager/js/larry.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/backManager/js/index.js"></script>
<body>
<div class="layui-layout layui-layout-admin" id="layui_layout">
    <!-- 顶部区域 -->
    <div class="layui-header header header-demo">
        <div class="layui-main">
            <!-- logo区域 -->
            <div class="admin-logo-box">
                <a class="logo" href="http://www.kuxuebao.net" title="logo">后台管理系统</a>
                <div class="larry-side-menu">
                    <i class="fa fa-bars" aria-hidden="true"></i>
                </div>
            </div>
            <!-- 顶级菜单区域 -->
            <div class="layui-larry-menu">
                <ul class="layui-nav clearfix">
                    <!--                       <li class="layui-nav-item layui-this">-->
                    <!--                 	   	   <a href="javascirpt:;"><i class="iconfont icon-wangzhanguanli"></i>内容管理</a>-->
                    <!--                 	   </li>-->
                    <!--                 	   <li class="layui-nav-item">-->
                    <!--                 	   	   <a href="javascirpt:;"><i class="iconfont icon-weixin3"></i>微信公众</a>-->
                    <!--                 	   </li>-->
                    <!--                 	   <li class="layui-nav-item">-->
                    <!--                 	   	   <a href="javascirpt:;"><i class="iconfont icon-ht_expand"></i>扩展模块</a>-->
                    <!--                 	   </li>-->
                </ul>
            </div>
            <!-- 右侧导航 -->
            <ul class="layui-nav larry-header-item">
                <li class="layui-nav-item">
                    ${sessionScope.user.name}
                </li>
                <!--            		<li class="layui-nav-item first">-->
                <!--						<a href="javascript:;">			-->
                <!--							<cite>默认站点</cite>-->
                <!--							<span class="layui-nav-more"></span>-->
                <!--						</a>-->
                <!--						<dl class="layui-nav-child">-->
                <!--							<dd>-->
                <!--								<a href="">站点1</a>-->
                <!--							</dd>-->
                <!--							<dd>-->
                <!--								<a href="">站点2</a>-->
                <!--							</dd>-->
                <!--							-->
                <!--						</dl>-->
                <!--					</li>-->
                <!--					<li class="layui-nav-item">-->
                <!--						<a href="javascript:;" id="lock">-->
                <!--                        <i class="iconfont icon-diannao1"></i>-->
                <!--						锁屏</a>-->
                <!--					</li>-->
                <li class="layui-nav-item">
                    <a href="user?action=managerLogout">
                        <i class="iconfont icon-exit"></i>
                        退出</a>
                </li>
            </ul>
        </div>
    </div>
    <!-- 左侧侧边导航开始 -->
    <div class="layui-side layui-side-bg layui-larry-side" id="larry-side">
        <div class="layui-side-scroll" id="larry-nav-side" lay-filter="side">

            <!-- 左侧菜单 -->
            <ul class="layui-nav layui-nav-tree">
                <!-- 个人信息 -->
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="iconfont icon-jiaoseguanli" ></i>
                        <span>疫情指南管理</span>
                        <em class="layui-nav-more"></em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" data-url="LayUIManager/GuideManager/protect/problem_view.jsp">
                                <i class="iconfont icon-geren1" data-icon='icon-geren1'></i>
                                <span>防护攻略问题管理</span>
                            </a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="LayUIManager/GuideManager/rumor/rumor.jsp">
                                <i class="iconfont icon-iconfuzhi01" data-icon='icon-iconfuzhi01'></i>
                                <span>谣言管理</span>
                            </a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="LayUIManager/GuideManager/Counseling/c_Problem_view.jsp">
                                <i class="iconfont icon-piliangicon" data-icon='icon-piliangicon'></i>
                                <span>心理问题管理</span>
                            </a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="LayUIManager/GuideManager/faceMask/facemaskProblem.jsp">
                                <i class="iconfont icon-piliangicon" data-icon='icon-piliangicon'></i>
                                <span>口罩使用问题管理</span>
                            </a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="LayUIManager/GuideManager/Hospitalize/h_problem_view.jsp">
                                <i class="iconfont icon-piliangicon" data-icon='icon-piliangicon'></i>
                                <span>就医问题管理</span>
                            </a>
                        </dd>
                    </dl>
                </li>


                <li class="layui-nav-item layui-this">
                    <a href="javascript:;" data-url="LayUIManager/COVID-19Manager/data_view.jsp">
                        <i class="iconfont icon-home1" data-icon='icon-home1'></i>
                        <span>疫情数据管理</span>
                    </a>
                </li>
                <li class="layui-nav-item layui-this">
                    <a href="javascript:;" data-url="LayUIManager/scenicManager/scenic_view.jsp">
                        <i class="iconfont icon-home1" data-icon='icon-home1'></i>
                        <span>出游助手管理</span>
                    </a>
                </li>
                <li class="layui-nav-item layui-this">
                    <a href="javascript:;" data-url="LayUIManager/UserManager/user_view.jsp">
                        <i class="iconfont icon-home1" data-icon='icon-home1'></i>
                        <span>用户管理</span>
                    </a>
                </li>

            </ul>
        </div>
    </div>

    <!-- 左侧侧边导航结束 -->
    <!-- 右侧主体内容 -->
    <div class="layui-body" id="larry-body" style="bottom: 0;border-left: solid 2px #2299ee;">
        <div class="layui-tab layui-tab-card larry-tab-box" id="larry-tab" lay-filter="demo" lay-allowclose="true">
            <div class="go-left key-press pressKey" id="titleLeft" title="滚动至最右侧"><i class="larry-icon larry-weibiaoti6-copy"></i> </div>
            <ul class="layui-tab-title">
                <li class="layui-this" id="admin-home"><i class="iconfont icon-diannao1"></i><em>后台首页</em></li>
            </ul>
            <div class="go-right key-press pressKey" id="titleRight" title="滚动至最左侧"><i class="larry-icon larry-right"></i></div>
            <ul class="layui-nav closeBox">
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="iconfont icon-caozuo"></i> 页面操作</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" class="refresh refreshThis"><i class="layui-icon">&#x1002;</i> 刷新当前</a></dd>
                        <dd><a href="javascript:;" class="closePageOther"><i class="iconfont icon-prohibit"></i> 关闭其他</a></dd>
                        <dd><a href="javascript:;" class="closePageAll"><i class="iconfont icon-guanbi"></i> 关闭全部</a></dd>
                    </dl>
                </li>
            </ul>
            <div class="layui-tab-content" style="min-height: 150px; ">
<%--                <div class="layui-tab-item layui-show">--%>
<%--                    <iframe class="larry-iframe" data-id='0' src="main.html"></iframe>--%>
<%--                </div>--%>
            </div>
        </div>
    </div>
    <!-- 底部区域 -->
    <div class="layui-footer layui-larry-foot" id="larry-footer">
        <div class="layui-mian">
            <p class="p-admin">
                <span>2021 &copy;</span>
                新冠疫情数据可视化与服务平台
            </p>
        </div>
    </div>
</div>

<!-- 锁屏 -->
<!--<div class="lock-screen" style="display: none;">-->
<!--	<div id="locker" class="lock-wrapper">-->
<!--		<div id="time"></div>-->
<!--		<div class="lock-box center">-->
<!--			<img src="images/userimg.jpg" alt="">-->
<!--			<h1>admin</h1>-->
<!--			<duv class="form-group col-lg-12">-->
<!--				<input type="password" placeholder='锁屏状态，请输入密码解锁' id="lock_password" class="form-control lock-input" autofocus name="lock_password">-->
<!--				<button id="unlock" class="btn btn-lock">解锁</button>-->
<!--			</duv>-->
<!--		</div>-->
<!--	</div>-->
<!--</div>-->

</body>
</html>
