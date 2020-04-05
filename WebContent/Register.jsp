<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<link rel="Stylesheet" type="text/css" href="form.css" />
<style type="text/css">
form fieldset input[type="submit"] {
background-color: blue;
border: none;

border-radius: 3px;
-moz-border-radius: 3px;
-webkit-border-radius: 3px;
color: #f4f4f4;
cursor: pointer;
font-family: 'Open Sans', Arial, Helvetica, sans-serif;
height: 40px;
text-transform: uppercase;
width: 100px;
}
legend {
    padding-left: 2px;
    padding-right: 2px;
    color:red;
}
</style>
</head>
<body>
<jsp:include page="nav.jsp"/>
<center>
<legend>REGISTRATION FORM</legend>

<div class="form-style-6">
<br/>
<form action="Register" method="post">
<fieldset>


NAME :<input type="text" name="t1" placeholder="Name" required="required"><p/>
USERNAME :<input type="text"  placeholder="UserName"name="t2" required="required"><p/>
PASSWORD :<input type="password" name="t3"  placeholder="Password" required="required"><p/>
CONTACT NO. :<input type="number" required data-val-required="*"  maxlength="10" placeholder="Contact No." type="text" name="t4" required="required"><p/>
EMAIL-ID :<input type="email" data-val="true"  placeholder="email-id" data-val-regex="*" required data-val-regex-pattern="\w+([-+.&#39;]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*" data-val-required="*" name="t5" required="required"><p/>
CITY: <select name="t6">
	<option>Mumbai (Bombay)	</option>

<option>Kolkata (Calcutta)	</option>

<option>Delhi	</option>

<option>Chennai	</option>
<option>Bangalore	</option>

<option>Hyderabad	</option>

<option>Ahmadabad	</option>

<option>Pune	</option>

<option>Surat	</option>

<option>Kanpur	</option>

<option>Jaipur	</option>

<option>Lucknow	</option>

<option>Nagpur	</option>

<option>Patna	</option>

<option>Indore	</option>

<option>Vadodara	</option>

<option>Bhopal	</option>

<option>Coimbatore	</option>

<option>Ludhiana	</option>

<option>Kochi	</option>

<option>Visakhapatnam	</option>

<option>Agra	</option>

<option>Varanasi	</option>

<option>Madurai	</option>

<option>Meerut	</option>

<option>Nashik	</option>

<option>Jabalpur	</option>

<option>Jamshedpur	</option>

<option>Asansol	</option>
<option>Dhanbad	</option>

<option>Faridabad</option>	

<option>Allahabad	</option>

<option>Amritsar	</option>

<option>Vijayawada	</option>

<option>Rajkot</option>
</select><p/>

STATE:<input type="text"  placeholder="State"name="t7" required="required"><p/>
ADDRESS:<textarea name="t8" placeholder="Address" required="required"></textarea><p/>
Policy Name:<input type="text"name="t9"  value="Health" readonly required="required"></textarea><p/>
<input type="submit" value="register">


</fieldset>
</form>
</div>
</center>
</body>
</html>