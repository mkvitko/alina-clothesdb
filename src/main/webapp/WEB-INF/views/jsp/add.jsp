<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<form:form method="POST" action="/addClothe" modelAttribute="clotheInfo" enctype="multipart/form-data">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
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
            <td><form:label path="urlToVKImage">Link to VK</form:label></td>
            <td><form:input path="urlToVKImage"/></td>
        </tr>
        <tr>
            <td><label for="imageFile">Image</label>
            <input id="imageFile" type="file" name="imageFile"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>