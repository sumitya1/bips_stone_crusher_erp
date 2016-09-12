<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to Inventory Management System.</h2>
<form action="InventoryTestServlet">
	<input type="SUBMIT" value="Send" />
</form>

<h4>From Below option, Add an item in Inventory.</h4>
<form action="InventoryTestServlet1">
	<input type="text" value="Add Item Name"/>
	<input type="checkbox" value="Are you sure want to add this Item.">
	<input type="SUBMIT" value="Send" />
</form>
</body>
</html>