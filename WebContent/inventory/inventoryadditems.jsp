<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function test() {
    if (document.getElementById('item_type').value == 'rented') {
        document.getElementById('owner_label').style.display = 'block';
       
    }
</script>
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Welcome to Inventory Management System</h2>

<form action="../inventoryset">
	<label style="margin-left: 50px;">Item Name:</label><input type="text" name="item_name" size="10"/>
	<br><br>
	<label style="margin-left: 50px;">Item Type:</label>
	<select name="item_type" id="item_type" onclick="test()">
    <option value="default" selected="selected">select</option>
    <option value="rented">Rented</option>
    <option value="owned">Owned</option>
    </select>
    <br>
  	<label id="owner_label" style="display:none" style="margin-left: 50px;" >Owner Name:</label><input id="owner_field" type="text" style="display:none" name="owner_name" size="10"/>
  	<br>
    <label style="margin-left: 50px;">Rent Type:</label>
    <select name="rent_type" >
    <option value="hourly">hourly</option>
    <option value="daily">daily</option>
    </select>
    <br>
    <br>
    <br>
    <label style="margin-left: 50px;">Rent Rate:</label><input type="text" name="rent_rate" size="10"/>	
    
   
     <br/><br/><br/>
	<input type="SUBMIT" value="SUBMIT" size="30"/>
	
</form>
</body>
</html>