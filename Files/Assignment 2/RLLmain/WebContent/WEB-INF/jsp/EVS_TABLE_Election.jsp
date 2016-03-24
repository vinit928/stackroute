<html>
<head>
<title>Electronic Voting System</title>
</head>
<body>

	<table width="100%" style="height: 100%;" cellpadding="10"
		cellspacing="0" border="1">
		<tr>
			<td colspan="3" style="height: 70px;"><img src="logo.jpg"
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
			<td width="50%" align="center">
				<h1>ADD Election</h1>

			</td>
			<td>
				<form action="EVS_TBL_Election" method="Get">
					<table>
						<tr>
						<tr>
							<td>Name:</td>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>
							<td>Election date:</td>
							<td><input type="text" name="date" placeholder="DD/MMM/YYY"></td>
						</tr>
						<tr>
							<td>District:</td>
							<td><input type="text" name="district"></td>
						</tr>
						<tr>
							<td>Constituency:</td>
							<td><input type="text" name="constituency"></td>
						</tr>
						<tr>
							<td>Counting Date*:</td>
							<td><input type="text" name="countingdate"
								placeholder="DD/MMM/YYY"></td>
						</tr>
						<tr>
							<td><input type="submit" value="Add Election"></td>
						</tr>
						<tr>
							<td colspan="2"><font color="red" size="2"> * Counting Date Should Be After the Election date within 30 days</font></td>
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
	
</body>
</html>
