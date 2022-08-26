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
