<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Erwan
  Date: 10/12/2019
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connection</title>
    <link rel="icon" href="${pageContext.request.contextPath}/assets/images/meeting.png"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/signin.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body class="text-center">
    <div class="container">
        <div class="row justify-content-center">
            <img class="mb-4" src="${pageContext.request.contextPath}/assets/images/meeting.png" alt="" width="72" height="72">
        </div>
        <div class="row justify-content-center">
            <h1><b>Meeting-Room</b></h1>
        </div>
        <form class="form-signin" method="POST" action="j_security_check">
            <h1 class="h3 mb-3 font-weight-normal">Connectez-vous</h1>
            <label for="inputEmail" class="sr-only">Adresse Email</label>
            <input type="email" name="j_username" id="inputEmail" class="form-control" placeholder="Adresse Email" required autofocus>
            <label for="inputPassword" class="sr-only">Mot de passe</label>
            <input type="password" name="j_password" id="inputPassword" class="form-control" placeholder="Mot de passe" required>
            <div class="checkbox mb-3">
                <label>
                    <input type="checkbox" value="remember-me"> Se souvenir de moi
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Connexion</button>
            <p class="mt-5 mb-3 text-muted">&copy; 2019</p>
        </form>
    </div>
</body>
<script src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/js/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>
