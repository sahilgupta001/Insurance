<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="Stylesheet" type="text/css" href="form.css" />
<title>Credit Card</title>
</head>
<body>
<center>

<fieldset>

<legend><b><font size="5">-----------------------------------------------<u>Pay By Credit Card</u>------------------------------------------------</font></b></legend>
<div class="form-style-6">
<br/><br/><br/>
<form action="CreditCard">
<img src="images/credit.jpg"><br/><br/>
<select>
<option>MASTERCARD</option>
<option>VISA</option>
<option>RUPEEY</option>
</select><br/><br/>

Cardholder Name :
 <input type="text" placeholder="UserName" name="t2" required="required" /></br></br><br/>
Credit Card Number :
 <input type="number" placeholder="card number" required data-val-required="*"  maxlength="16" name="t1" required="required"/></br></br><br/>

Expiry Date :
 
<select name="sl1">
<option value="select">select</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
</select>
 <select name="sl2">
 <option value="select">select</option>
<option value="2016">2016</option>
<option value="2017">2017</option>
<option value="2018">2018</option>
<option value="2017">2019</option>
<option value="2020">2020</option>
<option value="2021">2021</option>
<option value="2022">2022</option>
<option value="2023">2023</option>
<option value="2024">2024</option>
<option value="2025">2025</option>
<option value="2026">2026</option>
<option value="2027">2027</option>
<option value="2028">2028</option>
<option value="2029">2029</option>
<option value="2030">2030</option>
<option value="2031">2031</option>
</select><br/></br><br/>

CVV Number :
 <input type="number" placeholder="3-digit cvv number" required data-val-required="*"  maxlength="3" name="t3" required="required"/></br> <br/>
 
 <font size="20"><input type="submit" value="Make Payment"/> </font>



</form>
</div>
</fieldset>
</center>



</body>
</html>