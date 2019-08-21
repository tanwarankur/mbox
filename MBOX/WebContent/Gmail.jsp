<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="C:/Users/tanwa/eclipse-workspace/mail/WebContent/w3.css">
<link rel="stylesheet" href="C:/Users/tanwa/eclipse-workspace/mail/WebContent/css.css">
<title>Send Mails from Gmail</title>
<style type="text/css">
.container{
background-color:white;
width: 60%;
}
input[type=text],input[type=password],input[type=submit]
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
<body>
<%@ include file="header.jsp" %><br><br><br>
<center>
<h3>Send important Mails Through GMail</h3>
<img alt="File_Recovery_Logo" src="images\gmail.png" width="500"height="250"><br><br>
<div class="container">
<form action="mail" method="post">
<label for="to"><b>To</b></label><br>
<input type="text" name="to"/><br/>
<label for="subject"><b>Subject</b></label><br>
<input type="text" name="subject"/><br/>
<label for="message"><b>Message</b></label><br>
<input type="text" name="message"/><br/>
<label for="user"><b>Your Gmail Email id</b></label><br>
<input type="text" name="user"><br/>
<label for="password"><b>Gmail Password</b></label><br>
<input type="password" name="pass"/><br/>
<input type="submit" class="w3-button w3-black" value="send"  />
</form>
</div>
</center>
<br><br><br>
<%@ include file="footer.jsp" %>
</body>
</html>