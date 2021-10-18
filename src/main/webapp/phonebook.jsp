<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Telefonbuch Informatik</title>
    </head>
    <body>
        <h1>Telefonbuch Informatik</h1>
        <c:forEach var="person" items="${phoneBook.getPersons()}">
           <h2>${person.name}</h2>
           <p>Phone: ${person.phoneNumber}</p>
           <a href="editPerson.jsp?name=${person.name}&phone=${person.phoneNumber}">Edit</a>
           <a href="removePerson?name=${person.name}">Remove</a>
        </c:forEach>
        <h2>Neue Person</h2>
        <form action="addPerson" method="post">
            <p>Name: <input type="text" name="name" /></p>
            <p>Phone: <input type="text" name="phone" /></p>
            <p><input type="submit" value="Add" /></p>
        </form>
    </body>
</html>