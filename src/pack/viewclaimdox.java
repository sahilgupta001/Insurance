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

@WebServlet("/viewclaimdox")
public class viewclaimdox extends HttpServlet {
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			//response.setContentType("text/html");
			//PrintWriter out=response.getWriter();
			String col1="";
			
			String option=request.getParameter("st");
			String cid=request.getParameter("customerId");
			
			//System.out.println("Option  :  "+option);
			//System.out.println("Customer Id : "+cid);
			
			if(option.equals("bill")){
				col1="bill";
			}
				
				
			
			try{
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select " +col1+" from claim where cid=?");
			ps.setInt(1, Integer.parseInt(cid));
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				response.getOutputStream().write(rs.getBytes(col1));
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			
			
			
	}

}
