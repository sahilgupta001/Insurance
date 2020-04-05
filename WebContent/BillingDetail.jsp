<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Billing detail</title>
</head>
<body>
<center>
<h1>PERSONAL DETAILS</h1>

<fieldset>
<form action="Billing" method="post">
<table>
<tr>

<td>FIRST NAME : <input type="text" placeholder="first name" name="t1" required="required"></td>
</tr>
<>
<tr>
<td>LAST NAME : <input type="text" placeholder="last name" name="t2" required="required"></td>
</tr>
<tr>
<td>ADDRESS : <input type="text" placeholder="address" name="t3" required="required"></td>
</tr>
<tr>
<td>STATE : <input type="text" placeholder="state" name="t4" required="required"></td>
</tr>
<tr>br./
<td>PIN CODE : <input type="text" placeholder="pin code" required data-val-required="*"  maxlength="6" name="t5" required="required"></td>
</tr>
<tr>
<td>PHONE NO. : <input type="number" placeholder="phone number" required data-val-required="*"  maxlength="10" name="t6" required="required"></td>
</tr>
<tr>
<td><center><input type="submit" value="Payment"></center></td>
</tr>
</table>
</form>

</fieldset>
</center>

</body>
</html>