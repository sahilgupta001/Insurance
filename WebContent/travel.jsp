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

<form action="TravelServlet" method="post">
<fieldset style="width:100%">

<center>
<h1><b>Travel Insurance</b></h1>
<h2><b>Calculate Premium</b></h2><br/>
Place
<select name="sl1">
<option value="0">Select</option>
<option value="thailand">Thailand</option>
<option value="vegas">Vegas</option>
</select>
<br/><br/><br/>

Number of Days
<select name="sl2">
<option value="0">Select</option>
<option value="4">4</option>
<option value="7">7</option>

</select>
<br/><br/><br/>

Number of Migrant/s
<select name="sl3">
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select>
<br/><br/><br/>
<h3><input type="submit" value="Get premium"></h3><br>







</center>
</fieldset>
</form>
</body>
</html>