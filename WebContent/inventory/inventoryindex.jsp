<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to Inventory Management System.</h2>
<form action="../personservlet">
	<label>Item Name</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<label>Rate</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<label>Quantity</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<label>Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<label>Usage</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<label>Fuel</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<label>Amount</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<label>Payment</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<label>Balance</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<br>
	<select name="item" >
    <option value="tractor">Tractor</option>
    <option value="hammer">Hammer Machine</option>
    <option value="crwaler">Crawler Compressor</option>
    </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" value="rate" name="rate" size="10" />
	&nbsp;&nbsp;&nbsp;&nbsp;
	<select name="quantity">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
  </select>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <input type="text" value=systemdate name="systemdate" size="10" />
&nbsp;&nbsp;&nbsp;&nbsp;
 <input type="text" value="usage" name="usage" size="10"/>
	&nbsp;&nbsp;&nbsp;&nbsp;
 <input type="text" value="fuel"  name="fuel" size="10"/>
	&nbsp;&nbsp;&nbsp;&nbsp;
 <input type="text" value="amount" name="amount" size="10"/>
	&nbsp;&nbsp;&nbsp;&nbsp;
 <input type="text" value="payment" name="payment" size="10"/>
	&nbsp;&nbsp;&nbsp;&nbsp;
 <input type="text" value="balance" name="balance" size="10"/>
	&nbsp;&nbsp;&nbsp;&nbsp;
  <br/><br/><br/>
	<input type="SUBMIT" value="Send" size="30"/>
	
</form>
</body>
</html>