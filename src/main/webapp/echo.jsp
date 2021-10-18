<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Parameter Listing Example</title>
</head>
    <body>
        <p>Parameter values passed to this page for each parameter: </p>
        <table>
            <c:forEach var="current" items="${param}">
                <tr>
                    <td>
                        <b>${current.key}</b>
                    </td>
                    <c:forEach var="aVal" items="${paramValues[current.key]}">
                        <td>${aVal}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>

        <p>Headers passed to this page: </p>
        <table>
            <c:forEach var="current" items="${header}">
                <tr>
                    <td>
                        <b><c:out value="${current.key}" /></b>
                    </td>
                    <c:forEach var="aVal" items="${headerValues[current.key]}">
                        <td><c:out value="${aVal}" /></td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
</body>
</html>