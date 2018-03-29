<%@page import="pojo.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>欢迎界面</title>
</head>
<body>
	<%
		User user = (User)session.getAttribute("user");
		if(user != null){
	%>
			<h3>欢迎<%=user.getName()%>访问本网站</h3>
	<% 
		}else{
	%>
			<h3>您还未登录，请先<a href="/JSPProject/transaction/login.jsp">登录</a></h3>
	<%
		}
	%>
</body>
</html>