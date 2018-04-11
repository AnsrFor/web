<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java"%>
<%String realPath = session.getServletContext().getRealPath(""); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>$Title$</title>
</head>
<body>
	<h2>${sessionScope.realpath }</h2>
	<form action="${pageContext.servletContext.contextPath }/uploadServlet" method="post" name="form1" enctype="multipart/form-data">
		<input type="file" name="file1" />
		<button type="submit" name="btn">上传</button>
	</form>
</body>
</html>