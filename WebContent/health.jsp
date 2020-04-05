<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Health Insurance</title>
<link rel="Stylesheet" type="text/css" href="style.css" />
<link rel="stylesheet"  href="menu.css"/>
<link rel="Stylesheet" type="text/css" href="form.css" />
</head>
<body>

<nav>
	<ul style="left: 0px; top: 0px">
	<li style="width: 176px"><a href="health.jsp">Health Insurance</a></li>
<li style="width: 176px"><a href="viewstatus">View Verification Status</a></li>
<li style="width: 176px"><a href="viewdetails">View Insurance Details</a></li>
<li style="width: 176px"><a href="Profile">Edit Profile</a>
<li style="width: 176px"><a href="claimapply.jsp">Apply for Claim</a></li>
<li style="width: 176px"><a href="claimapprovalstatus">Claim Approval Status</a></li>
<li style="width: 176px"><a href="Logout">Logout</a>

</ul>

</nav>
<div class="header-mid">
<div class="logo"><img src="images/logof.jpg" width=200px /></div>

<div class="logo-left">Cradle To Grave Patronage Insurance  Services</div>


</div>
<br/><br/><br/><br/><br/>
<div class="form-style-6">
<br/><br/>
<br/><br/><br/>
<form action="HealthServlet" method="post">
<fieldset style="width:100%">
<center>
Number of adults
<select name="sl1">
<option value="select">select</option>
<option value="1">1</option>
<option value="2">2</option>
</select>
<br/><br/><br/>


Number of children
<select name="sl2">
<option value="0">select</option>
<option value="1">1</option>
<option value="2">2</option>
</select>
<br/><br/><br/>


Age limit for adult 1
<select name="sl3">
<option value="select">select</option>
<option value="18-30">18-30</option>
<option value="31-40">31-40</option>
<option value="41-55">41-55</option>
<option value="56-65">56-65</option>
</select>
<br/><br/><br/>

Age limit for adult 2
<select name="sl4">
<option value="select">select</option>
<option value="18-30">18-30</option>
<option value="31-40">31-40</option>
<option value="41-55">41-55</option>
<option value="56-65">56-65</option>
</select>
<br/><br/><br/>

<h3><input type="submit" value="Get premium"></h3><br>
</center>
</fieldset>
</form>
</div>
</body>
</html>