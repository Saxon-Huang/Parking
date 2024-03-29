<%--
  Created by IntelliJ IDEA.
  User: ZechenHuang
  Date: 2023/1/3
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<%@include file="/WEB-INF/basePages/base-head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.pagination.js"></script>
<head>
    <title>Title</title>
</head>
<body>
<div id="admin-main-body">
    <form id="getPageInfoForm" action="admin/get/page.html" role="form" method="post">
        <label>
            <input name="keyword" type="text" placeholder="Search admin ...">
        </label>
        <button type="submit" >submit</button>

    </form>
    <div id="Pagination"></div>
    <div>
        <h5>results containing "${param.keyword}"</h5>
        <c:if test="${!empty requestScope.pageInfo.list}">
            <table border="1">
                <c:forEach items="${requestScope.pageInfo.list}" var="admin" varStatus="myStatus">
                    <tr>
                        <td>${myStatus.count}</td>
                        <td><input type="checkbox"></td>
                        <td>${admin.admId}</td>
                        <td>${admin.admAcct}</td>
                        <td>${admin.admPswd}</td>
                        <c:if test="${sessionScope.loginAdmin.admAcct == 'adm0' && admin.admAcct != 'adm0'}">
                            <td>
                                <a href="admin/remove/admin/${admin.admId}/${requestScope.pageInfo.pageNum}/${param.keyword}.do">remove</a>
                            </td>
                        </c:if>

                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>

    <c:if test="${sessionScope.loginAdmin.admAcct == 'adm0'}">
        <p>Welcome, root admin! </p>
        <div>
            <p style="color: red">${requestScope.exception.message}</p>
            <form id="addAdmin" action="admin/add/admin.do" role="form" method="post">
                <label>
                    <input name="username" type="text" placeholder="username">
                </label>
                <label>
                    <input name="password" type="password" placeholder="password">
                </label>
                <button type="submit">add</button>
            </form>
        </div>
    </c:if>



</div>
</body>
<script type="text/javascript">

<%--
    pagination作用：
        生成导航栏，其中每个按钮（上/下一页、页码）绑定一个回调函数pageSelectCallBack(Integer)；
    回调函数：
        此处是向后端查询对应页码的数据，刷新页面显示。
        也可异步，先获取全部数据，再在回调函数中批量显示。
--%>
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
        //window.location.href = "admin/get/page.html?pageNum="+pageNum;
        window.location.href = "admin/get/page.html?pageNum="+pageNum+"&keyword="+"${param.keyword}";
        // 由于每一个页码按钮都是超链接，所以在这个函数最后取消超链接的默认行为
        return false;
    }

    $(function () {
        initPagination();
    })

</script>
</html>
