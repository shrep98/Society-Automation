package beans;


import java.sql.ResultSet;
import java.util.ArrayList;

import database.Select;
import database.Update;

public class Visitor {
   public int Visit_Id;
   public String FName;
   public String LName;
   public String Mob_No;
   public String Address;
   
   public static boolean insertVisitor(Visitor visitor) throws Exception
   {
       int rows=0;
       
       String query = "Insert into visitors(Visit_Id,FName,LName,Mob_No,Address)"+ 
       "values('"+visitor.Visit_Id+"','"+visitor.FName+"','"+visitor.LName+"','"+visitor.Mob_No+"','"+visitor.Address+"')";
       System.out.println(query);
       rows = Update.execute(query);
       
       return rows==1;
   }
   
   public static boolean updateVisitor(Visitor visitor) throws Exception
   {
       int rows=0;
       
       String query = "Update visitors"
    		   +" set FName = '"+visitor.FName+"' , LName = '"+visitor.LName+"' ,Mob_No = '"+visitor.Mob_No+"' , Address = '"+visitor.Address+"'"
    		   + " where Visit_Id = "+visitor.Visit_Id;
       System.out.println(query);
       rows = Update.execute(query);
       
       return rows==1;
   }
   
   public static boolean deleteVisitor(int Visit_Id) throws Exception
   {
       int rows=0;
       
       String query = "Delete from visitors"
    		   + " where Visit_Id = "+Visit_Id;
       System.out.println(query);
       rows = Update.execute(query);
       
       return rows==1;
   }
   
   public static ArrayList<Visitor> getAllVisitors() throws Exception
   {
       ArrayList<Visitor> visitorList = new ArrayList<Visitor>();
       Visitor visitor;
       String query = "Select Visit_Id,FName,LName,Mob_No,Address from visitors";
       ResultSet rs = Select.execute(query);
       while(rs.next())
       {
           visitor = new Visitor();
           visitor.Visit_Id = rs.getInt("Visit_Id");
           visitor.FName = rs.getString("FName");
           visitor.LName = rs.getString("LName");
           visitor.Mob_No = rs.getString("Mob_No");
           visitor.Address = rs.getString("Address");
          
           visitorList.add(visitor);
       }
       
       return visitorList;
   }
   
   public static Visitor getVisitorById(int Visit_Id) throws Exception
   {
       Visitor visitor=null;
       String query = "Select Visit_Id,FName,LName,Mob_No,Address from visitors where Visit_Id="+Visit_Id;
       ResultSet rs = Select.execute(query);
       if(rs.next())
       {
           visitor = new Visitor();
           visitor.Visit_Id = rs.getInt("Visit_Id");
           visitor.FName = rs.getString("FName");
           visitor.LName = rs.getString("LName");
           visitor.Mob_No = rs.getString("Mob_No");
           visitor.Address = rs.getString("Address");
       }
       
       return visitor;
   }
}
