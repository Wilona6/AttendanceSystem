<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加考勤记录页面</title>
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
<form action= "AddRecord"  method="post">
<table border="0" width="400" align="center" valign="center" height="300">
<tr></tr>
<tr></tr>
<tr></tr>
<tr> <td>学号：</td> <td><input type="text" name="id"></td> </tr>
<tr> <td>日期：</td> <td><input type="date" name="date" format="yyyy-MM-dd"></td> </tr>
<!--考勤情况-->
 <tr>
 <td align="right">是否考勤:</td>
 <td><input type="radio" name ="attend" value="1" checked="checked">出勤
     <input type="radio" name ="attend" value="0" >缺勤
     </td>
     <td style="color:Darkblue;font-size:14px;font-family:Trebuchet MS">请选择是否考勤！</td> 
 </tr>
<tr align="center">
<td colspan="2">
<input  type="submit" value="提  交"> &nbsp;&nbsp;&nbsp;
<input  type="reset" value="取  消">
 </td>
</tr>

</table>
</form>

<div id="footer">
            版权所有@YOYO&Hzd&nbsp;&nbsp;<br class="mbr">
            北京信息科技大学健翔桥校区&nbsp;&nbsp;
            </div>
</body>
</html>