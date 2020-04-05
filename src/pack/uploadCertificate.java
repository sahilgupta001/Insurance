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
 
@WebServlet("/uploadCertificate")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class uploadCertificate extends HttpServlet {
     
    private String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
    private String dbUser = "system";
    private String dbPass = "system";
     
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession();
		int id=(int) session.getAttribute("customerid");
		
         
        InputStream inputStream = null; // input stream of the upload file
        InputStream inputStream2 = null;
        
        
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("birth");
        Part filePart2 = request.getPart("idproof");
        if (filePart != null||filePart2 != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            
            System.out.println(filePart2.getName());
            System.out.println(filePart2.getSize());
            System.out.println(filePart2.getContentType());
            
            
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
            inputStream2 = filePart2.getInputStream();
        }
         
        Connection conn = null; // connection to the database
        String message = null;  // message will be sent back to client
         
        try {
            // connects to the database
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
 
            System.out.println("I m here after creating connection");
            // constructs SQL statement
            
            PreparedStatement statement = conn.prepareStatement("insert into upload values(?,?,?,'Verification Of Documents is Pending')");
            if (inputStream != null||inputStream2 != null) {
                // fetches input stream of the upload file for the blob column
                //statement.setBlob(3, inputStream,30000);
                statement.setBinaryStream(1,inputStream,300000);
                statement.setBinaryStream(2,inputStream2,300000);
            statement.setInt(3, id);
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