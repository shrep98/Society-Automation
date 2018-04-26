<%@page import="beans.Expenditure"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Expenditure</title>
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
 <li><a href="Expenditure.jsp"  style="text-decoration:none;color=#000000;">Expenditure<br></a></li>
  <li><a href="AddExpenditure.jsp" style="text-decoration:none;color=#000000;">Add Expenditure<br></a></li>
  <li><a href="DisplayExpenditure.jsp" style="text-decoration:none;color=#000000;">Display And Update Expenditure<br></a></li>
  <li><a href="DeleteExpenditure.jsp" style="text-decoration:none;color=#000000;">Delete Expenditure<br></a></li>
</ul>
</div>
<div class="mid-right">
<h1>Expenditure Update</h1>
<%
int Exp_Id = Integer.parseInt(request.getParameter("Exp_Id"));

Expenditure expenditure = Expenditure.getExpenditureById(Exp_Id);
%>
<form action="UpdateExpenditure" method="post">    
            <table width="60%">
            	<tr>
                    <td>
                        Expenditure Id
                    </td>
                    <td>
                        <input type="text" value="<%= expenditure.Exp_Id %>" disabled="disabled">
                        <input type="hidden" name="Exp_Id" value="<%= expenditure.Exp_Id %>">
                    </td>
                </tr>
                
                <tr>
                    <td>
                        Amount
                    </td>
                    <td>
                        <input type="text" name="Amount" value="<%= expenditure.Amount %>">
                    </td>
                </tr>
                <tr>
                    <td>
                        Type
                    </td>
                    <td>
                        <input type="text" name="Type" value="<%= expenditure.Type %>">
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
