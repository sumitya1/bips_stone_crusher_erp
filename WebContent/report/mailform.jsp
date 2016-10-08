<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body style="background-color:orange">
<form action="../composemail">
<table border=5>
<tr>
<td>
To: </td><td><input type="text" name="to"></td></tr><br/>
<tr><td>From: </td><td><input type="text" name="from"></td></tr><br/>
<tr><td>Subject: </td><td><input type="text" name="subject"></td></tr><br/>
<tr><td>Message Body:</td><td><textarea name="msgbody"></textarea></td></tr><br/>
<tr><td><input type="submit" value="Submit" onsubmit="return(getpath());"></td></tr>
</table>
</form>
</body>
</html>