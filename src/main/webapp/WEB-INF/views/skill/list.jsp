<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <table>
        <tr>
            <th>Lista umiejętności</th>


        </tr>
        <c:forEach items="${skills}" var="skill">
            <tr>
                <td>${skill.name}</td>
                <td>
                    <a href="<c:url value="/skill/delete/${skill.id}"/>">usuń</a>
                </td>
            </tr>
        </c:forEach>
    </table>

<form method="post" action="/skill/list">
    <label for="skill">Wpisz nazwę umiejętności którą chcesz dodać</label>
    <input id="skill" type="text" name="skill"/>
    <input type="submit"/>
</form>
</body>
</html>
