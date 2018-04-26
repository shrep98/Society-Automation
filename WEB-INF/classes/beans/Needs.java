package beans;


import java.sql.ResultSet;
import java.util.ArrayList;

import database.Select;
import database.Update;

public class Needs {

	public String Soc_Id;
	   public int Work_Id;
	   public int Flat_No;
	   public String Wing;
	   public String Date;
	   
	   public static boolean insertNeeds(Needs need) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Insert into needs(Soc_Id,Work_Id,Flat_No,Wing,Date)"+ 
	       "values('"+need.Soc_Id+"','"+need.Work_Id+"','"+need.Flat_No+"','"+need.Wing+"','"+need.Date+"')";
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   public static ArrayList<Needs> getAllNeeds() throws Exception
	   {
	       ArrayList<Needs> needsList = new ArrayList<Needs>();
	       Needs need;
	       String query = "Select Soc_Id,Work_Id,Flat_No,Wing,Date from needs ";
	       ResultSet rs = Select.execute(query);
	       while(rs.next())
	       {
	           need = new Needs();
	           need.Soc_Id=rs.getString("Soc_Id");
	           need.Work_Id=rs.getInt("Work_Id");
	           need.Flat_No=rs.getInt("Flat_no");
	           need.Wing=rs.getString("Wing");
	           need.Date=rs.getString("Date");
	           
	           needsList.add(need);
	       }
	       
	       return needsList;
	   }
	  
}
	   