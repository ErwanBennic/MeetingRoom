<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Genevee
  Date: 14/01/2020
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>accueil</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">MeetingRoom</a>
    <span class="navbar-text">
      <a href="${pageContext.request.contextPath}/admin/roomlist"><button class="btn btn-outline-success">Admin</button></a>
    </span>
</nav>

<div class="container text-center mt-5">
    <h1>Bienvenue sur MeetingRoom</h1>
    <hr>
    <h3>Vous pouvez directement scanner un QrCode pour arriver au formulaire de reservation</h3>

    <div class="card-deck mt-5">
        <c:forEach items="${salles}" var="salle">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Salle ${salle.lib}</h5>
                <a href="${pageContext.request.contextPath}/user/form/${salle.lib}">Faire un reservation</a>
            </div>
        </div>
        </c:forEach>
    </div>




</div>
</body>
<script src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/js/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>
