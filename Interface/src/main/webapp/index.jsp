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
<h2>用户登录</h2>
<form method="post" action="account/login">
    <span>
        <jsp:text>账号</jsp:text>
        <input type="text" name="username" placeholder="请输入学号" value="081417162">
    </span><br>
    <span>
        <jsp:text>密码</jsp:text>
        <input type="text" name="password" placeholder="请输入密码" value="000000">
    </span><br>
    <span>
        <jsp:text>登录类型</jsp:text>
        <input type="text" name="type" value=1>
    </span><br>

    <span>
        <input type="submit" value="提交">
    </span>
</form>
<a href="account/login?username=081417137&password=000000&type=1">学生登录get</a>
<a href="account/login?username=888888888&password=000000&type=2">教师登录get</a>
<a href="account/login?username=wsgly&password=000000&type=3">管理员登录get</a>
<br>
<a href="account/addstudent?sno=081417101&cla=0814171&pwd=000000&name=赵晓博&sex=m&email=123456@fbi.com&avatar=https://www.baidu.com&status=0">添加学生get</a>
<a href="account/addteacher?tno=123456789&pwd=000000&name=郭力争&sex=m&email=123456789@fbi.com&avatar=https://www.baidu.com&status=0">添加教师get</a>
<a href="account/addadmin?adminAccount=test&adminPwd=000000">添加管理员get</a>
<br>
<a href="account/delete?username=081417101&admin_user=wsgly&admin_pwd=000000&type=1">删除学生get</a>
<a href="account/delete?username=123456789&admin_user=wsgly&admin_pwd=000000&type=2">删除教师get</a>
<a href="account/delete?admin_user=test&admin_pwd=newpwd!!!&type=3">删除管理员get</a>
<br>
<a href="account/resetpwd?username=081417162&password=000000&newpwd=newpwd!!!&type=1">更新学生密码get</a>
<a href="account/resetpwd?username=111111&password=000000&newpwd=newpwd!!!&type=2">更新教师密码get</a>
<a href="account/resetpwd?username=test&password=000000&newpwd=newpwd!!!&type=3">更新管理员密码get</a>
<br>
<a href="chapter/addchapter?cid=1&chaptername=第九九九章">添加章节</a>
<a href="chapter/delchapter?chapterid=10">删除章节</a>
<br>
<a href="class/addclass?classid=0814172&classname=计算机科学与技术二班">添加班级</a>
<a href="class/delclass?classid=0814172">删除班级</a>
<br>
<a href="semester/addsemester?semesterid=2020_02&semestername=2019-2020学年第二学期">添加学期</a>
<a href="semester/delsemester?semesterid=2020_02">删除学期</a>
<br>
<a href="course/addcourse?semester=2020_09&tno=888888888&cname=人工智能&coverimg=https://i0.hdslb.com/bfs/sycp/creative_img/202008/26449dd779b45fca0fec993f66de6192.png&status=1">添加课程</a>
<a href="course/delcourse?courseid=6">删除课程</a>
<br>
<a href="topic/addtopic?courseid=1&topictitle=标题&topiccontent=内容&committime=2020-08-31 14:34:24&topicstatus=1">添加话题</a>
<a href="topic/deltopic?topicid=2">删除话题</a>
<br>
<a href="comment/addcomment?sno=081417162&topicid=1&commentcontent=回复一个试试&commenttime=2020-08-31 14:34:24">添加评论</a>
<a href="comment/delcomment?commentid=2">删除评论</a>
<br>
<a href="problem/addproblem?chapterid=1&ptype=3&question=这是一道测试题&panswer=答案：略">添加题目</a>
<a href="problem/delproblem?problemid=2">删除题目</a>
<br>
<a href="data/adddata?courseid=1&dataname=测试资料&datalink=https://blog.csdn.net/xy_hdl/article/details/106223305">添加资料</a>
<a href="data/deldata?dataid=2">删除资料</a>
<br>
<a href="paper/addpaper?courseid=1&papername=测试试卷&choicepoints=5&judgepoints=6&fillpoints=4&starttime=2020-07-31 14:25:24&endtime=2020-07-31 14:25:24&status=1">添加试卷</a>
<a href="paper/delpaper?paperid=3">删除试卷</a>
<br>
<a href="student/allstudent?classid=0814171">查询某班级所有学生</a>
<a href="teacher/allteacher">查询所有的教师信息</a>
<br>
<a href="course/getcoursebycid?courseid=1">按课程号查找课程</a>
<a href="topic/gettopicbycid?courseid=1">按课程号查找话题</a>
<a href="problem/getproblembychapterid?chapterid=2">按章节号查找题目</a>
<a href="chapter/getchapterbycourseid?courseid=1">按课程号查找章节</a>
<a href="course/getcoursebytno?tno=888888888">按教师号查找课程</a>
<br>
</body>
</html>
