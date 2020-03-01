<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Car booking</title>
    <style>
        .tb, td {
            border: 1px solid black;
            font-size: 22px;
        }
    </style>
</head>
<body>
<div align="center">
    <h1 style="color: red;">Car reservation infos</h1>
    <a href="/index">Back to homepage</a>
    <table class="tb">
        <tr>
            <td>id</td>
            <td>carModel</td>
            <td>carNumber</td>
            <td>bookDate</td>
            <td align="center" colspan="2">operation</td>
        </tr>
        <!-- forEach to show car reservation info in table -->
        <c:forEach items="${carList}" var="car">
            <tr>
                <td>${car.id}</td>
                <td>${car.carModel}</td>
                <td>${car.carNumber}</td>
                <td>${car.bookDate}</td>
                <td><a href="/book?id=${car.id}">book</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>