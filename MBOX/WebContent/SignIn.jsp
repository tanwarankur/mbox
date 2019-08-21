<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="C:/Users/tanwa/eclipse-workspace/mail/WebContent/w3.css">
<link rel="stylesheet" href="C:/Users/tanwa/eclipse-workspace/mail/WebContent/css.css">
<title>Mbox-SignIn</title>
<style type="text/css">
.container{
background-color:white;
width: 30%;
}
input[type=text],input[type=password]
{   width: 80%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;}
    button:hover{opacity:0.8;}
    button{
    background-color: skyblue;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 40%}
</style>
</head>
<body style="background-image: url('images/b.jpg');background-size:cover;">
<br><br><br><br>
<center>
<br>
<div class="container">
<form action="login" method="post">
<p><h1>Welcome to Mbox</h1></p>
    <label for="userName"><b>Username</b></label><br>
    <input type="text" placeholder="Enter Username" name="userName" required><br>
    <label for="password"><b>Password</b></label><br>
    <input type="password" placeholder="Enter Password" name="password" required><br><br>
 <p>&nbsp<a href="SignUp.jsp">Sign Up</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<button type="submit">Login</button> </p>
  <p align="center"><a href="ForgetPassword.jsp" style="color:dodgerblue">Trouble Signing in?</a>.</p>
  <br>
 
</form>
</div>
</center>
<br><br><br><br>

</body>
</html>