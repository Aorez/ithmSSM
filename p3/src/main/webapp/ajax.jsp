<%--
  Created by IntelliJ IDEA.
  User: Aorez
  Date: 2023/1/30
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        let userList = [];
        userList.push({username:"张三",age:13});
        userList.push({username:"李四",age:14});
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/user/save15",
            data:JSON.stringify(userList),
            contentType:"application/json;charset=utf-8",
        })
    </script>
</head>
<body>

</body>
</html>
