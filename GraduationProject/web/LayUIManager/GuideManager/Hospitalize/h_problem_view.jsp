<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/13
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--&lt;%&ndash; 引用LayUI的css样式 &ndash;%&gt;--%>
<%--<link type="text/css" rel="stylesheet" href="../css/layui.css">--%>
<%--<script src="../layui.js" charset="utf-8"></script>--%>
<%--<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->--%>
<head>
    <title>就医问题管理</title>
    <%@include file="../../common/LayUIjsAndCss.jsp" %>
</head>
<body>
<h1 align="center">就医问题</h1>
<%-- 条件查询的开始 --%>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>高级搜索</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">选择就医方法</label>
        <div class="layui-input-inline">
            <select id="h_name" name="h_name">
                <option value="">请选择就医方法</option>
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
    <form class="layui-form layui-form-pane" action="" lay-filter="add" id="addForms" method="post">
        <input type="hidden" name="treat_id">
        <div class="layui-form-item">
            <label class="layui-form-label">添加就医问题</label>
            <div class="layui-input-block">
                <input type="text" name="treat_prob" autocomplete="off" placeholder="请输入就医问题" class="layui-input" lay-verify="required" lay-reqtext="请输入就医问题">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">选择医生</label>
            <div class="layui-input-inline">
                <select id="d_info" name="d_doctorInfo" lay-verify="required" lay-reqtext="请先选择对应的医生">
                    <option value="">请选择医生</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">添加医生回答</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入医生回答" class="layui-textarea" name="treat_ans" lay-verify="required" lay-reqtext="请先添加医生回答"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">选择就医方法</label>
            <div class="layui-input-inline">
                <select id="hos_name" name="h_name" lay-verify="required" lay-reqtext="请先选择对应的就医方法">
                    <option value="">请选择就医方法</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="addHosProb">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<%-- 添加页面的结束 --%>

