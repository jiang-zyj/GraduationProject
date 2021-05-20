<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/13
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--&lt;%&ndash; 引用LayUI的css样式 &ndash;%&gt;--%>
<%--<link type="text/css" rel="stylesheet" href="../css/layui.css">--%>
<%--<script src="../layui.js" charset="utf-8"></script>--%>
<%--<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->--%>
<head>
    <title>用户管理</title>
    <%@include file="../common/LayUIjsAndCss.jsp" %>
</head>
<body>
<h1 align="center">用户信息</h1>

<%-- 条件查询的开始 --%>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>高级查询</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">身份证号</label>
        <div class="layui-input-inline">
            <input type="text" name="uid" lay-verify="required" placeholder="请输入身份证号" autocomplete="off" class="layui-input">
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
        <div class="layui-form-item">
            <label class="layui-form-label">身份证号码</label>
            <div class="layui-input-block">
                <input type="text" name="uid" lay-verify="required|identity" lay-reqtext="请先填写用户身份证号" autocomplete="off"
                       placeholder="请输入用户身份证号" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="name" lay-verify="required|title" lay-reqtext="请先填写用户名" autocomplete="off"
                       placeholder="请输入用户名" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户密码</label>
            <div class="layui-input-block">
                <input type="password" name="password" lay-verify="required" lay-reqtext="请先填写用户密码" autocomplete="off"
                       placeholder="请输入用户密码" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" pane="">
            <label class="layui-form-label">用户性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男" lay-verify="required" lay-reqtext="请先选择用户性别">
                <input type="radio" name="sex" value="女" title="女" lay-verify="required" lay-reqtext="请先选择用户性别">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户现居地址</label>
            <div class="layui-input-block">
                <select id="address" name="address" lay-filter="aihao" lay-verify="required"
                        lay-reqtext="请先选择用户现居地址">
                    <option value="">请选择城市</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">联系电话</label>
            <div class="layui-input-block">
                <input type="text" name="tel" lay-verify="required|phone" lay-reqtext="请先填写用户联系电话" autocomplete="off"
                       placeholder="请输入用户联系电话" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-block">
                <input type="text" name="email" lay-verify="required|email" lay-reqtext="请先填写用户邮箱" autocomplete="off"
                       placeholder="请输入用户邮箱" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="addUser">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<%-- 添加页面的结束 --%>

<table class="layui-hide" id="user_view" lay-filter="user" ></table>
<script>
    layui.use(['table', 'form', 'jquery'], function () {
        var table = layui.table;
        var form = layui.form;
        var $ = layui.jquery;

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

        var tableIns = table.render({
            elem: '#user_view'
            , url: 'user?action=queryUserForLayUI'
            , toolbar: '#user_toolbar'
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                {type: 'checkbox'}
                , {field: 'uid', width: 80, title: '身份证号', sort: true}
                , {field: 'name', width: 80, title: '用户名'}
                , {field: 'password', width: 80, title: '密码', sort: true}
                , {field: 'sex', width: 80, title: '性别'}
                , {field: 'address', title: '地址', width: '30%', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {field: 'tel', title: '联系电话', width: 80, minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {field: 'code', title: '激活码', width: 80, minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {field: 'email', title: '邮箱', width: 80, minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {field: 'status', title: '账号状态', width: 80, minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {field: 'options', title: '操作', width: 200, toolbar: '#toolbar'}
            ]]
            , page: true
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

        // Ajax 查询所有城市，为添加用户地址的下拉框提供数据
        $.get("user?action=loadAllCname", function (data) {
            var html = "";
            for (var i = 0; i < data.length; i++) {
                html += "<option value=" + data[i].cname + ">" + data[i].cname + "</option>"
            }
            $("#address").append(html);
            form.render('select'); //刷新select选择框渲染
        }, "json");

        // 触发事件
        table.on('toolbar(user)', function (obj) {
            switch (obj.event) {
                case 'add':
                    openAddUserWindow();
                    break;
                case 'delete':
                    batchDeleteUser();
                    break;
                case 'update':
                    layer.msg('编辑');
                    break;
            }
        });

        var window;
        var url;

        // 打开添加窗口
        function openAddUserWindow() {
            window = layer.open({
                title: "添加用户信息",
                type: 1,
                content: $("#addForm"),
                area: ['800px', '600px'],
                success: function () {
                    url = "user?action=addUser";
                }
            });
        }

        // 为添加操作绑定事件
        form.on('submit(addUser)', function (data) {
            $.post(url,data.field,function (res) {
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
            },"json")
            return false;
        })

        // 批量删除用户
        function batchDeleteUser() {
            // 获取选中状态
            let checkStatus = table.checkStatus("user_view");
            console.log(checkStatus.data) //获取选中行的数据
            console.log(checkStatus.data.length) //获取选中行数量，可作为是否有选中行的条件
            console.log(checkStatus.isAll) //表格是否全选
            // 如果有选中的行，且至少需要选中两行
            if (checkStatus.data.length > 1) {
                // 定义数组用于存储用户身份证号 uid
                var uidArr = [];
                // 遍历所有选中的行
                for (var i = 0; i < checkStatus.data.length; i++) {
                    uidArr.push(checkStatus.data[i].uid);
                }
                // 将数组转换为字符串
                var uidStr = uidArr.join(",");
                // 确认信息框
                layer.confirm("您确定要删除这<font color='red' >" + checkStatus.data.length + "</font>条用户数据吗", {
                    icon:3,
                    title:'提示'
                },function (index) {
                    // 确定，发起 Ajax 请求删除多条数据
                    $.get("user?action=batchDeleteUser",{uidStr:uidStr},function (res) {
                        if (res.success) {
                            layer.alert(res.message, {icon: 1});
                            // 关闭弹出层
                            layer.close(window);
                            // 重新渲染表格
                            tableIns.reload();
                        } else {
                            layer.alert(res.message, {icon: 2})
                        }
                    },"json")
                })
            } else {
                layer.alert("请至少选择两个或两个以上用户");
            }
        }

        // 为编辑与删除绑定事件
        table.on('tool(user)',function (obj) {
            switch (obj.event) {
                case 'edit':
                    openEditWindow(obj.data);
                    break;
                case 'delete':
                    deleteUser(obj.data);
            }
        })

        // 打开编辑用户窗口
        function openEditWindow(data) {
            window = layer.open({
                title: "修改用户信息",
                type: 1,
                content: $("#addForm"),
                area: ['800px', '600px'],
                success: function () {
                    url = "user?action=editUser";
                    // 填充用户信息
                    form.val("add",data);
                }
            });
        }

        //
        function deleteUser(data) {
            layer.confirm("是否删除ID为<font color='red' >" + data.uid + "</font>的用户信息", {
                icon: 3,
                title: '提示'
            }, function (index) {
                // 发起 Ajax 请求，删除该条谣言
                $.get("user?action=deleteUserByUid", {uid: data.uid}, function (res) {
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
<script type="text/html" id="user_toolbar">
    <button type="button" class="layui-btn layui-btn-normal" lay-event="add"><i class="layui-icon layui-icon-addition"></i>添加用户信息</button>
    <button type="button" class="layui-btn layui-btn-normal" lay-event="delete"><i class="layui-icon layui-icon-delete"></i>批量删除</button>
</script>

</body>
</html>

