package Booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EshopCartSerlet
 */
@WebServlet("/EshopCartSerlet")   //  selects all the carts RoomNames for UserName that is logged in.
public class EshopCartSerlet extends HttpServlet {
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
		Statement stmt = null;
	
			
			try {
				System.out.println("\nConnecting to the SSD Database......");
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(JDBCUrl, LogInusername,LogInpassword);
				
				System.out.println("succesfull  connection phase inside doPost! ");
			stmt = conn.createStatement();
			out.println("<html><head><title>Order Results</title></head><body>");
			String[] ids = request.getParameterValues("id");	
			String[] roomPrice = request.getParameterValues("roomPrice");
			System.out.println("ids (location)is"+ids+"");
			if (ids != null) {

				String sql = "SELECT roomName FROM zs_ord1 WHERE userName = (";

				sql += "'" + ids[0] + "'"; 

				for (int i = 1; i < ids.length; ++i) {

				   sql += ", '" + ids[i] + "'";  
				 

				}

				sql += ")";;

			
				ResultSet rss5 = stmt.executeQuery(sql);
				out.println("<h3>Name off rooms that you have previously booked</h3>");
				while (rss5.next()) {

						 out.println("<BR>roomname=" +rss5.getString("roomName") + " ");
					
						 rss5.getString("roomName");
				
					
					}
		
		

			 

			   }

		
			out.println("</body></html>");
			

			
		} catch (Exception e) {
			System.out.println("An error has occurred during the connection phase! Did you upload your Oracle Drivers?");
		
			e.printStackTrace();



		} finally {

			out.close();

			try {

			

				if (stmt != null)

					stmt.close();

				if (conn != null)

					conn.close();

			} catch (SQLException ex) {

				ex.printStackTrace();

			}

		}



		
		}
		}

