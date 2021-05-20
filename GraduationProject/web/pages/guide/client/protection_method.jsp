<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/1
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/jsAndCss.jsp"%>
<html>
<head>
    <title>防护方法</title>
</head>
    <script type="text/javascript">
        $.post({
            url:"guide?action=queryAllPMethod",
            data:{strategy_name:"${param.strategy_name}"},
            success:function (data) {
                var i = "";
                $.each(data,function (index,obj) {
                    i += "<li role='presentation'><a href = 'guide?action=querySProbByMName&method_name=" + obj.method_name + "'>" + obj.method_name + "</a></li>";
                });
                $("#strategy_method").html(i);
            },
            dataType:"json"
        });
    </script>
<body>
<%-- 静态包含头部分 --%>
<%@include file="../../common/head.jsp"%>
    <center>
        <ul class="nav nav-pills nav-stacked" id="strategy_method">

        </ul>
    </center>
</body>
</html>
