<%@page import="beans.Flats"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Flat Info</title>
        <meta name="description" content="Description of your site goes here">
  		<meta name="keywords" content="keyword1, keyword2, keyword3">
  		<link href="css/style.css" rel="stylesheet" type="text/css">   
  		<script>
var timer=null;

function stop()
{
clearTimeout(timer);
}

function start()
{
var time=new Date();
var hours=time.getHours();
var minutes=time.getMinutes();
minutes=((minutes < 10) ? "0" : "") + minutes;
var seconds=time.getSeconds();
seconds=((seconds < 10) ? "0" : "") + seconds;
var clock=hours + ":" + minutes + ":" + seconds;
document.forms[0].display.value=clock;
timer=setTimeout("start()",1000);
}
</script>
    </head>
 <body onload="start()" onunload="stop()">
   <div class="wrapper">
<div class="left-gap1"><img src="images/spacer.gif" alt="#" border="0"
 height="1" width="6"></div>
<div class="main">
<div class="header">
<div class="nav-area">
<ul class="nav">
  <li style="border: medium none ;"><a href="Index.jsp">Home</a></li>
</ul>
<form>
 <p align="right"> <input type="text" name="display" size="15"></p>
</form>

</div>
<div class="banner-area"><img src="images/society.JPG" alt="#" border="0"></div>
</div>
<div class="mid">
<div class="mid-left">
<h3>Main Menu<br>
</h3>
<ul class="left-item">
 <li><a href="Flats.jsp"  style="text-decoration:none;color=#000000;">Flat<br></a></li>
  <li><a href="AddFlat.jsp" style="text-decoration:none;color=#000000;">Add Flat<br></a></li>
  <li><a href="DisplayFlat.jsp" style="text-decoration:none;color=#000000;">Display And Update Flat<br></a></li>
  <li><a href="DeleteFlat.jsp" style="text-decoration:none;color=#000000;">Delete Flat<br></a></li>
</ul>
</div>
<div class="mid-right">
<h1>Flats Delete</h1>

<form action="DeleteFlats" method="post">    
 <table border="1">

<tr>
	<th> Soc_Id </th>
	<th> Flat_No </th>
	<th> Wing </th>
	<th>Floor</th>
	<th>Owner</th>
	<th> Maintenance </th>
	<th>Option</th>
</tr>

<%

	ArrayList<Flats> flatsList = Flats.getAllFlats();
 	Flats flats;
 	for(int i=0;i<flatsList.size();i++)
    {
        flats= flatsList.get(i);
		%>
			<tr>
				<td><%= flats.Soc_Id %></td>
				<td><%= flats.Flat_No %></td>
				<td><%= flats.Wing %></td>
				<td><%= flats.Floor %></td>
				<td><%= flats.Owner %></td>
				<td><%= flats.Maintenance %></td>
				<td><a href="DeleteFlats?Soc_Id=<%=flats.Soc_Id %>&Flat_No=<%=flats.Flat_No %>&Wing=<%=flats.Wing %>" style="text-decoration:none;color=#000000;"><input type="button" value="Delete"></a></td>
			</tr>
		<%
	}
%>

</table>
</form>
           
</div>
</div>
<div class="footer">
</div>
</div>
<div class="right-gap1"><img src="images/spacer.gif" alt="#" border="0"
 height="1" width="6"></div>
</div>

<br>

</body>
</html>
