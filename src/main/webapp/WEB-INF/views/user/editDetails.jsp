<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edytuj szczegółowy opis</title>
</head>
<body>
<form:form method="post" modelAttribute="userDetails" action="/user/editDetails">
    <label>Zmień dane</label><br/>
    <form:hidden path="id"/>
    Stanowisko<br>
    <form:input path="position"/><br>
    <form:errors path="position"/>
    Zespół<br>
    <form:input path="team"/><br>
    <form:errors path="team"/>
    Opis<br>
    <form:textarea path="description"/><br>
    <form:errors path="description"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
