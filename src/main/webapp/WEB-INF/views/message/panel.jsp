<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wiadomości</title>
</head>
<body>
<table>
    <tr>
        <th>Nieprzeczytane</th>
    <tr>
        <th>Tytuł</th>
        <th>Nadawca</th>
        <th>Treść</th>
        <th>Data</th>

    </tr>

    </tr>
    <c:forEach items="${messagesNoRead}" var="messageNoRead">
        <tr>
            <td>${messageNoRead.title}</td>
            <td>${messageNoRead.sender}</td>
            <td>${messageNoRead.contents}</td>
            <td>${messageNoRead.timeSending}</td>
            <td><a href="<c:url value="/message/panel/change/${messageNoRead.id}"/>">odczytaj</a></td>
            <td><a href="<c:url value="/message/panel/delete/${messageNoRead.id}"/>">usuń</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<table>
    <tr>
        <th>Przeczytane</th>
    <tr>
        <th>Tytuł</th>
        <th>Nadawca</th>
        <th>Treść</th>
        <th>Data</th>
    </tr>

    </tr>
    <c:forEach items="${messagesRead}" var="messageRead">
        <tr>

            <td>${messageRead.title}</td>
            <td>${messageRead.sender}</td>
            <td>${messageRead.contents}</td>
            <td>${messageRead.timeSending}</td>
            <td><a href="<c:url value="/message/panel/change/${messageRead.id}"/>">dodaj do nieprzeczytanych</a></td>
            <td><a href="<c:url value="/message/panel/delete/${messageRead.id}"/>">usuń</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
