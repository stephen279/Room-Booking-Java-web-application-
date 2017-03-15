<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title></title>
</head>
<body>
<p>
	<strong>Student name:</strong>
	<strong> </strong>
	<em> Stephen holland</em>
</p>
<p>
	<strong>Student Id:  13210385 </strong>
</p>
<p>
	<strong>Assignment description: </strong>
	<em>room booking service </em>
</p>
<p>
	<strong><em>Eclipse File Name:</em></strong>
	<em> </em>
	<em>DatabaseTest</em>
</p>
<p>
	<em></em>
	<br/>
</p>
<p>
	<em>My room booking service called smartroom has the following functionality:</em>
</p>
<p>
	<em>Note: The website must be run from the controller.java inside eclipse. For my Ajax to work it will only work in chrome so </em>
	<em>http://localhost:8080/DatabaseTest/Controller</em>
	<em> is the link to start up in chrome.</em>
</p>
<p>
	<strong><em></em></strong>
	<br/>
</p>
<ul>
	<li>
		&#8226; <strong>Register an Account which is saved to a database by using register an account. </strong>
	</li>
</ul>
<p>
	Files used. Controller.java, Createaccount.jsp, Createsuccess.jsp, User.java (bean), Account.java (sql content).
</p>
<p>
	How this works? When say inside index.jsp and you hit the link <em>register an account </em>which links to <em>roomEntry.jsp</em> .After filling out the
	form On submit you call an <em>action=createaccount</em> to <em>controller.java</em>
</p>
<p>
	Which gets info from the form such as requesting parameters and setting attributes. A database connecting is then established and a User bean object is
	called which does the setters and getters and some validation. Then the User.Validate () function is called that does some validation of the form, If a Boolean true is returned From User.java
	then the Account. Create method is called which does all our sql statement to our database zs_cos1 table, and a new account is created and
	CreateSuccess.jsp is called. If false is returned due to an issue the user will be redirected and a error message will appear. Also another validation of
	password matching has to be true
</p>
<ul>
	<li>
		&#8226; <strong><em>Log in to your registered account.</em></strong>
	</li>
</ul>
<p>
	Files used. Controller.java, Login.jsp, LoginSuccess.jsp, User.java (bean), Account.java.
</p>
<p>
	How this works? When say inside index.jsp and you hit the link <em>Login </em>which links to <em>Login.jsp</em>
</p>
<p>
	After filling out the form on submit you call an <em>action=doLogin </em>to <em>controller.java</em> which gets info from the form such as requesting
	parameters and setting attributes. .A database connecting is then established and a User bean object is called which does the setters and getters and some
	validation. Then the user. Validate () function is called, If a Boolean true is returned From User.java then the Account. Exists () method is called which
	does all our sql statement to our database and checks login and returns Boolean true if there is a match.
</p>
<p>
	<strong><em></em></strong>
	<br/>
</p>
<p>
	<strong><em></em></strong>
	<br/>
</p>
<ul>
	<li>
		&#8226; <strong><em>If "admin" userName you can enter a room to be advertised on site.</em></strong>
	</li>
</ul>
<p>
	Files used. Controller.java, roomEntry.jsp, roomSuccess.jsp, Entrys.java (bean), Room.java (sql content).
</p>
<p>
	How this works? When say inside index.jsp and you hit the Navigation ul <em>roomEntry </em>which links to <em>roomEntry.jsp.</em> After filling out the
	form (username must be "admin" or an error will appear) on submit you call an <em>action=doCreateRoom to</em> <em>controller.java</em> which gets info from
	the form such as requesting parameters and setting attributes. .A database connecting is then established and a Entry bean object is called which does the
	setters and getters and some validation . Then the Entry. Validate () function is called, If a Boolean true is returned From Entry.java then the Room.
	Create () method is called which does all our sql statement to our database zs_roo1, and a new room is created and RoomSuccess.jsp is called. If false is
	returned due to an issue the user will be redirected and an error message will appear.
</p>
<ul>
	<li>
		&#8226; <strong><em>Search for rooms advertised by location using Ajax.</em></strong>
	</li>
</ul>
<p>
	Files used. ajaxform.jsp, ajax_javascript.js, Search.java, EshopOrderServlet.java.
</p>
<p>
	How this works? When say inside index.jsp and you hit the Navigation ul <em>Bookroom </em>which links to <em>ajaxform.jsp. </em>
	<em>
		Which has an html text field that is linked to our JavaScript ajax_javasript.js file which will use the Search.java Servlet, which will look for a
		result in
	</em>
	<em>zs_roo1 table, </em>
	<em>
		if there is a result from the sql statement a html table of that info will be displayed including a checkbox option.(needed for next functionality).
	</em>
</p>
<ul>
	<li>
		&#8226; <strong><em>Add selected room to your cart.</em></strong>
	</li>
</ul>
<p>
	Files used. Search.java, EshopOrderServlet.java.
</p>
<p>
	How this works? So know you can tick your preferred room choice you want to add to your cart and fill out an additional form containing your username and
	password and submit Order. This will then send that formation from your form and checkbox to EshopOrderServlet.java. Where it will be inserted into the
	zs_ord1 table under that username you entered.
</p>
<ul>
	<li>
		&#8226; <strong><em>Check what rooms are in your booking cart.</em></strong>
	</li>
</ul>
<p>
	Files used. cart.jsp, EshopCartServlet.java
</p>
<p>
How this works? When say inside index.jsp and you hit the Navigation ul <em>Booking-cart which</em> links to <em>cart.jsp.</em>	<em> Inside this when you hit "check your bookings" button the username that you are signed in as and is in your session will be submitted to the </em>
	EshopCartServlet.java where it will select statement for the roomname of all of that userNames that are in the zs_ord1 table.
</p>
<p>
	<em> </em>
</p>
<p>
	<strong><em></em></strong>
	<br/>
</p>
<ul>
	<li>
		&#8226; <strong><em>Using session can see your username on each page.</em></strong>
	</li>
</ul>
<p>
	Files used. Controller.java, <em>all</em> .jsp files
</p>
<p>
	How this works? I have set up a httpSession in main controller.java file which then sets the Attribute for that session so it can be used inside any of the
	.jsp files by calling the session.getAttribute.
</p>
<p>
	<strong><em></em></strong>
	<br/>
</p>
<p>
	<strong><em>Other Files used:</em></strong>
</p>
<p>
	<em>Style.css </em>
	<em>used for styling main website</em>
</p>
<p>
	<em>SearchStyle.css </em>
	<em>used for styling the search part off website.</em>
</p>
<p>
	<em>Schemas.txt </em>
	<em>used for setting up sql content.</em>
</p>
</body>
</html>