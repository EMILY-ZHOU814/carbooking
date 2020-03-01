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
    <h1 style="color: red;">Personal car reservation info</h1>
    <a href="/index">Back to homepage</a>
    <table class="tb">
        <tr>
            <td>carModel</td>
            <td>carNumber</td>
            <td>bookDate</td>
        </tr>
        <!-- forEach to show car reservation info in table -->
        <c:forEach items="${userOrderList}" var="userOrder">
            <tr>
                <td>${userOrder.carModel}</td>
                <td>${userOrder.carNumber}</td>
                <td>${userOrder.bookDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>