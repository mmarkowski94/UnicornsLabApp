<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="skills" action="/user/addSkills">
<form:checkboxes items="${skills}" path="skills"/>
<input type="submit" value="Save">
</form:form>
</body>
</html>
