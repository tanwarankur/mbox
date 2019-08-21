<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ChatBox-User Conformed</title>
<style type="text/css">
.container {
    padding: 16px;
    background-color: #ebede8;
    width: 50%;
    }
    input[type=text], input[type=password], select[name=SecurityQuestion] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
     display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
input[type=submit]{
width: 40%;
color: white;
padding: 14px 20px;
margin: 8px 0;
border: none;
cursor: pointer;
background-color: #3068b5;
}
</style>
</head>
<body bgcolor="lavender">
<%@ include file="header.jsp" %><hr><br><br><br>

<center>
<form action="NextForget" method="post">
<div class="container">

<label for="SecurityQuestion"><b>Your Security Question </b></label><br>
    <select name="SecurityQuestion">
    <option>What is the name of your Favourite Pet ?</option>
    <option>Which Phone number do remember the most from childhood ?</option>
    <option>What is your favourite color ?</option>
    <option>What is the name of your best friend ?</option>
    </select><br>
<label for="SecurityAnswer"><b>Security Answer</b></label><br>
    <input type="text" placeholder="Your Security Answer" name="SecurityAnswer" required><br><br>
    <label for="RegMobile"><b>Registered E-Mail or Mobile Number</b></label><br>
    <input type="text" placeholder="email or Mobile Number" name="RegMobile" required><br><br>
    <input type="submit" name="submit" value="Submit">
    </div>
</form>
</center>

<br><br><br><br><br><br>
<%@ include file="footer.jsp" %>
</body>
</html>