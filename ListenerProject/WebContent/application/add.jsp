<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>设置application范围的属性</title>
</head>
<body>
	<%
		application.setAttribute("appInfo","这是application范围的属性值");
		application.setAttribute("appInfo2","这是application范围的属性值2");
	%>
</body>
</html>