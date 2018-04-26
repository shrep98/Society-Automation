<%@page import="beans.Visitor"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    	<title>Visitor</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="Description of your site goes here">
        <meta name="keywords" content="keyword1, keyword2, keyword3">
 		<link href="css/style.css" rel="stylesheet" type="text/css">
        <%
            String msg = null;
            String flag = (String)request.getAttribute("add_visitor");
            System.out.println(flag);
            if(flag!=null)
            {
                if(flag.equalsIgnoreCase("true"))
                    msg = "New Visitor added Successfully";
                else
                    msg = "New Visitor could not be added. Please try again later";
        %>
        <script type="text/javascript">
            alert("<%= msg %>");
        </script>   
        <%
            }
            
            msg = null;
            msg = (String)request.getAttribute("update_visitor");
            if(msg!=null)
            {
            	%>
            		<script type="text/javascript">
            			alert("<%= msg %>");
        			</script>
            	<%
            }
            
            msg = null;
            msg = (String)request.getAttribute("delete_visitor");
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
  <li><a href="Visitor.jsp"  style="text-decoration:none;color=#000000;">Visitor<br></a></li>
  <li><a href="RegisterVisitor.jsp" style="text-decoration:none;color=#000000;">Add Visitor<br></a></li>
  <li><a href="DisplayVisitor.jsp" style="text-decoration:none;color=#000000;">Display And Update visitor<br></a></li>
  <li><a href="DeleteVisitor.jsp" style="text-decoration:none;color=#000000;">Delete Vistor<br></a></li></ul>
</div>
<div class="mid-right">
<h1>Visitor</h1></div>
<a href="RegisterVisitor.jsp" style="text-decoration:none;color=#000000;">Register New Visitor</a>
        <br>
        <br>
        <form action="AddVisitor" method="post">
            Existing Visitor:
            <select name="Visit_Id">
                <option value="0">Select Visitor</option>
            <%
            
                ArrayList<Visitor> visitorList = Visitor.getAllVisitors();
                Visitor visitor;
                for(int i=0;i<visitorList.size();i++)
                {
                    visitor = visitorList.get(i);
                    %>
                    <option value="<%= visitor.Visit_Id %>"> <%= visitor.FName + " " + visitor.LName  %> </option>
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
