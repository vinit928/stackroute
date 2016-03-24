<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="EVS_TBL_Credential_Login" method="Post">
		<table>
			<tr>
				<td>User Id:</td>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td colspan="2">
						<input type="radio" value="admin" name="usertype">Admin<br>
						<input type="radio" value="electronic_Officer" name="usertype">Electronic Officer<br>
				</td>

			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>