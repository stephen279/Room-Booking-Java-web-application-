<html>
<head>
  <!-- simple search textfield which is connected to ajax_javascript.js   -->
<title>Example Ajax Form</title>
<script src="ajax_javascript.js"></script>
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

		} else {
			System.out.println("user does have email validated");
		}
	%>
	<div>

		<br />example location already in database: cavan, dublin...... 
		<p>
			<b>Search rooms by location using ajax(onkeyup): </b> <input type="text"
				autocomplete="on" onkeyup="showHint(this.value)"
				name="searchString" size="20" maxlength="30" /> 
				

	



		<div id="tabs">
			<ul>
				<li><a href="index.jsp">About</a></li>
				<li><a href="ajaxform.jsp">BookRoom</a></li>
				<li><a href="roomEntry.jsp">RoomEntry</a></li> 
				<li><a href="cart.jsp">Booking-Cart</a></li>
					<li><a href="support.jsp">Report/Support.jsp</a></li>
			</ul>
		</div>
		
			<div id="txtHint">No Suggestions</div>

	</div>

</p>
</body>
</html>