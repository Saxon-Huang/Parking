<%--
  Created by IntelliJ IDEA.
  User: ZechenHuang
  Date: 2022/11/9
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>
        <script type="text/javascript" src="jquery/jquery-3.6.1.min.js"></script>
        <%--<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/vue"></script>--%>
        <script src="https://cdn.jsdelivr.net/npm/vue@2.7.13"></script>
        <script type="text/javascript">
            $(function () {
                $("#btn0").click(function () {
                    var arr = [1, 2, 3, 4];
                    $.ajax({
                        "url": "test/ssm.html",
                        "type": "post",
                        "data": arr,
                        "dataType": "text",
                        "success": function (response) {
                            alert(response);
                        },
                        "error": function (response) {
                            alert(response);
                        },
                    })
                })

                $("#btn1").click(function () {
                    var arr = [1, 2, 3, 4];

                    var requestBody = JSON.stringify(arr);
                    $.ajax({
                        "url": "send/array.html",
                        "type": "post",
                        "data": requestBody,
                        "contentType": "application/json;charset=UTF-8",
                        "dataType": "text",
                        "success": function (response) {
                            alert(response);
                        },
                        "error": function (response) {
                            alert(response);
                        },
                    })
                })

                $("#btn2").click(function () {


                    var requestBody = JSON.stringify(null);
                    $.ajax({
                        "url": "error0.html",
                        "type": "post",
                        "data": requestBody,
                        "contentType": "application/json;charset=UTF-8",
                        "dataType": "text",
                        "success": function (response) {
                            //alert(response);
                        },
                        "error": function (response) {
                            //alert(response);
                        },
                    })
                })
            })
        </script>
    </head>
    <body>
        <a href="test/ssm.html">测试ssm整合</a>
        <a href="error0.html">test error</a>
        <p> paragraph </p>
        <button id="btn0"> test ssm </button>
        <button id="btn1"> button 1</button>
        <button id="btn2"> divide 10 by 0 </button>
        <a href="admin/login/page.html">admin login</a>
<%--        <script>
            /* Causing error ! (vue version) */
            var obj = {
                foo: 'bar'
            }

            Object.freeze(obj)

            new Vue({
                el: '#app',
                data: obj
            })
        </script>--%>
    </body>
</html>
