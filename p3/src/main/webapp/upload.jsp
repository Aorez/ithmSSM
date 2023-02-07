<%--
  Created by IntelliJ IDEA.
  User: Aorez
  Date: 2023/1/30
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--    测试文件上传--%>
<%--    <form method="post" action="${pageContext.request.contextPath}/user/save21" enctype="multipart/form-data">--%>
<%--        用户名<input type="text" name="username"><br>--%>
<%--        文件<input type="file" name="uploadFile"><br>--%>
<%--        <input type="submit" value="提交">--%>
<%--    </form>--%>

<%--    测试多文件上传--%>
    <form method="post" action="${pageContext.request.contextPath}/user/save22" enctype="multipart/form-data">
        用户名<input type="text" name="username"><br>
        文件<input type="file" name="uploadFile"><br>
        文件<input type="file" name="uploadFiles"><br>
        文件<input type="file" name="uploadFiles"><br>
        <input type="submit" value="提交">
    </form>

</body>
</html>
