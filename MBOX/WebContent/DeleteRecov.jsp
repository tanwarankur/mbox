<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DELETED MESSAGES RECOVERY</title>
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
    .container {
border-radius: 25px;
    padding: 16px;
    background-color: #ebede8;
    width: 50%;
}
</style>
</head>
<body style="background-color:lavender;">
<%@ include file="header.jsp" %><br><br>
<%-- <%
String usrid=(String) session.getAttribute("user_id");
if(usrid==null){
	response.sendRedirect("SignIn.jsp");
}
%> --%>
<h2 align="center">DELETED MESSAGES RECOVERY</h2>
<center>
<img alt="File_Recovery_Logo" src="images\l.jpg" width="500"height="300"><br><br>
<div class="container">
<h4><b>Recover your deleted messages</b><br>
<a href="DeletedMessageRecovery">Click Here To Continue</a>
 </h4>   </div>
</center>
<br><br>
<%@ include file="footer.jsp" %>
</body>
</html>