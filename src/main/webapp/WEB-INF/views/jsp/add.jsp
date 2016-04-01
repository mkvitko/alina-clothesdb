<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page errorPage="/WEB-INF/views/jsp/error.jsp" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
<h3>Добавить новую одежду</h3>
<form:form method="POST" action="/addClothe" modelAttribute="clotheInfo" enctype="multipart/form-data">
    <table>
        <tr>
            <td><form:label path="name">Название</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="oldPrice">Старая цена</form:label></td>
            <td><form:input path="oldPrice"/></td>
        </tr>
        <tr>
            <td><form:label path="newPrice">Новая цена</form:label></td>
            <td><form:input path="newPrice"/></td>
        </tr>
        <tr>
            <td><label path="category">Категория</label></td>
            <td>
                <form:select path="category" items="${categories}" itemLabel="name" itemValue="id"/>
            </td>
        </tr>
        <tr>
            <td><form:label path="urlToVKImage">Ссылка Вконтакте</form:label></td>
            <td><form:input path="urlToVKImage"/></td>
        </tr>
        <tr>
            <td><label for="imageFile">Картинка</label></td>
            <td><input id="imageFile" type="file" name="imageFile"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Добавить"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>