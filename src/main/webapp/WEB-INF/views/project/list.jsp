<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Projekty</title>
</head>
<body>
<table>
    <tr>
        <th>name</th>
        <th>description</th>
        <th>team</th>

    </tr>
    <c:forEach items="${projects}" var="project">
        <tr>
            <td>${project.name}</td>
            <td>${project.description}</td>


            <td>
                <a href="<c:url value="/project/delete/${project.id}"/>">usuń</a>
                <a href="<c:url value="/project/edit?id=${project.id}"/>">edytuj</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
