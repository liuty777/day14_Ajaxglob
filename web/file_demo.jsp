<%--
  Created by IntelliJ IDEA.
  User: 刘天宇
  Date: 2020/12/19
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>file.deomo</title>
</head>
<body>
<form action="fileDomoServlet?method=fileDomoServlet" method="post" enctype="multipart/form-data">
    用户名：<input type="text" ><br>
    文件：<input type="file" name="file"><br>
    <input type="submit" value="提交">


</form>



</body>
</html>
