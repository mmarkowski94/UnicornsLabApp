<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Utwórz swój profil</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    <label>Zarejestruj się:</label><br/>
    name
    <form:input path="name" />
    <form:errors path="name"/>
    surname
    <form:input path="surname"/>
    <form:errors path="surname"/>
    email
    <form:input path="email"/>
    <form:errors path="email"/>
    password
    <form:password path="password"/>
    <form:errors path="password"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
