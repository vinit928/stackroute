<!DOCTYPE html>
<html>
<head>
<%
	String action = (String) session.getAttribute("UserID");
%>
<title>Electronic Voting System</title>
</head>
<body>
<%if(action.equals("AD-004") || action.equals("AD-005")) {%>
	<table width="100%" cellpadding="10" cellspacing="0" border="1">
		<tr>
			<td colspan="3" style="height: 100px;" align="center"><img
				src="logo.jpg" height="100px" width="100px" style="float: left;">

				<h2>Electronic Voting System</h2></td>
		</tr>

		<tr>
			<table width="50%" cellpadding="5" cellspacing="0">
				<tr>
					<td><a href="EVS_TBL_User_Profile.jsp">Update Profile</a></td>
					<td><a href="Admin_Password_Change.html">Change Password</a></td>
					<td><a href="Logout.jsp">Logout</a></td>
				</tr>
			</table>
		</table>
		<table width="100%" cellpadding="10" cellspacing="0" border="1">
		</tr>

		<tr>
			<td colspan="2"><center>
					<h1>Party</h1>
				</center></td>
		</tr>
		<tr>
			<td>
				<center>
					<h2>
						<u><a href="Party_Register.html">Add Party</a></u>
					</h2>
				</center>
			</td>
			<td>
				<center>
					<h2>
						<u><a href="View_Parties.html">View Parties</a></u>
					</h2>
				</center>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center" height="20">Copyright © 2013Wipro
				Technologies. All rights reserved<br> <b>Designed &
					Developed By: Vinit Kumar Goel</b>
			</td>
		</tr>
	</table>
	<% }else { %>
	<script > 
	alert("You are <%=action %>, Sorry You are Not Authorized");
	</script>
	<%} %>
</body>
<html>