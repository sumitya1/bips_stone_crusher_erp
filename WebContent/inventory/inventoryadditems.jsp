<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Hello BIPS.</h2>

<form action="../inventoryset">
	<label>Item Name:</label><input type="text" name="item_name" size="10"/>
	<label>Item Type:</label>
	<select name="item_type">
    <option value="rented">Rented</option>
    <option value="owned">Owned</option>
    </select>
    <label>Owner Name:</label><input type="text" name="owner_name" size="10"/>
    <label>Rent Type:</label>
    <select name="rent_type" >
    <option value="hourly">hourly</option>
    <option value="daily">daily</option>
    </select>
    <label>Rent Rate:</label><input type="text" name="rent_rate" size="10"/>	
    
     <br/><br/><br/>
	<input type="SUBMIT" value="SUBMIT" size="30"/>
	
</form>
</body>
</html>