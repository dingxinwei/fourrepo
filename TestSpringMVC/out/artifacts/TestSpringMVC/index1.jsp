<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/4
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="jquery-1.9.1.js"></script>
</head>
<body>
<a href="h/handle02">handle02</a>
<a href="h/handle03">handle03</a>
<a href="h/handle04">handle04</a>
<button id="ajaxReqData">ajax请求json数据</button>
<button id="ajaxSendData">ajax发送json数据</button>
<div></div>
<script>
    $("#ajaxReqData").click(function(){
        $.ajax({
            url:"h/handle05",
            type:"GET",
            success:function (data) {
                console.log(data);

                    $("div").append(data.address+"-->"+data.gName);

            }
        })
    })
    $("#ajaxSendData").click(function () {
        var address = {province:"江苏省",city:"徐州市",area:"泉山区"}
        var str = JSON.stringify(address);
        $.ajax({
            url:"h/handle06",
            type:"post",
            data:str,
            contentType:"application/json",
            success:function (data) {
                alert(data);
            }
        })
    })
</script>
</body>
</html>
