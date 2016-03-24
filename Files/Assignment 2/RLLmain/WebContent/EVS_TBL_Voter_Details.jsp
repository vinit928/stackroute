<html>
<head>
<%
	String action = (String) session.getAttribute("UserID");
%>
<title>Electronic Voting System</title>
</head>
<body>
<%if(action.equals("US-002")) {%>

	<table width="100%" style="height: 100%;" cellpadding="10" cellspacing="0" border="1">
		<tr>
			<td colspan="3" style="height: 100px;"><img src="logo.jpg" height="100px" width="100px" style="float: left;">
			<center><h2>Electronic Voting System</h2></center></td>
		</tr>
		<tr>
			<td colspan="3" align="right" height="30"><a href="about_us">About
Us</a>&nbsp;<a href="contact_us">Contact Us</a></td>
		</tr>
		<tr>
			<td width="55%" align="top"><h1>Vote Request</h1></td>
			<td valign="top"><center>
					<form action="EVS_TBL_Voter_Details" method="get">
						<table width="100%" cellspacing="10px">
							<tr>
			<td>User: </td>
			<td><input type="text" name="user"></td>
		</tr>
		<tr>
			<td>Election ID:</td>
			<td><input type="text" name="election_id"></td>
		</tr>
		<tr>
		<td><input type="Submit" value="Create Voter"></td>
		</tr>
							<tr>
								<td>Election ID: <a href="Election_View.html" target="_blank">Click here for Election ID
										</a><br></td>
							</tr>
						</table>
					</form>
				</center>
				</td>
		</tr>
		<tr>
			<td colspan="3" align="center" height="20">Copyright © 2013Wipro Technologies. All rights reserved<br> <b>Designed & Developed By: Vinit Kumar Goel</b></td>
		</tr>
	</table>
	<% }else { %>
	<script > 
	alert("You are <%=action %>, Sorry You are Not Authorized");
	</script>
	<%} %>
</body>
<html>