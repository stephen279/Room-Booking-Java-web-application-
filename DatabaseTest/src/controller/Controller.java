package controller;

import java.io.*
;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
import javax.servlet.http.HttpSession;
import org.apache.jasper.tagplugins.jstl.core.Out;
import database.Account;
import database.Rooms;
import beans.Entrys;
import beans.User;
import beans.User;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")     // Main controller
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;   //setup connection variable

	String JDBCUrl = "jdbc:oracle:thin:@136.206.35.131:1521:SSD";
    String LogInusername = "ee_user";
    String LogInpassword = "ee_pass";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");  //return the value email that was submitted by an  form
		String password = request.getParameter("password");
		User user = new User(email, password);  		// create instance object of User bean - logIn details
		user.setEmail(email);							// setsEmail of user bean to email
		HttpSession session = request.getSession(); 	//returns a session if one exists or creates a new one if it does not
		session.setAttribute("user", user);				//saves  user  in the session so can be accessed from jsp
		//System.out.println("email is" + email);
		String action = request.getParameter("action");  //requests action from jsp form.

		if (action == null) { 							// if action is null return to index.jsp 
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);

		} else if (action.equals("login")) { 			//if action equals "login"   can validate it now if form submitted can get info from form 
			request.setAttribute("validateErrormessage", "");
			request.setAttribute("email", "");			// sets email textfield equal to "" (null looks bad)
			request.setAttribute("password", "");
			request.setAttribute("message", "");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);							//forward to login form

		}

		else if (action.equals("createaccount")) {   
			request.setAttribute("validateErrormessage", "");
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("repeatpassword", "");
			request.setAttribute("message", "");
			request.getRequestDispatcher("/createaccount.jsp").forward(request,
					response);

		}

		else if (action.equals("createroom")) { 
			request.setAttribute("userName", "");
			request.setAttribute("costumerName", "");
			request.setAttribute("location", "");
			request.setAttribute("roomSize", "");
			request.setAttribute("roomPrice", "");
			request.setAttribute("location", "");
			request.setAttribute("contact", "");
			request.setAttribute("message", "");
			request.getRequestDispatcher("/roomEntry.jsp").forward(request,
					response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *      // used when form is submitted
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); 	 //requests action from jsp form.
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (action == null) {								 // if action is null forward to index.jsp
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);

		} else if (action.equals("dologin")) {  			 // if action equals "dologin" from login.jsp
			String email = request.getParameter("email"); 	 // gets parameter email from jsp form and saves it as variable String email
			String password = request.getParameter("password");
		//	System.out.println("inside do login in controller");
			User user = new User(email, password);
			HttpSession session = request.getSession(); 	//returns a session if one exists or creates a new one if it does not
			session.setAttribute("email", email);  			 //saves email in the session 

			request.setAttribute("email", email);  			// sets email equal to email passed in from the jsp form
			request.setAttribute("password", password);
			HttpSession session1 = request.getSession();
			String email1 = request.getParameter("email"); 	// gets parameter email from jsp form and saves it as variable String email1
			String password1 = request.getParameter("password");

			User user1 = new User(email, password1); 		// create instance object of User bean - logIn details
			user1.setEmail(email);					
			session1.setAttribute("user", user1);  			 //saves email in the session 
			
			//Now its time to connect to database //
			try {
				System.out.println("\nConnecting to the SSD Database......");
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(JDBCUrl, LogInusername,LogInpassword);
				
				System.out.println("succesfull  connection phase inside doPost! ");
			} catch (Exception e) {
				System.out.println("An error has occurred during the connection phase! Did you upload your Oracle Drivers?");
			}
		
			Account account = new Account(con);  			// Create instance object of Account and pass in con connection(does the sql statements to the database)

			try {
				if (account.login(email1, password1)) { 	 // calls account login method which returns a boolean true or false

					request.getRequestDispatcher("/loginSuccess.jsp").forward(   // if returned true forward to loginsuccess.jsp 
							request, response);

				} else {									 // if returned false
					request.setAttribute("message", user1.getMessage());   // set message to message from user bean validate()
					request.getRequestDispatcher("/login.jsp").forward(request,  // forward to login.jsp
							response);

				}
			} catch (SQLException e) {
				request.setAttribute("email", " problem");   
				e.printStackTrace();
			}
		}

		if (action == null) { 								// if action is null
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);

		}

		else if (action.equals("docreateaccount")) {   		// if action equals "docreateaccount" from createaccount.jsp

			System.out.println("inside controller?createaccount");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String repeatpassword = request.getParameter("repeatpassword");
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			request.setAttribute("repeatpassword", repeatpassword);

			try {
				System.out.println("\nConnecting to the SSD Database......");
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(JDBCUrl, LogInusername,LogInpassword);
				System.out
						.println("succesfull  connection phase inside doPost! your email is "
								+ request.getParameter("email")
								+ "and password is"
								+ request.getParameter("password")
								+ "and repeatpassword is"
								+ request.getParameter("repeatpassword"));
			} catch (Exception e) {
				System.out
						.println("An error has occurred during the connection phase! Did you upload your Oracle Drivers?");
			}

			if (!password.equals(repeatpassword)) {
				System.out
						.println("inside controller?createaccount password notmatching");

				request.setAttribute("message", " passwords do not match ");
				request.getRequestDispatcher("/createaccount.jsp").forward(
						request, response);
			} else {

				User user = new User(email, password);

				if (!user.validate()) {
				//	System.out.println("inside controller?createaccount password not match");
					request.setAttribute("message", user.getMessage());
					request.getRequestDispatcher("/createaccount.jsp").forward(
							request, response);

				} else {
					Account account = new Account(con);

					try {
						if (account.exists(email)) {
							System.out
									.println("inside controller?createaccount");
							request.setAttribute("message",
									"account already exists");
							request.getRequestDispatcher("/createaccount.jsp")
									.forward(request, response);

						} else {
							// we create account
							account.create(email, password);
							request.getRequestDispatcher("/createsuccess.jsp")
									.forward(request, response);

						}
					} catch (SQLException e) {
						request.setAttribute("message",
								"Problem with inserting data into sql");
						e.printStackTrace();
					}

				}

			}
		} else if (action.equals("docreateroom")) {				 // create room in database
			System.out.println("inside docreateroom ready for connecting to server");
			String userName = request.getParameter("userName");
			String costumerName = request.getParameter("costumerName");
			String location = request.getParameter("location");
			String roomSize = request.getParameter("roomSize");
			String roomPrice = request.getParameter("roomPrice");
			String contact = request.getParameter("contact");

			request.setAttribute("userName", userName);
			request.setAttribute("costumerName", costumerName);
			request.setAttribute("location", location);
			request.setAttribute("roomSize", roomSize);
			request.setAttribute("roomPrice", roomPrice);
			request.setAttribute("contact", contact);

			System.out.println("inside docreateroom /controller test userName is"
							+ userName + "costumerName" + costumerName
							+ "location" + location + "roomSize" + roomSize
							+ "roomprice" + roomPrice + "contact" + contact);

			// database connection will go here //
			try {
				
				System.out.println("\nConnecting to the SSD Database......");
			//	Class.forName("oracle.jdbc.driver.OracleDriver");
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(JDBCUrl, LogInusername,
						LogInpassword);
				
				System.out.println("succesfull  connection phase inside doPost! your room info is "
								+ request.getParameter("username")
								+ "and password is"
								+ request.getParameter("costumerName")
								+ "and repeatpassword is"
								+ request.getParameter("location")
								+ request.getParameter("roomSize")
								+ "and password is"
								+ request.getParameter("roomPrice")
								+ "and repeatpassword is"
								+ request.getParameter("contact"));
			} catch (Exception e) {
				System.out.println("An error has occurred during the connection phase! Did you upload your Oracle Drivers?");
			}

			Entrys entrys = new Entrys(userName, costumerName, location,
					roomSize, roomPrice, contact);       			 //  creates object of Entry bean and pass in data 

			if (!entrys.validate()) {           				 	  // if validate() is false
				// System.out.println("inside controller?entry.validate if not validate");
				request.setAttribute("message", entrys.getMessage());  // set message to entrys.getMessage
				request.getRequestDispatcher("/roomEntry.jsp").forward(request,
						response);

			} else {
				Rooms rooms = new Rooms(con); 							// we create room by calling rooms.create 
				// request.getRequestDispatcher("/createsuccess.jsp");
				try {
					rooms.create(userName, costumerName, location, roomSize,
							roomPrice, contact);
					request.getRequestDispatcher("/roomSuccess.jsp").forward(
							request, response);
				} catch (SQLException e) {
					request.setAttribute("message",
							"Problem with inserting data into sql");
					request.getRequestDispatcher("/roomEntry.jsp").forward(
							request, response);
					e.printStackTrace();
				}

			}

		}

		else if (action.equals("dobooking")) {        
			System.out.println("iside controller doBooking");
			String userNameb = request.getParameter("userName");
			String costumerNameb = request.getParameter("costumerName");
			String locationb = request.getParameter("location");
			String roomSizeb = request.getParameter("roomSize");
			String roomPriceb = request.getParameter("roomPrice");
			String contactb = request.getParameter("contact");

			request.setAttribute("userName", userNameb);
			request.setAttribute("costumerName", costumerNameb);
			request.setAttribute("location", locationb);
			request.setAttribute("roomSize", roomSizeb);
			request.setAttribute("roomPrice", roomPriceb);
			request.setAttribute("contact", contactb);

			// database connection will go here //
			try {
				System.out.println("\nConnecting to the SSD Database......");
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(JDBCUrl, LogInusername,
						LogInpassword);
				System.out
						.println("succesfull  connection phase inside doPost! your userName info is "
								+ request.getParameter("userName")
								+ "and costumername is"
								+ request.getParameter("costumerName")
								+ "and location is"
								+ request.getParameter("location")
								+ "and roomSize is"
								+ request.getParameter("roomSize")
								+ "and roomprice is"
								+ request.getParameter("roomPrice")
								+ "and contact is"
								+ request.getParameter("contact"));
			} catch (Exception e) {
				System.out.println("An error has occurred during the connection phase! Did you upload your Oracle Drivers?");
			}
		
		
	}
	
		}
	}


 
