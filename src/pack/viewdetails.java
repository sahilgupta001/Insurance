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

@WebServlet("/viewdetails")
public class viewdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		int id=(int) session.getAttribute("customerid");
		
		int a,c,t;
		String a1="",a2="";
		
		try{
			Connection conn=ConnectionProvider.getConn();
				PreparedStatement ps=conn.prepareStatement("select * from healthcalc where cid=?");
				ps.setInt(1,id);
				
				out.println("<table border='1'>");
			
				out.println("<tr>");
				out.println("<td>Customer Id</td>");
				out.println("<td>Number Of Adults</td>");
				out.println("<td>Number Of Childrens</td>");
				out.println("<td>Age Of Adult 1 </td>");
				out.println("<td>Age Of Adult 2 </td>");
				out.println("<td>Total Premium</td>");
				out.println("</tr>");
				
			
	       		ResultSet rs=ps.executeQuery();
	       		while (rs.next()){
	       				a=rs.getInt(2);
	       				c=rs.getInt(3);
	       				t=rs.getInt(6);
	       				a1=rs.getString(4);
	       				a2=rs.getString(5);
	       				out.println("<tr>");
						out.println("<td>"+id+"</td>");

						out.println("<td>"+a+"</td>");
						out.println("<td>"+c+"</td>");
						out.println("<td>"+a1+"</td>");
						out.println("<td>"+a2+"</td>");
						out.println("<td>"+t+"</td>");
						out.println("</tr>");
						
				}
				out.println("</table>");
				
				
			}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
