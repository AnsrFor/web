<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
	<p>${sessionScope.realpath }</p>
	<p>${sessionScope.filename }</p>
	<img src="${sessionScope.filename }" width="200px" />
</body>
</html>