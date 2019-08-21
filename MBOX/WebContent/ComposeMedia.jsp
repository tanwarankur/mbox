<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.io.*,
    java.util.*,
    javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="C:/Users/tanwa/eclipse-workspace/mail/WebContent/w3.css">
<link rel="stylesheet" href="C:/Users/tanwa/eclipse-workspace/mail/WebContent/css.css">
<title>Send Multi-Media Messages</title>
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
   </style>
</head>
<body style="background-color:lavender;">
<%@ include file="header.jsp" %>
    <%@ include file="commonbar.jsp" %>
<center>
<% 
out.print("<div class=\"container\">");
         Date date = new Date();
         out.print( "<font style='color:black'><h2 align = \"center\">" +date.toString()+"</h2></font>");
         out.print("</div>");
         out.print("<hr>");
         out.print("<br>");
      %>
  
<%if(session != null){
 if(session.getAttribute("name")!=null){
	 out.print("<div class=\"container\">");
	 out.print("<center><h3>Compose Multi-Media Message</h3></center>");
	 out.print("<form action=\"MediaUploadServlet\" method=\"post\" enctype=\"multipart/form-data\">");
	 out.print("<label for=\"To\"><b>To</b></label>");
	 out.print("<br>");
	 out.print("<input type=\"text\" class=\"w3-input w3-padding-16 w3-border\" placeholder=\"Receiver's user-id\" name=\"to\" required>");
	 out.print("<br>");
	 out.print("<label for=\"media_type\"><b>File Type</b></label>");
	 out.print("<br>");
	 out.print("<select name=\"media_type\" style=\"margin:5px 0 22px 0;width: 80%; height: 50px\">");
	 out.print("<option>Image</option>");
	 out.print("<option>PDF</option>");
	 out.print("<option>.doc/word</option>");
	 out.print("<option>Audio</option>");
	 out.print("<option>Video</option>");
	 out.print("</select>");
	 out.print("<br>");
	 

	 
	
	 out.print("<input type=\"file\" style=\"margin:5px 0 22px 0;width: 80%; height: 50px\" placeholder=\"Add File\" name=\"upload\">");
	 out.print("<br>");
	 out.print("<br>");
	 
	 
	 out.print("<input type=\"submit\" class=\"w3-button w3-black\" name=\"submit\" value=\"SEND MESSAGE\">");
	 out.print("</form>");
	 out.print("<br>");
 }
 else{
		response.sendRedirect("SignIn.jsp");
	}
 }
 %>
</center>
 <br>
 <br>   
<%@ include file="footer.jsp" %>
</body>
</html>