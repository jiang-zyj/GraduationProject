<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/13
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--&lt;%&ndash; 引用LayUI的css样式 &ndash;%&gt;--%>
<%--<link type="text/css" rel="stylesheet" href="../css/layui.css">--%>
<%--<script src="../layui.js" charset="utf-8"></script>--%>
<%--<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->--%>
<head>
    <title>Title</title>
    <%@include file="../common/LayUIjsAndCss.jsp" %>
</head>
<body>
<h1 align="center">景区信息</h1>

<%-- 条件查询的开始 --%>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>高级查询</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">选择城市</label>
        <div class="layui-input-block">
            <select id="chooseCity" name="cname" lay-filter="aihao" lay-verify="required"
                    lay-reqtext="请先选择城市">
                <option value="">请选择城市</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="doSearch">搜索</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<%-- 条件查询的结束 --%>

<%-- 添加页面的开始 --%>
<div id="addForm" style="display: none">
    <form class="layui-form" action="" lay-filter="add">
        <input type="hidden" name="sid">
        <div class="layui-form-item">
            <label class="layui-form-label">景区名</label>
            <div class="layui-input-block">
                <input type="text" name="scenic_name" lay-verify="required|title" lay-reqtext="请先填写景区名"
                       autocomplete="off"
                       placeholder="请输入景区名" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">景区图片链接</label>
            <div class="layui-input-block">
                <input type="text" name="scenic_pic" lay-verify="required|title" lay-reqtext="请先填写景区图片链接"
                       autocomplete="off"
                       placeholder="请输入景区图片链接" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">景区地址</label>
            <div class="layui-input-block">
                <input type="text" name="scenic_addr" lay-verify="required" lay-reqtext="请先填写景区地址" autocomplete="off"
                       placeholder="请输入景区地址" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" pane="">
            <label class="layui-form-label">营业时间</label>
            <div class="layui-input-block">
                <input type="text" name="business_hours" lay-verify="required" lay-reqtext="请先填写营业时间" autocomplete="off"
                       placeholder="请输入营业时间" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">是否已开放</label>
            <div class="layui-input-block">
                <div class="layui-input-block">
                    <input type="radio" name="scenic_opened" value="已开放" title="已开放" lay-verify="required"
                           lay-reqtext="请先选择是否开放">
                    <input type="radio" name="scenic_opened" value="未开放" title="未开放" lay-verify="required"
                           lay-reqtext="请先选择是否开放">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">是否需要预约</label>
            <div class="layui-input-block">
                <div class="layui-input-block">
                    <input type="radio" name="scenic_flag" value="无需预约" title="无需预约" lay-verify="required"
                           lay-reqtext="请先选择是否需要预约">
                    <input type="radio" name="scenic_flag" value="需要预约" title="需要预约" lay-verify="required"
                           lay-reqtext="请先选择是否需要预约">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">所在城市</label>
            <div class="layui-input-block">
                <select id="cname" name="cname" lay-filter="aihao" lay-verify="required"
                        lay-reqtext="请先选择城市">
                    <option value="">请选择城市</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="addScenic">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<%-- 添加页面的结束 --%>

