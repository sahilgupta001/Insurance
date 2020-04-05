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

@WebServlet("/updatevehicle")
public class updatevehicle extends HttpServlet {
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
             ResultSet rs = stmt.executeQuery("select * from vehiclecalc");
             out.println("<table border=1 width=50% height=50%>");
             out.println("<tr><th>type of vehicle</th><th>manufacturer</th><th>premium</th><th>for update</th><th>for delete</th><tr>");
             while (rs.next()) {
                 String typeofvehicle = rs.getString("typeofvehicle");
                 String manufacture = rs.getString("manufacture");
                 premium = rs.getInt("premium");
                 
                 out.println("<tr><td>" + typeofvehicle + "</td><td>" + manufacture + "</td><td>" + premium + "</td><td><a href='updatevehicledata.jsp'>update</a></td><td><a href='deletevehicledata.jsp'>delete</a></td></tr>"); 
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

