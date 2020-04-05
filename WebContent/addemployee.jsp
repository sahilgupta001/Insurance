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


<form action="addemployee" method="post">
<fieldset style="width:100%">

<center>
<legend>NEW EMPLOYEE</legend>
<br/><br/>
Employee UserName:<input type="text" name="t1"><br><br>
Password:<input type="text" name="t2"><br><br>
Employee Name:<input type="text" name="t3"><br><br>

<input type="submit" value="Add Employee"><br/><br/>
</center>

</fieldset>
</form>
</body>
</html>