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
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ztree_v3/css/zTreeStyle/zTreeStyle.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/ztree_v3/js/jquery.ztree.all.min.js"></script>

<title>admin home</title>
<body>
Welcome! ${sessionScope.loginAdmin}
<div>
    <a href="admin/manage/admin.html">manage admins</a>
</div>

<div>
    <a href="admin/manage/role.html">manage roles</a>
</div>

<div id="menu">
    <button type="button" v-on:click="getNodes">get nodes</button>
</div>

<div>
    <ul id="treeDemo" class="ztree"></ul>
</div>
</body>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin-main.js"></script>--%>
<script type="text/javascript" src="js/menu.js"></script>
</html>
