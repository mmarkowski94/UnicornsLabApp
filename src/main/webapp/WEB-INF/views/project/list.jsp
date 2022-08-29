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

       <td><a href="/project/list/${project.id}/join">Join</a></td>

        <c:forEach items="${project.team}" var="member">
            <tr>
                <td>${member.name}</td>
                <td>${member.surname}</td>
            </tr>
        </c:forEach>
        <br>
    </c:forEach>
</table>
</body>
</html>
