package pack;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 




import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
 
@WebServlet("/Claim")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class Claim extends HttpServlet {
     
    private String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
    private String dbUser = "system";
    private String dbPass = "system";
     
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	HttpSession session=request.getSession();
		int id=(int) session.getAttribute("customerid");
		String hname=request.getParameter("hname");
		String amount=request.getParameter("amount");
		System.out.println(hname+" "+amount+" "+id);
        InputStream inputStream = null; // input stream of the upload file
       
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("hbill");
        
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        
        }
         
        Connection conn = null; // connection to the database
        String message = null;  // message will be sent back to client
         
        try {
            // connects to the database
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
 
            System.out.println("I m here after creating connection");
            // constructs SQL statement
            
            PreparedStatement statement = conn.prepareStatement("insert into claim values(?,?,?,?,'Approval Of Documents is Pending',sysdate)");
            if (inputStream != null) 
            {
                // fetches input stream of the upload file for the blob column
                //statement.setBlob(3, inputStream,30000);
                
            	statement.setInt(1,id);
            	statement.setString(2,hname);
            	statement.setString(3,amount);
            	statement.setBinaryStream(4,inputStream,300000);
            }
 
            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
            	PrintWriter out=response.getWriter();
            	 out.println("<script type=\"text/javascript\">");  
		    	  out.println("alert('File uploaded and saved into database');");  
		    	  out.println("</script>");
		    	  RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
					rd.include(request,response);
		        
               
            }
        } catch (Exception ex) {
          ex.printStackTrace();
		}            }
    
}