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

@WebServlet("/updatehome")
public class updatehome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int premium;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 out.println("<html><body>");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bca1","123456");
			 Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from homecalc");
             out.println("<table border=1 width=50% height=50%>");
             out.println("<tr><th>location</th><th>area</th><th>premium</th><th>for update</th><th>for delete</th><tr>");
             while (rs.next()) {
                 String location = rs.getString("location");
                 String area = rs.getString("area");
                 premium = rs.getInt("premium");
                 
                 out.println("<tr><td>" + location + "</td><td>" + area + "</td><td>" + premium + "</td><td><a href='updatehomedata.jsp'>update</a></td><td><a href='deletehomedata.jsp'>delete</a></td></tr>"); 
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

