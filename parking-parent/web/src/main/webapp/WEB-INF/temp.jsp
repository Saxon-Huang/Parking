<%--
  Created by IntelliJ IDEA.
  User: ZechenHuang
  Date: 2022/11/9
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>
    <script type="text/javascript" src="jquery/jquery-3.6.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue@2.7.13"></script>
</head>
<body>
    <h1>success</h1>

    ${requestScope.adminList}
    ${sessionScope.loginAdmin}
    {{ this.$session.getAll() }}
</body>
</html>