<table class="layui-hide" id="test" lay-filter="test"></table>
<script>
    layui.use(['table', 'jquery', 'form'], function () {
        var table = layui.table;
        var $ = layui.jquery;
        var form = layui.form;

        var tableIns = table.render({
            elem: '#test'
            , url: 'guide?action=queryH_probForLayUI'
            , toolbar: '#scenic_toolbar'
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                {type:'checkbox'}
                ,{field: 'treat_id', width: 80, title: 'ID', sort: true}
                , {field: 'treat_prob', width: 80, title: '就医问题'}
                // ,{field:'Last_Update', width:80, title: '最后更新时间', sort: true}
                , {field: 'd_doctorInfo', width: 80, title: '医生信息'}
                , {field: 'treat_ans', title: '医生回答', width: '30%', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {field: 'h_name', title: '所属就医方法', width: 80, minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {field: 'options', title: '操作', width: 200, toolbar: '#toolbar'}
            ]]
            , page: true
            , limits: [5, 10, 15, 20]
            , limit: 5
            , done: function(res, curr, count){
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
                        ,page: {
                            curr: curr - 1 // 显示最后一页
                        }
                    });
                }
            }
        });

        // 触发事件（关于表格上的工具条）
        table.on('toolbar(test)', function (obj) {
            switch (obj.event) {
                case 'add':
                    // 打开添加页面
                    openAddWindow();
                    break;
                case 'delete':
                    // 批量删除
                    batch_Delete();
                    break;
            }
        })

        var window; // 声明为一个弹出层对象
        var url;    // 声明一个访问路径（添加与修改）

        // 打开添加窗口
        function openAddWindow() {
            window = layer.open({
                title: "添加就医问题",
                type: 1,
                content: $("#addForm"),
                area: ['800px', '600px'],
                anim:0,
                success:function () {
                    url = "guide?action=saveHosProb";
                }
            });
        }

        // 通过 AJAX 请求查询所有医生信息并填写到添加页面
        $.get({
            url: "guide?action=queryAllDoctor",
            data: {},
            success: function (data) {
                var html = "";
                for (var i = 0; i < data.length; i++) {
                    html += "<option value=" + data[i].d_doctorInfo + ">" + data[i].d_doctorInfo + "</option>"
                }
                $("#d_info").append(html);
                // 刷新select选择框渲染
                form.render('select');
            },
            dataType: "json"
        });

        // 通过 AJAX 请求查询所有就医方法
        $.get({
            url: "guide?action=queryAllHosMethod",
            data: {},
            success: function (data) {
                var html = "";
                for (var i = 0; i < data.length; i++) {
                    html += "<option value=" + data[i].h_name + ">" + data[i].h_name + "</option>"
                }
                $("#h_name").append(html);
                $("#hos_name").append(html);
                // 刷新select选择框渲染
                form.render('select');
            },
            dataType: "json"
        });

        // 为添加表单的提交绑定事件
        form.on('submit(addHosProb)', function (data) {
            console.log(data.field);
            // 发起 Ajax 请求，添加就医问题
            $.post(url,data.field,function (res) {
                // 根据服务器响应的结果提示信息
                if (res.success) {
                    layer.alert(res.message,{icon:1});
                    // 关闭弹出层
                    layer.close(window);
                    // 重新渲染表格
                    tableIns.reload();
                    // 清空表单数据
                    $("#addForms")[0].reset();
                } else {
                    layer.alert(res.message,{icon:2});
                }
                //
            },"json");
            return false;   // 防止表单跳转
        })

        // 在表格上绑定事件
        form.on('submit(doSearch)',function (data) {
            console.log(data.field);
            tableIns.reload({
                where: data.field   // 这里为什么用 field
                ,page: {
                    curr: 1 // 重新从第 1 页开始
                }
            });
            return false;   // 防止表单跳转
        });

        // 为表格的工具栏添加事件
        table.on('tool(test)', function (obj) {
            switch (obj.event) {
                case 'delete':
                    // layer.msg("删除");
                    deleteH_Prob(obj.data); // 这里为什么用 data
                    break;
                case 'edit':
                    // layer.msg("编辑");
                    editH_Prob(obj.data);
                    break;
            }
        });

        // 删除一条就医问题
        function deleteH_Prob(data) {
            // 通过 Ajax 请求实现删除
            layer.confirm("是否删除ID为<font color='red' >" + data.treat_id + "</font>的就医问题", {icon: 3, title:'提示'}, function(index){
                // 删除该就医问题
                $.get("guide?action=deleteH_ProbByTreat_id",{treat_id:data.treat_id},function (data) {
                    if (data.success) {
                        layer.alert(data.message,{icon:1});
                        // 关闭确认信息框
                        layer.close(index);
                        // 重新渲染表格
                        tableIns.reload();
                    } else {
                        layer.alert(data.message,{icon:2});
                        // 关闭确认信息框
                        layer.close(index);
                    }
                },"json");
            });
        }

        // 打开修改窗口
        function editH_Prob(data) {
            window = layer.open({
                title: "修改就医问题",
                type: 1,
                content: $("#addForm"),
                area: ['800px', '600px'],
                anim:0,
                success: function(layero, index){
                    url = "guide?action=editHosProb";
                    // 填充表单
                    form.val("add",data);
                    // 重新渲染
                    // form.render();
                }
            });
        }

        // 批量删除
        function batch_Delete() {
            // 获取选中的行
            let checkStatus = table.checkStatus("test");
            console.log(checkStatus.data) //获取选中行的数据
            console.log(checkStatus.data.length) //获取选中行数量，可作为是否有选中行的条件
            console.log(checkStatus.isAll) //表格是否全选
            // 获取选中行的数据
            if (checkStatus.data.length > 0) {
                // 定义数据接收 id
                var idArr = [];
                // 遍历每一行，获取 id
                for (var i = 0; i < checkStatus.data.length; i++) {
                    idArr.push(checkStatus.data[i].treat_id);
                }
                // 将数组转换为字符串
                var hids = idArr.join(",");
                // 确认信息框
                layer.confirm("是否删除ID为<font color='red' >" + checkStatus.data.length + "</font>条就医问题数据吗", {icon: 3, title:'提示'}, function(index){
                    // 确认删除
                    // 发起 ajax 请求
                    $.get("guide?action=batchDeleteH_Prob",{hids:hids},function (data) {
                        if (data.success) {
                            layer.alert(data.message,{icon:1});
                            // 重新渲染表格
                            tableIns.reload();
                        } else {
                            layer.alert(data.message,{icon:2});
                        }
                        // 关闭确认信息框
                        layer.close(index);
                    },"json");
                });
            } else {
                layer.alert("请选择要删除的数据");
            }
        }

    });
</script>

<script type="text/html" id="toolbar">
    <button type="button" class="layui-btn layui-btn-normal" lay-event="edit">编辑</button>
    <button type="button" class="layui-btn layui-btn-normal" lay-event="delete">删除</button>
</script>
<script type="text/html" id="scenic_toolbar">
    <button type="button" class="layui-btn layui-btn-normal" lay-event="add">添加就医问题</button>
    <button type="button" class="layui-btn layui-btn-normal" lay-event="delete">批量删除</button>
</script>

</body>
</html>




