<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/14
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 导入 SpringMVC 的表单标签库 --%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- SpringMVC的表单标签：
            1、可以快速的开发表单
            2、可以更加方便的回显数据

            SpringMVC 表单标签遇到的问题
            问题原因：SpringMVC 的表单标签必须要进行数据的回显。默认会使用"command"这个key到request中
                    找回显的数据。如果找不到，则抛出异常。
            问题解决：让SpringMVC可以通过"command"从request中找到要回显的数据。
                        还可以通过modelAttribute来指定一个key替换默认的command
            表单标签在最终执行时会转化成原始的HTML标签
     --%>
    <%--<form:form action="${pageContext.request.contextPath}/emp" method="post" modelAttribute="employee">

        &lt;%&ndash;
            判断是添加操作还是修改操作：
                根据回显的 Employee 对象的id值来判断，如果有id，则是修改操作，没有id，则是添加操作
        &ndash;%&gt;
        <c:if test="${not empty employee.id}" var="flag">
            &lt;%&ndash; 修改操作 &ndash;%&gt;
            <form:hidden path="id"/>
            &lt;%&ndash; 隐藏PUT请求 &ndash;%&gt;
            <input type="hidden" name="_method" value="PUT">
        </c:if>
        lastName: <form:input path="lastName"/> &lt;%&ndash; path就相当于html标签中的name属性 &ndash;%&gt;
        <br>
        Email:<form:input path="email"/>
        <br>
        &lt;%&ndash; radiobuttons 可以根据Map数据来生成单选框 &ndash;%&gt;
        Gender:<form:radiobuttons path="gender" items="${genders}"/>
        <br>
        deptName:<form:select path="department.id" items="${depts}" itemLabel="departmentName" itemValue="id"/>
        <br>
        <c:if test="${flag}">
            <input type="submit" value="Edit">
        </c:if>
        <c:if test="${!flag}">
            <input type="submit" value="ADD">
        </c:if>
    </form:form>--%>

    <form:form action="${pageContext.request.contextPath}/employee" method="post" modelAttribute="employee">
        <c:if test="${not empty employee.id}" var="flag">
            <form:hidden path="id"/>
            <input type="hidden" name="_method" value="PUT">
        </c:if>
        lastName:<form:input path="lastName"/>
        <br>
        Email:<form:input path="email"/>
        <br>
        Gender:<form:radiobuttons path="gender" items="${genders}"/>
        <br>
        deptName:<form:select path="department.id" items="${depts}" itemValue="id" itemLabel="departmentName"/>
        <br>
        <c:if test="${flag}">
            <input type="submit" value="Edit">
        </c:if>
        <c:if test="${!flag}">
            <input type="submit" value="ADD">
        </c:if>
    </form:form>
</body>
</html>
