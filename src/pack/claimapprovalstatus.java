package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import finalinsurance.ConnectionProvider;

@WebServlet("/claimapprovalstatus")
public class claimapprovalstatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		int id=(int) session.getAttribute("customerid");
		
		String status="";
		
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement
					("select ststus from claim where cid=?");
			ps.setInt(1,id);
			ResultSet r=ps.executeQuery();
			while (r.next())
			{
				status=r.getString(1);
				System.out.println(status);
				//System.out.println(status);
				
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
				try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement
					("select * from customer  where customerid=?");
			ps.setInt(1,id);
			ResultSet r=ps.executeQuery();
			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<td>Name</td>");
			out.println("<td>Policy </td>");
			out.println("<td>Username </td>");
			out.println("<td>Verification Status </td>");
			out.println("<td>View Documents</td>");
			
			out.println("</tr>");
			
			//HttpSession session=request.getSession();
			int cid=(Integer)session.getAttribute("customerid");
			
			while(r.next()) {
				String name =r.getString(2);
				String p  =r.getString(10);
				String un=r.getString(3);
			
				out.println("<tr>");
				out.println("<td>"+name+"</td>");
				
				out.println("<td>"+p+"</td>");
				out.println("<td>"+un+"</td>");
				out.println("<td>"+status+"</td>");
				out.println("<td><a href='viewclaimdox?customerId="+cid+"&&st=bill'>View my bill</a></td>");
				

				out.println("</tr>");
				
			}
			out.println("</table>");
			out.println("</div>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
	
			out.println("<a href='welcome.jsp' align='right'>Go Back</a>");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}

}
