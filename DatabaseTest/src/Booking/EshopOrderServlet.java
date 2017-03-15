package Booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EshopOrderServlet")   // When Order button is pressed from form data sent here and saved inside zs_ord1 table
public class EshopOrderServlet extends HttpServlet {
	Connection con = null;   //setup connection variable

	String JDBCUrl = "jdbc:oracle:thin:@136.206.35.131:1521:SSD";
    String LogInusername = "ee_user";
    String LogInpassword = "ee_pass";

	private static final long serialVersionUID = 1L;


	@Override

	public void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		Statement stmtc = null;
		
			try {
				System.out.println("\nConnecting to the SSD Database......");
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(JDBCUrl, LogInusername,LogInpassword);
				
				System.out.println("succesfull  connection phase inside doPost! ");

			out.println("<html><head><title>Order Results</title></head><body>");
			String[] ids = request.getParameterValues("id");
			String[] roomPrice = request.getParameterValues("roomPrice");
			System.out.println("ids (location)is"+ids+"");

			if (ids != null) {

	
		   for (int i = 0; i < ids.length; ++i) {
					  String username =   request.getParameter("userName") ;
					  String password =   request.getParameter("password") ;

					  System.out.println("username = "+username+"");
					  System.out.println("password = "+password+"");

				//   sqlStr = "INSERT INTO zs_ord1 (ord_id, qty_ordered,roomname,userName,password) VALUES (222 ,1,'"+ ids[i] +"','" + request.getParameter("userName") +"','" 
					  //    + request.getParameter("password")+ "')";
	
						System.out.println("inside OrderServlet before sql");

						String sql = " INSERT  INTO zs_ord1 (ord_id,qty_ordered ,roomname,username, PASSWORD) values (oid.nextval,1,'"+ ids[i] +"',?,?) ";
						PreparedStatement stmt = conn.prepareStatement(sql);
						stmt.setString(1, username);
						stmt.setString(2, password);
						stmt.executeUpdate();

			      out.println("<h3>Your order for roomName is" + ids[i]

			            + " has been confirmed.</h3>");

			   }

			   out.println("<h3>Thank you.<h3>");

			} else { 

			   out.println("<h3>Please go back and select a room...</h3>");

			}

			out.println("</body></html>");
			
		} catch (Exception e) {
			System.out.println("An error has occurred during the connection phase! Did you upload your Oracle Drivers?");
		
			e.printStackTrace();



		} finally {

			out.close();

			try {
			
		
				if (stmtc != null)

					stmtc.close();

				if (conn != null)

					conn.close();

			} catch (SQLException ex) {

				ex.printStackTrace();

			}

		}



		
		}
		}

