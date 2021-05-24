<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/22
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1 align="center">员工信息列表</h1>
    <table align="center" border="1px" width="70%" cellspacings="0px">
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Email</th>
            <th>Gender</th>
            <th>DeptName</th>
            <th>Operation</th>
        </tr>
        <c:forEach items="${employees}" var="emp">
            <tr align="center">
                <td>${emp.id}</td>
                <td>${emp.last_Name}</td>
                <td>${emp.email}</td>
                <td>${emp.gender == 0 ? '女' : '男'}</td>
                <td>${emp.dept.deptName}</td>
                <td>
                    <a href="#">Edit</a>
                    <a href="#">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h2 align="center"><a href="#">Add New Emp</a></h2>
</body>
</html>
