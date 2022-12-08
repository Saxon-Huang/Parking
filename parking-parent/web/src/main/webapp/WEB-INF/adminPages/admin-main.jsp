<%--
  Created by IntelliJ IDEA.
  User: ZechenHuang
  Date: 2022/11/22
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<%@include file="/WEB-INF/basePages/base-head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.pagination.js"></script>
<title>admin home</title>
<body>
${sessionScope.loginAdmin}

    <div id="admin-main-body">
        <form id="getPageInfoForm" action="admin/get/page.html" role="form" method="post">
            <input name="keyword" type="text" placeholder="Searching keyword">
            <button type="submit" >submit</button>

        </form>
        <div id="Pagination"></div>
        <div>
                <c:if test="${!empty requestScope.pageInfo.list}">
                    <table border="1">
                        <c:forEach items="${requestScope.pageInfo.list}" var="admin" varStatus="myStatus">
                            <tr>
                                <td>${myStatus.count}</td>
                                <td><input type="checkbox"></td>
                                <td>${admin.admId}</td>
                                <td>${admin.admAcct}</td>
                                <td>${admin.admPswd}</td>

                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
        </div>

    </div>

</body>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin-main.js"></script>--%>
<script type="text/javascript">

    function initPagination () {
        var totalRecord = ${requestScope.pageInfo.total};

        var properties = {
            num_edge_entries: 3, // 边缘页数
            num_display_entries: 5, // 主体页数
            callback: pageSelectCallback,
            items_per_page:${requestScope.pageInfo.pageSize},
            current_page: ${requestScope.pageInfo.pageNum - 1}, // Pagination内部使用pageIndex来管理页码，从0开始，而pageNum从1开始
            prev_text: "previous",
            next_text: "next"
        }
        // 生成页码导航条
        $("#Pagination").pagination(totalRecord, properties);
    }

     function pageSelectCallback(pageIndex) {
        // 根据pageIndex计算得到pageNum
        var pageNum = pageIndex + 1;
        // 跳转页码
        window.location.href = "admin/get/page.html?pageNum="+pageNum;
        // 由于每一个页码按钮都是超链接，所以在这个函数最后取消超链接的默认行为
        return false;
    }

    $(function () {
        initPagination();
    })

</script>
</html>
