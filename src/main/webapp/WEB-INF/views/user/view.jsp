<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${user.surname}
${user.name}<br>
<br>
Stanowisko:
<td>${details.position}</td><br>
Zespoł:
<td>${details.team}</td><br>
Opis:
${details.description}<br>
<br>
<br>
<br>
<table>
    <tr>
        <th>Lista umiejętności</th>
    </tr>
    <c:forEach items="${skills}" var="skill">
        <tr>
            <td>${skill.name}</td>
        </tr>
    </c:forEach>
</table>
<br>
<br>
<br>
<table>
    <tr>
        <th>Lista projektow</th>
    </tr>
    <c:forEach items="${projects}" var="project">
        <tr>
            <td>${project.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</body>
</html>
