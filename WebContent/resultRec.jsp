<%@page import="model.Record"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr><th>id</th>
<th>日期</th>
<th>出勤情况</th>
</tr>

<%
List list=(List)request.getAttribute("list");
for(Iterator it=list.iterator();it.hasNext();){%>
<% 	Record record=(Record)it.next();
%>
<tr>
<td><%=record.getId() %></td>
<td><%=record.getDate() %></td>
<td><%=record.getAttend() %></td>
</tr>
<%} %>
</table>
</body>
</html>