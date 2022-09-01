<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Szczególy projektu</title>
</head>
<body>
<table>
    <tr>
        <th>Nazwa</th>
        <th>Opis</th>
        <th>Cel projektu</th>
        <th>Ilość potrzebnych osób</th>
        <th>Data rozpoczęcia</th>
    <tr>
        <br>
        <td>${project.name}</td>
        <td>${project.description}</td>
        <td>${project.thePurposeOfTheProject}</td>
        <td>${project.numberOfPeopleNeeded}</td>
        <td>${project.startDate}</td>
</table>
<table>
    <tr>
        <th>Zespół</th>
        <c:forEach items="${project.team}" var="member">
    <tr>
        <br>
        <td>${member.name}</td>
        <td>${member.surname}</td>
        <br>
        </c:forEach>
</table>
<br>
<a href="/project/list">Wróc do listy projektów</a></li>

</body>
</html>
