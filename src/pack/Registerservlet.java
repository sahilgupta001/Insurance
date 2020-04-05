package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import finalinsurance.ConnectionProvider;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	 String v1= request.getParameter("t1");
   	 String v2 = request.getParameter("t2");
   	 String v3= request.getParameter("t3");   	 	
   	 String v4 = request.getParameter("t4");
   	String v5= (request.getParameter("t5"));
   	 String v6 = request.getParameter("t6");
	 String v7 = request.getParameter("t7");
   	 String v8 = request.getParameter("t8");
   	String v9 = request.getParameter("t9");
   
   	 try{
		 Connection conn = ConnectionProvider.getConn();
	     
		 PreparedStatement ps = conn.prepareStatement("insert into customer values(custid.nextval,?,?,?,?,?,?,?,?,?,sysdate)");

ps.setString(1,v1);
ps.setString(2,v2);
ps.setString(3,v3);
ps.setString(4,v4);
ps.setString(5,v5);
ps.setString(6,v6);
ps.setString(7,v7);
ps.setString(8,v8);
ps.setString(9,v9);

int i = ps.executeUpdate();
if (i!=0) {
  out.println("REGISTERED Successfully <a href='login.jsp'>Click Here</a> TO Login");
  
}
else{
  out.println("failed to insert the data");
}
conn.close();
}
catch (Exception e){
out.println(e);
e.printStackTrace();
}
}



}


