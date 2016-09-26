<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function test() {
		if (document.getElementById('item_type').value == 'rented') {
			document.getElementById('rentedTable').style.display = 'block';
			document.getElementById('ownedTable').style.display = 'none';

		} else if (document.getElementById('item_type').value == 'owned') {
			document.getElementById('ownedTable').style.display = 'block';
			document.getElementById('rentedTable').style.display = 'none';
			

		} else {
			document.getElementById('rentedTable').style.display = 'none';
			document.getElementById('ownedTable').style.display = 'none';

		}

	}
	
	
	
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BIPS STONE CRUSHER ERP</title>
</head>
<body>
	<h2 align="center">Welcome to Inventory Management System</h2>

	<form action="../inventoryset">
		<label style="margin-left: 50px;">Item Name:</label>
		<input type="text" name="item_name" size="10" required/> <br>
		<br> <label style="margin-left: 50px;">Item Type:</label>
		 <select
			name="item_type" id="item_type" onclick='test()'
			style="margin-left: 5px;">
			<option value="default">options</option>
			<option value="rented">Rented</option>
			<option value="owned">Owned</option>
		</select> <br>
		<table id="ownedTable" style="display: none">
			<tr>
				<td><label id="owner_label" style="margin-left: 25px;">Owner
						Name:</label></td>
				<td><input id="owner_field" type="text"
					style="margin-left: 0px;" name="owner_name" size="10" required/></td>
			</tr>
			<tr>
				<td><label id="emi_label" style="margin-left: 40px;">EMI:</label></td>
				<td><input id="emi_field" type="text" style="margin-left: 0px;"
					name="emi" size="10" required/></td>
			</tr>
		</table>

		<table id="rentedTable" style="display: none">
			<tr>
				<td><label id="rent_type_label" style="margin-left: 50px;">Rent
						Type:</label></td>
				<td><select id="rent_type_field" name="rent_type">
						<option value="">Select</option>
						<option value="hourly">hourly</option>
						<option value="daily">daily</option>
				</select></td>
			</tr>
			<tr>
				<td><label id="rent_rate_label" style="margin-left: 50px;">Rent
						Rate:</label></td>
				<td><input id="rent_rate_field" type="text" name="rent_rate"
					size="10" /></td>
			</tr>
		</table>
		<br />
		<br />
		<br /> <input name="submit" type="SUBMIT" onsubmit="return validateForm()" value="SUBMIT" size="30" />

	</form>
</body>
</html>