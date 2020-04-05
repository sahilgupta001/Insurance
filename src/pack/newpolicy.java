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


@WebServlet("/newpolicy")
public class newpolicy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	 String v1= request.getParameter("t1");
   	 String v2 = request.getParameter("t2");

   	 try{
		 Connection conn = ConnectionProvider.getConn();
	     
		 PreparedStatement ps = conn.prepareStatement("insert into policytable values(pid.nextval,?,?)");
		 ps.setString(1,v1);	
ps.setString(2,v2);
int i = ps.executeUpdate();
if (i!=0) {
  out.println("POLICY ADDED SUCCESSFULLY");
  
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


