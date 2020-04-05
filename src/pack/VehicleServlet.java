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


@WebServlet("/vehicle")
public class VehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String s1=request.getParameter("t1");
		String s2=request.getParameter("t2");

		
		
		int temp=0,premium=0;						

		try
		{
		
			Connection conn=ConnectionProvider.getConn();
			
			
			PreparedStatement ps=conn.prepareStatement("select premium from vehiclecalc where typeofvehicle=? and manufacture=?");
			
			ps.setString(1,s1);
			ps.setString(2,s2);

			
			ResultSet rs=ps.executeQuery();

			
			if(rs.next()){
				temp = rs.getInt(1);
			}
	
			
			out.println("Premium :" + temp);
			
			conn.close();
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
	
		
		
		out.println("<br/><br/>");
		out.println("<a href='UploadDocuments.jsp'>Upload Documents for Submission</a>");
	
	}

}



































