<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edytuj dane osobowe</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    <label>Zmień dane</label><br/>
    <form:hidden path="id"/>
    <form:hidden path="details.id"/>
    name<br>
    <form:input path="name"/><br>
    <form:errors path="name"/>
    surname<br>
    <form:input path="surname"/><br>
    <form:errors path="surname"/>
    email<br>
    <form:input path="email"/><br>
    <form:errors path="email"/>
    <form:hidden path="password"/><br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
