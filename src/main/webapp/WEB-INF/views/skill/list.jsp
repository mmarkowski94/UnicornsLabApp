<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj umiejętności</title>
</head>
<body>

<tr>
    <th>Twoje umiejętności</th>
</tr>
<c:forEach items="${currentSkills}" var="currentSkill">
    <p> ${currentSkill.name}</p>
</c:forEach>

<table>
    <tr>
        <th>Dodaj umiejętności</th>
    </tr>
    <c:forEach items="${skills}" var="skill">
        <tr>
            <td>${skill.name}</td>
            <td>
                <a href="/skill/list/${skill.id}/add">Dodaj umiejętnośc</a>
                <a href="/skill/list/${skill.id}/delete">Usuń umiejętnośc</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
