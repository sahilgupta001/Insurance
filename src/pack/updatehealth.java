package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import finalinsurance.ConnectionProvider;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatehealth")
public class updatehealth extends HttpServlet {
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
             ResultSet rs = stmt.executeQuery("select * from healthcalc");
             out.println("<table border=1 width=50% height=50%>");
             out.println("<tr><th>ageslab</th><th>premium</th><th>category</th><th>for update</th><th>for delete</th><tr>");
             while (rs.next()) {
                 String ageslab = rs.getString("ageslab");
                 premium = rs.getInt("premium");
                 String cat = rs.getString("category");
                 out.println("<tr><td>" + ageslab + "</td><td>" + premium + "</td><td>" + cat + "</td><td><a href='healthformfill'>update</a></td><td><a href='deletehealthdata.jsp'>delete</a></td></tr>"); 
             }
             out.println("</table>");
             out.println("</html></body>");
             conn.close();
            }
             catch (Exception e) {
             out.println("error");
         }
		
		}
	}

