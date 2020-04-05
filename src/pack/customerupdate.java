package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import finalinsurance.ConnectionProvider;

@WebServlet("/customerupdate")
public class customerupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		int id=(int) session.getAttribute("customerid");
		String a1=request.getParameter("t1");
		String a2=request.getParameter("t2");
		String a3=request.getParameter("t3");
		String a4=request.getParameter("t4");
		String a5=request.getParameter("t5");
		String a6=request.getParameter("t6");
		String a7=request.getParameter("t7");
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement
					("update customer set name=?,password=?,contactno=?,emailid=?,city=?,state=?,address=? where customerid=?");
			ps.setString(1,a1);
			ps.setString(2,a2);
			ps.setString(3,a3);
			ps.setString(4,a4);
			ps.setString(5,a5);
			ps.setString(6,a6);
			ps.setString(7,a7);
			ps.setInt(8,id);
			 int i = ps.executeUpdate();
		      if (i!=0) {
		        out.println("Details Updated Successfully");
		        out.println("<a href='welcome.jsp' align='right'>Go Back</a>");
		        
		      }
		      else{
		        out.println("Failed to update the Details");
		      }
		
	}
catch (Exception e){
	e.printStackTrace();
	
	
}
			
		
	
	}

}
