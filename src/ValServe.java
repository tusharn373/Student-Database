import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValServe extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		
		
		  PrintWriter pw=response.getWriter(); 
		  ServletContext context=request.getServletContext(); String
		  Driver=context.getInitParameter("DRIVER"); 
		  String Url=context.getInitParameter("URL"); 
		  String Dbuser=context.getInitParameter("DBUSER"); 
		  String Dbpass=context.getInitParameter("DBPASS"); 
		  String Username=request.getParameter("un"); 
		  String Password=request.getParameter("pwd"); 
		  pw.print("Driver="+Driver);
		  pw.print("<br>Url="+Url); 
		  pw.print("<br>Dbuser="+Dbuser);
		  pw.print("<br>Dbpass="+Dbpass); 
		  pw.print("<br>Username="+Username);
		  pw.print("<br>Password="+Password); 
		  try {
		  Class.forName("com.mysql.jdbc.Driver"); 
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root"); 
		  PreparedStatement pst=con.prepareStatement("select * from loginpage where Username=? and Password=?");
		  pst.setString(1, Username); 
		  pst.setString(2, Password); 
		  ResultSet rs=pst.executeQuery(); 
		  if(rs.next()) 
		  { pw.print("Welcome  "+Username); } 
		  else
		  { pw.print("Incorrect login details"); } 
		  } 
		  catch (ClassNotFoundException e) {
		  // TODO Auto-generated catch block 
			  e.printStackTrace(); 
			  } 
		  catch (SQLException e) { // TODO Auto-generated catch block 
				  e.printStackTrace(); }
			  }
		 
		 
		/*
		 * String url="jdbc:mysql://localhost:3306/emp"; String uname="root"; String
		 * pass="tushar97@"; String query="select name from student where rollno=101";
		 * try { Class.forName("com.mysql.jdbc.Driver"); Connection
		 * con=DriverManager.getConnection(url, uname, pass); Statement st =
		 * con.createStatement(); ResultSet rs=st.executeQuery(query); rs.next(); String
		 * name=rs.getString("name"); System.out.println(name); st.close(); con.close();
		 * } catch (ClassNotFoundException | SQLException e) { // TODO
		 * Auto-generatedcatch block e.printStackTrace(); }
		 */
		  }
		 
	


