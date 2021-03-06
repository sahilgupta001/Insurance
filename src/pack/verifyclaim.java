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

@WebServlet("/verifyclaim")
public class verifyclaim extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=0;
		String n=null;
		String hospitalname=null;
		String amount=null;
		String un=null;
		String c=null;
		String email="";
		String pname="";
		String city="";
		int adult=0,children=0,total=0;
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement p=conn.prepareStatement
					("select cid from claim where ststus='Approval Of Documents is Pending'");
			ResultSet r=p.executeQuery();
			while(r.next()) {
				id=r.getInt(1);
				hospitalname=r.getString(2);
				amount=r.getString(3);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement p=conn.prepareStatement
					("select * from customer where customerid=?");
			p.setInt(1, id);
			ResultSet r=p.executeQuery();
			while(r.next()) {
				n=r.getString(2);
				un=r.getString(3);
				c=r.getString(5);
				email=r.getString(6);
				pname=r.getString(10);
				city=r.getString(7);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement p=conn.prepareStatement
					("select * from healthcalc where cid=?");
			p.setInt(1, id);
			ResultSet r=p.executeQuery();
			out.println("<table border='1'>");
			
			out.println("<tr>");
			out.println("<td>Customer Id</td>");
			out.println("<td>Name</td>");
			out.println("<td>Username</td>");
			out.println("<td>Contact </td>");
			out.println("<td>Email </td>");
			out.println("<td>City</td>");
			out.println("<td>Policy</td>");
			out.println("<td>Adults</td>");
			out.println("<td>Childrens</td>");
			out.println("<td>Total Premium</td>");
			out.println("<td>Hospital Name</td>");
			out.println("<td>amount</td>");
			out.println("<td>View bill</td>");
			
			
			out.println("<td colspan=3>Verify/Reject</td>");
			out.println("</tr>");
			
			while(r.next()) {
				adult=r.getInt(2);
				children=r.getInt(3);
				total=r.getInt(6);
				out.println("<tr>");
				out.println("<td>"+id+"</td>");
				out.println("<td>"+n+"</td>");
				out.println("<td>"+un+"</td>");
				out.println("<td>"+c+"</td>");
				out.println("<td>"+email+"</td>");
				out.println("<td>"+city+"</td>");
				out.println("<td>"+pname+"</td>");
				out.println("<td>"+adult+"</td>");
				out.println("<td>"+children+"</td>");
				out.println("<td>"+total+"</td>");
				out.println("<td>"+hospitalname+"</td>");
				out.println("<td>"+amount+"</td>");
				out.println("<td><a href='employeeviewclaimdox?customerId="+id+"&&st=bill'>view claim bill</td>");
				
				
				
				out.println("<td><a href='verifyrejectclaim?verification=Claim Approved&&customerid="+id+"'>Approve</a></td>");
				out.println("<td><a href='verifyrejectclaim?verification=Reject&&customerid="+id+"'>Reject</a></td>");
				out.println("</tr>");
				
			}
			out.println("</table>");
			
			
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
	}

}
