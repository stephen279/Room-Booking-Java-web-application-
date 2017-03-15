<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

     <!-- simple html when submit "check for bookings" it sends userName in session to EshopCartSerlet -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/DatabaseTest/styleSearch.css">
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
	<form method='get' action='/DatabaseTest/EshopCartSerlet' name='form'/>

		
				 <input type="hidden" name="id"
					value=<%=user.getEmail()%> />
				
				<input type="submit" value="check your bookings " style="width:650px ;height:40px" color="blue"/>
			</table>
		</form>
		<p>
			<b>&nbsp;&nbsp;&nbsp;&nbsp;Check your bookings cart by using your logged in session details !
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