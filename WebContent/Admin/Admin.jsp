<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="../stylesheet/bips_style1.css" rel="stylesheet" type="text/css" />
</head>
<body>
<header>
<jsp:include page="/Header.jsp"></jsp:include>      
 <section>
<div id="bips_container_sec">

<h1>Hello Admin.How are you doing..</h1>
</center>
<%
   Date date = new Date();
   out.print( "<h2 align=\"center\">" +date.toString()+"</h2>");
%>

</div>
</section>
<jsp:include page="/Footer.jsp"></jsp:include>   

</body>
</html>