<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="https://code.jquery.com/resource/demos/style.css"> 
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
  <script>
  $( function() {
    $( "#datepicker1" ).datepicker();
  } );
  
  $( function() {
	    $( "#datepicker2" ).datepicker();
	  } );
  
  $( function() {
	    $( "#datepicker3" ).datepicker();
	  } );
  
  function test() {
		if (document.getElementById('report_type').value == 'department') {
			document.getElementById('departmentTable').style.display = 'block';
			document.getElementById('trendingTable').style.display = 'none';
			
			

		} if (document.getElementById('report_type').value == 'trending') {
			document.getElementById('trendingTable').style.display = 'block';
			document.getElementById('departmentTable').style.display = 'none';
			

		} if (document.getElementById('report_type').value == '-1') {
			document.getElementById('departmentTable').style.display = 'none';
			document.getElementById('trendingTable').style.display = 'none';

		}
	}
  
  
  function validate()
  {
 		if( document.submitform.report_type.value == "-1" )
 	     {
 	         alert( "Please select Report Type!" );
 	        document.submitform.report_type.focus() ;
 	         return false;
 	     }
 		
 		if( document.submitform.report_type.value == "department" )
	     {
 			if(document.submitform.dp_report_type.value == "-1"){
 				alert( "Please select department type" );
 				document.submitform.dp_report_type.focus();
 		         return false;	
 			}
 			if(document.submitform.dp_fromdate.value == "mm/dd/yyyy"){
 				alert( "Please select from date" );
 				document.submitform.dp_fromdate.focus();
 		         return false;	
 			}
 			
 			if(document.submitform.dp_todate.value == "mm/dd/yyyy"){
 				alert( "Please select to date" );
 				document.submitform.dp_todate.focus();
 		         return false;	
 			}
 			
 			
	     }
 		
 		if( document.submitform.report_type.value == "trending" )
	     {
			if(document.submitform.tr_report_type.value == "-1"){
				alert( "Please select Trending Report type" );
				document.submitform.tr_report_type.focus();
		         return false;	
			}
			
			if(document.submitform.tr_fromdate.value == "mm/dd/yyyy"){
 				alert( "Please select from date" );
 				document.submitform.tr_fromdate.focus();
 		         return false;	
 			}
 			
 			if(document.submitform.tr_todate.value == "mm/dd/yyyy"){
 				alert( "Please select to date" );
 				document.submitform.tr_todate.focus();
 		         return false;	
 			}
					
	     }
		
 		 
 		  return(true);
  }
  
  
  </script>

<title>Report Date selector</title>
</head>
<body style="background-color:orange">

<h2 align="center">Welcome to Report Management System</h2>	
		
<form action="../dateselector"  name="submitform" id="configform" onsubmit="return(validate());" method="post">
       
       <label style="margin-left: 50px;">Select Report Type:</label>
		 <select name="report_type" id="report_type" onclick='test()' style="margin-left: 5px;">
			<option value="-1" selected>[choose Report type]</option>
			<option value="department">Department Wise Report</option>
			<option value="trending">Trending Report</option>
	</select> 
       
       <table id="departmentTable" style="display: none">
       <tr>
     <td>
         <div  style="margin-top:20px">
         <label style="margin-left: 30px;">Select Department </label><br>
          <select id="dp_report_type" name="dp_report_type" style="margin-left: 30px;">
				<option value="-1" selected>[choose department type]</option>
				<option value="inventory">Inventory</option>
				<option value="sales">Sales</option>
				<option value="minning">Minning</option>
				<option value="employee">Employee</option>
			</select>
         </div>  
          </td>
          <td>
          <div  style="margin-top:20px">
             <label style="margin-left: 30px;">Select From Date</label><br>
             <input type="text" name="dp_fromdate" value="mm/dd/yyyy" id="datepicker" style="margin-left: 10px;">&nbsp;&nbsp;&nbsp;
          </div>  
          </td>
          <td>
          <div  style="margin-top:20px">
             <label style="margin-left: 30px;">Select To Date</label><br>
             <input type="text" name="dp_todate" value="mm/dd/yyyy" id="datepicker1" style="margin-left: 10px;">&nbsp;&nbsp;&nbsp;
          </div>  
          </td>
          <td>
          <div  style="margin-top:38px">
             <input type="submit" value="Submit" id="submit" size="10" style="margin-left: 10px;">&nbsp;&nbsp;&nbsp;
          </div> 
           
          </td>
          </tr>
          
          </table>
          
           <table id="trendingTable" style="display: none">
       <tr>
	       	<td>
	       <div  style="margin-top:20px">
         	<label style="margin-left: 30px;">Select Department </label><br>
          		<select id="tr_report_type" name="tr_report_type" style="margin-left: 30px;">
					<option value="-1" selected>[choose Trending report type]</option>
					<option value="tr_sales">Trending in Sales</option>
					<option value="tr_expense">Trending in Expense</option>
					<option value="tr_fuel">Trending in Fuel</option>
				</select>
         </div>  
	       </td>
	       
	       <td>
          <div  style="margin-top:20px">
             <label style="margin-left: 30px;">Select From Date</label><br>
             <input type="text" name="tr_fromdate" value="mm/dd/yyyy" id="datepicker2" style="margin-left: 10px;">&nbsp;&nbsp;&nbsp;
          </div>  
          </td>
          <td>
          <div  style="margin-top:20px">
             <label style="margin-left: 30px;">Select To Date</label><br>
             <input type="text" name="tr_todate" value="mm/dd/yyyy" id="datepicker3" style="margin-left: 10px;">&nbsp;&nbsp;&nbsp;
          </div>  
          </td>
	       
	        <td>
          <div  style="margin-top:38px">
             <input type="submit" value="Submit" id="submit" size="10" style="margin-left: 10px;">&nbsp;&nbsp;&nbsp;
          </div> 
           
          </td>
       </tr>
       </table>
          
</body>
</html>