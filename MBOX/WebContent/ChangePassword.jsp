<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MailBox-Change Password</title>
<style type="text/css">
input[type=submit] {
    background-color: #af0505;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 50%;
}
input[type=password],[type=text] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
     display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
.container {
    padding: 16px;
    border:thin;
    background-color: #ebede8;
    width: 30%;
    height: 40%;
    border-radius: 25px;
}
</style>
</head>
<body background="images\background.jpg">
<%@ include file="header.jsp" %><br><br><br>


<%
String name=(String)session.getAttribute("name");
String uname=(String)session.getAttribute("user_id");
if(session != null){
	if(session.getAttribute("name")!=null){
	out.print("<form action=\"ChangePassword\" method=\"post\" name=\"form\">");
	out.print("<div class=\"container\">");
	out.print("<center>");
	out.print("<b>");
	out.print("Hi ");
	out.print(name);
	out.print(" Now You Can Change Your Password..</b><br><br>");
	out.print("<label for=\"usrid\"><b>Your user-id</b></label><br>");
	out.print("");
	out.print("<label for=\"password\"><b>Enter New Password</b></label><br>");
	out.print("<input type=\"password\" placeholder=\"Enter Password\" name=\"ChangedPassword\" id=\"id1\" required><br><br>");
	out.print("<input type=\"checkbox\" onclick=\"myFunction()\">Show Password");
	out.print("<br><br>");
	out.print("<input type=\"submit\" name=\"submit\" value=\"Change Password\" ><br>");
	out.print("</div>");
	out.print("</form>");
	out.print("</center>");
	
	out.print("<script>");
	out.print("function myFunction() {");
	out.print("var x = document.getElementById(\"id1\");");
	out.print("if (x.type === \"password\") {");
	out.print("x.type = \"text\";} else {");
	out.print("x.type = \"password\";}}");
	out.println("</script>");
	}
	else{
		response.sendRedirect("SignIn.jsp");
	}
}
%>
</body>
</html>