<%@page import="beans.Expense"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Expense</title>
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
<h1>Expense Delete</h1>

<form action="DeleteExpense" method="post">    
 <table border="1">

<tr>
	<th> Soc_Id </th>
	<th> Exp_Id </th>
	<th> Status </th>
	<th> Date </th>
	<th>Option</th>
</tr>

<%

		ArrayList<Expense> expenseList = new ArrayList<Expense>();
		Expense expense;
		for(int i=0;i<expenseList.size();i++)
{
    	expense = expenseList.get(i);
		%>
			<tr>
				<td><%= expense.Soc_Id %></td>
				<td><%= expense.Exp_Id %></td>
				<td><%= expense.Status %></td>
				<td><%= expense.Date %></td>
				<td><a href="DeleteExpense?Soc_Id=<%=expense.Soc_Id %>&Exp_Id=<%=expense.Exp_Id %>" style="text-decoration:none;color=#000000;"><input type="button" value="Delete"></a></td>
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
