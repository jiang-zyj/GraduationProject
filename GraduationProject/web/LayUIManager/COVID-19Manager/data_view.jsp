<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/13
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--&lt;%&ndash; 引用LayUI的css样式 &ndash;%&gt;--%>
<%--<link type="text/css" rel="stylesheet" href="../css/layui.css">--%>
<%--<script src="../layui.js" charset="utf-8"></script>--%>
<%--<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->--%>
<head>
    <title>疫情数据管理</title>
    <%@include file="../common/LayUIjsAndCss.jsp" %>
</head>
<body>
<h1 align="center">疫情数据信息</h1>


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
        <input type="hidden" name="covid_id">
        <div class="layui-form-item">
            <label class="layui-form-label">国家</label>
            <div class="layui-input-block">
                <input type="text" name="countryOrRegion" lay-verify="required|title" lay-reqtext="请先填写国家"
                       autocomplete="off"
                       placeholder="请输入国家" class="layui-input">
            </div>
        </div>
<%--        <div class="layui-form-item">--%>
<%--            <label class="layui-form-label">更新时间</label>--%>
<%--            <div class="layui-input-block">--%>
<%--                <input type="text" name="last_Update" lay-verify="required|title" lay-reqtext="请先填写更新时间"--%>
<%--                       autocomplete="off"--%>
<%--                       placeholder="请选择更新时间" class="layui-input">--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="layui-inline">--%>
<%--            <label class="layui-form-label">更新时间</label>--%>
<%--            <div class="layui-input-inline">--%>
<%--                <input type="text" name="last_Update" lay-verify="required|title" lay-reqtext="请先填写更新时间"--%>
<%--                       autocomplete="off"--%>
<%--                       placeholder="请选择更新时间" class="layui-input">--%>
<%--            </div>--%>
<%--        </div>--%>

        <div class="layui-inline">
            <label class="layui-form-label">更新时间</label>
            <div class="layui-input-inline">
                <input type="text" name="last_Update" id="date" lay-verify="date" placeholder="yyyy-MM-dd"
                       class="layui-input" lay-reqtext="请先填写更新时间" autocomplete="off" placeholder="请选择更新时间">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">总确诊人数</label>
            <div class="layui-input-block">
                <input type="text" name="confirmed" lay-verify="required" lay-reqtext="请先输入总确诊人数" autocomplete="off"
                       placeholder="请输入总确诊人数" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" pane="">
            <label class="layui-form-label">总死亡人数</label>
            <div class="layui-input-block">
                <input type="text" name="deaths" lay-verify="required" lay-reqtext="请先输入总死亡人数" autocomplete="off"
                       placeholder="请输入总死亡人数" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">总痊愈人数</label>
            <div class="layui-input-block">
                <div class="layui-input-block">
                    <input type="text" name="recovered" lay-verify="required" lay-reqtext="请先输入总痊愈人数" autocomplete="off"
                           placeholder="请输入总痊愈人数" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">新增确诊人数</label>
            <div class="layui-input-block">
                <div class="layui-input-block">
                    <input type="text" name="increment_Confirmed" lay-verify="required" lay-reqtext="请先输入新增确诊人数"
                           autocomplete="off"
                           placeholder="请输入新增确诊人数" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">新增死亡人数</label>
            <div class="layui-input-block">
                <div class="layui-input-block">
                    <input type="text" name="increment_Deaths" lay-verify="required" lay-reqtext="请先输入新增死亡人数"
                           autocomplete="off"
                           placeholder="请输入新增死亡人数" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">新增痊愈人数</label>
            <div class="layui-input-block">
                <div class="layui-input-block">
                    <input type="text" name="increment_Recovered" lay-verify="required" lay-reqtext="请先输入新增痊愈人数"
                           autocomplete="off"
                           placeholder="请输入新增痊愈人数" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">城市</label>
            <div class="layui-input-block">
                <select id="cname" name="cname" lay-filter="aihao" lay-verify="required"
                        lay-reqtext="请先选择城市">
                    <option value="">请选择城市</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="addCovidData">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<%-- 添加页面的结束 --%>


