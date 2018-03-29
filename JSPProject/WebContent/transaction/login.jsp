<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录界面</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/loginServlet" method="post">
		用户名：<input type="text" name="logName" /> <br/><br/>
		密码：<input type="password" name="logPwd" /> <br/><br/>
		<input type="submit" value="登录" />
		<input type="reset" value="重置" />		
	</form>
</body>
</html>