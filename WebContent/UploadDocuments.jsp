<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>insurance</title>
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
<li style="width: 176px"><a href="">Apply for Claim</a></li>
<li style="width: 176px"><a href="">Claim Approval Status</a></li>
<li style="width: 176px"><a href="Logout">Logout</a>

</ul>

</nav>

<div class="header-mid">

<div class="logo"><img src="images/logof.jpg" width=200px /></div>

<div class="logo-left">Cradle To Grave Patronage Insurance  Services</div>


</div>
<div class="form-style-6">
<br/><br/><br/>
<center>

	<form action="uploadCertificate" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>
				<br/><br/><br/>
				Birth Certificate :
				</td>
				<td>
				<br/><br/><br/>
				<input type="file" name="birth"/>
				</td>
			</tr>
			<tr>
				<td>
				<br/><br/><br/>
					ID Proof :
				</td>
				<td>
				<br/><br/><br/>
				<input type="file" name="idproof">
				</td>
			</tr>
			<tr> 
				<td colspan="2">
				<br/><br/><br/>
				<input type="submit" value="Upload Documents">
				</td>
			</tr>
		</table>
		
		<br/>
		
		<br/>
		
	</form>
	</center>
	</div>
</body>
</html>