<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/29
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新冠疫情数据平台后台管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <!-- load css -->
    <link rel="stylesheet" type="text/css" href="LayUIManager/common/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="LayUIManager/common/global.css" media="all">
    <link rel="stylesheet" type="text/css" href="LayUIManager/css/adminstyle.css" media="all">


</head>
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
            <%--            <div class="layui-larry-menu">--%>
            <%--                <ul class="layui-nav clearfix">--%>
            <%--                    <li class="layui-nav-item layui-this">--%>
            <%--                        <a href="javascirpt:;"><i class="iconfont icon-wangzhanguanli"></i>内容管理</a>--%>
            <%--                    </li>--%>
            <%--                    <li class="layui-nav-item">--%>
            <%--                        <a href="javascirpt:;"><i class="iconfont icon-weixin3"></i>微信公众</a>--%>
            <%--                    </li>--%>
            <%--                    <li class="layui-nav-item">--%>
            <%--                        <a href="javascirpt:;"><i class="iconfont icon-ht_expand"></i>扩展模块</a>--%>
            <%--                    </li>--%>
            <%--                </ul>--%>
            <%--            </div>--%>
            <!-- 右侧导航 -->
            <ul class="layui-nav larry-header-item">
                <li class="layui-nav-item">
                    账户名：${sessionScope.userManager.name}
                </li>
                <%--                <li class="layui-nav-item first">--%>
                <%--                    <a href="javascript:;">--%>
                <%--                        <cite>默认站点</cite>--%>
                <%--                        <span class="layui-nav-more"></span>--%>
                <%--                    </a>--%>
                <%--                    <dl class="layui-nav-child">--%>
                <%--                        <dd>--%>
                <%--                            <a href="">站点1</a>--%>
                <%--                        </dd>--%>
                <%--                        <dd>--%>
                <%--                            <a href="">站点2</a>--%>
                <%--                        </dd>--%>
                <%--                    </dl>--%>
                <%--                </li>--%>
                <%--                <li class="layui-nav-item">--%>
                <%--                    <a href="javascript:;" id="lock">--%>
                <%--                        <i class="iconfont icon-diannao1"></i>--%>
                <%--                        锁屏</a>--%>
                <%--                </li>--%>
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
                <li class="layui-nav-item layui-this">
                    <a href="javascript:;" data-url="ScenicManager/scenic_view.jsp">
                        <i class="iconfont icon-home1" data-icon='icon-home1'></i>
                        <span>出游景点管理</span>
                    </a>
                </li>
                <li class="layui-nav-item layui-this">
                    <a href="javascript:;" data-url="ScenicManager/scenic_view.jsp">
                        <i class="iconfont icon-home1" data-icon='icon-home1'></i>
                        <span>用户管理</span>
                    </a>
                </li>
                <li class="layui-nav-item layui-this">
                    <a href="javascript:;" data-url="ScenicManager/scenic_view.jsp">
                        <i class="iconfont icon-home1" data-icon='icon-home1'></i>
                        <span>疫情数据管理</span>
                    </a>
                </li>


                <!-- 个人信息 -->
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="iconfont icon-jiaoseguanli"></i>
                        <span>疫情指南模块管理</span>
                        <em class="layui-nav-more"></em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;"
                               data-id="protected"
                               data-url="GuideManager/protect/problem_view.jsp">
                                <i class="iconfont icon-geren1" data-icon='icon-geren1' data-type="tabAdd"></i>
                                <span>科学防护管理</span>
                            </a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="changepwd.html">
                                <i class="iconfont icon-iconfuzhi01" data-icon='icon-iconfuzhi01'></i>
                                <span>口罩使用管理</span>
                            </a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="myloginfo.html">
                                <i class="iconfont icon-piliangicon" data-icon='icon-piliangicon'></i>
                                <span>心理疏导管理</span>
                            </a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="myloginfo.html">
                                <i class="iconfont icon-piliangicon" data-icon='icon-piliangicon'></i>
                                <span>心理疏导管理</span>
                            </a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="myloginfo.html">
                                <i class="iconfont icon-piliangicon" data-icon='icon-piliangicon'></i>
                                <span>就医问题管理</span>
                            </a>
                        </dd>
                    </dl>
                </li>


            </ul>
        </div>
    </div>

    <!-- 左侧侧边导航结束 -->
    <!-- 右侧主体内容 -->
    <div class="layui-body" id="larry-body" style="bottom: 0;border-left: solid 2px #2299ee;">
        <div class="layui-tab layui-tab-card larry-tab-box" id="larry-tab" lay-filter="demo" lay-allowclose="true">
            <div class="go-left key-press pressKey" id="titleLeft" title="滚动至最右侧"><i
                    class="larry-icon larry-weibiaoti6-copy"></i></div>
            <ul class="layui-tab-title">
                <li class="layui-this" id="admin-home"><i class="iconfont icon-diannao1"></i><em>后台首页</em></li>
            </ul>
            <div class="go-right key-press pressKey" id="titleRight" title="滚动至最左侧"><i
                    class="larry-icon larry-right"></i></div>
            <ul class="layui-nav closeBox">
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="iconfont icon-caozuo"></i> 页面操作</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" class="refresh refreshThis"><i class="layui-icon">&#x1002;</i>
                            刷新当前</a></dd>
                        <dd><a href="javascript:;" class="closePageOther"><i class="iconfont icon-prohibit"></i>
                            关闭其他</a></dd>
                        <dd><a href="javascript:;" class="closePageAll"><i class="iconfont icon-guanbi"></i> 关闭全部</a>
                        </dd>
                    </dl>
                </li>
            </ul>
            <div class="layui-tab-content" style="min-height: 150px; ">
                <div class="layui-tab-item layui-show">
                    <iframe class="larry-iframe" data-id='0'
                            src="${pageContext.request.contextPath}/LayUIManager/main.jsp"></iframe>
                </div>
            </div>
        </div>
    </div>
    <!-- 底部区域 -->
    <div class="layui-footer layui-larry-foot" id="larry-footer">
        <div class="layui-mian">
            <p class="p-admin">
                <span>2017 &copy;</span>
                新冠疫情服务平台后台管理系统
            </p>
        </div>
    </div>
