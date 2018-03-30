<%@page import="session.SessionBindingListener"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>session属性设置值</title>
</head>
<body>
   <%
       session.setAttribute("sessionInfo","会话范围的属性值");
       SessionBindingListener sb=new SessionBindingListener();
       session.setAttribute("bindingInfo",sb);
   %>
</body>
</html>