<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/14
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%-- 引入JQuery
            SpringMVC处理静态资源的问题：
                静态资源：.js .css .html .txt .png .jpg .avi等等

                因为 DispatcherServlet 的<url-pattern> 配置的是 /，会匹配到所有的请求(排除jsp的请求).
                因为请求的 .js 文件，是一个静态资源请求，交给 DispatcherServlet 后就会出现 no mapping found 的问题
            解决问题：
                1. 修改<url-pattern>为后缀匹配，但是不建议这么做，对REST的支持不好。因为一个优秀的REST不希望请求的
                URL带有任何后缀。
                2. 在spring-config.xml中加上一个配置：<mvc:default-servlet-handler/>
                                                    <mvc:annotation-driven/>
    --%>
    <script type="text/javascript" src="script/jquery-1.7.2.js"></script>
    <%--<script type="text/javascript">
        $(function () {

            // 给删除的<a>动态绑定事件
            $(".del").click(function () {
                // 确认是否要删除
                var flag = window.confirm("是否删除？");
                if (!flag) {
                    return false;
                }
                // this：当前点击的DOM对象
                // 获取点击的超链接的 href 的值
                var href = $(this).attr("href");
                // 将 href 的值设置到表单的 action 上，并提交
                $("form").attr("action",href).submit();
                // 取消 <a> 的默认行为
                return false;
            });
        });
    </script>--%>
    <script type="text/javascript">
        $(function () {
            $(".del").click(function () {
                var flag = window.confirm("是否删除？");
                if (!flag) {
                    return false;
                }
                var href = $(this).attr("href");
                $("form").attr("action",href).submit();
                return false;
            });
        });
    </script>
</head>
<body>

    <form action="" method="post">
        <input type="hidden" name="_method" value="DELETE">

    </form>

    <h1 align="center">员工信息列表</h1>
    <%--<table border="1px" align="center" width="70%" cellspacing="0px">
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Email</th>
            <th>Gender</th>
            <th>DeptName</th>
            <th>Operation</th>
        </tr>
        <c:forEach items="${requestScope.emps}" var="emp">
            <tr align="center">
                <td>${emp.id}</td>
                <td>${emp.lastName}</td>
                <td>${emp.email}</td>
                <td>${emp.gender==0?"女":"男"}</td>
                <td>${emp.department.departmentName}</td>
                <td>
                    <a href="emp/${emp.id}">Edit</a>
                    &nbsp;
                    &nbsp;
                    &lt;%&ndash; 解决思路：
                                给删除的超链接绑定事件，当触发了点击事件，我们可以在事件处理函数中获取到要发送的请求URL
                                再将获取到的请求URL设置到某个表单的action属性上，再将表单提交。
                                最终将<a>的默认行为取消掉。
                     &ndash;%&gt;
                    <a class="del" href="emp/${emp.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h2 align="center"><a href="emp">Add New Emp</a></h2>--%>
    <%-- 练习Practice --%>
    <table border="1px" align="center" width="70%" cellspacing="0px">
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Email</th>
            <th>Gender</th>
            <th>DeptName</th>
            <th>Operation</th>
        </tr>
        <c:forEach items="${requestScope.emps}" var="emp">
            <tr align="center">
                <td>${emp.id}</td>
                <td>${emp.lastName}</td>
                <td>${emp.email}</td>
                <td>${emp.gender==0?"女":"男"}</td>
                <td>${emp.department.departmentName}</td>
                <td>
                    <a href="employee/${emp.id}">Edit</a>
                    &nbsp;
                    &nbsp;
                        <%-- 解决思路：
                                    给删除的超链接绑定事件，当触发了点击事件，我们可以在事件处理函数中获取到要发送的请求URL
                                    再将获取到的请求URL设置到某个表单的action属性上，再将表单提交。
                                    最终将<a>的默认行为取消掉。
                         --%>
                    <a class="del" href="employee/${emp.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h2 align="center"><a href="employee">Add New Emp</a></h2>
</body>
</html>
