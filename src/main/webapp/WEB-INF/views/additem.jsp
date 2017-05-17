<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Megan
  Date: 5/16/2017
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Add Item</title>
</head>
<body>

<form name="form" method="post" action="success">
    <table>
        <tr>
            <td><label for="itemid">ID: </label></td>
            <td><input type="text" id="itemid" name="itemid"><br></td>
        </tr>
        <tr>
            <td><label for="name">Name: </label></td>
            <td><input type="text" id="name" name="name"><br></td>
        </tr>
        <tr>
            <td><label for="description">Description: </label></td>
            <td><input type="text" id="description" name="description"><br></td>
        </tr>
        <tr>
            <td><label for="quantity">Quantity: </label></td>
            <td><input type="text" id="quantity" name="quantity"><br></td>
        </tr>
        <tr>
            <td><label for="price">Price: </label></td>
            <td><input type="text" id="price" name="price"><br></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save"/><br></td>
        </tr>
    </table>
</form>

</body>
</html>
