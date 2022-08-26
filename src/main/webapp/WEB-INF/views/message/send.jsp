<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kontakt</title>
</head>
<body>
<form:form method="post" modelAttribute="message" action="/message/send">
    <label>Skontaktuj się z nami </label><br/>
    Podaj temat wiadomości<br/>
    <form:input path="title" />
    <form:errors path="title"/>
    Podaj swoję imię<br/>
    <form:input path="sender"/>
    <form:errors path="sender"/>
    Wpisz tresć swojej wiadomości<br/>
    <form:textarea path="contents"/>
    <form:errors path="contents"/>
    <input type="submit" value="Wyślj">
</form:form>
</body>
</html>
