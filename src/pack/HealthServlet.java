package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import finalinsurance.ConnectionProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HealthServlet")
public class HealthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int flag=0;
	int premium1=0,premium2=0,childPremium=0;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		int id=(int) session.getAttribute("customerid");
		
	
		
		String age1="",age2="";
		int total=0;
		int adult1=Integer.parseInt(request.getParameter("sl1"));
		int child=Integer.parseInt(request.getParameter("sl2"));
		
		
		if(adult1==1){
			age1=request.getParameter("sl3");
		}
		if(adult1==2){
			flag=1;
			age1=request.getParameter("sl3");
			age2=request.getParameter("sl4");
		}
		
		try
		{
			
			if(flag==0){
				Connection conn=ConnectionProvider.getConn();
				PreparedStatement ps=conn.prepareStatement("select premium from health where ageslab=? and category=?");
				ps.setString(1,age1);
				ps.setString(2,"adult");
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					premium1=rs.getInt(1);
				}
				conn.close();
			}
			if(flag==1){
				Connection conn=ConnectionProvider.getConn();
				PreparedStatement ps=conn.prepareStatement("select premium from health where ageslab=? and category=?");
				ps.setString(1,age1);
				ps.setString(2,"adult");
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					premium1=rs.getInt(1);
					PreparedStatement ps1=conn.prepareStatement("select premium from health where ageslab=? and category=?");
					ps1.setString(1,age2);
					ps1.setString(2,"adult");
					ResultSet rs1=ps1.executeQuery();
					if(rs1.next()){
						premium2=rs1.getInt(1);
					}
					
				}
				conn.close();
			}
			if(child>0){
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select premium from health where category='child'");
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				childPremium=rs.getInt(1);
				if(child==2){
					childPremium=2*childPremium;
				}
			}
			conn.close();
			}
			
			out.println("Premium for Adult 1 : "+premium1);
			out.println("<br/>");
			out.println("Premium for Adult 2 : "+premium2);
			out.println("<br/>");
			out.println("Premium for Child : "+childPremium);
			out.println("<br/><br/>");
			
			
			out.println("Total Premium : "+(premium1+premium2+childPremium));
			total=premium1+premium2+childPremium;
			try{
			Connection conn=ConnectionProvider.getConn();
				PreparedStatement ps=conn.prepareStatement("insert into healthcalc values(?,?,?,?,?,?)");
				ps.setInt(1,id );
				ps.setInt(2,adult1);
				ps.setInt(3,child);
				ps.setString(4,age1);
				ps.setString(5, age2);
				ps.setInt(6, total);
				int i=ps.executeUpdate();
				if(i!=0){
				out.println("Record Inserted Successfully");	
				}
				
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			out.println("<br/><br/>");
			out.println("<a href='UploadDocuments.jsp'>Upload Documents for Submission</a>");
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		out.println("<form action=''");
		out.println("<input type='submit' value='Submit documents for verification'>");
	}
	

}
