<%--
  Created by IntelliJ IDEA.
  User: Megan
  Date: 5/8/2017
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>User Registration</title>
    <%--    <style>
            Any CSS code will go here
        </style>--%>
</head>
<body>

<h2>Please fill in the form to register!</h2>

<form:form method="POST" action="/addCustomer">
    <table>
        <tr>
            <td><form:label path="firstName">First Name</form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Last Name</form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td><form:label path="phoneNumber">Phone Number</form:label></td>
            <td><form:input path="phoneNumber"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:input type="password" path="password"/></td>
            <td><form:errors path="password" cssClass="error" /></td>
        </tr>
        <tr>
            <td colspan ="2">
                <input type="submit" value="Register"/></td>
        </tr>
    </table>
</form:form>

<%--<script>
    Javascript code goes here
</script>--%>
</body>
</html>

