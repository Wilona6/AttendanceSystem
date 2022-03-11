<%@page import="model.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<table border="1" align="center">
<tr><th>id</th>
<th>密码</th>
<th>出勤次数</th>
<th>总次数</th>
</tr>
<%
Student student=(Student)request.getAttribute("student");
%>
<tr>
<td><%=student.getId()%></td>
<td><%=student.getPwd()%></td>
<td><%=student.getAttend_num() %></td>
<td><%=student.getTotal_num() %></td>
</tr>

</table>
<!--下面是注销按钮--> 
 <table border="0" align="center" width="500">
<tr><td colspan="3" align="center" valign="middle" height="400">
<input type="button" style="background:lightblue"  value="注销" onClick="top.location.href='login.jsp'">
</td></tr>
</table>
</body>
</html>