<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Car booking</title>
    <style>
        .a {
            font-size: 26px;
            margin-top: 20px;
        }
    </style>
</head>
<body>

<%
    Object message = request.getAttribute("message");
    if (message != null && !"".equals(message)) {

%>
<script type="text/javascript">
    alert("<%=request.getAttribute("message")%>");
</script>
<%}else if("SUCCESS".equals(message)){ %>
<script type="text/javascript">
    alert("Book success");
    location.href="/index";
</script>
<%} %>

<div align="center">
    <h1 style="color: red;">Reserve car</h1>
    <a href="/index">back to homepage</a>
    <form action="/car/book" method="get" onsubmit="return check()">
        <div>
            id: <input type="text" id="id" name="id" value="${id}" readonly="readonly"/>
        </div>
        <div>
            date: <input type="text" id="date" name="date"/>
        </div>
        <div>
            userName: <input type="text" id="userName" name="userName"/>
        </div>
        <div>
            <button type="submit" class="b">Book</button>
        </div>
    </form>
</div>
<script type="text/javascript">
    function check() {
        var date = document.getElementById("date");
        var userName = document.getElementById("userName");

        //date can not be empty
        if (date.value == '') {
            alert('Please input date');
            date.focus();
            return false;
        }
        //userName can not be empty
        if (userName.value == '') {
            alert('Please input userName');
            userName.focus();
            return false;
        }
    }
</script>
</body>
</html>