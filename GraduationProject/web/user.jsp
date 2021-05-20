<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/29
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <form action="test?action=searchUser" method="post">
        <label>输入姓名：</label><input type="text" name="t_name"><br>
        <input type="submit" value="查询">
    </form>
</center>
    <center>
        <table>
            <tr>
                <th>ID</th>
                <th>姓名</th>
                <th>图片</th>
                <th>时间</th>
                <th colspan="2">修改</th>
            </tr>
            <c:forEach items="${requestScope.page.items}" var="i">
                <tr>
                    <td>${i.t_id}</td>
                    <td>${i.t_name}</td>
                    <td>${i.t_pic}</td>
                    <td>${i.t_time}</td>
                    <td><a href="test?action=addUser">增加</a></td>
                    <td><a href="test?action=deleteUser">修改</a></td>
                </tr>
            </c:forEach>
        </table>
    </center>
    <%@include file="pages/common/page_nav.jsp"%>

</body>
</html>
