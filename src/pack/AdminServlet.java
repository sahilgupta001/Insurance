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

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String user = request.getParameter("t1");
		String pass = request.getParameter("t2");
		
		try{
			 Connection conn = ConnectionProvider.getConn();
			    
			PreparedStatement p=conn.prepareStatement("select * from usert where username=? and password=?");
						p.setString(1,user);
						p.setString(2,pass);
						ResultSet r=p.executeQuery();
						if(r.next()) {
							
							String u=r.getString(1);
							HttpSession session=request.getSession();
							session.setAttribute("adusername",user);
							
							
							
							
							
							out.println("<b>");
							out.println("Welcome : "+user);
							out.println("</b>");
							RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
							rd.include(request,response);
 	}
						else {
							out.println("<div align='center' style='color:red'>");
							out.println("<b>User name or password is incorrect</b></div>");
					RequestDispatcher rd=request.getRequestDispatcher("loginagain.html");
								rd.include(request,response);
						}
	



	

}
catch(Exception e){
	e.printStackTrace();
}

	}
}
