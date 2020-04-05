package pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import finalinsurance.ConnectionProvider;

@WebServlet("/employeeviewdocument")
public class employeeviewdocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String col1="";
		
		String option=request.getParameter("st");
		String cid=request.getParameter("customerId");
		
		//System.out.println("Option  :  "+option);
		//System.out.println("Customer Id : "+cid);
		
		if(option.equals("birth")){
			col1="image1";
		}
		if(option.equals("id")){
			col1="image2";
		}
			
			
		
		try{
		Connection conn=ConnectionProvider.getConn();
		PreparedStatement ps=conn.prepareStatement("select " +col1+" from upload where id=?");
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
