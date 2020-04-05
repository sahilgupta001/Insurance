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

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int premium=0;
	int temp=0;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String location=request.getParameter("t1");
		int area=Integer.parseInt(request.getParameter("t2"));
		int number=Integer.parseInt(request.getParameter("t3"));
		
		out.println("Location : "+location);
		out.println("Area : "+area);
		
		try
		{
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select premium from homecalc where location=? and area=?");
			
			ps.setString(1,location);
			ps.setInt(2,area);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				temp=rs.getInt(1);
				
			}
			System.out.println("Temp : "+temp);
			System.out.println("Number : "+number);
			premium = temp*number;
			conn.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		out.println("premium:" +premium);
	}
}