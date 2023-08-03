<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
        <body>
                <h2>All users are welcome:</h2>
                <p style="font-size: 10pt"><a href="./add">add a new user</a></p>
                <c:forEach var="user" items="${requestScope.users}">
                        <hr>
                        <p>
                                <c:out value="${user.id} - ${user.name} - ${user.email} - ${user.age}"/>
                        </p>
                </c:forEach>
        </body>
</html>
