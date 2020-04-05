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

@WebServlet("/ViewEmployee")
public class ViewEmployee extends HttpServlet {
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
             ResultSet rs = stmt.executeQuery("select * from employee");
             out.println("<table border=1 width=50% height=50%>");
             out.println("<tr><th>employeeid</th><th>employeename</th><th>service</th><tr>");
             while (rs.next()) {
                 int employeeid = Integer.parseInt(rs.getString("employeeid"));
                 int service = Integer.parseInt(rs.getString("service"));
                 String name = rs.getString("employeename");
                 out.println("<tr><td>" + employeeid + "</td><td>" + name + "</td><td>" + service + "</td></tr>"); 
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

