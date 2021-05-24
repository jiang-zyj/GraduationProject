<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/14
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <a href="testInterceptor">Test Interceptor</a>
    <br>
    <form action="upload" method="post" enctype="multipart/form-data">
        上传文件: <input type="file" name="uploadFile">
        <br>
        文件描述：<input type="text" name="desc">
        <br>
        <input type="submit" value="上传">
    </form>
    <br>
    <a href="download">点击下载图片</a>
    <br>
    <a href="testJson">Test JSON</a>
    <br>
    <a href="emps">List All Emps</a>
</body>
</html>
