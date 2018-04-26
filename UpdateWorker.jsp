<%@page import="beans.Workers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Workers</title>
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
   <li><a href="Workers.jsp"  style="text-decoration:none;color=#000000;">Worker<br></a></li>
  <li><a href="AddWorker.jsp" style="text-decoration:none;color=#000000;">Add Worker<br></a></li>
  <li><a href="DisplayWorker.jsp" style="text-decoration:none;color=#000000;">Display And Update Worker<br></a></li>
  <li><a href="DeleteWorker.jsp" style="text-decoration:none;color=#000000;">Delete Worker<br></a></li>
</ul>
</div>
<div class="mid-right">
<h1>Workers Info Update</h1>
<%
int Work_Id = Integer.parseInt(request.getParameter("Work_Id"));
Workers w =Workers.getWorkerById(Work_Id);
%>
<form action="UpdateWorkers" method="post">    
            <table width="60%">
            	<tr>
                    <td>
                        Work Id
                    </td>
                    <td>
                        <input type="text" value="<%= w.Work_Id %>" disabled="disabled">
                        <input type="hidden" name="Work_Id" value="<%= w.Work_Id %>">
                    </td>
                </tr>
                
                <tr>
                    <td>
                        First Name
                    </td>
                    <td>
                        <input type="text" name="FName" value="<%= w.FName %>">
                    </td>
                </tr>
                <tr>
                    <td>
                        Last Name
                    </td>
                    <td>
                        <input type="text" name="LName" value="<%= w.LName %>">
                    </td>
                </tr>
                <tr>
                    <td>
                        Mobile No
                    </td>
                    <td>
                        <input type="text" name="Mob_No" value="<%= w.Mob_No %>">
                    </td>
                </tr>
                 <tr>
                    <td>
                        Type
                    </td>
                    <td>
                        <input type="text" name="Mob_No" value="<%= w.Type %>">
                    </td>
                </tr>
               
                <tr>
                    <td>
                        Address
                    </td>
                    <td>
                        <textarea name="Address" cols="25" rows="5" ><%= w.Address %></textarea>
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
