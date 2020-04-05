package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import finalinsurance.ConnectionProvider;
@WebServlet("/VerifyReject")
public class VerifyReject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int z=Integer.parseInt(request.getParameter("customerid"));
		String verification=request.getParameter("verification");
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement
					("update upload set verification=? where id=?");
			ps.setString(1,verification);
			ps.setInt(2,z);
			
			int i=ps.executeUpdate();
			if(i!=0){
			
				out.println("<script type=\"text/javascript\">");  
		    	  out.println("alert('Verification of Documents Processed Succesfully...');");  
		    	  out.println("</script>");
		    	  RequestDispatcher rd=request.getRequestDispatcher("employee.jsp");
					rd.include(request,response);
		        
				
			}
			else {
				out.println("Problem in Changing status");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	
	
	}

}
