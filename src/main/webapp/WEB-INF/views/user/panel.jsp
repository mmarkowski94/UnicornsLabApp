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



            Stanowisko:
            <td>${details.position}</td><br>
            Zespoł:
            <td>${details.team}</td><br>
            Opis:
            ${details.description}<br>


</body>
</html>
