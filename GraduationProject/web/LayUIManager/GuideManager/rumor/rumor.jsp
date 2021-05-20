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
    <title>谣言</title>
    <%@include file="../../common/LayUIjsAndCss.jsp" %>
</head>
<body>

<h1 align="center">谣言信息</h1>

<%-- 搜索条件 --%>
<div>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>高级搜索</legend>
    </fieldset>
    <form class="layui-form" action="" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">选择医生</label>
            <div class="layui-input-block">
                <select id="doctor" name="d_doctorInfo" lay-filter="aihao" lay-verify="required"
                        lay-reqtext="请先选择对应的医生">
                    <option value="">请选择医生</option>
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
</div>

<%-- 添加页面的开始 --%>
<div id="addForm" style="display: none">
    <form class="layui-form" action="" lay-filter="add">
        <input type="hidden" name="rid">
        <div class="layui-form-item">
            <label class="layui-form-label">谣言</label>
            <div class="layui-input-block">
                <input type="text" name="r_question" lay-verify="required|title" lay-reqtext="请输入谣言" autocomplete="off"
                       placeholder="请输入谣言" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">医生简答</label>
            <div class="layui-input-block">
                <input type="text" name="r_shortAnswer" lay-verify="required" lay-reqtext="请填写医生简答" autocomplete="off"
                       placeholder="请输入医生简答" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">医生详细回答</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入医生详细回答" class="layui-textarea" name="r_answer"></textarea>
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
        <div class="layui-form-item" pane="">
            <label class="layui-form-label">请选择谣言真假</label>
            <div class="layui-input-block">
                <input type="radio" name="t_ensure" value="真" title="真" lay-verify="required" lay-reqtext="请先选择谣言真假">
                <input type="radio" name="t_ensure" value="假" title="假" lay-verify="required" lay-reqtext="请先选择谣言真假">
                <input type="radio" name="t_ensure" value="不确定" title="不确定" lay-verify="required"
                       lay-reqtext="请先选择谣言真假">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="addRumor">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<%-- 添加页面的结束 --%>

<%-- 数据表格 --%>
<table class="layui-hide" id="rumor_view" lay-filter="rumor" ></table>
<script>
    layui.use(['table', 'form', 'jquery'], function () {
        var table = layui.table;
        var form = layui.form;
        var $ = layui.jquery;

        // AJAX请求 返回json(分类的列表)
        $.get("guide?action=loadRumorT_EnsureCategory", function (data) {
            var html = "";
            for (var i = 0; i < data.length; i++) {
                html += "<option value=" + data[i].r_shortAnswer + ">" + data[i].r_shortAnswer + "</option>"
            }
            $("#t_ensure").append(html);
            form.render('select'); //刷新select选择框渲染
        }, "json");

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
                // 为条件查询页面添加数据
                $("#doctor").append(html);
                form.render('select'); //刷新select选择框渲染
            },
            dataType: "json"
        })

        // 为条件查询提交绑定事件  (高级查询)
        form.on('submit(doSearch)', function (data) {
            console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
            tableIns.reload({
                where: data.field
                , page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
            return false; //阻止表单跳转。
        })


        var tableIns = table.render({
            elem: '#rumor_view'
            , url: 'guide?action=queryRumorForLayUI'
            , toolbar: '#rumor_toolbar'
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                  {type:'checkbox'}
                , {field: 'rid', width: 80, title: 'ID', sort: true}
                , {field: 'r_question', width: 80, title: '谣言'}
                , {field: 'r_shortAnswer', width: 80, title: '医生简答', sort: true}
                , {field: 'r_answer', width: 80, title: '医生详答'}
                , {field: 'd_doctorInfo', title: '医生信息', width: '30%', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {field: 't_ensure', title: '谣言真假', width: 80, minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
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
        // 触发事件
        table.on('toolbar(rumor)', function (obj) {
            switch (obj.event) {
                case 'add':
                    openAddRumorWindow();
                    break;
                case 'delete':
                    batchDeleteRumor();
                    break;
            }
        });

        // 定义添加窗口
        var window;
        // 定义访问路径 url
        var url;

        // 打开添加事件的窗口
        function openAddRumorWindow() {
            window = layer.open({
                title: '添加谣言',
                type: 1,
                content: $('#addForm'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                area: ['800px', '500px'],
                success: function () {
                    url = "guide?action=saveRumor";
                }
            });
        }

        // 为添加谣言绑定事件
        form.on('submit(addRumor)', function (data) {
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

        // 单项删除谣言信息
        table.on('tool(rumor)', function (obj) {
            switch (obj.event) {
                case 'delete':
                    // 删除谣言
                    deleteRumor(obj.data);
                    break;
                case 'edit':
                    // 修改谣言
                    editRumor(obj.data);
                    break;
            }
        });

        // 删除谣言
        function deleteRumor(data) {
            layer.confirm("是否删除ID为<font color='red' >" + data.rid + "</font>的谣言信息", {
                icon: 3,
                title: '提示'
            }, function (index) {
                // 发起 Ajax 请求，删除该条谣言
                $.get("guide?action=deleteRumorByRid", {rid: data.rid}, function (res) {
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

        // 打开修改窗口
        function editRumor(data) {
            window = layer.open({
                title: '修改谣言',
                type: 1,
                content: $('#addForm'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                area: ['800px', '500px'],
                success: function () {
                    url = "guide?action=editRumor";
                    // 填充数据
                    form.val("add", data);
                }
            });
        }

        // 批量删除
        function batchDeleteRumor() {
            // 获取选中的行
            let checkStatus = table.checkStatus('rumor_view');
            console.log(checkStatus.data) //获取选中行的数据
            console.log(checkStatus.data.length) //获取选中行数量，可作为是否有选中行的条件
            console.log(checkStatus.isAll) //表格是否全选
            // 如果有选中的行
            if (checkStatus.data.length > 0) {
                // 定义一个数组接收 rid
                var ridArr = [];
                for (let i = 0; i < checkStatus.data.length; i++) {
                    ridArr.push(checkStatus.data[i].rid);
                }
                // 数组转换为字符串
                let rids = ridArr.join(",");
                // 确认信息框
                layer.confirm("您确定要删除这<font color='red' >" + checkStatus.data.length + "</font>条谣言数据吗", {
                    icon: 3,
                    title: '提示'
                }, function (index) {
                    // 发起 Ajax 请求删除数据
                    $.get("guide?action=batchDeleteRumor",{rids:rids},function (res) {
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

    });
</script>

<script type="text/html" id="toolbar">
    <button type="button" class="layui-btn layui-btn-normal" lay-event="edit">编辑</button>
    <button type="button" class="layui-btn layui-btn-normal" lay-event="delete">删除</button>
</script>
<script type="text/html" id="rumor_toolbar">
    <button type="button" class="layui-btn layui-btn-normal" lay-event="add"><i class="layui-icon layui-icon-addition"></i>添加谣言问题
    </button>
    <button type="button" class="layui-btn layui-btn-normal" lay-event="delete"><i class="layui-icon layui-icon-delete"></i>批量删除
    </button>
</script>

</body>
</html>
