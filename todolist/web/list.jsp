<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>待办事项</title>
</head>
<body>
    <table>
        <tr>
            <th>序号</th>
            <th>内容</th>
        </tr>
        <c:forEach var="item" items="${list}" >
            <tr>
                <td><c:out value="${item.id}"/></td>
                <td><c:out value="${item.content}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>