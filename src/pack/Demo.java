package pack;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import finalinsurance.ConnectionProvider;






import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
 
@WebServlet("/Demo")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class Demo extends HttpServlet {
     
     
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
         
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
         
        
        String message = null;  // message will be sent back to client
        HttpSession session=request.getSession();
			int x=(int) session.getAttribute("Fullname");
	
        try {
        	
        	 Connection conn = ConnectionProvider.getConn();
        	 {
        		 PreparedStatement ps = conn.prepareStatement("select * from customer where name=?");
        		 ps.setInt(1,x);
        		 ResultSet rs=ps.executeQuery();
        		 while(rs.next()) 
 				{

        			 String username=rs.getString(3);
        			 String contact=rs.getString(4);
        			 String email=rs.getString(5);
 						}
        	 
        	 }
        	
            // connects to the database
           
            System.out.println("I m here after creating connection");
            // constructs SQL statement
            
            PreparedStatement statement = conn.prepareStatement("insert into upload values(transactionid.nextval,?,?,?,?,?,?,?,?,?,?,?,?)");
            if (inputStream != null||inputStream2 != null)
            {
                // fetches input stream of the upload file for the blob column
                //statement.setBlob(3, inputStream,30000);
                statement.setBinaryStream(1,inputStream,300000);
                statement.setBinaryStream(2,inputStream2,300000);
            }
 
            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
            	PrintWriter out=response.getWriter();
               out.println("File uploaded and saved into database");
            }
        } catch (Exception ex) {
          ex.printStackTrace();
		}            }
    
}