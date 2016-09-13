<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
-<link href="../stylesheet/bips_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
       <jsp:include page="/Header.jsp"></jsp:include>
    <section>
<div id="bips_container_sec">
 <form action="#">
      <p> User Id: </P>  <input type="text" name="s" id="s" class="kk" placeholder="User Id" value="" />
      <p> Password:</p>  <input type="Password" name="s1" id="s1" class="kk" placeholder="Password" value="" />
          <button type="submit">Submit</button>
<h3><a href="ForgetPassword.jsp"> Forget Password</a></h3>
<h3><a href="SetPin.jsp">First Time User?</a></h3>
<input type="checkbox" class="rem" name="n" id="l" value="Remember Password"/><p class="jojo"><strong>Remember Password</strong></p>


        </form>

</div>
</section>
          <jsp:include page="/Footer.jsp"></jsp:include>

</body>
</html>