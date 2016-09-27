<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.bips.inventory.beans.InventoryFetchBean"%>

<%@ page import="java.util.List"%>
<%@ page import="java.lang.Object"%>

<% List<InventoryFetchBean> records = (List)request.getAttribute("records");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://code.jquery.com/resource/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>

var rentArray = [];
var itemArray = [];
var renttypeArray = [];

  $(function() {
    $("#currentdate").datepicker();
  } );
  
 function getrate() {
		<% for (int j=0; j<records.size(); j++) { %>
         rentArray[<%= j %>] = <%= records.get(j).getRent_rate() %>; 
        <% } %>
        
        <% for (int k=0; k<records.size(); k++) { %>
        itemArray[<%= k %>] = "<%= records.get(k).getItem_name() %>";
       <% } %>

       <% for (int n=0; n<records.size(); n++) { %>
       renttypeArray[<%= n %>] = "<%= records.get(n).getRent_type() %>"; 
      <% } %>
	 	
      for (var l = 0; l < rentArray.length; l++) {
      	console.log(rentArray[l]);
      	}
       
		var e = document.getElementById('item_selected');
		var itemvalue = e.options[e.selectedIndex].value;
		
		console.log("item value is :="+itemvalue);
		
		var itmind = itemArray.indexOf(itemvalue); 
		
		console.log("Item index is:="+itmind);
		
		console.log("Rent is:="+rentArray[itmind]);
		console.log("Rent type is:="+renttypeArray[itmind]);
		
		if(renttypeArray[itmind]){
		document.getElementById("rate").value = rentArray[itmind];
		document.getElementById("usage").value = renttypeArray[itmind];
		}
		else{
			document.getElementById("rate").value = "Owned";
			document.getElementById("usage").value = "Owned";
		}
	}
  
 
 function deleteRow(row)
 {
     var i=row.parentNode.parentNode.rowIndex;
     document.getElementById('iventorygettable').deleteRow(i);
 }

 
 function insRow()
 {
     console.log( 'haula');
     var x=document.getElementById('iventorygettable');
     var new_row = x.rows[1].cloneNode(true);
     var len = x.rows.length;
     //new_row.cells[0].innerHTML = len;
     
     var inp1 = new_row.cells[0].getElementsByTagName('select');
     inp1.id += len;
     inp1.value = '';
     var inp2 = new_row.cells[1].getElementsByTagName('input');
     inp2.id += len;
     inp2.value = '';
     x.appendChild( new_row );
 }
 
   </script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BIPS STONE CRUSHER ERP</title>
</head>
<body>

	<h2 align="center">Welcome to Inventory Management System</h2>
	<input type="button" value="Add New Item" style="margin-left: 25px;"
		name="addnewitem"
		onclick="window.location='inventory/inventoryadditems.jsp'; return true;" />
	<form action="inventoryget" method="post">
	
		 <table id="iventorygettable" border="1">
		 <tr>
		<td><label style="margin-left: 50px;">Item Name</label></td> 
		<td><label style="margin-left: 50px;">Rate</label></td> 
		<td><label style="margin-left: 50px;">Quantity</label></td>
		<td><label style="margin-left: 50px;">Date</label></td> 
		<td><label style="margin-left: 50px;">Usage</label></td> 
		<td><label style="margin-left: 50px;">Fuel</label></td> 
		<td><label style="margin-left: 50px;">Amount</label></td> 
		<td><label style="margin-left: 50px;">Payment</label></td> 
		<td><label style="margin-left: 50px;">Balance</label></td>
		<td><label style="margin-left: 50px;">Add Row</label></td>
		<td><label style="margin-left: 50px;">Delete Row</label></td> 
		</tr>
			
			<tr>
			<td>
			 <select id="item_selected" name="item" style="margin-left: 25px;" onclick='getrate()'>
			<% for(int i = 0; i < records.size(); i++) { %>
	    		<option><%= records.get(i).getItem_name()%></option>
			<% } %>
		</select>
		</td> 
		
		<td><input id="rate" type="text" value="rate" name="rate" disabled="disabled" style="margin-left: 25px;" size="10" /></td> 
			
			<td>
			<select name="quantity"
			style="margin-left: 10px;">
			<option value="1" selected>1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="4">5</option>
			<option value="4">6</option>
			<option value="4">7</option>
			<option value="4">8</option>
			<option value="4">9</option>
			<option value="4">10</option>
		</select> 
		</td>
		<td><input type="text" value="mm/dd/yyyy" id="currentdate" name="systemdate" style="margin-left: 10px;" size="10" /></td>
		<td><input id="usage" type="text" value="usage" name="usage" disabled="disabled" style="margin-left: 10px;" size="10" /></td> 
		<td><input type="text" value="fuel" name="fuel" style="margin-left: 10px;" size="10" /></td>
		<td><input type="text" value="amount" name="amount" style="margin-left: 10px;" size="10" /></td>

		<td><input type="text" value="payment" name="payment" style="margin-left: 10px;" size="10" /></td>
		<td><input type="text" value="balance" name="balance" style="margin-left: 10px;" size="10" /></td>
		
		<td><input type="button" id="delItembutton" value="Delete Row" onclick="deleteRow(this)"/></td>
        <td><input type="button" id="addmoreItembutton" value="Add Row" onclick="insRow()"/></td>

		
		 
		</tr>
		<input type="SUBMIT" value="SUBMIT" style="margin-left: 25px;" size="30" />
	</table>
	</form>
</body>
</html>