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
			$.ajax({
				method:"post",
				url:"/AjaxProject/checkServlet",
				data:{"registerName":$("#registername").val()},
				beforeSend:function(){
					alert("准备发送数据...");
				},
				success:function(data){
					$("#msg").html(data);
				}
			});
		});
	});
</script>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/registerServlet" method="post">
		注册用户名：<input type="text" id="registername" name="regname" />
		<span id="msg" style="color:red"></span><br/><br/>
		注册密码：<input type="password" name="regPwd" /><br/><br/>
		<input type="submit" value="注册" />
	</form>
</body>
</html>