<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="C:/Users/tanwa/eclipse-workspace/mail/WebContent/w3.css">
<link rel="stylesheet" href="C:/Users/tanwa/eclipse-workspace/mail/WebContent/css.css">
<title>Mbox Change Pass</title>
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
<body  style="background-color:lavender;">
<%@ include file="header.jsp" %>
<%@ include file="commonbar.jsp" %><br><br>
<center>

<h1 style=color:black>Change Password</h1>

<div class="container">
<form action="AdvSectionPasswordChange" method="post">
    <%
    if(session.getAttribute("name")!=null){
    	out.print("<label for=\"NewPass\"><b>Enter Your New Password</b></label><br>");
            out.print("<input type=\"password\" placeholder=\"Enter New Password\" name=\"NewPass\" required><br><br>");
        	out.print("<input type=\"submit\" class=\"w3-button w3-black\" name=\"submit\" value=\"Change Password\">");
    	}
    else{
    	response.sendRedirect("SignIn.jsp");	
    }%>
</form>
</div>
</center>
</body>
</html>