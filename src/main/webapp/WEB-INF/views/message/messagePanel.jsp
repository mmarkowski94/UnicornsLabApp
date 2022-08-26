
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Nieprzeczytane</th>


    </tr>
    <c:forEach items="${messagesNoReaded}" var="messageToRead">
        <tr>
            <td>${messageToRead.title}</td>
        </tr>
    </c:forEach>
</table>
<br>
<table>
    <tr>
        <th>Przeczytane</th>


    </tr>
    <c:forEach items="${messagesReaded}" var="messageReaded">
        <tr>
            <td>${messageReaded.title}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
