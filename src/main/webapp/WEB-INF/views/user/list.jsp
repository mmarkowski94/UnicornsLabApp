<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/user/register"/>">Dołącz</a>
<table>
    <tr>
        <th>name</th>
        <th>surname</th>

    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.surname}</td>


            <td>
                <a href="<c:url value="/user/delete/${user.id}"/>">usuń</a>
                <a href="<c:url value="/user/edit?id=${user.id}"/>">edytuj</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
