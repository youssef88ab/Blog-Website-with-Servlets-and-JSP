<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <title>Login</title>
</head>
<body>
    <nav>
        <img src="logo.png" alt="Logo" id="logo">
        <ul class="nav-links">
            <li><a href="/home">Home</a></li>
            <li><a href="/about">About Us</a></li>
            <li><a href="/contact">Contact Us</a></li>
            <li><a href="/help">Help</a></li>
        </ul>
    </nav>

    <h1>Login</h1>
    <div class="login">
          <form action="${pageContext.request.contextPath}/login" method="POST">
            <input type="text"     name="Username" placeholder="Username" required>
            <input type="password" name="Password" placeholder="Password" required>
            <input type="submit"   value="Sign In" id="submit">
        </form>
    </div>

    <a href="#">Forgot Password?</a>
</body>
</html>