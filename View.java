
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class View extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
    {
       try
       {
           
           rs.setContentType("text/html");
           PrintWriter out=rs.getWriter();
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3318/abc?autoReconnect=true&useSSL=false","root","root");
           Statement st=con.createStatement();
           String q="select * from data";
           ResultSet r1=st.executeQuery(q);
           while(r1.next())
           {
             
                out.print(r1.getString(1)+"\t"+r1.getString(2)+"\t"+r1.getString(3)+"\t"+r1.getString(4));
                 out.print("<br><br>");
           }
             
           


//rq.getRequestDispatcher("index.html").include(rq, rs);
           
       }
       catch(Exception e)
       {
           
       }
    }

    
    

}