<table class="layui-hide" id="scenic_view" lay-filter="scenic_view"></table>
<script>
    layui.use(['table', 'form', 'jquery'], function () {
        var table = layui.table;
        var form = layui.form;
        var $ = layui.jquery;


        var url;
        var window;
        var tableIns = table.render({
            elem: '#scenic_view'
            , url: 'scenic?action=queryScenicForLayUI'
            , toolbar: '#scenic_toolbar'
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                {type: 'checkbox'}
                , {field: 'sid', width: 80, title: 'ID', sort: true}
                , {field: 'scenic_name', width: 80, title: '景区名'}
                , {
                    field: 'scenic_pic',
                    width: 80,
                    title: '景区图片',
                    sort: true,
                    templet: '<div><img src="{{d.scenic_pic}}"></div>'
                }
                , {field: 'scenic_addr', width: 80, title: '景区地址'}
                , {field: 'business_hours', title: '营业时间', width: '30%', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {field: 'scenic_opened', title: '是否开放', sort: true}
                , {field: 'scenic_flag', title: '是否需要预约', sort: true}
                , {field: 'cname', title: '所在城市'}
                , {field: 'options', title: '操作', width: 200, toolbar: '#toolbar'}
            ]]
            , page: true
            , limit: 5
            , limits: [5, 10, 15, 20]
            , done: function (res, curr, count) {
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                console.log(res);

                //得到当前页码
                console.log(curr);

                //得到数据总量
                console.log(count);
                // 如果当前页没有数据，且当前页大于 1
                if ((res.data == null || res.data.length == 0) && curr > 1) {
                    tableIns.reload({
                        where: {}  // 这里为什么用 field
                        , page: {
                            curr: curr - 1 // 显示最后一页
                        }
                    });
                }
            }
        });

        // AJAX请求 查询所有城市
        $.get({
            url: "scenic?action=queryAllCities",
            data: {},
            success: function (data) {
                var html = "";
                for (var i = 0; i < data.length; i++) {
                    html += "<option value=" + data[i].cname + ">" + data[i].cname + "</option>"
                }
                // 为添加页面添加数据
                $("#chooseCity").append(html);
                $("#cname").append(html);
                form.render('select'); //刷新select选择框渲染
            },
            dataType: "json"
        });

        // 高级查询
        form.on('submit(doSearch)', function (data) {
            console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
            tableIns.reload({
                where: data.field
                , page: {
                    curr: 1 //重新从第 1 页开始
                }
            })
            return false;   // 防止表单跳转
        })

        // 触发事件
        table.on('toolbar(scenic_view)', function (obj) {
            switch (obj.event) {
                case 'add':
                    openAddScenicWindow();
                    break;
                case 'batchDelete':
                    batchDeleteScenic();
                    break;
            }
        });

        // 打开添加页面
        function openAddScenicWindow() {
            window = layer.open({
                title: "添加景区信息",
                type: 1,
                content: $("#addForm"),
                area: ['800px', '600px'],
                success: function () {
                    url = "scenic?action=addScenic";
                }
            });
        }

        // 为添加窗口的提交添加事件
        form.on('submit(addScenic)', function (data) {
            $.post(url, data.field, function (res) {
                if (res.success) {
                    layer.alert(res.message, {icon: 1});
                    // 关闭弹出层
                    layer.close(window);
                    // 重新渲染表格
                    tableIns.reload();
                    // 清空表单数据
                    $("#addForms")[0].reset();
                } else {
                    layer.alert(res.message, {icon: 2})
                }
            }, "json")
            // 防止表单跳转
            return false;
        })

        // 批量删除景区信息
        function batchDeleteScenic() {
            // 获取选中的行
            let checkStatus = table.checkStatus('scenic_view');
            console.log(checkStatus.data) //获取选中行的数据
            console.log(checkStatus.data.length) //获取选中行数量，可作为是否有选中行的条件
            console.log(checkStatus.isAll) //表格是否全选
            // 如果有选中的行
            if (checkStatus.data.length > 0) {
                // 定义一个数组接收 rid
                var scenicArr = [];
                for (let i = 0; i < checkStatus.data.length; i++) {
                    scenicArr.push(checkStatus.data[i].sid);
                }
                // 数组转换为字符串
                let ids = scenicArr.join(",");
                // 确认信息框
                layer.confirm("您确定要删除这<font color='red' >" + checkStatus.data.length + "</font>条景区信息吗？", {
                    icon: 3,
                    title: '提示'
                }, function (index) {
                    // 发起 Ajax 请求删除数据
                    $.get("scenic?action=batchDeleteScenic", {ids: ids}, function (res) {
                        if (res.success) {
                            layer.alert(res.message, {icon: 1});
                            // 重新渲染表格
                            tableIns.reload();
                        } else {
                            layer.alert(res.message, {icon: 2});
                        }
                        // 关闭确认信息框
                        layer.close(index);
                    }, "json");
                });
            }
        }

        // 编辑与删除
        table.on('tool(scenic_view)', function (obj) {
            switch (obj.event) {
                case 'edit':
                    openEditScenicWindow(obj.data);
                    break;
                case 'delete':
                    deleteScenic(obj.data);
                    break;
            }
        })


        // 打开编辑页面
        function openEditScenicWindow(data) {
            window = layer.open({
                title: "编辑景区信息",
                type: 1,
                content: $("#addForm"),
                area: ['800px', '600px'],
                success: function () {
                    url = "scenic?action=editScenic";
                    // 填充数据
                    form.val("add", data);
                }
            });
        }


        // 删除景区信息
        function deleteScenic(data) {
            layer.confirm("是否删除ID为<font color='red' >" + data.sid + "</font>的景区信息", {
                icon: 3,
                title: '提示'
            }, function (index) {
                // 发起 Ajax 请求，删除该条谣言
                $.get("scenic?action=deleteScenicBySid", {sid: data.sid}, function (res) {
                    if (res.success) {
                        layer.alert(res.message, {icon: 1});
                        // 关闭确认信息框
                        layer.close(index);
                        // 重新渲染表格
                        tableIns.reload();
                    } else {
                        layer.alert(res.message, {icon: 2});
                    }
                }, "json")
            });
        }

    });
</script>

<%--<script type="text/html" id="image">
    <img src="{{d.image}}" style="width: 150px;height: 50px">
</script>--%>

<%--<script type="text/html" id="tool">
    {{# if (d.scenic_opened == "已开放") { }}
        <button type="button" class="layui-btn layui-btn-normal">已开放</button>
    {{ } else { }}
        <button type="button" class="layui-btn layui-btn-normal">未开放</button>
    {{ } }}
</script>--%>
<script type="text/html" id="toolbar">
    <button type="button" class="layui-btn layui-btn-normal" lay-event="edit">编辑</button>
    <button type="button" class="layui-btn layui-btn-normal" lay-event="delete">删除</button>
</script>
<script type="text/html" id="scenic_toolbar">
    <button type="button" class="layui-btn layui-btn-normal" lay-event="add">添加景区信息</button>
    <button type="button" class="layui-btn layui-btn-normal" lay-event="batchDelete">批量删除</button>
</script>
</body>
</html>
