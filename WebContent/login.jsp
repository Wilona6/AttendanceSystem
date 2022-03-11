<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language ="javascript">
function test(){
	var id=document.forms[0].id.value;
	var password=document.forms[0].password.value;
	if(id.length<=0) alert("学号不能为空！");
    else if(password.length<6) alert("密码长度必须大于等于6");
    else document.forms[0].submit();
}
</script>
<title>登录界面</title>
</head>
<body bgcolor=Seashell>
<script src="https://eqcn.ajz.miesnfu.com/wp-content/plugins/wp-3d-pony/live2dw/lib/L2Dwidget.min.js"></script>

<script>
    L2Dwidget.init({        "model": {  

          //jsonpath控制显示那个小萝莉模型，下面这个就是我觉得最可爱的小萝莉模型，替换时后面名字也要替换掉
            jsonPath: "https://unpkg.com/live2d-widget-model-koharu@1.0.5/assets/koharu.model.json",        

           "scale": 1
        },     

          "display": {      

            "position": "right", //看板娘的表现位置
            "width": 150,  //小萝莉的宽度
            "height": 300, //小萝莉的高度
            "hOffset": 0,     

            "vOffset": -20
        },       

           "mobile": {        

           "show": true,

           "scale": 0.5
        },

        "react": {

            "opacityDefault": 0.7,

            "opacityOnHover": 0.2
        }
    });</script>
<form action="LoginVal" method="post">
<h2 align="center">登 录</h2>
<!--下面是绘制一条直线-->
<hr size="1px" align="center" color="pink" width="100%"/>
<!--下面是用户号-->
 <table border="0" align="center" width="500">
 <tr><td align="right" valign="middle">用户号:</td>
     <td><input type="text" name="id"/></td>
     <td style="color:Darkblue;font-size:14px;font-family:Trebuchet MS">请输入用户号！</td>
 </tr> 
<!--下面是密码-->
 <tr><td align="right" valign="middle">密码:</td>
     <td><input type="password" name="password"></td>
 <td style="color:Darkblue;font-size:14px;font-family:Trebuchet MS">请输入密码！</td>    
 </tr>
<!--选择身份-->
 <tr>
 <td align="right">身份:*</td>
 <td><input type="radio" name ="identity" value="teacher" checked="checked">教师
     <input type="radio" name ="identity" value="student" >学生
     </td>
     <td style="color:Darkblue;font-size:14px;font-family:Trebuchet MS">请选择您的身份！</td> 
 </tr>
 
<!--下面是登录按钮-->
<tr><td colspan="3" align="center" valign="middle" height="40">
<input type="button" style="background:lightblue" value="登录" onClick="test()"/>&nbsp;
<!--下面是学生注册按钮--> 
<input type="button" style="background:lightgreen" value="注册" onClick="window.location.href='register.jsp'">
</td></tr>
</table>
</form>
</body>
</html>