<%@page import="session.MySessionUtil"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>通过sessionid查找session</title>
</head>
<body>
	<%
		HttpSession hs = MySessionUtil.getSessionById("10AE2832F6968D548F765DF88845E706");
		Object obj = hs.getAttribute("sessionInfo");
	%>
	<h3>获取到的session属性值是：<%=obj%></h3>
</body>
</html>