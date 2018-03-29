<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>登录页面</title>
</head>
<body>
   <h3 style="color:red">${msg}</h3>
   <form action="${pageContext.servletContext.contextPath}/loginServlet" method="post">
       登录名：<input type="text" name="loginName"/><br/><br/>
       登录密码：<input type="password" name="loginPwd"/> <br/><br/>
       <input type="submit" value="登录"/>
   </form>
</body>
</html>