<%--
  Created by IntelliJ IDEA.
  User: Erwan
  Date: 10/12/2019
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Liste des salles</title>
</head>
<body>
<div class="container">
    <%-- Tableau à remplacer par un foreach --%>
    <div class="row pt-4 pb-4">
        <h1>Liste des salles</h1>
    </div>
    <div class="row">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Salle</th>
                <th scope="col">Impression PDF</th>
                <th scope="col">Réservations</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">211</th>
                <td><a href="lienspdf">lien</a></td>
                <td><a href="lienspdf">Voir les réservations</a></td>
            </tr>
            <tr>
                <th scope="row">106</th>
                <td><a href="lienspdf">lien</a></td>
                <td><a href="lienspdf">Voir les réservations</a></td>
            </tr>
            <tr>
                <th scope="row">207</th>
                <td><a href="lienspdf">lien</a></td>
                <td><a href="lienspdf">Voir les réservations</a></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

</body>
<script src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/js/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>
