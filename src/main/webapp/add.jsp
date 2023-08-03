<%--
  Created by IntelliJ IDEA.
  User: pb
  Date: 8/3/23
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Create new user</h2>
<form action="./add" method="post">
    <label for="username">username: </label>
    <input type="text" id="username" name="username" required>
    <br>
    <label for="email">email: </label>
    <input type="email" id="email" name="email" required>
    <br>
    <label for="age">age (optional): </label>
    <input type="number" id="age" name="age">
    <br>
    <button type="submit">Submit your info</button>
</form>
</body>
</html>
