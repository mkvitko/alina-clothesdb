<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
<h3>Добавить новую категорию</h3>
<form:form method="POST" action="/addCategory" modelAttribute="clotheCategory" enctype="multipart/form-data">
    <table>
        <tr>
            <td><form:label path="name">Название</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="path">Путь к папке</form:label></td>
            <td><form:input path="path"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Добавить"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>