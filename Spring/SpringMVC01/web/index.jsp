<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/3/27
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <a href="testServletAPI">testServletAPI</a>

  <form action="testPOJO" method="post">
      用户名：<input type="text" name="username">
      <br>
      用户密码：<input type="text" name="password">
      <br>
      用户邮箱：<input type="text" name="email">
    <br>
    用户性别：<input type="radio" name="gender" value="1">男
              <input type="radio" name="gender" value="0">女
    <br>
    <%-- 支持级联的方式 --%>
    用户省份：<input type="text" name="address.province">
    <br>
    用户城市：<input type="text" name="address.city">
    <br>
    <input type="submit" value="注册">
  </form>

  <a href="testCookieValue">Test CookieValue</a>
  <br>
  
  <a href="testRequestHeader">Test RequestHeader</a>
  
  <br>
  <a href="testRequestParam?username=Tom&age=22">Test RequestParam</a>
  <br>
  
  <%-- REST 测试开始 --%>
    <br>
    <%-- REST GET --%>
    <a href="order/1001">REST GET</a>

    <br>
    <%-- REST POST --%>
    <form action="order" method="post">
      <input type="submit" value="REST POST">
    </form>
    <br>
    <%-- REST DELETE --%>
    <form action="order/1001" method="post">
      <%-- 使用隐藏域来发送_method，使_method不为空。同时value要定义为要执行的操作 --%>
      <input type="hidden" name="_method" value="DELETE"/>
      <input type="submit" value="REST DELETE">
    </form>
    <%-- REST PUT --%>
    <form action="order" method="post">
      <input type="hidden" name="_method" value="PUT">
      <input type="submit" value="REST PUT">
    </form>
  <%-- REST 测试结束 --%>
  <br>
  <a href="testPathVariable/admin/1001">Test PathVariable</a>
  <br>
  <a href="testRequestMappingParamsAndHeaders?username=tom&age=22">Test RequestMapping Params And Headers</a>
  <br>
  <form action="testRequestMappingMethod" method="post">
    <input type="submit" value="提交">
  </form>
  <br>
  <a href="testRequestMappingMethod">Test RequestMapping Method</a>
  <br>
  <a href="springmvc/testRequestMapping">Test RequestMapping</a>
  <br>
  <%--
      相对路径：hello  不以 / 开头的路径,相对于当前路径来发送请求，
          当前路径解释：例如 http://localhost:8080/SpringMVC01/hello.jsp，当前路径为 SpringMVC01。就是说当前打开的页面的前一个
      绝对路径：/hello 以 / 开头的路径，一定要以 / 开头,例如 page/hello 这种就不是绝对路径
  --%>
  <a href="hello">Hello SpringMVC</a>

  </body>
</html>
