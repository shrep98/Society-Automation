<%@page import="beans.Flats"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Flats</title>
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
<h1>Flat Info Update</h1>
<%
String Soc_Id = request.getParameter("Soc_Id");
int Flat_No = Integer.parseInt(request.getParameter("Flat_No"));
String Wing = request.getParameter("Wing");

Flats flat=Flats.getFlatsById(Soc_Id, Flat_No, Wing);
%>
<form action="UpdateFlats" method="post">    
            <table width="60%">
            	<tr>
                    <td>
                        Soc_Id :
                    </td>
                    <td>
                        <input type="text" value="<%= flat.Soc_Id %>" disabled="disabled">
                        <input type="hidden" name="Soc_Id" value="<%= flat.Soc_Id %>">
                    </td>
                </tr>
                            	<tr>
                    <td>
                        Flat_No :
                    </td>
                    <td>
                        <input type="text" value="<%= flat.Flat_No %>" disabled="disabled">
                        <input type="hidden" name="Flat_No" value="<%= flat.Flat_No %>">
                    </td>
                </tr>
                
                <tr>
                    <td>
                        Wing:
                    </td>
                    <td>
                        <input type="text" name="Wing" value="<%= flat.Wing %>">
                    </td>
                </tr>
                <tr>
                    <td>
                        Floor:
                    </td>
                    <td>
                        <input type="text" name="Floor" value="<%= flat.Floor %>">
                    </td>
                </tr>
                 <tr>
                    <td>
                        Owner:
                    </td>
                    <td>
                        <input type="text" name="Owner" value="<%= flat.Owner %>">
                    </td>
                </tr>
                <tr>
                    <td>
                        Maintenance:
                    </td>
                    <td>
                        <input type="text" name="Maintenance" value="<%= flat.Maintenance %>">
                    </td>
                </tr>
               
                 <tr>
                    <td>
               <center><input type="submit" value=" Submit "></center> 
                    </td>
                </tr>
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
