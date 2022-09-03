<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj projekt</title>
</head>
<body>
<form:form method="post" modelAttribute="project">
    <label>Opisz nowy projekt</label><br/><br>
    nazwa
    <form:input path="name" />
    <form:errors path="name"/><br>
    opis<br>
    <form:textarea path="description"/>
    <form:errors path="description"/><br>
    cel projektu<br>
    <form:input path="thePurposeOfTheProject"/>
    <form:errors path="thePurposeOfTheProject"/><br>
    Wymagana ilość osob<br>
    <form:input type = "number"  min="1" path="numberOfPeopleNeeded"/>
    <form:errors path="numberOfPeopleNeeded"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
