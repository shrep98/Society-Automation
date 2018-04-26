<%@page import="beans.Workers"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    	<title>Workers</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="Description of your site goes here">
        <meta name="keywords" content="keyword1, keyword2, keyword3">
 		<link href="css/style.css" rel="stylesheet" type="text/css">
        <%
            String msg = null;
            String flag = (String)request.getAttribute("add_workers");
            System.out.println(flag);
            if(flag!=null)
            {
                if(flag.equalsIgnoreCase("true"))
                    msg = " Worker Info added Successfully";
                else
                    msg = "Worker Info could not be added. Please try again later";
        %>
        <script type="text/javascript">
            alert("<%= msg %>");
        </script>   
        <%
            }
            
            msg = null;
            msg = (String)request.getAttribute("update_workers");
            if(msg!=null)
            {
            	%>
            		<script type="text/javascript">
            			alert("<%= msg %>");
        			</script>
            	<%
            }
            
            msg = null;
            msg = (String)request.getAttribute("delete_workers");
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
  <li><a href="Workers.jsp"  style="text-decoration:none;color=#000000;">Worker<br></a></li>
  <li><a href="AddWorker.jsp" style="text-decoration:none;color=#000000;">Add Worker<br></a></li>
  <li><a href="DisplayWorker.jsp" style="text-decoration:none;color=#000000;">Display And Update Worker<br></a></li>
  <li><a href="DeleteWorker.jsp" style="text-decoration:none;color=#000000;">Delete Worker<br></a></li>
</ul>
</div>
<div class="mid-right">
<h1>Workers</h1></div>
<a href="AddWorker.jsp" style="text-decoration:none;color=#000000;">Add New Worker</a>
        <br>
        <br>
        <form action="AddWorkers" method="post">
            Existing Worker
            <select name="Work_Id">
                <option value="0">Select Visitor</option>
            <%
            
                ArrayList<Workers> wList = Workers.getAllWorkers();
                Workers w;
                for(int i=0;i<wList.size();i++)
                {
                    w = wList.get(i);
                    %>
                    <option value="<%= w.Work_Id %>"> <%= w.FName + " " + w.LName  %> </option>
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
