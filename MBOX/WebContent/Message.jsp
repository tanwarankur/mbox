<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.io.PrintWriter"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="C:/Users/tanwa/eclipse-workspace/mail/WebContent/w3.css">
<link rel="stylesheet" href="C:/Users/tanwa/eclipse-workspace/mail/WebContent/css.css">
<title>Mbox-MultiMedia Message Authentication</title>
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
    button{
    background-color: skyblack;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 16%}
</style>
</head>
<body  style="background-color:lavender;">
<%@ include file="header.jsp" %><br><br><br><br>

      <br><br><br><br>
<center>
<% out.print("<center>");
out.print("<div class=\"container\">");
         Date date = new Date();
         out.print( "<font style='color:black'><h2 align = \"center\">" +date.toString()+"</h2></font>");
         out.print("</div>");
         out.print("</center>");
         out.print("<hr>");
      %>
<div class="container">
<center>
        <h3><%=request.getAttribute("Message")%></h3>
<a href="inbox">Click here to continue</a>
    </center>
</div>
</center>


<%@ include file="footer.jsp" %>
</body>
</html>