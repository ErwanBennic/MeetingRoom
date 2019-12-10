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
          <c:forEach items="${result}" var="res">
              <tr>
                  <td>${res.id}</td>
                  <td>${res.nom}</td>
                  <td>${res.telephone}</td>
                  <td>${res.dateEmission}</td>
              </tr>
          </c:forEach>

          </tr>
      </table>

      <a href="<c:url value="/preparation"/>">Commande suivante</a>
      <br>
      <a href="<c:url value="/form"/>">Commander</a>
  </div>

  </body>
</html>