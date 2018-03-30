<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册用户</title>
<script type="text/javascript" src="../js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(function(){
		$("#registername").blur(function(){
			$.get("/AjaxProject/checkServlet",{"registerName":$("#registername").val()},
					function(data){
					$("#msg").html(data);
			});
		});
	});
</script>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/registerServlet" method="post">
		注册用户名：<input type="text" id="registername" name="regName" />
		<span id="msg" style="color:red"></span><br/><br/>
		注册密码：<input type="text" name="regPwd" /><br/><br/>
		<input type="submit" value="注册" />
	</form>
</body>
</html>