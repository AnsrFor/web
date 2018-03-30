<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>移除application范围的属性</title>
</head>
<body>
	<%
		application.removeAttribute("addinfo");
		application.removeAttribute("appInfo2");
	%>
</body>
</html>