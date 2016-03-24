<html>
<head>

<script>
	function loadXMLDoc(uname) {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("1").innerHTML = xmlhttp.responseText;
			}
		}
		var URL = "EVS_TBL_Result?c_name=" + uname;
		xmlhttp.open("Post", URL, true);
		xmlhttp.send();
	}
</script>
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
			<td colspan="3" align="right" height="30"><a
				href="Admin_Password_Change.html">Change Password</a>&nbsp;<a
				href="Logout.jsp">Logout</a></td>
		</tr>
		<tr>

			<td valign="top"><center>
					<input type="text" name="c_name"> <input type="submit"
						value="Show Result" onclick="loadXMLDoc(c_name.value)">
				</center></td>
		</tr>
		<tr>
			<td><center>
					<span id="1"></span>
				</center></td>
		</tr>
		<tr>
			<td colspan="3" align="center" height="20">Copyright © 2013
				Wipro Technologies. All rights reserved<br> <b>Designed &
					Developed By: Vinit Kumar Goel</b>
			</td>
		</tr>
	</table>

</body>
</html>