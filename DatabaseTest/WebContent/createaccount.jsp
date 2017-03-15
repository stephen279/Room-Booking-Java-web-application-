<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

		<!-- sends docreateAccount to main Controller with the form parameters -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/DatabaseTest/style.css">
<title>Create Account</title>
</head>
<body>
an Account thats already registered inside database:UserNAme zach@msn.com  password: Electronics1 . ther is form validation here.
<h1>Please Create Account</p>
<h2>

<form   method = "post"  action ='/DatabaseTest/Controller?action=docreateaccount'/>

<table>
<input type="hidden" name="action" value="docreateaccount" /> <!-- if submit form sends dolog to controller -->
email:<input type = "text" name ="email" value="<%= request.getAttribute("email") %>" />
password: <input type ="text" name ="password" value="<%= request.getAttribute("password") %>" />
Repeat Password: <input type="text" name="repeatpassword" value="<%= request.getAttribute("repeatpassword") %>" />
<input type= "submit" value ="log in here" />
</table>
</form>

</h1>
<p class="message"> <%= request.getAttribute("message") %> </p>


</body>
</html> 