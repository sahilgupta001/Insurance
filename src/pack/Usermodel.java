package pack;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Usermodel implements Serializable{
	private String uname;
	private String upass;
	
	
	String tablename = "adminlogin";
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	
	
	String m;
	public String validate(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bca1","123456");
			PreparedStatement ps = conn.prepareStatement("select * from "+tablename+" where username=? and password=?");
			ps.setString(1, uname);
			ps.setString(2, upass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				m="success";
			}
			else{
				m="failed";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	/*public String register(){
		try {
			Connection conn=ConnectionProvider.getConn();
			
			PreparedStatement ps = conn.prepareStatement("insert into "+ tablename+" values(?,?,?,?)");
			ps.setString(1, uname);
			ps.setString(2, upass);
			ps.setString(3, fname);
			ps.setString(4, lname);
			int i = ps.executeUpdate();
				if(i==0){
					m="failed";
				}
				else{
					m="success";
						
				}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return m;
	}
	public String changepass(){
try {Connection conn=ConnectionProvider.getConn();
		
PreparedStatement ps = 
conn.prepareStatement
("update usertable set password=? where username=?");
		ps.setString(1,getUpass());
		ps.setString(2,getUname());
		int i = ps.executeUpdate();
		if(i==0){
			m="failed";
		}
		else{
			m="success";
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}*/
	
	ArrayList<Usermodel>list=new ArrayList<>();
	public ArrayList<Usermodel> viewAllUsers(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345");
		PreparedStatement ps=conn.prepareStatement("select * from adminlogin");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
		String s1=rs.getString(1);
		String s2=rs.getString(2);
		
		Usermodel um=new Usermodel();
		um.setUname(s1);
		um.setUpass(s2);
		list.add(um);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}












