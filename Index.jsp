<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Society Automation </title>
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
  <li style="border: medium none ;"><a href="Index.jsp">Home</a></li></ul> 
<form>
 <p align="right"> <input type="text" name="display" size="15"></p>
</form>

</div>
<div class="banner-area"><img src="images/society.JPG" alt="#"
 border="0"></div>
</div>
<div class="mid">
<div class="mid-left">
<h3>Main Menu<br>
</h3>
<ul class="left-item">
  <li><a href="Society.jsp"  style="text-decoration:none;color=#000000;">Society<br></a></li>
  <li><a href="Flats.jsp"  style="text-decoration:none;color=#000000;">Flats<br></a></li>
  <li><a href="Members.jsp"  style="text-decoration:none;color=#000000;">Members<br></a></li>
  <li><a href="Visitor.jsp"  style="text-decoration:none;color=#000000;">Visitor<br></a></li>
  <li><a href="Workers.jsp"  style="text-decoration:none;color=#000000;">Workers<br></a></li>
  <li><a href="Expenditure.jsp" style="text-decoration:none;color=#000000;">Expenditure<br></a></li>
  <li><a href="Lives.jsp" style="text-decoration:none;color=#000000;">Lives<br></a></li>
  <li><a href="Pays.jsp" style="text-decoration:none;color=#000000;">Pays<br></a></li>
  <li><a href="Needs.jsp" style="text-decoration:none;color=#000000;">Needs<br></a></li>
  <li><a href="Expense.jsp" style="text-decoration:none;color=#000000;">Expense<br></a></li>
  <li><a href="Visits.jsp" style="text-decoration:none;color=#000000;">Visits<br></a></li>
          
</ul>
</div>
<div class="mid-right">
<center><h1>Society Automation</h1></center></div>
<center><p>For a More Secured and Stabilised Management of the Society Information.</p></center>
<br><br>
<center><a href="DisplaySociety.jsp"  style="text-decoration:none;color=#000000;">Click To See The Societies Managed.</a></center>
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