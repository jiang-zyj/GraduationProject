<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/9
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/jsAndCss.jsp" %>
<html>
<head>
    <title>健康打卡</title>
</head>
<script type="text/javascript">
    $.post({
        url: "personal?action=queryAllCity",
        data: {},
        success: function (data) {
            var i = "";
            $.each(data, function (index, obj) {
                i += "<option value='" + obj.cname + "'>" + obj.cname + "</option>";
            });
            $("#cities").html(i);
        },
        dataType: "json"
    });
</script>
<c:if test="${param.msg != null and param.msg == 'clockInFail'}">
    <script type="text/javascript">
        alert("打卡失败，请填写每一个选项");
    </script>
</c:if>
<body>
<%-- 静态包含头部分 --%>
<%@include file="../common/head.jsp"%>
    <div class="container">
        <div class="col-lg-8">
            <form class="form-group" action="personal?action=healthClockIn" method="post">
                <div class="form-group">
                    <label>姓名：</label>
                    <input class="form-control" type="text" placeholder="${sessionScope.user.name}" readonly>
                </div>
                <div class="form-group">
                    <label>身份证号：</label>
                    <input class="form-control" type="text" placeholder="${sessionScope.user.uid}" readonly>
                </div>
                <div class="form-group">
                    <label>联系方式：</label>
                    <input class="form-control" type="text" placeholder="${sessionScope.user.tel}" readonly>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">当前所在城市</label>
                    <select class="form-control" id="cities" name="city">
                        <%--<c:forEach items="${sessionScope.riskCity.cname}" var="i">
                            <option>${i.}</option>
                        </c:forEach>--%>
                    </select>
                </div>

                <div class="form-group">
                    <label>近14天内您是否接触新冠肺炎确诊患者或疑似患者</label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="touch" id="optionsRadios1" value="10">是
                    </label>
                    <label>
                        <input type="radio" name="touch" id="optionsRadios3" value="5">不确定
                    </label>
                    <label>
                        <input type="radio" name="touch" id="optionsRadios2" value="0">否
                    </label>
                </div>
                <div class="form-group">
                    <label>您是否有以下症状，如有请多选（可多选）</label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="0" name="symptom">
                        没有出现症状
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="5" name="symptom">
                        感冒样症状：乏力、咳嗽、发烧、肌肉痛、头痛
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="5" name="symptom">
                        喘憋、呼吸急促
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="5" name="symptom">
                        恶心呕吐、腹泻
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="5" name="symptom">
                        心慌、胸闷
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="5" name="symptom">
                        结膜炎（红眼病样表现：眼睛涩、红、分泌物）
                    </label>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="5" name="symptom">
                        其他症状
                    </label>
                </div>

                <div class="form-group">
                    <label>当前体温（°C）</label>
                    <input class="form-control" type="text" placeholder="请输入当前体温" name="curr_temperature">
                </div>

                <div class="radio">
                    <label>
                        <input type="radio" name="" id="" value="option1">上述信息是我本人填写，本人对信息内容的真实性和完整性负责。
                    </label>
                </div>

                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>
</body>
</html>
