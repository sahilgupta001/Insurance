<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Health Insurance</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<link rel="stylesheet"  href="menu.css"/>
<link rel="Stylesheet" type="text/css" href="form.css" />
</head>
<body>

<nav>
	<ul style="left: 0px; top: 0px">
<li style="width: 176px"><a href="Register.jsp">Register As Customer</a></li>
<li style="width: 176px"><a href="#">Login</a>
<ul>
<li ><a href="login.jsp">Login as Customer</a></li>
<li><a href="employeelogin.jsp">Login as Employee</a></li>
<li><a href="loginadmin.jsp">Login as Admin</a></li>
</ul>
</li>
		
		<li style="width: 160px"><a href="about.jsp">About Us</a>
		</li>
		<li style="width: 160px"><a href="contact.jsp">Contact Us</a>
		</li>
		
		</ul>
</nav>


<div class="header-mid">
<div class="logo"><img src="images/logof.jpg" width=200px  /> </div>

<div class="logo-left">Cradle To Grave Patronage Insurance  Services</div>


</div>



<br/>
<br/>
<br/><br/><br/>
<div class="form-style-6">
<br/><br/><br/><br/><br/><br/>
<form action="LoginServlet" method="post">
<fieldset style="width:100%">
<center>
<h1>CUSTOMER LOGIN</h1>
Customer Name:<input type="text" name="t1"><br><br>
Password:<input type="password" name="t2"><br><br>
<input type="submit" value="Login" name="b"><br/><br/>

</center>
</fieldset>
</form>
</div>
</body>

</html>