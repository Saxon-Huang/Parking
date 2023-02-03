<%--
  Created by IntelliJ IDEA.
  User: ZechenHuang
  Date: 2023/1/3
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<%@include file="/WEB-INF/basePages/base-head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.pagination.js"></script>

<script type="text/javascript">
/*    $(function (){
        window.pageNum = 1;
        window.pageSize = 5;
        window.keyword = "";

        //generatePagination();
    });*/
</script>
<head>
    <title>role management page</title>
</head>
<body>
    <div id="role-page">
        <button type="button" v-on:click="generatePagination">start</button>

        <div>
            <label>
                <input v-model="inputKeyword" type="text" placeholder="Search role ..."/>
            </label>
            <button type="button" v-on:click="searchKeyword" >search</button>
        </div>


        <div id="Pagination"></div>
        <div id="table">
            <table border="1" v-if="tableReady">
                <tr v-for="role in rolePageInfo.list">
                    <td> {{ role.role_id }} </td>
                    <td> {{ role.name }} </td>
                </tr>
            </table>
        </div>
    </div>

</body>
<script type="text/javascript" src="js/role-manage.js"></script>
</html>
