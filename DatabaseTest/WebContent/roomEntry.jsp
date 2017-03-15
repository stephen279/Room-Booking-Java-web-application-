<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

				<!-- sends docreateRoom to main Controller with the form parameters --> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/DatabaseTest/style.css">
<title>SmartRoom.com</title>
<h2>SmartRoom.com</h2>

</head>
<body>


	<a href="/DatabaseTest/Controller?action=login"> login here</a>
	<a href="support.jsp">Register for an
		administration  account</a> Administration details needed to enter a room for viewing!(userName = "admin")

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
			<b>&nbsp;&nbsp;&nbsp;&nbsp;Enter Room for viewing In
				SmartRoom.com</b></b><br> Please Fill out form for a room you want to
			advertise in SmartRoom.com (userName must be: admin)
		</p>
		<div id="tabs">
			<ul>
				<li><a href="index.jsp">About</a></li>
				<li><a href="ajaxform.jsp">BookRoom</a></li>
				<li><a href="roomEntry.jsp">RoomEntry</a></li>
				<li><a href="cart.jsp">Booking-Cart</a></li>
					<li><a href="support.jsp">Support.jsp</a></li>
			</ul>
		</div>
	</div>



	<form method="post"
		action='/DatabaseTest/Controller?action=docreateroom'/>

		<table>
			<input type="hidden" name="action" value="docreateroom" />
			<!-- if submit form sends dolog to controller -->
			userName:
			<input type="text" name="userName"
				value="<%=request.getAttribute("userName")%>" /> costumer:
			<input type="text" name="costumerName"
				value="<%=request.getAttribute("costumerName")%>" /> Location:
			<input type="text" name="location"
				value="<%=request.getAttribute("location")%>" />
			<br> RoomSize:
			<input type="text" name="roomSize"
				value="<%=request.getAttribute("roomSize")%>" /> RoomPrice:
			<input type="text" name="roomPrice"
				value="<%=request.getAttribute("roomPrice")%>" /> Contact:
			<input type="text" name="contact"
				value="<%=request.getAttribute("contactDetails")%>" />
			<br>
			<input type="submit" value="Save Room" />
		</table>
	</form>

	</h1>
	<p class="message">
		<%=request.getAttribute("message")%>
	</p>

</body>
</html>