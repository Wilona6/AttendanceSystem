<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language ="javascript">
function test(){
	var student_id=document.forms[0].student_id.value;
	var student_password=document.forms[0].student_password.value;
	var student_password1=document.forms[0].student_password1.value;
	var accept=document.forms[0].accept.checked;
	var reg1=/[2][0][1][8][0-9][0-9]\w*/;
	if(accept!==true) alert("请您仔细阅读并同意用户使用协议！");
	else if(student_id.length<=0) alert("学号不能为空！");
    else if(!reg1.test(student_id)) alert("学号格式不正确！");
    else if(student_password.length<6) alert("密码长度必须大于等于6");
    else if(student_password1!=student_password) alert("两次密码不一致！");
    else document.forms[0].submit();
}
</script>
<title>学生注册页面</title>
</head>
<body bgcolor=Seashell>
<h2 align="center">学生信息注册</h2>
<form name="stu" action="Register" method="post">

<!--下面是绘制一条直线-->
<hr size="1px" align="center" color="pink" width="100%"/>

<!--下面是学号-->
<table border="0" align="center" width="600">
 <tr><td align="right">学号:*</td>
     <td><input type="text" name="student_id"/></td>
     <td style="color:Darkblue;font-size:14px;font-family:Trebuchet MS">以2018开头！至少六位！</td>
 </tr>
 
<!--下面是密码-->
 <tr><td align="right">密码:*</td>
     <td><input type="password" name="student_password"></td>
 <td style="color:Darkblue;font-size:14px;font-family:Trebuchet MS">设置登录密码，至少六位！</td>    
 </tr>
 
 <!--下面是确认密码-->
  <tr><td align="right">确认密码:*</td>
     <td><input type="password" name="student_password1"></td>
 <td style="color:Darkblue;font-size:14px;font-family:Trebuchet MS">请再次输入一次的密码！</td>    
 </tr>
 
 <!--下面是用户使用协议--> 
 <tr><td colspan="3" align="center" height="70">
    <input type="checkbox" name = "accept"/>
    我已经仔细阅读并同意接受用户使用协议
    </td>
</tr>

<!--下面是注册按钮-->
 <tr><td colspan="3" align="center" height="40"><input type="button" style="background:lightblue" value="注册" onClick="test()"></td></tr>
</table>
</form>
</body>
</html>