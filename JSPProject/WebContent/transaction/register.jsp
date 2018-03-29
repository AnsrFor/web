<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册界面</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/registerServlet" method="post">
		注册用户名：<input type="text" name="regName" /> <br/><br/>
		注册密码：<input type="password" name="regPwd" /> <br/><br/>
		<input type="submit" value="注册" />
		<input type="reset" value="重置" />
	</form>
</body>
</html>