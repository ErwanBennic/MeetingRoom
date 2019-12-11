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
        <div class="row pt-4 pb-4 justify-content-center">
            <h1>Réservation de salle</h1>
        </div>
        <div class="row justify-content-center">
            <div class="col-6">
                <form action="ajoutresa" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">Date de début</label>
                            <input type="datetime-local" class="form-control" id="inputEmail4" placeholder="Date">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">Date de fin</label>
                            <input type="datetime-local" class="form-control" id="inputEmail5" placeholder="Date">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword4">Prénom, Nom</label>
                        <input type="text" class="form-control" id="inputPassword4" placeholder="John Doe">
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">Description</label>
                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="inputAddress2">Email des participants</label>
                        <input type="text" class="form-control" id="inputAddress2" placeholder="Rentrez un email">
                        <div class="row justify-content-center pt-4">
                            <button type="button" class="btn btn-primary btn-sm">Ajouter un email</button>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="gridCheck">
                            <label class="form-check-label" for="gridCheck">
                                Je souhaite aussi recevoir un email de confirmation.
                            </label>
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <button type="submit" class="btn btn-primary">Sign in</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
<script src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/js/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>
