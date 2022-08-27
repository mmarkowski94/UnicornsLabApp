<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UnicornsLab</title>
    <link href="<c:url value="/resources/theme/style.css" />" rel="stylesheet">
</head>
<body>
<h1 class="title">Witamy w UnicornsLab</h1>
<ul class="menu">
    <li><a href=""> O nas </a></li>
    <li><a href="/user/list">Zespoł</a></li>
    <li><a href="/project/list">Projekty</a></li>
    <li><a href="/message/send">Kontakt</a></li>
    <li><a href="/message/panel">Wiadomości</a></li>
    <li><a href="/user/register">Dołącz do nas</a></li>
    <li><a href="/user/login">Logowanie</a></li>
    <li><a href="/user/panel">Panel użytkownika</a></li>
    <li><a href="/skill/list">Lista umiejętności</a></li>
</ul>
<hr>
</body>
</html>
