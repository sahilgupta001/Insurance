package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import finalinsurance.ConnectionProvider;

@WebServlet("/employee")
public class employee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("t1");
		String s2=request.getParameter("t2");
		
		try {
			 Connection conn = ConnectionProvider.getConn();
			 	PreparedStatement ps=conn.prepareStatement("select * from employeelogin where username=? and password=?");
				ps.setString(1,s1);
				ps.setString(2,s2);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) 
				{
					String name=rs.getString(1);
					
				out.println("<b>");
					out.println("Welcome :"+name);
					out.println("</b>");

					RequestDispatcher rd=request.getRequestDispatcher("employee.jsp");
					rd.include(request,response);
				
				}
				else {
					out.println("<div align='center' style='color:red'>");
					out.println("<b>User name or password is incorrect</b></div>");
					RequestDispatcher rd=request.getRequestDispatcher("employeelogin.jsp");
					rd.include(request,response);
				
					}
			    }catch(Exception e){
			    		e.printStackTrace();}		

	
	
	}

}
