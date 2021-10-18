<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Telefonbuch Informatik</title>
    </head>
    <body>
        <h1>Telefonbuch Informatik</h1>
 
        <h2>Person Editieren</h2>
        <form action="savePerson" method="post">
            <p>Name: <input type="text" name="name" value="${param.name}"/></p>
            <p>Phone: <input type="text" name="phone" value="${param.phone}"/></p>
            <p><input type="submit" value="Save" /></p>
        </form>
    </body>
</html>