<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--
  Created by IntelliJ IDEA.
  User: Megan
  Date: 5/8/2017
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link href="../../resources/styles.css" rel="stylesheet">

</head>
<body>

    <h1>Welcome to The Java Bean</h1>
    <p class="lead"><a href='/registration'>Create an Account</a><br></p>

    <table>
    <c:forEach items="${addStuff}" var="list">
        <tr>
            <td><c:out value="${list}"></c:out></td>
        </tr>
    </c:forEach>
    </table>


</body>
</html>
