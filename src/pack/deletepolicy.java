package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import finalinsurance.ConnectionProvider;

@WebServlet("/deletepolicy")
public class deletepolicy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	 String v1= request.getParameter("t1");
   	 String v2 = request.getParameter("t2");

   	 try{
		 Connection conn = ConnectionProvider.getConn();
	     
		 PreparedStatement ps = conn.prepareStatement("delete  from policytable where POLICYid=? or policyname=?");


		 ps.setString(1,v1);
		 ps.setString(2,v2);
		 ps.executeQuery();
		 int i = ps.executeUpdate();
		 out.println("policy delete successfully");

conn.close();
}
catch (Exception e){
out.println(e);
e.printStackTrace();
}

	
	}

}
