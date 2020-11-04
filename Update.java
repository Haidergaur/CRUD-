
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
    {
       try
       {
           String a=rq.getParameter("Name");
           String b=rq.getParameter("Address");
           String c=rq.getParameter("Email");
           rs.setContentType("text/html");
           PrintWriter out=rs.getWriter();
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3318/abc?autoReconnect=true&useSSL=false","root","root");
           PreparedStatement ps=con.prepareStatement("update data set Name=?,Address=? where Email=?");
           ps.setString(1,a);
           ps.setString(2,b);
           ps.setString(3,c);
           int row=ps.executeUpdate();
           if(row>0)
                 out.print("<html><marquee>Record Updated</marquee></html>");
           else
               out.print("<html><marquee>Record Not Found</marquee></html>");
           
           rq.getRequestDispatcher("index.html").include(rq, rs);
           
       }
       catch(Exception e)
       {
           
       }
    }

    
    

}
