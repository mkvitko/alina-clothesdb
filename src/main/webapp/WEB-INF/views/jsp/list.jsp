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
    <title>All clothe</title>
</head>
<body>
    <div align="center">
        <h1>All clothe</h1>
        <br>
        <form action="${pageContext.request.contextPath}/newClothe" method="get">
            <input type="submit" value="Add new clothe"><br>
        </form>
        <style>
            td {
                text-align: center;
            }
        </style>
        <table border="1">
            <tr>
                <td>Name</td>
                <td>Old Price</td>
                <td>New Price</td>
                <td>Photo</td>
                <td>VK link</td>
                <td>Added date</td>
            </tr>
            <c:forEach var="clothe" items="${allClothe}">
                <tr>
                    <td>${clothe.name}</td>
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
                            <input type="submit" value="Edit">
                        </form:form>
                    </td>
                    <td>
                        <form:form action="/remove/${clothe.id}" method="post">
                            <input type="submit" value="Remove">
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
