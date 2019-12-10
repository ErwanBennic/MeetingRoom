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
    <title>form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
    <div class="container">
        <form action="traitement" method="post">
            <label>Nom :</label>
            <input class="form-control" type="text" name="nom">
            <label>Telephone :</label>
            <input class="form-control" type="text" name="telephone">
            <br>
            <select class="form-control" multiple name="listId">
                <c:forEach items="${pizzas}" var="pizza">
                    <option value="${pizza.id}">${pizza.nom}</option>
                </c:forEach>
            </select>
            <br>
            <a href="<c:url value="/"/>">Retour</a>
            <br>
            <button type="submit">Envoyer</button>
        </form>
    </div>
</body>
</html>
