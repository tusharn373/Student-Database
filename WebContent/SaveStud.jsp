<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="s1" class="com.Student"></jsp:useBean>
<jsp:setProperty property="rollno" name="s1" value="143"/>
<jsp:setProperty property="name" name="s1" value="Ketan"/>
<jsp:setProperty property="address" name="s1" value="Nashik"/>
<jsp:setProperty property="result" name="s1" value="443"/>

<h2>Student Static data</h2>
<jsp:getProperty property="rollno" name="s1"/><br>
<jsp:getProperty property="name" name="s1"/><br>
<jsp:getProperty property="address" name="s1"/><br>
<jsp:getProperty property="result" name="s1"/><br>
<%
String Driver=application.getInitParameter("DRIVER");
String Url=application.getInitParameter("URL");
String Dbuser=application.getInitParameter("DBUSER");
String Dbpass=application.getInitParameter("DBPASS");
Class.forName(Driver);
Connection con=DriverManager.getConnection(Url,Dbuser,Dbpass);
PreparedStatement pst=con.prepareStatement("insert into student values(?,?,?,?)");
pst.setInt(1, s1.getRollno());
pst.setString(2, s1.getName());
pst.setString(3, s1.getAddress());
pst.setFloat(4, s1.getResult());
int x=pst.executeUpdate();
if(x>0)
{
	out.print("success");
}
else
{
	out.print("fail");
}
con.close();
%>
</body>
</html>
