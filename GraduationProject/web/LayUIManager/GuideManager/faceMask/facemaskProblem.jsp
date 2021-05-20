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
    <title>口罩使用问题</title>
    <%@include file="../../common/LayUIjsAndCss.jsp"%>
</head>
<body>
<h1 align="center">口罩问题</h1>

<%-- 条件查询的开始 --%>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>高级查询</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="" >
    <div class="layui-form-item">
        <label class="layui-form-label">口罩方法</label>
        <div class="layui-input-block">
            <select id="fm_method" name="fm_method" lay-filter="aihao" lay-verify="required"
                    lay-reqtext="请输入口罩方法">
                <option value="">请选择口罩方法</option>
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
        <input type="hidden" name="fp_id">
        <div class="layui-form-item">
            <label class="layui-form-label">口罩问题</label>
            <div class="layui-input-block">
                <input type="text" name="fp_question" lay-verify="required|title" lay-reqtext="请先填写口罩问题" autocomplete="off"
                       placeholder="请输入口罩问题" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">请选择对应的医生信息</label>
            <div class="layui-input-block">
                <select id="d_doctorInfo" name="d_doctorInfo" lay-filter="aihao" lay-verify="required"
                        lay-reqtext="请先选择对应的医生">
                    <option value="">请选择医生</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">添加医生回答</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入医生回答" class="layui-textarea" name="fp_answer" lay-verify="required" lay-reqtext="请先添加医生回答"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">选择口罩使用方法</label>
            <div class="layui-input-block">
                <select id="chooseFM_Method" name="fm_method" lay-filter="aihao" lay-verify="required"
                        lay-reqtext="请先选择口罩使用方法">
                    <option value="">请选择口罩使用方法</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="addFP_Prob">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<%-- 添加页面的结束 --%>

<table class="layui-hide" id="fp_Prob_view" lay-filter="FP_Prob"></table>
<script>
    layui.use(['table', 'form', 'jquery'], function(){
        var table = layui.table;
        var form = layui.form;
        var $ = layui.jquery;

        var tableIns = table.render({
            elem: '#fp_Prob_view'
            ,url:'guide?action=queryFp_probForLayUI'
            ,toolbar:'#fp_toolbar'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {type:'checkbox'}
                ,{field:'fp_id', width:80, title: 'ID', sort: true}
                ,{field:'fp_question', width:80, title: '口罩使用问题'}
                ,{field:'d_doctorInfo', width:80, title: '医生信息', sort: true}
                ,{field:'fp_answer', width:80, title: '医生回答'}
                ,{field:'fm_method', title: '所属口罩使用方法', width: '30%', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{field: 'options', title: '操作', width: 200, toolbar: '#toolbar'}
            ]]
            ,page: true
            , limit:5
            , limits:[5,10,15,20]
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

        // 为高级搜索发起 Ajax 请求查询所有口罩使用方法
        $.get("guide?action=queryAllFM_Method",{},function (data) {
            var html = "";
            for (var i = 0; i < data.length; i++) {
                html += "<option value=" + data[i].fm_method + ">" + data[i].fm_method + "</option>"
            }
            $("#fm_method").append(html);
            $("#chooseFM_Method").append(html);
            // 刷新select选择框渲染
            form.render('select');
        },"json");

        // 高级查询
        form.on('submit(doSearch)',function (data) {
            console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
            tableIns.reload({
                where:data.field
                , page : {
                    curr: 1 //重新从第 1 页开始
                }
            })
            return false;   // 防止表单跳转
        })

        // AJAX请求 查询医生信息
        $.get({
            url: "guide?action=queryAllDoctor",
            data: {},
            success: function (data) {
                var html = "";
                /*$.each(data,function (index, object) {
                    html += "<option value="+object.d_doctorInfo+">"+object.d_doctorInfo+"</option>"
                })*/
                for (var i = 0; i < data.length; i++) {
                    html += "<option value=" + data[i].d_doctorInfo + ">" + data[i].d_doctorInfo + "</option>"
                }
                // 为添加页面添加数据
                $("#d_doctorInfo").append(html);
                form.render('select'); //刷新select选择框渲染
            },
            dataType: "json"
        })

        // 触发事件
        table.on('toolbar(FP_Prob)', function (obj) {
            switch (obj.event) {
                case 'add':
                    openAddFP_ProbWindow();
                    break;
                case 'batchDelete':
                    batchDeleteFP_Prob();
                    break;
                case 'update':
                    layer.msg('编辑');
                    break;
            }
        });

        var url;
        var window;
        // 打开添加窗口
        function openAddFP_ProbWindow() {
            window = layer.open({
                title: "添加口罩问题",
                type: 1,
                content: $("#addForm"),
                area: ['800px', '600px'],
                success: function () {
                    url = "guide?action=addFP_Prob";
                }
            });
        }

        // 为添加窗口的提交添加事件
        form.on('submit(addFP_Prob)',function (data) {
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

        // 批量删除口罩使用问题
        function batchDeleteFP_Prob() {
            // 获取选中的行
            let checkStatus = table.checkStatus('fp_Prob_view');
            console.log(checkStatus.data) //获取选中行的数据
            console.log(checkStatus.data.length) //获取选中行数量，可作为是否有选中行的条件
            console.log(checkStatus.isAll) //表格是否全选
            // 如果有选中的行
            if (checkStatus.data.length > 0) {
                // 定义一个数组接收 rid
                var fp_probArr = [];
                for (let i = 0; i < checkStatus.data.length; i++) {
                    fp_probArr.push(checkStatus.data[i].fp_id);
                }
                // 数组转换为字符串
                let ids = fp_probArr.join(",");
                // 确认信息框
                layer.confirm("您确定要删除这<font color='red' >" + checkStatus.data.length + "</font>条谣言数据吗", {
                    icon: 3,
                    title: '提示'
                }, function (index) {
                    // 发起 Ajax 请求删除数据
                    $.get("guide?action=batchDeleteFP_Prob",{ids:ids},function (res) {
                        if (res.success) {
                            layer.alert(res.message,{icon:1});
                            // 重新渲染表格
                            tableIns.reload();
                        } else {
                            layer.alert(res.message,{icon:2});
                        }
                        // 关闭确认信息框
                        layer.close(index);
                    },"json");
                });
            }
        }

        // 编辑与删除
        table.on('tool(FP_Prob)',function (obj) {
            switch (obj.event) {
                case 'edit':
                    openEditFP_ProbWindow(obj.data);
                    break;
                case 'delete':
                    deleteFP_Prob(obj.data);
                    break;
            }
        })

        // 打开编辑页面
        function openEditFP_ProbWindow(data) {
            window = layer.open({
                title: "编辑口罩问题",
                type: 1,
                content: $("#addForm"),
                area: ['800px', '600px'],
                success: function () {
                    url = "guide?action=editFP_Prob";
                    // 填充数据
                    form.val("add", data);
                }
            });
        }

        // 删除口罩使用问题
        function deleteFP_Prob(data) {
            layer.confirm("是否删除ID为<font color='red' >" + data.fp_id + "</font>的谣言信息", {
                icon: 3,
                title: '提示'
            }, function (index) {
                // 发起 Ajax 请求，删除该条谣言
                $.get("guide?action=deleteFp_probByFp_id", {fp_id: data.fp_id}, function (res) {
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
<script type="text/html" id="fp_toolbar">
    <button type="button" class="layui-btn layui-btn-normal" lay-event="add">添加使用口罩问题</button>
    <button type="button" class="layui-btn layui-btn-normal" lay-event="batchDelete">批量删除</button>
</script>

</body>
</html>
