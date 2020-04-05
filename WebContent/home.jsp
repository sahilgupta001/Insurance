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

<form action="HomeServlet" method="post">
<fieldset style="width:100%">

<center>
<h1><b>Home Insurance</b></h1>
<h2><b>Calculate Premium</b></h2><br/>
Location: 
<select>
<option value="select">select</option>
<option value="rohini">Rohini</option>
<option value="pitampura">Pitampura</option>
</select>
<br/><br/><br/>

Area(in sq ft):
<select>
<option value="select">Select</option>
<option value="500">500</option>
<option value="1000">1000</option>
</select>
<br/><br/><br/>

Floor:
<select>
<option value="none">None</option>
<option value="1">1</option>
<option value="2">2</option>
</select>
<br/><br/><br/>
<h3><input type="submit" value="Get premium"></h3><br>
</center>
</fieldset>
</form>
</div>

</body>


</body>
</html>