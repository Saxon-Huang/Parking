<%--
  Created by IntelliJ IDEA.
  User: ZechenHuang
  Date: 2022/11/17
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="basePages/base-head.jsp"%>
<body>

<div id="admin">
  <form action="admin/do/login/page.html" method="post" role="form">
    <h1> Administrator Login</h1>
    <input type="text" name="username" v-model="username" placeholder="username">
    <input type="password" name="password" v-model="password" placeholder="password">
    <button type="submit">Login</button>
  </form>


  {{ username }}
  <p>${requestScope.exception.message}</p>


  <a href="admin/login/page.html?username='vvv'" > test redirect login </a>

</div>
<script type="text/javascript" src="js/test.js"></script>
</body>
</html>