<table class="layui-hide" id="data_view" lay-filter="data_view"></table>
<script>
    layui.use(['table', 'form', 'jquery', 'laydate'], function () {
        var table = layui.table;
        var form = layui.form;
        var $ = layui.jquery;
        var laydate = layui.laydate;


        laydate.render({
            elem: '#date' //或 elem: document.getElementById('test')、elem: lay('#test') 等
        });

        var url;
        var window;
        var tableIns = table.render({
            elem: '#data_view'
            , url: 'covid?action=queryCovidDataForLayUI'
            , toolbar: '#scenic_toolbar'
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                {type: 'checkbox'}
                , {field: 'covid_id', width: 80, title: 'ID', sort: true}
                , {field: 'countryOrRegion', width: 80, title: '国家或地区'}
                , {field: 'last_Update', width: 80, title: '更新时间',templet: '<div>{{layui.util.toDateString(d.last_Update, "yyyy-MM-dd") }}</div>'}
                , {field: 'confirmed', width: 80, title: '总确诊人数'}
                , {field: 'deaths', title: '总死亡人数', width: '30%', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {field: 'recovered', title: '总痊愈人数', width: 80, minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {field: 'increment_Confirmed', title: '新增确诊人数', width: 80, minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {field: 'increment_Deaths', title: '新增死亡人数', width: 80, minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {field: 'increment_Recovered', title: '新增痊愈人数', width: 80, minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {field: 'cname', title: '城市', width: 80, minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
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
            url: "covid?action=queryAllCities",
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
        });

        // 触发事件
        table.on('toolbar(data_view)', function (obj) {
            switch (obj.event) {
                case 'add':
                    openAddCovidDateWindow();
                    break;
                case 'batchDelete':
                    batchDeleteCovidData();
                    break;
            }
        });

        // 打开添加页面
        function openAddCovidDateWindow() {
            window = layer.open({
                title: "添加疫情数据",
                type: 1,
                content: $("#addForm"),
                area: ['800px', '600px'],
                success: function () {
                    url = "covid?action=addCovidData";
                }
            });
        }

        // 添加疫情数据
        form.on('submit(addCovidData)', function (data) {
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

        // 批量删除疫情数据
        function batchDeleteCovidData() {
            // 获取选中的行
            let checkStatus = table.checkStatus('data_view');
            console.log(checkStatus.data) //获取选中行的数据
            console.log(checkStatus.data.length) //获取选中行数量，可作为是否有选中行的条件
            console.log(checkStatus.isAll) //表格是否全选
            // 如果有选中的行
            if (checkStatus.data.length > 0) {
                // 定义一个数组接收 rid
                var dataArr = [];
                for (let i = 0; i < checkStatus.data.length; i++) {
                    dataArr.push(checkStatus.data[i].covid_id);
                }
                // 数组转换为字符串
                let ids = dataArr.join(",");
                // 确认信息框
                layer.confirm("您确定要删除这<font color='red' >" + checkStatus.data.length + "</font>条疫情数据信息吗？", {
                    icon: 3,
                    title: '提示'
                }, function (index) {
                    // 发起 Ajax 请求删除数据
                    $.get("covid?action=batchDeleteCovidData", {ids: ids}, function (res) {
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
        table.on('tool(data_view)', function (obj) {
            switch (obj.event) {
                case 'edit':
                    openEditCovidDataWindow(obj.data);
                    break;
                case 'delete':
                    deleteCovidData(obj.data);
                    break;
            }
        })

        // 打开编辑页面
        function openEditCovidDataWindow(data) {
            window = layer.open({
                title: "编辑疫情数据",
                type: 1,
                content: $("#addForm"),
                area: ['800px', '600px'],
                success: function () {
                    url = "covid?action=editCovidData";
                    // 填充数据
                    form.val("add", data);
                }
            });
        }

        // 删除景区信息
        function deleteCovidData(data) {
            layer.confirm("是否删除ID为<font color='red' >" + data.covid_id + "</font>的疫情数据信息", {
                icon: 3,
                title: '提示'
            }, function (index) {
                // 发起 Ajax 请求，删除该条谣言
                $.get("covid?action=deleteCovidDataByCovid_id", {covid_id: data.covid_id}, function (res) {
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


<script type="text/html" id="toolbar">
    <button type="button" class="layui-btn layui-btn-normal" lay-event="edit">编辑</button>
    <button type="button" class="layui-btn layui-btn-normal" lay-event="delete">删除</button>
</script>
<script type="text/html" id="scenic_toolbar">
    <button type="button" class="layui-btn layui-btn-normal" lay-event="add">添加疫情数据</button>
    <button type="button" class="layui-btn layui-btn-normal" lay-event="batchDelete">批量删除</button>
</script>

</body>
</html>


