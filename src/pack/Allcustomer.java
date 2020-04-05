
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

@WebServlet("/Allcustomer")
public class Allcustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try{
		Connection conn=ConnectionProvider.getConn();
		PreparedStatement ps=conn.prepareStatement
				("select customerid,name,username,password,contactno,emailid,city,state,address,policy,hospitalname,amount,ststus,cdate from customer c left outer join claim cl on c.customerid=cl.cid");
		ResultSet rs=ps.executeQuery();
		
		out.println("<table border='1'>");
		
		out.println("<tr>");
		out.println("<td>Customer Id</td>");
		out.println("<td>Name</td>");
		out.println("<td>User Name</td>");
		
		out.println("<td>Password </td>");
		out.println("<td>Contact </td>");
		out.println("<td>Email</td>");
		out.println("<td>City </td>");
		out.println("<td>State</td>");
		out.println("<td>Address </td>");
		
		
		out.println("<td>Policy Name</td>");
		out.println("<td>Hospital</td>");
		out.println("<td>Amount</td>");
		
		out.println("<td>status</td>");
		out.println("<td>Date</td>");
		out.println("<td>Total Premimum</td>");
		out.println("<td>Birth Certificate</td>");
		out.println("<td>Id Proof Bill</td>");
		out.println("<td>Hospital Bill</td>");
		
		out.println("</tr>");
	
		
		while(rs.next()){
			out.println("<tr>");
			out.println("<td>"+rs.getInt(1)+"</td>");
			out.println("<td>"+rs.getString(2)+"</td>");
			out.println("<td>"+rs.getString(3)+"</td>");
			out.println("<td>"+rs.getString(4)+"</td>");
			out.println("<td>"+rs.getString(5)+"</td>");
			out.println("<td>"+rs.getString(6)+"</td>");
			out.println("<td>"+rs.getString(7)+"</td>");
			out.println("<td>"+rs.getString(8)+"</td>");
			out.println("<td>"+rs.getString(9)+"</td>");
			out.println("<td>"+rs.getString(10)+"</td>");
			out.println("<td>"+rs.getString(11)+"</td>");
			out.println("<td>"+rs.getString(12)+"</td>");
			out.println("<td>"+rs.getString(13)+"</td>");
			out.println("<td>"+rs.getDate(14)+"</td>");
			out.println("<td>"+getPremium(rs.getInt(1))+"</td>");
			out.println("<td><a href='adminviewdox?customerId="+rs.getInt(1)+"&&st=birth'>view birth certificate</td>");
			out.println("<td><a href='adminviewdox?customerId="+rs.getInt(1)+"&&st=id'>view id proof</td>");
			out.println("<td><a href='adminviewclaimdox?customerId="+rs.getInt(1)+"&&st=bill'>view claim bill</a></td>");
			
			out.println("</tr>");
		}
		
		out.println("</table>");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	int p=0;
	public int getPremium(int cid){
			try{
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select totalpremium from healthcalc where cid=?");
			ps.setInt(1,cid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				p=rs.getInt(1);
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return p;
	
	}}
