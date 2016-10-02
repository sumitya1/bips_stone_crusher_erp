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

  $(function() {
    $("#currentdate").datepicker();
  } );
  
  function getamount() {
	
	  var itemrate = document.getElementById('rate').value;
	  var quantityval = document.getElementById('quantity').value;
	  
	  var e = document.getElementById('no_of_trucks');
	  var no_of_trucksVal = e.options[e.selectedIndex].value;
	  var itemamount = itemrate * quantityval * no_of_trucksVal;
      document.getElementById('amount').value = itemamount;
       
 }
 
 function getbalance() {
		
	  var amountval = document.getElementById('amount').value;
	  console.log("amountval is:="+amountval);
	 
	  var paymentval = document.getElementById('payment').value;
	  console.log("paymentval is:="+amountval);
	  
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
		if( document.submitform.stone_type.value == "-1" )
	     {
	         alert( "Please select Stone Type!" );
	         return false;
	     }
	       
		if(document.submitform.systemdate.value == "mm/dd/yyyy")
	       {
	          alert( "Please Select Date!" );
	          document.submitform.usage.focus() ;
	          return false;
	       } 
		
	       if( document.submitform.rate.value == "" || document.submitform.rate.value == "rate")
	       {
	          alert( "Please Enter Rate!" );
	          document.submitform.rate.focus() ;
	          return false;
	       }
		
	       if( document.submitform.quantity.value == "" || document.submitform.quantity.value == "Quantity")   
	       {
	          alert( "Please enter Qauantity!" );
	          document.submitform.quantity.focus() ;
	          return false;
	       }
	       
	       if( document.submitform.no_of_trucks.value == "-1")
	       {
	          alert( "Please Select No. of Trucks!" );
	           return false;
	       }
	       
	       if( document.submitform.company_name.value == "" || document.submitform.company_name.value == "company_name") 
	       {
	          alert( "Please Enter Company Name, where good are being Sent" );
	          document.submitform.company_name.focus() ;
	          return false;
	       }
	       
	       if( document.submitform.payment.value == "" || document.submitform.payment.value == "Enter Payment Amount") 
	       {
	          alert( "Please Enter Payment Amount" );
	          document.submitform.payment.focus() ;
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

	<h2 align="center">Welcome to Sales Management System</h2>
		
	<form action="../salescontroller" name="submitform" onsubmit="return(validate());" method="post">
	
		 <table id="iventorygettable" style="margin-left: 50px;" border="1" cellspacing="1" cellpadding="1">
		 <tr>
		<td><label style="margin-left: 50px;">Stone Type</label></td> 
		<td><label style="margin-left: 50px;">Date</label></td> 
		<td><label style="margin-left: 50px;">Rate</label></td>
		<td><label style="margin-left: 50px;">Quantity</label></td> 
		<td><label style="margin-left: 50px;">No. of Trunks</label></td> 
		<td><label style="margin-left: 50px;">Company Name</label></td> 
		<td><label style="margin-left: 50px;">Total Amount</label></td> 
		<td><label style="margin-left: 50px;">Payment</label></td> 
		<td><label style="margin-left: 50px;">Balance</label></td>
		 
		</tr>
			
			<tr>
			<td>
			 <select id="stone_type" name="stone_type" style="margin-left: 25px;">
	    		<option value ="-1">[choose Stone Type]</option>
	    		<option value ="1">20mm</option>
	    		<option value ="2">25mm</option>
	    		<option value ="3">40mm</option>
	    		<option value ="4">50mm</option>
		</select>
		</td> 
		<td><input type="text" value="mm/dd/yyyy" id="currentdate" name="systemdate" style="margin-left: 10px;" size="10" /></td>
		
		<td><input id="rate" type="text" value="rate" name="rate" style="margin-left: 25px;" size="10" /></td> 
			
		<td><input id="quantity" type="text" value="Quantity" name="quantity" style="margin-left: 10px;" size="10" onchange="getamount();" onfocus="getamount();" /></td>
		
		<td>
		<select id="no_of_trucks" name="no_of_trucks" style="margin-left: 25px;" onclick='getrate()'>
	    		<option value ="-1">[choose no_of_truck]</option>
	    		<option value ="1">1</option>
	    		<option value ="2">2</option>
	    		<option value ="3">3</option>
	    		<option value ="4">4</option>
	    		<option value ="5">5</option>
	    		<option value ="6">6</option>
	    		<option value ="7">7</option>
	    		<option value ="8">8</option>
	    		<option value ="9">9</option>	    			    			    			    		
	    		<option value ="10">10</option>	    		
		</select>
		</td> 
		<td><input id="company_name" type="text" value="company_name" name="company_name" style="margin-left: 10px;" size="10" /></td>
		<td><input id="amount" type="text" value="amount" name="amount" style="margin-left: 10px;" size="10" /></td>
						
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