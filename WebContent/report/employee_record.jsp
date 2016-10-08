<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.bips.report.beans.DateSelectorBean" %>
   
    <%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Record</title>
</head>
<body style="background-color:orange">


<% List<DateSelectorBean> records = (List)request.getAttribute("dp_records");%>


<table class="table" style="width:70%;margin-left:200px">
<tr>

<td><label>EMPLOYEE NAME</label></td>
<td><label>RUPEES<label></td>
<td><label>SYSTEMDATE</label></td>
<td><label>DESCRIPTION</label></td>
</tr>

<% for(int i = 0; i < records.size(); i++) { %>

<tr class="success">
<td><%=records.get(i).getItem() %></td>
<td><%=records.get(i).getRate() %></td>
<td><%=records.get(i).getQuantity() %></td>
<td><%=records.get(i).getSystemdate() %></td>
<td><%=records.get(i).getUsage()%></td>
<td><%=records.get(i).getFuel() %></td>
<td><%=records.get(i).getAmount() %></td>
<td><%=records.get(i).getPayment() %></td>
<td><%=records.get(i).getBalance() %></td>

</tr>
 <% } %>
 
</table>
<table class="table" style="width:100%;margin-left:170px">
<tr class="info" >
<td><label>Total</label></td>
</tr>
 <br>
<tr>
	<td colspan="2">
	<label style="margin-left: 50px;">Want to save this report in pdf file</label>
	</td>

	<td>
	<form action="pdfreport" method="get">
	 <input type="submit" value="Submit" id="submit" size="10" >
	</form>
	</td>
</tr>

<tr>
	<td>
		 <a href="report/mailform.jsp" style="color:green;">Want to email this report</a>
	</td>

</tr>

</table>
</body>
</html>