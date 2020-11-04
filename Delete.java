
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
    {
       try
       {
           
           rs.setContentType("text/html");
           PrintWriter out=rs.getWriter();
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3318/abc?autoReconnect=true&useSSL=false","root","root");
           PreparedStatement st=con.prepareStatement("delete from data where Email=?");
           st.setString(1,rq.getParameter("Email"));
           int row=st.executeUpdate();
           if(row>0)
              out.print("Record Deleted successfully");
           else
               out.print("Record Not Exist");


rq.getRequestDispatcher("index.html").include(rq, rs);
           
       }
       catch(Exception e)
       {
           
       }
    }

    
    

}
