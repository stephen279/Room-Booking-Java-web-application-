<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  				 		<!-- sends doLogin to main Controller with the form parameters -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/DatabaseTest/style.css">
<title>Insert title here</title>
</head>
<body>
		A log in details that already exist: UserName: sh@msn.com   Password: Electronics1.there is form validation here
	<h1>
		Please login



		<form method="post"
			action='/DatabaseTest/Controller?action=dologin' />

			<table>
				<input type="hidden" name="action" value="dologin" />
				<!-- if submit form sends dolog to controller -->
				email:
				<input type="text" name="email"
					value="<%=request.getAttribute("email")%>" /> Password:
				<input type="text" name="password"
					value="<%=request.getAttribute("password")%>" />
				<input type="submit" value="log in here" />
			</table>
		</form>
	</h1>
	<%=request.getAttribute("message")%>


</body>
</html>
