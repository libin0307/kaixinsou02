<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2018/9/27
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>开心搜</title>
</head>
<body style="background-color: darkgrey">
<h2>新增资源</h2>
<form action="/success.action" method="get">
    资源名称&nbsp&nbsp&nbsp<input type="text" style="width:500px; height:40px;" name="sourceName"><br/>  <br/>
    资源链接&nbsp&nbsp&nbsp<input type="text" style="width:500px; height:30px;" name="links"><br/>  <br/>
    资源大小&nbsp&nbsp&nbsp<input type="text" style="width:80px; height:30px;" name="size"><br/>  <br/>
    资源详情&nbsp&nbsp&nbsp<textarea style="width:500px; height:200px;" name="details"></textarea><br/>  <br/>
    <input type="submit" style="width: 80px;height: 40px;" value="提交">
</form>
</body>
</html>
