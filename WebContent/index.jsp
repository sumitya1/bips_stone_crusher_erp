<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="../stylesheet/bips_style1.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <jsp:include page="/Header.jsp"></jsp:include>   
  <section>
<div id="bips_container_sec">
<div class="subdiv">
<a href="login/Login.jsp"><h1>Login</h1></a>
<form action="inventoryget" method="get">
<input type="SUBMIT" value="Inventory" size="30"/>
</form>
<!-- <a href="inventory/inventoryindex.jsp"><h1>Inventory</h1></a> -->

<h1>Mining</h1>
<h1>EMployee Management</h1>
<a href="sales/salesindex.jsp"><h1>Sales</h1></a>
<a href="report/dateselector.jsp"><h1>Generate Report</h1></a>
<a href="Admin/Admin.jsp"><h1>Admin</h1></a>
<a href="Manager/Manager.jsp"><h1>Manager</h1></a>
<a href="User/User.jsp"><h1>User</h1></a>
</div>


</div>
</section>
   <footer>
<div id="bips_container_fot">
<p><i><strong>Copyright &copy; 2016 -BIPS PVT LTD &middot; All Rights Reserved<strong></i></p>
</div>
</footer>

</body>
</html>