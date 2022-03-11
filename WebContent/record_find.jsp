<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询考勤记录页面</title>
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
<form action= "ShowRecord"  method="post">
<table border="0" width="400" align="center" valign="center" height="200">
<tr></tr>
<tr></tr>
<tr></tr>
<h2 align=center>请输入查询条件</h2>
<tr> <td>学号：</td> <td><input type="text" name="id"></td> </tr>
<tr> <td>日期：</td> <td><input type="date" name="date" format="yyyy-MM-dd"></td> </tr>

<tr align="center">
<td colspan="2">
<input  type="submit" value="提  交"> &nbsp;&nbsp;&nbsp;
<input  type="reset" value="取  消">

<div id="footer">
            版权所有@YOYO&Hzd&nbsp;&nbsp;<br class="mbr">
            北京信息科技大学健翔桥校区&nbsp;&nbsp;
            </div>
             </td>
</tr>
</table>
</form>
</body>
</html>