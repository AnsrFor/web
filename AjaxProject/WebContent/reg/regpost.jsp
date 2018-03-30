<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册用户</title>
<script type="text/javascript">
	function getXHR(){
		var xhr = null;
		if(window.XMLHttpRequest){
			xhr = new XMLHttpRequest();
		}else{
			xhr = new ActiveXObject("Microsoft.XMLHttp");
		}
		return xhr;
	}
	
	function checkUser(obj){
		var regName = obj.value;//获取填写的注册用户名
		var xhr = getXHR();//获取Ajax对象
		xhr.open("post","/AjaxProject/checkServlet",true);
		//post请求时必须设置请求头消息
		xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
		//绑定onreadystatechange事件
		xhr.onreadystatechange=function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					var txt = xhr.responseText;//获取后台传来的相应文本
					document.getElementById("msg").innerHTML = txt;
				}
			}
		};
		xhr.send("registerName=" + regName);//发送请求
	}
</script>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/registerServlet" method="post">
		注册用户名：<input type="text" name="regName" onblur="checkUser(this)" />
		<span id="msg" style="color:red"></span><br/><br/>
		注册密码：<input type="password" name="ragPwd" /><br/><br/>
		<input type="submit" value="注册" />
	</form>
</body>
</html>