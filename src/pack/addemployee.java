package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import finalinsurance.ConnectionProvider;

@WebServlet("/addemployee")
public class addemployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	 String v1= request.getParameter("t1");
	 String v2= request.getParameter("t2");
	 String v3= request.getParameter("t3");
			  	
	 try{
		 Connection conn = ConnectionProvider.getConn();
	     
		 PreparedStatement ps = conn.prepareStatement("insert into employeelogin values(?,?,emid.nextval,?)");
ps.setString(1,v1);
ps.setString(2,v2);

ps.setString(3,v3);
int i = ps.executeUpdate();
if (i!=0) {
	 out.println("<script type=\"text/javascript\">");  
	  out.println("alert('EMPLOYEE ADDED SUCCESSFULLY');");  
	  out.println("</script>");
	  RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
		rd.include(request,response);
  
}
else{
  out.println("Failed to add new Employee");
}
conn.close();
}
catch (Exception e){
out.println(e);
e.printStackTrace();
}
}

}


