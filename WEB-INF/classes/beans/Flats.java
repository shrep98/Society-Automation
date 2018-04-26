package beans;

import java.sql.ResultSet;
import java.util.ArrayList;

import database.Select;
import database.Update;

public class Flats {


	   public String Soc_Id;
	   public int Flat_No;
	   public String Wing;
	   public int Floor;
	   public String Owner;
	   public int Maintenance;
	   
	   public static boolean insertFlats(Flats flats) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Insert into flats(Soc_Id,Flat_No,Wing,Floor,Owner,Maintenance)"+ 
	       "values('"+flats.Soc_Id+"','"+flats.Flat_No+"','"+flats.Wing+"','"+flats.Floor+"','"+flats.Owner+"','"+flats.Maintenance+"')";
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   
	   public static boolean updateFlats(Flats flats) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Update flats"
	    		   +" set Floor= '"+flats.Floor+"' , Owner = '"+flats.Owner+"' ,Maintenance = '"+flats.Maintenance+"'"
	    		   		+ " where Soc_Id = '"+flats.Soc_Id+"' and Flat_No ='"+flats.Flat_No+"' and Wing = '"+flats.Wing+"'";
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   
	   public static boolean deleteFlats(String Soc_Id,int Flat_No,String Wing) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Delete from flats"
	    		   + " where Soc_Id = "+Soc_Id + " And Flat_No =" + Flat_No +" And Wing = '" + Wing + "'";
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   
	   public static ArrayList<Flats> getAllFlats() throws Exception
	   {
	       ArrayList<Flats> flatsList = new ArrayList<Flats>();
	       Flats flats;
	       String query = "Select Soc_Id,Flat_No,Wing,Floor,Owner,Maintenance from flats";
	       ResultSet rs = Select.execute(query);
	       while(rs.next())
	       {
	           flats =new Flats();
	           flats.Soc_Id = rs.getString("Soc_Id");
	           flats.Flat_No = rs.getInt("Flat_No");
	           flats.Wing = rs.getString("Wing");
	           flats.Floor = rs.getInt("Floor");
	           flats.Owner = rs.getString("Owner");
	           flats.Maintenance = rs.getInt("Maintenance");
	           
	           flatsList.add(flats);
	       }
	       
	       return flatsList;
	   }
	   
	   public static Flats getFlatsById(String Soc_Id,int Flat_No,String Wing) throws Exception
	   {
	       String query = "Select Floor,Owner,Maintenance from flats where Soc_Id='"+Soc_Id +"' and Flat_no ="+ Flat_No + " and Wing = '"+ Wing+"'";
	       ResultSet rs = Select.execute(query);
	       Flats flats = null;
		if(rs.next())
	       {
	    	   flats =new Flats();
	           flats.Soc_Id = rs.getString("Soc_Id");
	           flats.Flat_No = rs.getInt("Flat_No");
	           flats.Wing = rs.getString("Wing");
	           flats.Floor = rs.getInt("Floor");
	           flats.Owner = rs.getString("Owner");
	           flats.Maintenance = rs.getInt("Maintenance");
	           }
	       
	       return flats;
	   }


}
