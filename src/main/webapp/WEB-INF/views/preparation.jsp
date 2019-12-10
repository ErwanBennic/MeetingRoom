<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pizza Spring</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <table class="table table-bordered">
        <tr>
            <th>id</th>
            <th>Nom</th>
            <th>Telephone</th>
            <th>Date Emission</th>
        </tr>
        <tr>
            <td>${commande.id}</td>
            <td>${commande.nom}</td>
            <td>${commande.telephone}</td>
            <td>${commande.dateEmission}</td>
        </tr>
    </table>

    <div style="text-align: center;">
        <ul class="list-group">
        <c:forEach items="${commande.pizzasList}" var="pizza">
            <li class="list-group-item active">${pizza.nom}</li>
            <c:forEach items="${pizza.ingredientList}" var="ingre">
                <li class="list-group-item">${ingre.nom}</li>
            </c:forEach>
            <br>
        </c:forEach>
        </ul>
    </div>

    <div>
        <a href="<c:url value="/"/>">Retour</a>
        <br>
        <form action="valideCommande" method="post">
            <input type="hidden" name="id" value="${commande.id}">
            <button type="submit">Valider</button>
        </form>

    </div>

</div>

</body>
</html>