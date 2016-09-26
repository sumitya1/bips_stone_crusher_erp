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

  $( function() {
    $( "#currentdate" ).datepicker();
  } );
  
 function getrate() {
		//var itemvalue = document.getElementById('item_selected').id
		
		
		<% for (int j=0; j<records.size(); j++) { %>
         rentArray[<%= j %>] = <%= records.get(j).getRent_rate() %>; 
        
        <% } %>
	 	
        for (var l = 0; l < rentArray.length; l++) {
        	console.log(rentArray[l]);
        	}
        
        <% for (int k=0; k<records.size(); k++) { %>
        itemArray[<%= k %>] = "<%= records.get(k).getItem_name() %>";
        
       <% } %>

       for (var m = 0; m < itemArray.length; m++) {
       	console.log(rentArray[m]);
       	}
       
       
		var e = document.getElementById('item_selected');
		console.log(e);
		
		var itemvalue = e.options[e.selectedIndex].value;
		
		console.log(itemvalue);
		
		var itmind = itemArray.indexOf(itemvalue); 
		
		console.log(itmind);
		
		switch(itmind){
		case "1":
		document.getElementById("rate").value = <%= records.get(0).getRent_rate()%>
		break;
		case "2":
			document.getElementById("rate").value = <%= records.get(1).getRent_rate()%>
			break;
		case "3":
			document.getElementById("rate").value = <%= records.get(2).getRent_rate()%>
			break;
		}
		
	}
  
   </script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2 align="center">Welcome to Inventory Management System</h2>
	<input type="button" value="Add New Item" style="margin-left: 25px;"
		name="addnewitem"
		onclick="window.location='inventory/inventoryadditems.jsp'; return true;" />
	<br>
	<br>
	<form action="inventoryget" method="post">
		<label style="margin-left: 50px;">Item Name</label> <label
			style="margin-left: 50px;">Rate</label> <label
			style="margin-left: 50px;">Quantity</label> <label
			style="margin-left: 50px;">Date</label> <label
			style="margin-left: 50px;">Usage</label> <label
			style="margin-left: 50px;">Fuel</label> <label
			style="margin-left: 50px;">Amount</label> <label
			style="margin-left: 50px;">Payment</label> <label
			style="margin-left: 50px;">Balance</label> 
			
			<br> <br>
			
			 <select id="item_selected" name="item" style="margin-left: 25px;" onclick='getrate()'>
			<% for(int i = 0; i < records.size(); i++) { %>
			
			<option><%= records.get(i).getItem_name()%></option>
			<% } %>
		</select> 
		<input id="rate" type="text" value="rate" name="rate"
			style="margin-left: 25px;" size="10" /> 
			
			<select name="quantity"
			style="margin-left: 10px;">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
		</select> 
		
		<input type="text" value=systemdate id="currentdate"
			name="systemdate" style="margin-left: 10px;" size="10" />
			 <input
			type="text" value="usage" name="usage" style="margin-left: 10px;"
			size="10" /> 
			<input type="text" value="fuel" name="fuel"
			style="margin-left: 10px;" size="10" />
			 <input type="text"
			value="amount" name="amount" style="margin-left: 10px;" size="10" />

		<input type="text" value="payment" name="payment"
			style="margin-left: 10px;" size="10" />
			 <input type="text"
			value="balance" name="balance" style="margin-left: 10px;" size="10" />

		<br /> <br /> <br /> 
		<input type="SUBMIT" value="SUBMIT"
			style="margin-left: 25px;" size="30" />

	</form>
</body>
</html>