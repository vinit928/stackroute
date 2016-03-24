<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String action = (String) session.getAttribute("UserID");
%>

<script>
function loadXMLDoc(sname)
{
var xmlhttp;
if (window.XMLHttpRequest)
  {
  xmlhttp=new XMLHttpRequest();
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("1").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("Post","EVS_TBL_Vote_Voter_ID_Check?serial_no="+sname,true);
xmlhttp.send();
}
</script>

<title>Electronic Voting System</title>
</head>
<body>
	<%
		if (action.equals("US-003")) {
	%>

	<table width="100%" style="height: 100%;" cellpadding="10"
		cellspacing="0" border="1">
		<tr>
			<td colspan="3" style="height: 100px;"><img src="logo.jpg"
				height="100px" width="100px" style="float: left;">
				<center>
					<h2>Electronic Voting System</h2>
				</center></td>
		</tr>
		<tr>
			<td colspan="3" align="right" height="30"><a
				href="Admin_Password_Change.html">Change Password</a>&nbsp;<a
				href="Logout.jsp">Logout</a></td>
		</tr>
		<tr>
			<td>Enter Serial No: <input type="text" name="serial_no">
				<input type="submit" value="Check"
				onclick="loadXMLDoc(serial_no.value)">

			</td>
			<td><span id="1"></span></td>
		</tr>
		<tr>
			<td colspan="3" align="center" height="20">Copyright © 2013
				Wipro Technologies. All rights reserved<br> <b>Designed &
					Developed By: Vinit Kumar Goel</b>
			</td>
		</tr>
	</table>
	<%
		} else {
	%>
	<script> 
	alert("You are <%=action%>, Sorry You are Not Authorized");
	</script>
	<%
		}
	%>
</body>
</html>