<%@page import="beans.Expense"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Expense</title>
        <meta name="description" content="Description of your site goes here">
  		<meta name="keywords" content="keyword1, keyword2, keyword3">
  		<link href="css/style.css" rel="stylesheet" type="text/css">   
    </head>
    <body>
    <div class="wrapper">
<div class="left-gap1"><img src="images/spacer.gif" alt="#" border="0"
 height="1" width="6"></div>
<div class="main">
<div class="header">
<div class="nav-area">
<ul class="nav">
  <li style="border: medium none ;"><a href="#">Homepage</a></li>
</ul>
</div>
<div class="banner-area"><img src="images/society.JPG" alt="#" border="0"></div>
</div>
<div class="mid">
<div class="mid-left">
<h3>Main Menu<br>
</h3>
<ul class="left-item">
  <li><a href="#">Link 1<br>
    </a></li>
</ul>
<h3>Resources</h3>
<ul class="left-item">
  <li><a href="index.html#">Link 1</a></li>
</ul>
</div>
<div class="mid-right">
<h1>Expense Update</h1>
<%
String Soc_Id = request.getParameter("Soc_Id");
int Exp_Id = Integer.parseInt(request.getParameter("Exp_Id"));

Expense expense =Expense.getExpenseById(Soc_Id, Exp_Id);
%>
<form action="UpdateExpense" method="post">    
            <table width="60%">
            	<tr>
                    <td>
                        Soc_Id :
                    </td>
                    <td>
                        <input type="text" value="<%= expense.Soc_Id %>" disabled="disabled">
                        <input type="hidden" name="Soc_Id" value="<%= expense.Soc_Id %>">
                    </td>
                </tr>
                            	<tr>
                    <td>
                        Exp_Id :
                    </td>
                    <td>
                        <input type="text" value="<%= expense.Exp_Id %>" disabled="disabled">
                        <input type="hidden" name="Exp_Id" value="<%= expense.Exp_Id %>">
                    </td>
                </tr>
                
                <tr>
                    <td>
                        Status:
                    </td>
                    <td>
                        <input type="text" name="Status" value="<%= expense.Status %>">
                    </td>
                </tr>
                <tr>
                    <td>
                        Date:
                    </td>
                    <td>
                        <input type="text" name="Date" value="<%= expense.Date %>">
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
