<%--
  Created by IntelliJ IDEA.
  User: 才二
  Date: 2021/3/11
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--页码输出的开始--%>
<%--展示5条页码--%>
<center>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <a href="${requestScope.page.url}&pageNo=1" aria-label="Previous">
                    <span aria-hidden="true">首页</span>
                </a>
            </li>
            <c:if test="${requestScope.page.pageNo <= 1}">
                <li class="disabled">
                    <a href="${requestScope.page.url}&pageNo=${requestScope.page.prePage}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>
            <c:if test="${requestScope.page.pageNo > 1}">
                <li>
                    <a href="${requestScope.page.url}&pageNo=${requestScope.page.prePage}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>
            <c:choose>

                <%--第一种情况：当总页数 pageTotal <= 5--%>
                <c:when test="${requestScope.page.pageTotal <= 5}">
                    <%--观察每个情况下，都是从 begin 遍历到 end。该 foreach 可以提取出来，然后
                            在每种情况下都记录下 begin 和 end 的值，最后执行即可--%>
                    <%--                    <c:set var="begin" value="1"/>--%>
                    <%--                    <c:set var="end" value="${requestScope.page.pageTotal}"/>--%>
                    <c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
                        <c:if test="${requestScope.page.pageNo == i}">
                            <%--                【${i}】--%>
                            <li><a href="${requestScope.page.url}&pageNo=${i}">${i}</a></li>
                        </c:if>
                        <c:if test="${requestScope.page.pageNo != i}">
                            <%--                <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>--%>
                            <li><a href="${requestScope.page.url}&pageNo=${i}">${i}</a></li>
                        </c:if>
                    </c:forEach>
                </c:when>
                <%--第二种情况：当总页数 pageTotal >= 5 --%>
                <c:when test="${requestScope.page.pageTotal > 5}">
                    <c:choose>
                        <%--小情况1：当当前页码在前 5 页时--%>
                        <c:when test="${requestScope.page.pageNo <= 3}">
                            <c:forEach begin="1" end="5" var="i">
                                <c:if test="${requestScope.page.pageNo == i}">
                                    <%--                        【${i}】--%>
                                    <li><a href="${requestScope.page.url}&pageNo=${i}">${i}</a></li>
                                </c:if>
                                <c:if test="${requestScope.page.pageNo != i}">
                                    <%--                        <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>--%>
                                    <li><a href="${requestScope.page.url}&pageNo=${i}">${i}</a></li>
                                </c:if>
                            </c:forEach>
                        </c:when>
                        <%--小情况2：当当前页码在最后的 5 页时--%>
                        <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal - 3}">
                            <c:forEach begin="${requestScope.page.pageTotal - 4}" end="${requestScope.page.pageTotal}"
                                       var="i">
                                <c:if test="${requestScope.page.pageNo == i}">
                                    <%--                        【${i}】--%>
                                    <li><a href="${requestScope.page.url}&pageNo=${i}">${i}</a></li>
                                </c:if>
                                <c:if test="${requestScope.page.pageNo != i}">
                                    <%--                        <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>--%>
                                    <li><a href="${requestScope.page.url}&pageNo=${i}">${i}</a></li>
                                </c:if>
                            </c:forEach>
                        </c:when>
                        <%--小情况3：当当前页码在中间时(即其他情况)--%>
                        <c:otherwise>
                            <c:forEach begin="${requestScope.page.pageNo - 2}" end="${requestScope.page.pageNo + 2}"
                                       var="i">
                                <c:if test="${requestScope.page.pageNo == i}">
                                    <%--                        【${i}】--%>
                                    <li><a href="${requestScope.page.url}&pageNo=${i}">${i}</a></li>
                                </c:if>
                                <c:if test="${requestScope.page.pageNo != i}">
                                    <%--                        <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>--%>
                                    <li><a href="${requestScope.page.url}&pageNo=${i}">${i}</a></li>
                                </c:if>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </c:when>
            </c:choose>
            <c:if test="${requestScope.page.pageNo >= requestScope.page.pageTotal}">
                <li class="disabled">
                    <a href="${requestScope.page.url}&pageNo=${requestScope.page.nextPage}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>
            <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
                <li>
                    <a href="${requestScope.page.url}&pageNo=${requestScope.page.nextPage}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>
            <li>
                <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}" aria-label="Next">
                    <span aria-hidden="true">尾页</span>
                </a>
            </li>
            <li class="disabled">
                <span aria-hidden="true">共 <font color="red">${requestScope.page.pageTotal}</font> 页</span>
            </li>
        </ul>
    </nav>
</center>
<%--页码输出的结束--%>
