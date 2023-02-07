<%--
  Created by IntelliJ IDEA.
  User: Aorez
  Date: 2023/1/28
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--测试Controller接收集合类型的请求参数--%>
<%--需要写一个表单来提交集合类型的数据--%>
    <form action="${pageContext.request.contextPath}/user/save14" method="post">
        <input type="text" name="users[0].username"><br>
        <input type="text" name="users[0].age"><br>
        <input type="text" name="users[1].username"><br>
        <input type="text" name="users[1].age"><br>
        <input type="submit" value="提交">
    </form>

</body>
</html>
