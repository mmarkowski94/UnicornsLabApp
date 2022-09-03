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
        <th>Nazwa</th>
        <th>Opis</th>

    </tr>
    <c:forEach items="${projects}" var="project">
    <tr>
        <td>${project.name}</td>
        <td>${project.description}</td>

        <td><a href="/project/list/${project.id}/join">dołącz</a></td>
        <td><a href="/project/list/${project.id}/leave">zrezygnuj</a></td>
        <td><a href="/project/${project.id}/details">więcej</a></td>
        <br>
        </c:forEach>
</table>
<a href="/project/add">Dodaj nowy projekt</a>
</body>
</html>
