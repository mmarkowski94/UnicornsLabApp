<%--
  Created by IntelliJ IDEA.
  User: mmarkowski
  Date: 22.08.2022
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie</title>
</head>
<body>
<form method="post" action="user/login">
    <label>Zaloguj się </label><br/>

    email
    <input type="text" name="email" placeholder="Podaj email"/><br>
    password
    <input type="password" name ="password" placeholder="Podaj hasło"/>
    <input type="submit" value="Zaloguj">

</form>
</body>
</html>
