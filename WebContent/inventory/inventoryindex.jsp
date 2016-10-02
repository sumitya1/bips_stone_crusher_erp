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
	 	
      //for (var l = 0; l < rentArray.length; l++) {
      //	console.log(rentArray[l]);
      //	}
       
		var e = document.getElementById('item_selected');
		var itemvalue = e.options[e.selectedIndex].value;
		
		//console.log("item value is :="+itemvalue);
		
		var itmind = itemArray.indexOf(itemvalue); 
		
		if(renttypeArray[itmind]){
			document.getElementById("rate").value = rentArray[itmind];
			console.log("rentrate is:="+rentArray[itmind]);
			document.getElementById("usage").value = renttypeArray[itmind];
				if(document.getElementById("usage").value == "hourly"){
					document.getElementById("usage").value = "enter hours";
					//document.getElementById("usage").disabled = false;
				}
				if(document.getElementById("usage").value == "daily"){
					//document.getElementById("usage").disabled = true;
				}
				if(document.getElementById("usage").value == null){
					document.getElementById("usage").value = "Owned vehicle";
					console.log("Usage is:="+document.getElementById("usage").value);
				}
				
		 }
		
	}
 function getamount() {
	
	  var itemrate = document.getElementById('rate').value;
	  var e = document.getElementById('quantity');
	  var quantityvalue = e.options[e.selectedIndex].value;
	  var usageval = document.getElementById('usage').value;
	
	  if(document.getElementById('rate').value == null){
		  document.getElementById('amount').value="";
		  //document.getElementById('amount').disabled = true;
	  }
	  else{
	    	if(document.getElementById('usage').value == "daily"){
    			  var itemamount = itemrate * quantityvalue * 1;
    	  		  console.log("itemamount is:="+itemamount);
    	  	 	  document.getElementById('amount').value = itemamount;
             }
	    	else if(document.getElementById('usage').value == "-1"){
  			  
  	  	 	  document.getElementById('amount').value = "NA";
  	  	 	  document.getElementById('payment').value = "NA";
  	  	      document.getElementById('balance').value = "NA";
  	  	 		
           }
	    	else{
    	  
	   	  		  var itemamount = itemrate * quantityvalue * usageval;
    	  		document.getElementById('amount').value = itemamount;
        	}
	  }
	  
	 
 }
 
 function getbalance() {
		
	  var amountval = document.getElementById('amount').value;
	  console.log("itemrate is:="+amountval);
	 
	  var paymentval = document.getElementById('payment').value;
	  console.log("itemrate is:="+amountval);
	  
	  var balanceval = amountval - paymentval;
	  
	  if(amountval<paymentval){
		 alert( "Payment should be less than Amount"); 
	  }
	  else{
	      document.getElementById('balance').value = balanceval;
	  }
}
 
 function validate()
 {
		if( document.submitform.quantity.value == "-1" )
	     {
	         alert( "Please select Quantity of items!" );
	         return false;
	     }
	       
		 
	       if( document.submitform.usage.value == "" || document.submitform.usage.value == "enter hours")
	       {
	          alert( "Please enter no. of hours!" );
	          document.submitform.usage.focus() ;
	          return false;
	       }
		
	       if( document.submitform.fuel.value == "" || document.submitform.fuel.value == "0L")
	       {
	          alert( "Please enter Fuel Qauantity!" );
	          document.submitform.fuel.focus() ;
	          return false;
	       }
	       
	       if( document.submitform.payment.value == "" || document.submitform.payment.value == "Enter Payment Amount")
	       {
	          alert( "Please enter Payment Amount!" );
	          document.submitform.payment.focus() ;
	          return false;
	       }
	       
	       if(document.submitform.systemdate.value == "mm/dd/yyyy")
	       {
	          alert( "Please Select Date!" );
	          document.submitform.usage.focus() ;
	          return false;
	       }
	    
		  return(true);
 }
 
 /*function submitForm() {
	  
	   var frm = document.getElementsByName('submitform')[0];
	   frm.submit(); // Submit
	   frm.reset();  // Reset
	   return false; // Prevent page refresh
	} */

   </script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BIPS STONE CRUSHER ERP</title>
</head>
<body>

	<h2 align="center">Welcome to Inventory Management System</h2>
	<input type="button" value="Add New Item" style="margin-left: 50px;" style="margin-top:50px;" name="addnewitem"
		onclick="window.location='inventory/inventoryadditems.jsp'; return true;" />
		
	<form action="inventoryget" name="submitform" onsubmit="return(validate());" method="post">
	
		 <table id="iventorygettable" style="margin-left: 50px;" border="1" cellspacing="1" cellpadding="1">
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
		 
		</tr>
			
			<tr>
			<td>
			 <select id="item_selected" name="item" style="margin-left: 25px;" onclick='getrate()'>
			<% for(int i = 0; i < records.size(); i++) { %>
	    		<option><%= records.get(i).getItem_name()%></option>
			<% } %>
		</select>
		</td> 
		
		<td><input id="rate" type="text" value="rate" name="rate" style="margin-left: 25px;" size="10" readonly="readonly" /></td> 
			
			<td>
			<select id="quantity" name="quantity" style="margin-left: 10px;" onchange="getamount();">
			<option value="-1" selected>[choose quantity]</option>
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
		</select> 
		</td>
		<td><input type="text" value="mm/dd/yyyy" id="currentdate" name="systemdate" style="margin-left: 10px;" size="10" /></td>
		<td><input id="usage" type="text" value="usage" name="usage" style="margin-left: 10px;" size="10" onchange="getamount();" onfocus="getamount();" /></td> 
		<td><input type="text" value="0L" name="fuel" style="margin-left: 10px;" size="10" onchange="getamount();"/></td>
		<td><input id="amount" type="text" value="amount" name="amount" style="margin-left: 10px;" size="10" readonly="readonly" /></td>

		<td><input id="payment" type="text" value="Enter Payment Amount" name="payment" style="margin-left: 10px;" size="10" onchange="getbalance();"/></td>
		<td><input id="balance" type="text" value="balance" name="balance" style="margin-left: 10px;" size="10" /></td>
		
		</tr>
		<tr height="50px">
		<td align="center" colspan="9" >
		<input type="SUBMIT" value="SUBMIT" style="margin-left: 25px;" size="50" />
		<!-- <input type="button" value="SUBMIT" id="btnsubmit" onclick="submitForm()" style="margin-left: 25px;" size="50"> -->
		</td>
		</tr>
		
		
	</table>
	</form>
</body>
</html>