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

@WebServlet("/DebitCard")
public class DebitCard extends HttpServlet {
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			 String mode="debit";
			 
			 HttpSession session=request.getSession();
			 int id=(int) session.getAttribute("customerid");
			 
		    String cno=request.getParameter("t1");
		    String username=request.getParameter("t2");
			String cvv=request.getParameter("t3");
			int	month=Integer.parseInt(request.getParameter("sl1"));
			int year=Integer.parseInt(request.getParameter("sl2"));

			int c=cno.length();
			int d=username.length();
			int e=cvv.length();
			
			out.println("<script type=\"text/javascript\">");
			
			if(c!=16)
				out.println("alert('please enter valid length of Card number i.e.16');");
				
			
			
			if(!((d>4)&(d<20)))
				out.println("alert('character length must be between 4 to 16');");
					
				
			if(e!=3)
				out.println("alert('please enter valid length of number i.e.3');");
			
			
			 out.println("</script>");
			
			 
			 try
			 {
				 Connection conn=ConnectionProvider.getConn();
				 PreparedStatement ps=conn.prepareStatement("insert into billing values(?,?,?,?,?,?,?,sysdate)");
				 
				 ps.setInt(1,id);
				 ps.setString(2,mode);
				 ps.setString(3,cno);
				 ps.setString(4,username);
				 ps.setInt(5,month);
				 ps.setInt(6,year);
				 ps.setString(7,cvv);
				 
				 ResultSet rs=ps.executeQuery();
					if(rs.next()){
						out.println("<script type=\"text/javascript\">");
						out.println("alert('PAYMENT SUCCESSFULL');");
						out.println("</script>");
						RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
						rd.include(request,response);
			        
					}
					conn.close();
				 
			 }catch(Exception ex)
			 {
				 ex.printStackTrace();
			 }
		
	
		}
			
			
					



	}


