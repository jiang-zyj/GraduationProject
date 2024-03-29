<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/5/6
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>基本信息</title>
    <link rel="stylesheet" href="css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-side layui-bg-black" style="top:0px;background-color: #33b7b1!important;">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" style="background-color: #33b7b1!important;color: white;">
                <li class="layui-nav-item">
                    <a data-url="/information/getCarInformation" data-id="carInformation" data-title="车辆信息" class="site-demo-active"  href="javascript:;" data-type="tabAdd">车辆信息</a>
                </li>
                <li class="layui-nav-item">
                    <a data-url="${pageContext.request.contextPath}/LayUIManager/COVID-19Manager/data_view.jsp" data-id="userInformation" data-title="疫情数据" class="site-demo-active"  href="javascript:;" data-type="tabAdd">疫情数据</a>
                </li>
                <li class="layui-nav-item">
                    <a data-url="/information/getRoleInformation" data-id="roleInformation" data-title="角色信息" class="site-demo-active"  href="javascript:;" data-type="tabAdd">角色信息</a>
                </li>
                <li class="layui-nav-item">
                    <a data-url="/news_list" data-id="3" data-title="新闻列表" class="site-demo-active"  href="javascript:;" data-type="tabAdd">新闻列表</a>
                </li>
                <li class="layui-nav-item">
                    <a data-url="/news_list" data-id="3" data-title="新闻列表" class="site-demo-active"  href="javascript:;" data-type="tabAdd">新闻列表</a>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body" style="top:0px">

        <!-- 内容主体区域 -->
        <div class="layui-tab layui-tab-card" lay-filter="demo" lay-allowclose="true">
            <ul class="layui-tab-title">
                <li class="layui-this" lay-id="carInformation">车辆信息</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <iframe src="scenicManager/scenic_view.jsp" scrolling="no" frameborder="0"  style="width:100%"></iframe>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="common/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
        var $ = layui.jquery;
        //触发事件

        element.tabAdd('demo', {
            title: '选项卡的标题'
            ,content: '<iframe data-frameid="'+id+'" scrolling="no" frameborder="0" src="'+url+'" style="width:100%;"></iframe>' //支持传入html
            ,id: '选项卡标题的lay-id属性值'
        });

        var active = {
            //在这里给active绑定几项事件，后面可通过active调用这些事件
            tabAdd: function(url,id,name) {
                //新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
                //关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
                element.tabAdd('demo', {
                    title: name,
                    content: '<iframe data-frameid="'+id+'" scrolling="no" frameborder="0" src="'+url+'" style="width:100%;"></iframe>',
                    id: id //规定好的id
                })
                element.render('tab');
            },
            tabChange: function(id) {
                //切换到指定Tab项
                element.tabChange('demo', id); //根据传入的id传入到指定的tab项
            },
            tabDelete: function (id) {
                element.tabDelete("demo", id);//删除
            }
            , tabDeleteAll: function (ids) {//删除所有
                $.each(ids, function (i,item) {
                    element.tabDelete("demo", item); //ids是一个数组，里面存放了多个id，调用tabDelete方法分别删除
                })
            }
        };


//当点击有site-demo-active属性的标签时，即左侧菜单栏中内容 ，触发点击事件
        $('.site-demo-active').on('click', function() {
            var dataid = $(this);

//这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
            if ($(".layui-tab-title li[lay-id]").length <= 0) {
//如果比零小，则直接打开新的tab项
                active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"),dataid.attr("data-title"));
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
                    active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"),dataid.attr("data-title"));
                }
            }
//最后不管是否新增tab，最后都转到要打开的选项页面上
            active.tabChange(dataid.attr("data-id"));
        });

    });
</script>
</body>
</html>
