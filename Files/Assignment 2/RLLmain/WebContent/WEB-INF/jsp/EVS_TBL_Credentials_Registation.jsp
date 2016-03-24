<!DOCTYPE html>
<html>
<head>

<title>Electronic Voting System</title>
</head>
<body>
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
			<td width="55%" align="top">General info</td>
			<td valign="top"><center>
					<form action="EVS_TBL_Credential_Registation" method="post">
						<table width="100%" cellspacing="10px">
							<tr>
								<h3>Register</h3>
								<td>Login Id <input type="text" name="userId" > </td>
							</tr>
							<tr>
								<td>Password <input type="password" name="password"> </td>
							</tr>
							<tr>
								<td colspan="2">
						<input type="radio" value="admin" name="usertype">Admin<br>
						<input type="radio" value="electronic_Officer" name="usertype">Electronic Officer<br>
						<input type="radio" value="User" name="usertype">User<br>
				</td>
								<td><input type="submit" value="Registation"><br></td>
							</tr>
							<tr>
								<td>Forget password?<a href="Admin_Password_Change.html">Click here to
										reset it.</a><br></td>
							</tr>
						</table>
					</form>
				</center>
				<center>
					NEW USER? <a href="User_Register.html">Register here</a>
				</center></td>
		</tr>
		<tr>
			<td colspan="3" align="center" height="20">Copyright © 2013Wipro Technologies. All rights reserved<br> <b>Designed & Developed By: Vinit Kumar Goel</b></td>
		</tr>
	</table>
</body>
<html>