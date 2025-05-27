<%--
  Created by IntelliJ IDEA.
  User: pepew
  Date: 20/5/2025
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<div class="login-container">
    <h1>Login de usuario</h1>
    <form action="login" method="post">
        <label for="username">Nombre de usuario:</label>
        <input type="text" name="username" id="username" required>

        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required>

        <input type="submit" value="Enviar">
    </form>
</div>
</body>
</html>
