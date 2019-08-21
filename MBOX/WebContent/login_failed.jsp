<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login error</title>
</head>
<body background="images\background.jpg">
<%@ include file="header.jsp" %>
<hr>
<form name="loginform" method="post" action="login">
<br><br>
<pre><b>Incorrect username/password.
please login again or <a href="SignUp.jsp">Sign Up</a></b></pre>
<table align="center"><tr><td><h2>Login Authentication</h2></td></tr></table>
<table width="300px" align="center" style="border:1px solid #000000;background-color:#efefef;">
<tr><td colspan=2></td></tr>
<tr><td colspan=2>&nbsp;</td></tr>
	<tr>
		<td><b>UserName</b></td>
		<td><input type="text" name="userName" value=""></td>
	</tr>
	<tr>
		<td><b>Password</b></td>
		<td><input type="password" name="password" value=""></td>
	</tr>
	
	<tr>
		<td></td>
		<td><input type="submit" name="Submit" value="Login"></td>
	</tr>
	<tr><td colspan=2>&nbsp;</td></tr>
</table>
</form>

<%@ include file="footer.jsp" %>
</body>
</html>