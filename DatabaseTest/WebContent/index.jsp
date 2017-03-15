<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/DatabaseTest/style.css">
<title>SmartRoom.com</title>
<h2>SmartRoom.com</h2>

</head>
<body>


	<a href="/DatabaseTest/Controller?action=login"> login here</a>
	<a href="/DatabaseTest/Controller?action=createaccount">Register a
		new account</a> Logged in session with email:

	<%@ page import="beans.*"%>
	<%
		User user = (User) session.getAttribute("user");
	%>
	<%=user.getEmail()%>

	<%
		if (user.getEmail() == (null)) {
			out.println("PLEASE LOG IN");
			System.out.println("user is not equal email");

		} else { %>
			


		<%	}
		%>
	
	<div>

		<p>
			<b>&nbsp;&nbsp;&nbsp;&nbsp;About SmartRoom.com</b></b><br> Welcome,
			This is a website that allows you to search and book a Room.<br>
			
			<b>1</b> Register an new account username:sh@msn.com password:Electronics1 already registered<br>
			<b>2</b> Log in with new account details<br>
			<b>3</b> Go into RoomEntry and enter a new room to be saved for viewing using "admin" as userName.<br>
			<b>4</b> Go into BookRoom and enter location you want to search for a room using ajax.<br>
			<b>5</b> tick the checkbox off the room you want to book and fill out form then press order.<br>
			<b>6</b> Go into Booking-cart and press "check you bookings" to see the roomNames that you have already booked. <br>			
			<a href="support.jsp">Assignment Report</a>original word report in DatabaseTest/Report.docx
		</p>
		<div id="tabs">
			<ul>
				<li><a href="index.jsp">About</a></li>
				<li><a href="ajaxform.jsp">BookRoom</a></li>
				<li><a href="roomEntry.jsp">RoomEntry</a></li> 
				<li><a href="cart.jsp">Booking-Cart</a></li>
				<li><a href="support.jsp">Report/Support.jsp</a></li>
			</ul>
		</div>
	</div>

</body>
</html>