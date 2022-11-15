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
        <script type="text/javascript">
            $(function () {
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
            })
        </script>
    </head>
    <body>
        <a href="test/ssm.html">测试ssm整合</a>
        <p> paragraph </p>
        <button id="btn1"> button 1</button>
    </body>
</html>
