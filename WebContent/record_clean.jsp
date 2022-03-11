<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除考勤记录页面</title>
<style>
#footer{
color:black;
clear:both;
text-align:center;
padding:1px;
left:42%;
position:absolute;
bottom:0;
font-size:10px;
}
</style>
</head>
<body>
<form action="CleanRecord"method="post">
<table border="0" align="center" width="500">

<tr><td colspan="3" align="center" height="250">
清空的记录无法找回，请谨慎操作!
</td></tr>

<!--下面是清空按钮--> 
<tr><td colspan="3" align="center" height="100">
<input type="button" style="background:lightblue" value="清空所有考勤记录" onClick="window.location.href='CleanRecord'">
</td></tr>
</table>
<div id="footer">
            版权所有@YOYO&Hzd&nbsp;&nbsp;<br class="mbr">
            北京信息科技大学健翔桥校区&nbsp;&nbsp;
            </div>
</form>
</body>
</html>