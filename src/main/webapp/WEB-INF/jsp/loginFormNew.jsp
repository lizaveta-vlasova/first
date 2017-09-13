<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="../../assets/stylesheets/loginFormNew.css"%>
    </style>
    <script src="<c:url value="../../assets/lib/jquery-3.2.1.js" />"></script>
    <script src="<c:url value="../../assets/javascript/login.js" />"></script>

    <title>Title</title>
</head>
<body>
<div class="body"></div>
<div class="grad"></div>
<div class="header">
    <div>Вход/<span>Авторизация</span></div>
</div>
<br>
<div class="login">
    <%--<form id="loginForm" action="login"  method="get" onsubmit="login();" >--%>
    <form id="loginForm" action="javascript:void(null);" method="get" onsubmit="login();">
        <input type="text" placeholder="email" name="email" id="email"><br>
        <input type="password" placeholder="password" name="password" id="password"><br>
        <button type="submit" name="button" value="Войти" id="entry">Войти</button>
        <input type="hidden" name="authorization" value="Basic MTIzQHlhLnJ1OjEyMzQ1" />
    </form>
</div>
</body>
</html>
