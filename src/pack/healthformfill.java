package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import finalinsurance.ConnectionProvider;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/healthformfill")
public class healthformfill extends HttpServlet
{
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement
					("select * from healthcalc");
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
			String ageslab=rs.getString(1);
			int premium=rs.getInt(2);
			String category=rs.getString(3);
			
			
			
			out.println("<center>");
			out.println("<h1>Update Form</h1>");
			out.println("<form>");
	out.println
	("Age slab : <input type='text' name='t1' value='"+ageslab+"'><br/>");
			out.println("Premium : <input type='text' name='t2' value='"+premium+"'><br/>");
			out.println("Category : <input type='text' name='t3' value='"+category+"'><br/>");
			
			out.println("<input type='submit' value='Update'>");
			
			out.println("</form>");
			out.println("</center>");
			}
			}
			catch(Exception e){e.printStackTrace();}

	}

}
