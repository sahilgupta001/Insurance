package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import finalinsurance.ConnectionProvider;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewcustomer")
public class viewcustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int premium;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 out.println("<html><body>");
		try
		{
			Connection conn=ConnectionProvider.getConn();
			Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from customer");
             out.println("<table border=1 width=30% height=20%>");
             out.println("<tr><th>customerid</th><th>name</th><th>username</th><th>password</th><th>contact no.</th><th>email id</th><th>city</th><th>state</th><th>address</th><th>policy name</th><tr>");
             while (rs.next()) {
            	 
            	 int customerid = Integer.parseInt(rs.getString("customerid"));
            	 String name = rs.getString("name");
                 String username = rs.getString("username");
                 String password = rs.getString("password");
                 String contactno = rs.getString("contactno");
                 String emailid = rs.getString("emailid");
                 String city = rs.getString("city");
                 String state= rs.getString("state");
                 String address= rs.getString("address");
                 String policyname= rs.getString("policyname");
                 
                 out.println("<tr><td>" + customerid + "</td><td>" + name + "</td><td>" + username + "</td><td>" + password + "</td><td>" + contactno + "</td><td>" + emailid + "</td><td>" + city + "</td><td>" + state + "</td><td>" + address + "</td><td>" + policyname + "</td></tr>"); 
             }
             out.println("</table>");
             out.println("</html></body>");
             conn.close();
            }
             catch (Exception e) {
             out.println("error");
             e.printStackTrace();
             }
		
		}
	}

