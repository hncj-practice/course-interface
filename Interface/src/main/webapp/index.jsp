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
<h2>学生登录</h2>
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
<a href="student/login?username=081417137&password=000000">学生登录get</a>
<a href="student/add?sno=081417101&cla=0814171&pwd=000000&name=赵晓博&sex=m&email=123456@fbi.com&avatar=https://www.baidu.com&status=0">添加学生get</a>

<h2>教师登录</h2>
<form method="post" action="teacher/login">
    <span>
        <jsp:text>学号</jsp:text>
        <input type="text" name="username" placeholder="请输入工号" value="888888888">
    </span><br>
    <span>
        <jsp:text>密码</jsp:text>
        <input type="text" name="password" placeholder="请输入密码" value="000000">
    </span><br>

    <span>
        <input type="submit" value="提交">
    </span>

</form>
<a href="teacher/login?username=888888888&password=000000">教师登录get</a>


<h2>管理员登录</h2>
<form method="post" action="admin/login">
    <span>
        <jsp:text>账号</jsp:text>
        <input type="text" name="username" placeholder="请输入账号" value="wsgly">
    </span><br>
    <span>
        <jsp:text>密码</jsp:text>
        <input type="text" name="password" placeholder="请输入密码" value="000000">
    </span><br>

    <span>
        <input type="submit" value="提交">
    </span>

</form>
<a href="admin/login?username=wsgly&password=000000">管理员登录get</a>

</body>
</html>