</div>
<!-- 加载js文件-->
<script type="text/javascript" src="LayUIManager/common/layui/layui.js"></script>
<script type="text/javascript" src="LayUIManager/js/larry.js"></script>
<script type="text/javascript" src="LayUIManager/js/index.js"></script>
<!-- 锁屏 -->
<div class="lock-screen" style="display: none;">
    <div id="locker" class="lock-wrapper">
        <div id="time"></div>
        <div class="lock-box center">
            <img src="images/userimg.jpg" alt="">
            <h1>admin</h1>
            <duv class="form-group col-lg-12">
                <input type="password" placeholder='锁屏状态，请输入密码解锁' id="lock_password" class="form-control lock-input"
                       autofocus name="lock_password">
                <button id="unlock" class="btn btn-lock">解锁</button>
            </duv>
        </div>
    </div>
</div>

</body>


<script src="common/layui/layui.js"></script>
<%--<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;
        var $ = layui.jquery;
        //触发事件
        var active = {
            //在这里给active绑定几项事件，后面可通过active调用这些事件
            tabAdd: function (url, id, name) {
                console.log(url);
                console.log(id);
                console.log(name);
                //新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
                //关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
                element.tabAdd('demo', {
                    title: name,
                    content: '<iframe data-frameid="' + id + '" scrolling="no" frameborder="0" src="' + url + '" style="width:100%;"></iframe>',
                    id: id //规定好的id
                })
                element.render('tab');

            },
            tabChange: function (id) {
//切换到指定Tab项
                element.tabChange('demo', id); //根据传入的id传入到指定的tab项
            },
            tabDelete: function (id) {
                element.tabDelete("demo", id);//删除
            }
            , tabDeleteAll: function (ids) {//删除所有
                $.each(ids, function (i, item) {
                    element.tabDelete("demo", item); //ids是一个数组，里面存放了多个id，调用tabDelete方法分别删除
                })
            }
        };

        // 获取宽高
        function


//当点击有site-demo-active属性的标签时，即左侧菜单栏中内容 ，触发点击事件
        $('.site-demo-active').on('click', function () {
            var dataid = $(this);

//这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
            if ($(".layui-tab-title li[lay-id]").length <= 0) {
//如果比零小，则直接打开新的tab项
                active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.attr("data-title"));
            } else {
//否则判断该tab项是否以及存在

                var isData = false; //初始化一个标志，为false说明未打开该tab项 为true则说明已有
                $.each($(".layui-tab-title li[lay-id]"), function () {
//如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
                    if ($(this).attr("lay-id") == dataid.attr("data-id")) {
                        isData = true;
                    }
                })
                if (isData == false) {
//标志为false 新增一个tab项
                    active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.attr("data-title"));
                }
            }
//最后不管是否新增tab，最后都转到要打开的选项页面上
            active.tabChange(dataid.attr("data-id"));
        });

    });
</script>--%>
</html>
