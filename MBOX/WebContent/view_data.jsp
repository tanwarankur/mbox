<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
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
//PrintWriter pw=response.getWriter();
String id=request.getParameter("id");
String usrid=(String) session.getAttribute("user_id");
if(usrid==null){
	response.sendRedirect("SignIn.jsp");
}
else{
try {
	Class.forName("com.mysql.jdbc.Driver");
	con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mailbox","root","root");
	stmt=con.createStatement();
	rs=stmt.executeQuery("select data,data_type from multi_media where receiver='"+usrid+"' And time='"+id+"'");	
	if (rs.next()) {
		file_type=rs.getString(2);
		image = rs.getBlob(1);
		imgData = image.getBytes(1,(int)image.length());
		}
	else {
		//pw.println("File not found for given id>");
		return;
		}
	if(file_type.equals("Image")) {
		response.setContentType("image/jpg");
		OutputStream o = response.getOutputStream();
		o.write(imgData);
        o.flush();
        o.close();
		
	}
	if(file_type.equals("PDF")) {
    	response.setHeader("Content-Type", "application/pdf");
    	OutputStream o = response.getOutputStream();
		o.write(imgData);
        o.flush();
        o.close();
    	
	}
	if(file_type.equals(".doc/word")) {
    	response.setContentType("video/mp4");
    	OutputStream o = response.getOutputStream();
		o.write(imgData);
        o.flush();
        o.close();
    	
    }
	if(file_type.equals("Audio")) {
    	response.setContentType("video/mp4");
    	OutputStream o = response.getOutputStream();
		o.write(imgData);
        o.flush();
        o.close();
    	
    }
	if(file_type.equals("Video")) {
    	response.setContentType("video/mp4");
    	OutputStream o = response.getOutputStream();
		o.write(imgData);
        o.flush();
        o.close();
    	
    }
	/*response.setHeader("Content-Type", "application/pdf");
OutputStream o = response.getOutputStream();
	o.write(imgData);
    o.flush();
    o.close();*/
    
}
catch(Exception e) {
	e.printStackTrace();
	//out.println("Unable To Display File");
	//pw.println("File Display Error=  "+e);
}
}
%>

</body>
</html>