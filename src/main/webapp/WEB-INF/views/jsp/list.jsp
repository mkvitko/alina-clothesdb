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
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
    <title>Вся одежда</title>
</head>
<body>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>
    <div align="center">
        <h1>Вся одежда</h1>
        <br>
        <form action="${pageContext.request.contextPath}/newClothe" method="get">
            <input type="submit" value="Добавить новую одежду"><br>
        </form>
        <form action="${pageContext.request.contextPath}/categories" method="get">
            <input type="submit" value="Просмотреть категории"><br>
        </form>
        <style>
            td {
                text-align: center;
            }
        </style>
        <table border="1">
            <tr>
                <td>Название</td>
                <td>Категория</td>
                <td>Старая цена</td>
                <td>Новая цена</td>
                <td>Фото</td>
                <td>Ссылка VK</td>
                <td>Дата добавления</td>
                <td>Редактировать</td>
                <td>Удалить</td>
            </tr>
            <c:forEach var="clothe" items="${allClothe}">
                <tr>
                    <td>${clothe.name}</td>
                    <td>${clothe.category.name}</td>
                    <td>${clothe.oldPrice}</td>
                    <td>${clothe.newPrice}</td>
                    <td>
                        <img alt="No photo" src="${pageContext.request.contextPath}/photo/${clothe.imageId}"
                             width="150" height="200"/>
                    </td>
                    <td><a href="${clothe.urlToVKImage}">${clothe.urlToVKImage}</a></td>
                    <td>${clothe.addedDate}</td>
                    <td>
                        <form:form action="/edit/${clothe.id}" method="post">
                            <input type="submit" value="Редактировать">
                        </form:form>
                    </td>
                    <td>
                        <form:form action="/remove/${clothe.id}" method="post">
                            <input type="submit" value="Удалить">
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
