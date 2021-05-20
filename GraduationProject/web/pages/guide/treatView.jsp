<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/3/30
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    医生信息：${sessionScope.doctors}
    <title>就医问题</title>
    <%-- 静态包含js、css、base --%>
    <%@include file="../common/jsAndCss.jsp"%>
</head>
<c:if test="${param.msg != null and param.msg == 'success'}">
    <script type="text/javascript">
        alert("添加成功！");
    </script>
</c:if>

<body>
<%-- 静态包含头部分 --%>
<%@include file="../common/head.jsp"%>
    <%--数据为：<br>
    ${requestScope.page}--%>
    <div class="container">
<%--        <div class="col-md-1"></div>--%>
        <div class="col-md-12">
            <table class="table table-hover">
                <th>序号</th>
                <th>问题编号</th>
                <th>就医问题</th>
                <th>医生回答</th>
                <th>医生信息</th>
                <th>就医方法</th>
                <th colspan="2">操作</th>

                <c:forEach items="${requestScope.page.items}" var="i" varStatus="s">
                    <tr>
                        <td>${s.count}</td>
                        <td>${i.treat_id}</td>
                        <td>${i.treat_prob}</td>
                        <td>${i.treat_ans}</td>
                        <td>${i.d_doctorInfo}</td>
                        <td>${i.h_name}</td>
                        <td><a href="#">删除</a></td>
                        <td><a href="#">更新</a></td>
                    </tr>
                </c:forEach>

            </table>
            <tr>
                <td><a href="pages/guide/addTreatProb.jsp">添加</a></td>
            </tr>
            <tr>
                <c:if test="${requestScope.page.pageNo > 1}">
                <a href="${requestScope.page.url}&pageNo=1">首页</a> &nbsp;
                <a href="${requestScope.page.url}&pageNo=${requestScope.page.prePage}">上一页</a> &nbsp;
                </c:if>

                <%--静态包含分页条--%>
                <%@include file="../common/page_nav.jsp"%>



                当前页 <font color="blue" size="5">${requestScope.page.pageNo}</font>
                <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
                <a href="${requestScope.page.url}&pageNo=${requestScope.page.nextPage}">下一页</a> &nbsp;
                <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a> &nbsp;
                </c:if>
                共 <font color="red">${requestScope.page.pageTotal}</font> 页
                到 <input id="page" type="text">  页 &nbsp
        </div>
<%--        <div class="col-md-1"></div>--%>
    </div>

</body>
</html>
