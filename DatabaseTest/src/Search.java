import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import beans.User;
import database.Rooms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

@WebServlet("/Search")      // called from ajax_javascript to search zs_roo1 table for a location from ajaxform.jsp  
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String JDBCUrl = "jdbc:oracle:thin:@136.206.35.131:1521:SSD";
	String LogInusername = "ee_user";
	String LogInpassword = "ee_pass";

	public void doGet(HttpServletRequest request, HttpServletResponse res)
			throws ServletException, IOException {
		String location = request.getParameter("location");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String typed = request.getParameter("q").toLowerCase();
		String responsetext = new String("");

		try {
			location = typed;
			System.out.println("\nConnecting to the SSD Database......");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(JDBCUrl, LogInusername,
					LogInpassword);
			System.out.println("succesfull  connection phase inside doPost! ");

			String sql = "SELECT * FROM zs_roo1 WHERE location =?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, location);
			ResultSet rs = stmt.executeQuery();

			System.out.println("just after rs statement before while loop" + rs);
	
			// new form created with checkbox,s to select a room from options. 
			out.println("<form method='get' action='/DatabaseTest/EshopOrderServlet' name='form'/>");
			
			out.println("<table style= margin-left:800px  table border='9' cellspaccing='50'");
			out.println("<tr><th> </th><th>Roommname</th><th>roomprice</th><th>contact</tr>");

			while (rs.next()) { 
				
				
		 out.println("<td><input type='checkbox' name='id' value="

         + "'" + rs.getString("costumerName") + "'</td><td>"

         + rs.getString("costumerName") + "</td><td>" 

         + rs.getString("roomPrice") + "</td><td>$"

         + rs.getString("contact") + "</td>");
			
		 out.println("</tr>");
			}
			// fill out form with userName and password On Sbmit sends form data to EshopOrderServlet
			out.println("<p>Enter userName: <input type='text' name='userName'/></p>");
			out.println("<p>Enter password: <input type='text' name='password'/></p>");			
			out.println("<p><input type='submit' value='ORDER' />");
			out.println("<p>Please tick room to book into cart</p>");
			out.println("</form>");
		

			out.println("</body></html>");
			} catch (Exception e) {
			System.out
					.println("An error has occurred during the connection phase! Did you upload your Oracle Drivers?");
		}

		out.println(responsetext);
		out.close();
	}

	

}