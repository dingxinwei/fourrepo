<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/6
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>success</title>
</head>
<body>
success!
session中的值：${sessionScope.info}
request中的值：${requestScope.message}
<hr/>
request：${requestScope.val}<br/>
session:${sessionScope.val}${sessionScope.ha}<br/>
pageContext:${pageScope.val}<br/>
application:${applicationScope.val}<br/>
<hr>
<h1>${requestScope.msg}</h1>
</body>
</html>
