<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>panel</p>
<p>Cześć ${user.name}</p>
Twoj profil<br>
<br>
Imię:<td>${user.name}</td><br>
Nazwisko:<td>${user.surname}</td><br>
Mail:<td>${user.email}</td><br>
<br>
<br>
<a href="/user/edit">Edytuj dane</a></li>
<br>

            Stanowisko:
            <td>${details.position}</td><br>
            Zespoł:
            <td>${details.team}</td><br>
            Opis:
            ${details.description}<br>
<br>

<a href="/user/editDetails">Edytuj dane szczegółowe</a></li>
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
<a href="/skill/list">dodaj umiejętności</a></li>
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
    <a href="/skill/list">Dołącz do projektów</a></li>
    <br>
    <c:if test= "${user.isAdmin} == true}">
        <li><a href="/skill/admin/list">Lista umiejętności</a></li>
        <li><a href="/message/panel">Wiadomości</a></li>
    </c:if>
</table>
</body>
</html>
