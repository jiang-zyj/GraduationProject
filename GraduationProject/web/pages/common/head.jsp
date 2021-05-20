<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/4/9
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 用户页面 --%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Brand</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
            <ul class="nav navbar-nav">
                <li><a href="#">首页</a></li>
                <li class="active"><a href="pages/scenic/chooseScenic.jsp">出游助手 <span
                        class="sr-only">(current)</span></a></li>
                <li><a href="personal?action=queryHealthCode">健康码</a></li>
                <%--          <li><a href="#">个人中心</a></li>--%>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">疫情指南 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <%-- 直接显示页面的做法，通过页面做Ajax请求来获取数据 --%>
                        <%--              <li><a href="pages/guide/client/protection_strategy.jsp">防护攻略</a></li>--%>
                        <%-- 向 Servlet 请求数据 --%>
                        <li><a href="guide?action=queryAllStrategy">防护攻略</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="guide?action=queryAllHosMethodForClient">就医问题</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="guide?action=queryAllUseFaceMaskForClient">口罩使用</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="guide?action=queryAllRumor">关于谣言</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="guide?action=queryAllCounselingForClient">心理疏导</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">个人中心 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="pages/personal/healthClockIn.jsp">健康打卡</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="personal?action=queryHealthRecord">查看打卡记录</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="personal?action=queryRiskCity">查询风险城市</a></li>
                    </ul>
                </li>
            </ul>
            <c:if test="${sessionScope.user == null}">
                <button type="button" class="btn btn-default navbar-right"><a href="pages/user/login.jsp">登录</a>
                </button>
                <button type="button" class="btn btn-default navbar-right"><a href="pages/user/register.jsp">注册</a>
                </button>
            </c:if>
            <c:if test="${sessionScope.user != null}">
                <button type="button" class="btn btn-default navbar-right"><a href="pages/user/login.jsp">注销</a>
                </button>
            </c:if>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

