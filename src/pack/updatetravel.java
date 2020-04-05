package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatetravel")
public class updatetravel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int premium,days;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 out.println("<html><body>");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bca1","123456");
			 Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from travelcalc");
             out.println("<table border=1 width=50% height=50%>");
             out.println("<tr><th>place</th><th>days</th><th>premium</th><th>for update</th><th>for delete</th><tr>");
             while (rs.next()) {
                 String place = rs.getString("place");
                 days = rs.getInt("days");
                 premium = rs.getInt("premium");
                 
                 out.println("<tr><td>" + place + "</td><td>" + days + "</td><td>" + premium + "</td><td><a href='updatetraveldata.jsp'>update</a></td><td><a href='deletetraveldata.jsp'>delete</a></td></tr>"); 
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

