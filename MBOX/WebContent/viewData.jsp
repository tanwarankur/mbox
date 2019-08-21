<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import = "java.util.*, javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
Blob image = null;
Connection con = null;
byte[ ] imgData = null ;
Statement stmt = null;
ResultSet rs = null;
String file_type="";
String usrid=(String)session.getAttribute("user_id");
String id=request.getParameter("id");
try {
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailbox","root","root");
stmt = con.createStatement();
rs = stmt.executeQuery("select data,data_type from multi_media where receiver='"+usrid+"' And time='"+id+"'");
if (rs.next()) {
	file_type=rs.getString("data_type");
	image = rs.getBlob("data");
	imgData = image.getBytes(1,(int)image.length());
	}
else {
out.println("File not found for given id");
return;
}


if(file_type.equals("Image")) {
	response.setContentType("image/jpg");
	
}
if(file_type.equals("PDF")) {
	response.setHeader("Content-Type", "application/pdf");
	
}
if(file_type.equals(".doc/word")) {
	response.setContentType("video/mp4");
	
}
if(file_type.equals("Audio")) {
	response.setContentType("video/mp4");
	
}
if(file_type.equals("Video")) {
	response.setContentType("video/mp4");
	
}


OutputStream o = response.getOutputStream();
o.write(imgData);
o.flush();
o.close();
}
catch (Exception e) {
out.println("Unable To Display image");
out.println("File Display Error=" + e.getMessage());
return;
}
%>
</body>
</html>