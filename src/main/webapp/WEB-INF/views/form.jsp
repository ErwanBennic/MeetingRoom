<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Genevee
  Date: 09/12/2019
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="icon" href="${pageContext.request.contextPath}/assets/images/meeting.png"/>
    <title>Formulaire</title>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center mt-3">
            <h1>Réservation de salle</h1>
        </div>
        <hr>
        <br>
        <div class="row justify-content-center">
            <div class="col-6">
                <form action="/MeetingRoom/user/ajoutresa" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="datedebut">Date de début</label>
                            <input type="datetime-local" name="date_debut" class="form-control" id="datedebut" placeholder="Date">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="datefin">Date de fin</label>
                            <input type="datetime-local" name="date_fin" class="form-control" id="datefin" placeholder="Date">
                        </div>
                        <p>${invalide}</p>
                    </div>
                    <div class="form-group">
                        <label for="nomresa">Nom de la réservation</label>
                        <input type="text" name="nom" class="form-control" id="nomresa" placeholder="John Doe">
                    </div>
                    <div class="form-group">
                        <label for="description">Description</label>
                        <textarea class="form-control" id="description" name="description" rows="3"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="emails">Emails des participants</label>
                        <textarea class="form-control" id="emails" name="emails" rows="3"></textarea>
                    </div>
                    <input type="hidden" name="salle" value="${salle}">
                    <hr>
                    <div class="row justify-content-center">
                        <button type="submit" class="btn btn-primary">Envoyer</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
<script src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/js/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/js/formEmail.js"></script>
</html>

