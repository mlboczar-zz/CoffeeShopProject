<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Megan
  Date: 5/15/2017
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <title>Item Admin</title>

    <link href="../../resources/styles.css" rel="stylesheet">

</head>
<body>

<table>
    <c:forEach items="${itemsList}" var="items">
        <tr>
            <td><c:out value="${items.itemid}"/></td>
            <td><c:out value="${items.name}"/></td>
            <td><c:out value="${items.description}"/></td>
            <td><c:out value="${items.quantity}"/></td>
            <td><c:out value="${items.price}"/></td>
            <td><a href="delete?id=${items.itemid}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
