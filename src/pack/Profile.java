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
import javax.servlet.http.HttpSession;

import finalinsurance.ConnectionProvider;

@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name,pass,contact,email,city,state,address;
		HttpSession session=request.getSession();
		int id=(int) session.getAttribute("customerid");
		try {
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement
					("select * from customer where customerid=?");
			ps.setInt(1,id);
			
       		ResultSet rs=ps.executeQuery();
       		while (rs.next()){
       			name=rs.getString(2);
       			pass=rs.getString(4);
       		contact=rs.getString(5);
       				email=rs.getString(6);
       				city=rs.getString(7);
       				state=rs.getString(8);
       				address=rs.getString(9);
       				out.println("<form action=customerupdate>");
           		out.println("<center>");
       				out.println("<h1>Edit Personal Details </h1>");
       				out.println(" Name : <input type='text' name='t1' value='"+name+"'><br/>");
           			out.println("Password : <input type='text' name='t2' value='"+pass+"'><br/>");
           			out.println("CONTACT NO. : <input type='text' name='t3' value='"+contact+"'><br/>");
           			out.println("EMAIL-ID : <input type='email' name='t4' value='"+email+"'><br/>");
           			out.println("ADDRESS : <input type='text' name='t5' value='"+address+"'><br/>");
           			out.println("CITY : <input type='text' name='t6' value='"+city+"'><br/>");
           			out.println("STATE : <input type='text' name='t7' value='"+state+"'><br/>");
           			
           			
           			
           			out.println("<input type='submit' value='Update'>");
           			out.println("</center>");	
               		
           			out.println("</form>");
           			out.println("</center>");
           			}
           			}
           			catch(Exception k){k.printStackTrace();}
          	
	}

}
