<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Health Insurance</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>

<%@ include file="header.jsp" %>

<form action="vehicle" method="post">
<fieldset style="width:100%">
<center>
<h1><b>Vehicle Insurance</b></h1>
<h2><b>Calculate Premium</b></h2><br/>


Type Of Vehicle:<select name="t1" required="required">
<option value="select">select</option>
<option value="bike">bike</option>
<option value="car">car</option>
</select><br/><br/>

Manufacturer:<select name="t2" required="required">
<option value="select">select</option>
<option value="BMW">BMW</option>
<option value="Mercedes-Benz">Mercedes-Benz</option>
</select><br/><br/>

<h3><input type="submit" value="Get premium" name="b"></h3><br>
</center>
</fieldset>
</form>
</body>
</html>