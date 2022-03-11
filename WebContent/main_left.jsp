<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统页面（左）</title>
</head>
<body bgcolor="Lavender">
 <br><br><br> <br><br><br>
  		<p><a href="record_add.jsp" target="right">添加考勤记录</a></p> 
        <p><a href="record_update.jsp" target="right">修改考勤记录</a></p> 
        <p><a href="record_find.jsp" target="right">查询考勤记录</a></p> 
        <p><a href="record_clean.jsp" target="right">清空考勤记录</a></p>
 		<p><a href="CountWithDate" target="right">查看出勤分布</a></p>
 		<!--下面是注销按钮--> 
<input type="button" style="background:lightblue" value="注销" onClick="top.location.href='login.jsp'">
</body>
</html>