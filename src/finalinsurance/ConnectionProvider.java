package finalinsurance;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectionProvider {
	private ConnectionProvider(){}
	static Connection conn = null;
	static Connection con = null;
	public static Connection getConn(){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","<username>","<password>");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
					
			} 
			catch (Exception e) {
			e.printStackTrace();
		}
			return conn;
	}
}
	
