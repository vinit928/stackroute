
<html>
<head>
<script>
function loadXMLDoc()
{
var xmlhttp;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("1").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("Post","EVS_TBL_party",true);
xmlhttp.send();
}
</script>
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
			
			<td valign="top"><center>
					
		<input type="submit" value="Show All Parties" onclick="loadXMLDoc()">
				</center>
				</td>
		</tr>
		<tr><td><center><span id="1"></span></center></td></tr>
		<tr>
			<td colspan="3" align="center" height="20">Copyright © 2013Wipro Technologies. All rights reserved<br> <b>Designed & Developed By: Vinit Kumar Goel</b></td>
		</tr>
	</table>
</body>
<html>