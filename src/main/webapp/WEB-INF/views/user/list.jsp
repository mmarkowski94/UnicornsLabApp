<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zespół</title>
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
                <a href="<c:url value="/user/delete/${user.id}"/>">Usuń</a>
                <a href="<c:url value="/user/${user.id}/details"/>">Szczegoły</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
