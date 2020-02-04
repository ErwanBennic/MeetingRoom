<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Erwan
  Date: 11/12/2019
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="icon" href="${pageContext.request.contextPath}/assets/images/meeting.png"/>
    <title>Réservation</title>
</head>
<body>

<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">MeetingRoom</a>
    <span class="navbar-text">
      <a href="${pageContext.request.contextPath}/admin/roomlist"><button class="btn btn-outline-success">Admin</button></a>
    </span>
</nav>

<div class="container mt-3">
    <div class="row">
        <h1>Réservation pour la salle ${salle} :</h1>
    </div>

    <div class="row pt-4 pb-4">
        <form method="post" action="reservation">
                <input type="date" class="form-control" name="dateFrom" value="${dateUser}">
            <hr>
                <button type="submit" class="btn btn-outline-primary">Rechercher</button>
            <input type="hidden" name="id" value="${salle}">
        </form>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nom</th>
                <th scope="col">Description</th>
                <th scope="col">Heure de début</th>
                <th scope="col">Heure de fin</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${reservations}" var="resa">
                <tr>
                    <td>${resa.id}</td>
                    <td>${resa.nom}</td>
                    <td>${resa.description}</td>
                    <td><fmt:formatDate value="${resa.date_debut}" pattern="HH:mm" /></td>
                    <td><fmt:formatDate value="${resa.date_fin}" pattern="HH:mm" /></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="row">
        <a href="${pageContext.request.contextPath}/admin/roomlist">Retour</a>
    </div>
</div>

</body>
<script src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/js/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>
