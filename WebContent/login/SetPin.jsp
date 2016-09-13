<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="../stylesheet/bips_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <jsp:include page="/Header.jsp"></jsp:include>
    <section>
<div id="bips_container_sec">
 <form action="setPassword.html" method="get">
      <h4> User Id: *</h4>  <input type="text" name="s" id="s" class="kk"placeholder="Enter User Id" value="" />
      <h4> Mobile No: *</h4>  <input type="text" name="s" id="s" class="kk"placeholder="Enter Mobile number" value="" />
      <h4> Email Id: </h4>  <input type="text" name="s" id="s" class="kk"placeholder="Enter Email Id" value="" />
      <button type="button" onclick="generatePin()" class="kk">Get Pin</button>
      <h4> Enter Pin: </h4>  <input type="text" name="s" id="s" class="kk" placeholder="Enter Pin" value="" />
      
   <button type="submit">Submit</button> 



        </form>

</div>
</section>
    <jsp:include page="/Footer.jsp"></jsp:include>

</body>
</html>