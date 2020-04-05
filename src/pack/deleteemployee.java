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

import finalinsurance.ConnectionProvider;

@WebServlet("/deleteemployee")
public class deleteemployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	 int v1= Integer.parseInt(request.getParameter("t1"));
	 String v2= request.getParameter("t2");
	 
   	 System.out.println("Employee ID for Delete : "+v1);
   	 try{
		 Connection conn = ConnectionProvider.getConn();
	     
		 PreparedStatement ps = conn.prepareStatement("delete from employeelogin where empid=? and username=?");
		 ps.setInt(1,v1);
		 ps.setString(2,v2);
		 
		 int i = ps.executeUpdate();
		 if(i!=0)
		 {
			 out.println("<script type=\"text/javascript\">");  
			  out.println("alert('EMPLOYEE DELETED SUCCESSFULLY');");  
			  out.println("</script>");
			  RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
				rd.include(request,response);
		  
		 }
		 else{
			 
			 out.println("Error in deleting the employee");
		 }
}
catch (Exception e){
out.println(e);
e.printStackTrace();
}

	
	}

}
