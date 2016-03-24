<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<form:form method="POST" action="/addClothe" modelAttribute="clotheInfo">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="id">Id</form:label></td>
        </tr>
        <tr>
            <td><form:label path="oldPrice">Old Price</form:label></td>
            <td><form:input path="oldPrice"/></td>
        </tr>
        <tr>
            <td><form:label path="newPrice">New Price</form:label></td>
            <td><form:input path="newPrice"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>