<!DOCTYPE html>
<html>
<head>
<%
	String incorrect = (String) session.getAttribute("Incorrect");
%>


<title>Electronic Voting System</title>
</head>
<body>
	<table width="100%" style="height: 100%;" cellpadding="10"
		cellspacing="0" border="1">
		<tr>
			<td colspan="3" style="height: 100px;"><img src="logo.jpg"
				height="100px" width="140px" style="float: left;">
				<center>
					<h2>Electronic Voting System</h2>
				</center></td>
		</tr>
		<tr>
			<td colspan="3" align="right" height="30"><a href="About_US.jsp">About
					Us</a>&nbsp;<a href="contact_us">Contact Us</a></td>
		</tr>
		<tr>
			<td width="55%" align="top">
			
			</td>
			<td valign="top"><center>
					<form action="EVS_TBL_Credential_Login" method="post">
						<table width="100%" cellspacing="10px">
							<tr>
								<%
									if (incorrect != null) {
								%>
								<td><font color="red"><%=incorrect%> is InCorrect</font></td>
								<%
									}
								%>
							</tr>
							<tr>
								<td>Login Id: <input type="text" name="userId"><br></td>
							</tr>
							<tr>
								<td>Password: <input type="password" name="password"><br></td>
							</tr>
							<tr>
								<td colspan="2">
									<div>
										<input type="radio" value="admin" name="usertype">Admin<br>
										<input type="radio" value="electronic_Officer" name="usertype">Electronic
										Officer<br> <input type="radio" value="User"
											name="usertype">User<br>
									</div>
								</td>
								<td><input type="submit" value="Login"><br></td>
							</tr>
							<tr>
								<td>Forget password?<a href="Admin_Password_Change.html">Click
										here to reset it.</a><br></td>
							</tr>
						</table>
					</form>
				</center>
				<center>
					NEW USER? <a href="User_Register.html">Register here</a>
				</center></td>
		</tr>
		<tr>
			<td colspan="3" align="center" height="20">Copyright © 2013Wipro
				Technologies. All rights reserved<br> <b>Designed &
					Developed By: Vinit Kumar Goel</b>
			</td>
		</tr>
	</table>
	<%
		session.removeAttribute("Incorrect");
	%>
</body>
<html>