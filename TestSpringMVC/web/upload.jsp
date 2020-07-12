<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/12
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>文件上传</title>
</head>
<body>
    <form action="upload" method="post" enctype="multipart/form-data">
        用户头像：<input type="file" name="headimg"/>
        用户名：<input type="text" name="uname"/>
        <input type="submit" value="文件上传"/>
    </form>
</body>
</html>
