<%@page import="beans.Expense"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    	<title>Expense</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="Description of your site goes here">
        <meta name="keywords" content="keyword1, keyword2, keyword3">
 		<link href="css/style.css" rel="stylesheet" type="text/css">
        <%
            String msg = null;
            String flag = (String)request.getAttribute("add_expense");
            System.out.println(flag);
            if(flag!=null)
            {
                if(flag.equalsIgnoreCase("true"))
                    msg = "New Expense added Successfully";
                else
                    msg = "New expense could not be added. Please try again later";
        %>
        <script type="text/javascript">
            alert("<%= msg %>");
        </script>   
        <%
            }
            
            msg = null;
            msg = (String)request.getAttribute("update_expense");
            if(msg!=null)
            {
            	%>
            		<script type="text/javascript">
            			alert("<%= msg %>");
        			</script>
            	<%
            }
            
            msg = null;
            msg = (String)request.getAttribute("delete_expense");
            if(msg!=null)
            {
            	%>
            		<script type="text/javascript">
            			alert("<%= msg %>");
        			</script>
            	<%
            }
        %>
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
<div class="banner-area"><img src="images/society.JPG" alt="#"
 border="0"></div>
</div>
<div class="mid">
<div class="mid-left">
<h3>Main Menu<br>
</h3>
<ul class="left-item">
  <li><a href="Expense.jsp" style="text-decoration:none;color=#000000;">Expense<br></a></li>
  <li><a href="AddExpense.jsp" style="text-decoration:none;color=#000000;">Add Expense<br></a></li>
  <li><a href="DisplayExpense.jsp" style="text-decoration:none;color=#000000;">Display Expense<br></a></li>
</ul>
</div>
<div class="mid-right">
<h1>Expense</h1></div>
<a href="AddExpense.jsp" style="text-decoration:none;color=#000000;">Add  New Expense</a>
        <br>
        <br>
        <form action="AddExpense" method="post">
            Existing Expense
            <select name="Exp_Id">
                <option value="0">Select Expense</option>
            <%
            
            	ArrayList<Expense> expenseList = Expense.getAllExpense();
 	       		Expense expense;
 	      		for(int i=0;i<expenseList.size();i++)
                {
                    expense = expenseList.get(i);
                    %>
                    <option value="<%= expense.Soc_Id + expense.Exp_Id %>"> Soc_Id: <%= expense.Soc_Id + " "%>Exp_Id: <%= expense.Exp_Id   %> </option>
                    <%
                }
                
            %>
            </select>
        </form>
    
</div>
<div class="footer">
</div>
</div>
<div class="right-gap1"><img src="images/spacer.gif" alt="#" border="0"
 height="1" width="6"></div>
</div>

<br>

</body>
 
    </body>
</html>
