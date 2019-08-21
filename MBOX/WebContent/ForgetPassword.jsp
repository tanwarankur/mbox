<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="C:/Users/tanwa/eclipse-workspace/mail/WebContent/w3.css">
<link rel="stylesheet" href="C:/Users/tanwa/eclipse-workspace/mail/WebContent/css.css">
<title>Forget Password-MBox</title>
<style type="text/css">
.container{
background-color:lavender;
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
  }
</style>
</head>
<body bgcolor="lavender">
<%@ include file="header.jsp" %><br><br><br>
<center>
<br><br><br>
<form action="NextForgetPassword.jsp" method="post">
  <div class="container">
<label for="ForgetPassUserName"><h3><b>Enter Your MailBox E-mail id To Continue</b></h3></label><br><br>
		<input type="text" class="w3-input w3-padding-16 " name="ForgetPassUserName" required>
	    <br>
		<br>
		<button type="submit" class="w3-button w3-black " value="next">Login</button>
	
</div>
</form>
</center>
<br><br><br><br><br><br><br>
<%@ include file="footer.jsp" %><hr>
</body>
</html>