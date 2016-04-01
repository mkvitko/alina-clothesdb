<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page errorPage="/WEB-INF/views/jsp/error.jsp" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
<h3>Редактировать одежду</h3>
<form:form method="POST" action="/editClothe" modelAttribute="clotheInfo" enctype="multipart/form-data">
    <table>
        <tr>
            <td><form:label path="name">Название</form:label></td>
            <td><form:input path="name">${clotheInfo.name}</form:input></td>
        </tr>
        <tr>
            <td><form:label path="oldPrice">Старая цена</form:label></td>
            <td><form:input path="oldPrice">${clotheInfo.oldPrice}</form:input></td>
        </tr>
        <tr>
            <td><form:label path="newPrice">Новая цена</form:label></td>
            <td><form:input path="newPrice">${clotheInfo.newPrice}</form:input></td>
        </tr>
        <tr>
            <td><label for="category">Категория</label></td>
            <td>
                <select name="category" id="category">
                    <c:forEach var="category" items="${categories}">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td><form:label path="urlToVKImage">Ссылка Вконтакте</form:label></td>
            <td><form:input path="urlToVKImage">${clotheInfo.urlToVKImage}</form:input></td>
        </tr>
        <tr>
            <td><label for="imageFile">Картинка</label></td>
            <td><input id="imageFile" type="file" name="imageFile"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Отредактировать"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>