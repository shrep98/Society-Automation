package beans;

import java.sql.ResultSet;
import java.util.ArrayList;

import database.Select;
import database.Update;
public class Society {

	   public  String Soc_Id;
	   public String Name;
	   public int TimeForm;
	   public int Age;
	   public String Street;
	   public String City;
	   public int Pincode;
	   
	   public static boolean insertSociety(Society soc) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Insert into society(Soc_Id,Name,TimeForm,Age,Street,City,Pincode)"+ 
	       "values('"+soc.Soc_Id+"','"+soc.Name+"','"+soc.TimeForm+"','"+soc.Age+"','"+soc.Street+"','"+soc.City+"','"+soc.Pincode+"')";
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   
	   public static boolean updateSociety(Society s) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Update society"
	    		   +" set Name = '"+s.Name+"' , TimeForm = '"+s.TimeForm+"' ,Age = '"+s.Age+"' , Street='"+s.Street+"',City ='"+s.City+"' ,Pincode = '"+s.Pincode+"'"
	    		   + " where Soc_Id = "+s.Soc_Id;
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   
	   public static boolean deleteSociety(String s) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Delete from society"
	    		   + " where Soc_Id = "+s;
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   
	   public static ArrayList<Society> getAllSociety() throws Exception
	   {
	       ArrayList<Society> societyList = new ArrayList<Society>();
	       Society s;
	       String query = "Select Soc_Id,Name,TimeForm,Age,Street,City,Pincode from society";
	       ResultSet rs = Select.execute(query);
	       while(rs.next())
	       {
	           s= new Society();
	           s.Soc_Id = rs.getString("Soc_Id");
	           s.Name = rs.getString("Name");
	           s.TimeForm= rs.getInt("TimeForm");
	           s.Age = rs.getInt("Age");
	           s.Street=rs.getString("Street");
	           s.City=rs.getString("City");
	           s.Pincode = rs.getInt("Pincode");
	          
	           societyList.add(s);
	       }
	       
	       return societyList;
	   }
	   
	   public static Society getSocietyById(String soc) throws Exception
	   {
	       Society s=null;
	       String query = "Select Soc_Id,Name,TimeForm,Age,Street,City,Pincode from society where Soc_Id="+soc;
	       ResultSet rs = Select.execute(query);
	       if(rs.next())
	       {
	           
	    	   s= new Society();
	           s.Soc_Id = rs.getString("Soc_Id");
	           s.Name = rs.getString("Name");
	           s.TimeForm= rs.getInt("TimeForm");
	           s.Age = rs.getInt("Age");
	           s.Street=rs.getString("Street");
	           s.City=rs.getString("City");
	           s.Pincode = rs.getInt("Pincode");
	          
	       }
	       
	       return s;
	   }


}
