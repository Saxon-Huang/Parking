<%--
  Created by IntelliJ IDEA.
  User: ZechenHuang
  Date: 2023/1/3
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<%@include file="/WEB-INF/basePages/base-head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.pagination.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script><script type="text/javascript">
    $(function (){
        window.pageNum = 1;
        window.pageSize = 5;
        window.keyword = "";

    });
</script>
<head>
    <title>role management page</title>
</head>
<body>
    <div id="role-page">
        <%--<button type="button" v-on:click="generatePagination">start</button>--%>

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
                    <td> {{ role.roleId }} </td>
                    <td> {{ role.name }} </td>
                    <td><img src="images/red_cross.jpg" alt="a red cross" width="20px" v-on:click="deleteRole(role.roleId)"/> </td>
                </tr>
            </table>
        </div>

            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                add role
            </button>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">Add a new role</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <p> {{addRoleResult}} </p>
                            <input type="text" placeholder="new role name ..." v-model="newRoleName"/>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" v-on:click="addRole">Add</button>
                        </div>
                    </div>
                </div>
            </div>
    </div>

</body>
<script type="text/javascript" src="js/role-manage.js"></script>
</html>
