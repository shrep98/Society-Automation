package beans;


import java.sql.ResultSet;
import java.util.ArrayList;

import database.Select;
import database.Update;

public class Visits {

	   public String Soc_Id;
	   public int Visit_Id;
	   public int Flat_No;
	   public String Wing;
	   public String Visit_Time;
	   public String Exit_Time;
	   
	   public static boolean insertVisits(Visits visit) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Insert into visits(Soc_Id,Visit_Id,Flat_No,Wing,Visit_Time,Exit_Time)"+ 
	       "values('"+visit.Soc_Id+"','"+visit.Visit_Id+"','"+visit.Flat_No+"','"+visit.Wing+"','"+visit.Visit_Time+"','"+visit.Exit_Time+"')";
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   
	   public static ArrayList<Visits> getAllVisits() throws Exception
	   {
	       ArrayList<Visits> visitList = new ArrayList<Visits>();
	       Visits visit;
	       String query = "Select Soc_Id,Visit_Id,Flat_No,Wing,Visit_Time,Exit_Time from visits";
	       ResultSet rs = Select.execute(query);
	       while(rs.next())
	       {
	           visit = new Visits();
	           visit.Soc_Id = rs.getString("Soc_Id");
	           visit.Visit_Id = rs.getInt("Visit_Id");
	           visit.Flat_No = rs.getInt("Flat_No");
	           visit.Wing = rs.getString("Wing");
	           visit.Visit_Time = rs.getString("Visit_Time");
	           visit.Exit_Time = rs.getString("Exit_Time");
	           visitList.add(visit);
	       }
	       
	       return visitList;
	   }
	   }
