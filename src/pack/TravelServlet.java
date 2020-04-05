
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


@WebServlet("/TravelServlet")

public class TravelServlet extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
		String place=request.getParameter("sl1");	// Name of Place
		String days=request.getParameter("sl2");	// Number of Days
		int no_of_migrants = Integer.parseInt(request.getParameter("sl3"));	    //Number of migrants
		
		int temp=0,premium=0;						// Temporary Variables

		try
		{
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select premium from travelcalc where place=? and days=?");
			
			ps.setString(1,place);
			ps.setString(2,days);

			ResultSet rs=ps.executeQuery();

			if(rs.next())
			{
				temp = rs.getInt(1);
			}
			
			premium = temp*no_of_migrants;
			
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		out.println("Premium :"+premium);
		out.println("<br/><br/>");
		
		
		out.println("<br/><br/>");
		out.println("<a href='UploadDocuments.jsp'>Upload Documents for Submission</a>");
	
		
		
	}
}