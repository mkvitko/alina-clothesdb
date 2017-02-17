<%--
  Created by IntelliJ IDEA.
  User: mkvitko
  Date: 3/24/16
  Time: 3:00 PM
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
    <title>Welcome to clothe collection!</title>

    <script type="text/javascript">
        function searchtxt(){
            var l = $('#log').val();
            if (l === null || l.toString() === ""){
                alert("Empty login!");
                return false;
            }
            var p = $('#pas').val();
            if (p === null || p.toString() === ""){
                alert("Empty password!");
                return false;
            }
            return true;

        }
    </script>
</head>
<body>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>
<div align="center">
    <h1>Добро пожаловать в коллекцию одежды!</h1>
    <br>
    <h2>Пожалуйста, авторизируйтесь чтобы получить доступ к системе</h2>
    <br>
    <form:form name="signin" action="${pageContext.request.contextPath}/login" method="POST" >
        <table>
            <tr>
                <td>
                    <label style="font-weight: bold; margin-right: 9px;" for="username">Логин</label>
                    <input type=username name="username" id="username" autofocus/>
                </td>
            </tr>

            <tr>
                <td>
                    <label style="font-weight: bold;" for="password">Пароль</label>
                    <input type=password name="password" id="password"/>
                </td>
            </tr>
            <c:if test="${errorMessage!=null && !''.equals(errorMeassage)}">
                <tr>
                    <p style="color: red">${errorMessage}</p>
                </tr>
            </c:if>
        </table>
        <br><br>
        <input type="submit" value="Войти" onclick="return searchtxt()?true:false;" > <br>
    </form:form>
</div>
</body>
</html>
