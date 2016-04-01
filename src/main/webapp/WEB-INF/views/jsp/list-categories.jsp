<%--
  Created by IntelliJ IDEA.
  User: mkvitko
  Date: 3/29/16
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page errorPage="/WEB-INF/views/jsp/error.jsp" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Все категории</title>
</head>
<body>
<div align="center">
    <h1>Все категории</h1>
    <br>
    <form action="${pageContext.request.contextPath}/newCategory" method="get">
        <input type="submit" value="Добавить новую категорию"><br>
    </form>
    <form action="${pageContext.request.contextPath}/listClothe" method="get">
        <input type="submit" value="Назад к одежде"><br>
    </form>
    <style>
        td {
            text-align: center;
        }
    </style>
    <table border="1">
        <tr>
            <td>Название</td>
            <td>Путь к папке</td>
            <td>Редактировать</td>
            <td>Удалить</td>
        </tr>
        <c:forEach var="category" items="${allCategories}">
            <tr>
                <td>${category.name}</td>
                <td>${category.path}</td>
                <td>
                    <form:form action="/editCategory/${category.id}" method="post">
                        <input type="submit" value="Редактировать">
                    </form:form>
                </td>
                <td>
                    <form:form action="/removeCategory/${category.id}" method="post">
                        <input type="submit" value="Удалить">
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
