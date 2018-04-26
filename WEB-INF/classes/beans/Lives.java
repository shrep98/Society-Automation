package beans;


import java.sql.ResultSet;
import java.util.ArrayList;

import database.Select;
import database.Update;

public class Lives {

	   public String Soc_Id;
	   public int Mem_Id;
	   public int Flat_No;
	   public String Wing;
	   
	   public static boolean insertLives(Lives lives) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Insert into lives(Soc_Id,Mem_Id,Flat_No,Wing)"+ 
	       "values('"+lives.Soc_Id+"','"+lives.Mem_Id+"','"+lives.Flat_No+"','"+lives.Wing+"')";
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   public static ArrayList<Lives> getAllLives() throws Exception
	   {
	       ArrayList<Lives> livesList = new ArrayList<Lives>();
	       Lives lives;
	       String query = "Select Soc_Id,Mem_Id,Flat_No,Wing from lives ";
	       ResultSet rs = Select.execute(query);
	       while(rs.next())
	       {
	           lives = new Lives();
	           lives.Soc_Id=rs.getString("Soc_Id");
	           lives.Mem_Id=rs.getInt("Mem_Id");
	           lives.Flat_No=rs.getInt("Flat_no");
	           lives.Wing=rs.getString("Wing");
	           
	           livesList.add(lives);
	       }
	       
	       return livesList;
	   }
	  
}
	   