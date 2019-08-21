<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="C:/Users/tanwa/eclipse-workspace/mail/WebContent/w3.css">
<link rel="stylesheet" href="C:/Users/tanwa/eclipse-workspace/mail/WebContent/css.css">
<title>Message Recovery-Mbox</title>
<style type="text/css">
.container{
background-color:lavender;
width: 40%;
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
    background-color: skyblack;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 13%}
</style>
</head>
<body  style="background-color:lavender;">
<%@ include file="header.jsp" %><br><br><br>
<%
String usrid=(String) session.getAttribute("user_id");
if(usrid==null){
	response.sendRedirect("SignIn.jsp");
}
%>
<h2 align="center">Advanced Options</h2>
<center>
<img align="middle" alt="File_Recovery_Logo" src="images\reco.jpg" width="500"height="300"><br><br>

<div class="container">
<h4><b><a href="DeleteRecov.jsp">CLICK HERE TO RECOVER YOUR DELETED MESSAGES</a><br><br>
<a href="AdvSectionPassword.jsp">CLICK HERE TO CHANGE YOUR PASSWORD</a><BR><BR>
<a href="Gmail.jsp">SEND IMPORTANT GMAIL MESSAGES</a>
</b></h4>
</div>
</center>


<%@ include file="footer.jsp" %>
</body>
</html>