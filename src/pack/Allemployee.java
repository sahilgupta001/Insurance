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

import finalinsurance.ConnectionProvider;

@WebServlet("/Allemployee")
public class Allemployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String un=null,n=null;
		String pass=null;
		int l=0;
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement p=conn.prepareStatement
					("select  * from employeelogin");
			out.println("<table border='1'>");
			
			out.println("<tr>");
			
			out.println("<td>Username</td>");
			out.println("<td>Password </td>");
			out.println("<td>Employee Id</td>");
			out.println("<td>Name </td>");
			
			
			out.println("</tr>");
			
			
			ResultSet r=p.executeQuery();
			while(r.next()) {
			un=r.getString(1);
			pass=r.getString(2);
			l=r.getInt(3);
			n=r.getString(4);
			out.println("<tr>");
			out.println("<td>"+un+"</td>");
			out.println("<td>"+pass+"</td>");
		out.println("<td>"+l+"</td>");
			out.println("<td>"+n+"</td>");
			out.println("</tr>");
			
			}
			out.println("</table>");
			out.println("<a href='admin.jsp' align='right'>Go Back</a>");
			
	}
		catch(Exception e){
			e.printStackTrace();
		}
		}

}
