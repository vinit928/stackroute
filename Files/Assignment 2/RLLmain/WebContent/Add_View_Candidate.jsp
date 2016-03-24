<html>
<head>
<%
	String action = (String) session.getAttribute("UserID");
%>
<title>Electronic Voting System</title>
</head>
<body>
	<%
		if (action.equals("AD-006") || action.equals("AD-007")) {
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
			<td colspan="2"><center>
					<h1>Candidate</h1>
				</center></td>
		</tr>
		<tr>
			<td>
				<center>
					<h2>
						<u><a href="ADD_Candidate_Profile.html">Add Candidate
								Profile</a></u>
					</h2>
				</center>
			</td>
			<td>
				<center>
					<h2>
						<u><a href="View_Candidate_Profile.html">View Candidate
								Profile</a></u>
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
<html>