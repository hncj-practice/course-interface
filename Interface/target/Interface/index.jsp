<%--
  Created by IntelliJ IDEA.
  User: fyz
  Date: 2020/8/2
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>

<form method="post" action="student/login">
    <span>
        <jsp:text>学号</jsp:text>
        <input type="text" name="username" placeholder="请输入学号" value="081417162">
    </span><br>
    <span>
        <jsp:text>密码</jsp:text>
        <input type="text" name="password" placeholder="请输入密码" value="000000">
    </span><br>

    <span>
        <input type="submit" value="提交">
    </span>


</form>

<a href="student/login">测试链接</a>
</body>
</html>
