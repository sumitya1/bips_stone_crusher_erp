<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.bips.report.beans.ReportBean" %>
   
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


<% List<ReportBean> records = (List)request.getAttribute("tr_records");%>


<table class="table" style="width:70%;margin-left:200px">
<tr>

<td><label>Employee Name</label></td>
<td><label>RUPEES</label></td>
<td><label>DESCRIPTION</label></td>

</tr>

<% for(int i = 0; i < records.size(); i++) { %>

<tr class="success">
<td><%=records.get(i).getEmployee_name() %></td>
<td><%=records.get(i).getRupees() %></td>
<td><%=records.get(i).getDescription() %></td>
</tr>
 <% } %>
 
</table>
<table class="table" style="width:75%;margin-left:160px">
<tr class="info" ><td style="width: 80px;">
<td><label>Total</label></td>
</tr>
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