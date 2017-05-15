<%--
  Created by IntelliJ IDEA.
  User: Megan
  Date: 5/15/2017
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Item Admin</title>
</head>
<body>

<c:forEach items="${addStuff}" var="list">
    <tr>
        <td class="itemlist"><c:out value="${list}"></c:out></td>
    </tr>
</c:forEach>

</body>
</html>
