<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/3/30
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加就医问题</title>
    <%-- 静态包含js、css、base --%>
    <%@include file="../common/jsAndCss.jsp"%>
</head>
    <script type="text/javascript">
        $.post({
            url: "guide?action=queryAllGuide",
            data: {},
            success: function (data) {

            },
            dataType: "json"
        });
    </script>
<body>
<%-- 静态包含头部分 --%>
<%@include file="../common/head.jsp"%>
<c:if test="${param.msg != null and param.msg == 'fail'}">
    <script type="text/javascript">
        alert("添加失败！请检查添加信息中的医生信息和就医方法是否存在！");
    </script>
</c:if>
<div class="container">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <center><h1>添加就医问题</h1></center>
            <form id="register" class="form-horizontal" action="guide?action=addProblem" method="post">
                <div class="form-group">
                    <label>问题描述：</label>
                    <input type="text" class="form-control" id="treat_prob" name="treat_prob" value="${sessionScope.hosProblem.treat_prob}">
<%--                    <textarea class="form-control" rows="3" id="treat_prob" name="treat_prob" value="${sessionScope.hosProblem.treat_prob}></textarea>--%>
                </div>
                <div class="form-group">
                    <label>医生回答：</label>
                    <input type="text" class="form-control" id="treat_ans" name="treat_ans" value="${sessionScope.hosProblem.treat_ans}">
                </div>
                <div>
                    <label>请选择医生：</label>
                    <select class="form-control" name="d_doctorInfo" id="d_doctorInfo">
                        <c:forEach items="${sessionScope.doctors}" var="i">
                            <option value="${i.d_doctorInfo}"><h4>${i.d_doctorInfo}</h4></option>
                        </c:forEach>
                    </select>
                </div>
<%--                <select name="d_doctorInfo" id="d_doctorInfo2">--%>
<%--                    <c:forEach items="${sessionScope.doctors}" var="i">--%>
<%--                        <option value="${i.d_doctorInfo}">${i.d_doctorInfo}</option>--%>
<%--                            <label>--%>
<%--                                <input type="radio" name="optionsRadios" id="optionsRadios1" value="${i.d_doctorInfo}" checked>--%>
<%--                                ${i.d_doctorInfo}--%>
<%--                            </label>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>

                <div>
                    <label>归类方法：</label>
                    <select name="h_name" id="h_name" class="form-control">
                        <c:forEach items="${sessionScope.rationals}" var="i">
                            <option value="${i.h_name}">${i.h_name}</option>
                        </c:forEach>
                    </select>

                </div>
                <br>

                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="submit" class="btn btn-primary">提交</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="reset" class="btn btn-primary">重置</button>
            </form>
        </div>
        <div class="col-md-2"></div>

    </div>
</div>
</body>
</html>
