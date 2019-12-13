<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="icon" href="${pageContext.request.contextPath}/assets/images/meeting.png"/>
    <title>Liste des salles</title>
</head>
<body>
<div class="container">
    <div class="row pt-4 pb-4">
        <h1>Liste des salles</h1>
        ${pageContext.request.userPrincipal.name}
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
            <c:forEach items="${salles}" var="salle">
                <tr>
                    <td>${salle.lib}</td>
                    <td><a href="<c:url value="/pdf/${salle.lib}"/>">Impression PDF</a></td>
                    <td>
                        <form action="reservation" method="post">
                            <input type="hidden" name="id" value="${salle.lib}">
                            <button type="submit">Voir</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
<script src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/js/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>
