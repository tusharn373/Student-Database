import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServe extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter pw=response.getWriter();
		ServletContext sc=request.getServletContext();
		String Driver=sc.getInitParameter("DRIVER");
		String Url=sc.getInitParameter("URL");
		String Dbuser=sc.getInitParameter("DBUSER");
		String Dbpass=sc.getInitParameter("DBPASS");
		String Fname=request.getParameter("firstname");
		String Lname=request.getParameter("lastname");
		String Age=request.getParameter("age");
		String Username=request.getParameter("username");
		String Password=request.getParameter("password");
		try {
			Class.forName(Driver);
			Connection con=DriverManager.getConnection(Url, Dbuser, Dbpass);
			PreparedStatement pst=con.prepareStatement("insert into loginpage values(?,?,?,?,?)");
			pst.setString(1, Fname);
			pst.setString(2, Lname);
			pst.setInt(3, Integer.parseInt(Age));
			pst.setString(4, Username);
			pst.setString(5, Password);
			int r=pst.executeUpdate();
			if(r>0)
			{
				pw.print("Inserted Successfully");
			}
			else
			{
				pw.print("Please try again!!!");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
