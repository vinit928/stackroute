<html>
<head>
<%
	String action = (String) session.getAttribute("UserID");
%>

<title>Electronic Voting System</title>
</head>
<body>

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
			<td colspan="3" align="right" height="30"><a href="about_us">About
					Us</a>&nbsp;<a href="contact_us">Contact Us</a></td>
		</tr>
		<tr>
			<td width="50%">
				<h1>Register Your Profile</h1>

			</td>
			<td>
				<form action="EVS_TBL_User_Profile" method="Post">
					<table>
						
						<tr>
							<td>First Name:</td>
							<td><input type="text" name="first_name"
								placeholder="First Name"></td>
						</tr>
						<tr>
							<td>Last Name:</td>
							<td><input type="text" name="last_name"
								placeholder="Last Name"></td>
						</tr>
						<tr>
							<td>Date of Birth:</td>
							<td><input type="text" name="dob" placeholder="DD/MM/YYYY"></td>
						</tr>
						<tr>
							<td>Male <input type="radio" name="gender" value="Male"
								checked="checked"></td>
							<td>Female <input type="radio" name="gender" Value="Female"></td>
						</tr>
						<tr>
							<td>Street:</td>
							<td><input type="text" name="street"
								placeholder="Street Name"></td>
						</tr>
						<tr>
							<td>Location:</td>
							<td><input type="text" name="location"
								placeholder="Location"></td>
						</tr>
						<tr>
							<td>City:</td>
							<td><input type="text" name="City" placeholder="City Name"></td>
						</tr>
						<tr>
							<td>State:</td>
							<td><input type="text" name="state" placeholder="State Name"></td>
						</tr>
						<tr>
							<td>Pin Code:</td>
							<td><input type="text" name="pincode" placeholder="Pin Code"></td>
						</tr>
						<tr>
							<td>Mobile No:</td>
							<td><input type="text" name="mobileno"
								placeholder="Mobile No"></td>
						</tr>
						<tr>
							<td>E-mail id:</td>
							<td><input type="text" name="emailid" placeholder="yourname@example.com"></td>
						</tr>
						<tr>
							<td><input type="submit" value="Registation"></td>
						</tr>
					</table>
				</form>
	</table>
	</td>
	</tr>
	<table border="1" cellspacing="0" width="100%">
	<tr>
		<td colspan="3" align="center" height="20">Copyright © 2013Wipro
			Technologies. All rights reserved<br> <b>Designed &
				Developed By: Vinit Kumar Goel</b>
		</td>
	</tr>
	</table>
	<%
		session.removeAttribute("UserID");
	%>
</body>
</html>
