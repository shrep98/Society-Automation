package beans;


import java.sql.ResultSet;
import java.util.ArrayList;

import database.Select;
import database.Update;

public class Members {
	
	   public int Mem_Id;
	   public String FName;
	   public String LName;
	   public String Mob_No;
	   
	   public static boolean insertMembers(Members member) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Insert into members(Mem_Id,FName,LName,Mob_No)"+ 
	       "values('"+member.Mem_Id+"','"+member.FName+"','"+member.LName+"','"+member.Mob_No+"')";
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   
	   public static boolean updateMembers(Members member) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Update members"
	    		   +" set FName = '"+member.FName+"' , LName = '"+member.LName+"' ,Mob_No = '"+member.Mob_No+"'"
	    		   + " where Mem_Id = "+member.Mem_Id;
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   
	   public static boolean deleteMembers(int Mem_Id) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Delete from members"
	    		   + " where Mem_Id = "+Mem_Id;
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   
	   public static ArrayList<Members> getAllMembers() throws Exception
	   {
	       ArrayList<Members> membersList = new ArrayList<Members>();
	       Members member;
	       String query = "Select Mem_Id,FName,LName,Mob_No from members";
	       ResultSet rs = Select.execute(query);
	       while(rs.next())
	       {
	           member = new Members();
	           member.Mem_Id = rs.getInt("Mem_Id");
	           member.FName = rs.getString("FName");
	           member.LName = rs.getString("LName");
	           member.Mob_No = rs.getString("Mob_No");
	          
	           membersList.add(member);
	       }
	       
	       return membersList;
	   }
	   
	   public static Members getMembersById(int Mem_Id) throws Exception
	   {
	       
	       String query = "Select Mem_Id,FName,LName,Mob_No from members where Mem_Id="+Mem_Id;
	       ResultSet rs = Select.execute(query);
		Members member = null;
		if(rs.next())
	       {
	    	   member = new Members();
	           member.Mem_Id = rs.getInt("Mem_Id");
	           member.FName = rs.getString("FName");
	           member.LName = rs.getString("LName");
	           member.Mob_No = rs.getString("Mob_No");
	        }
	       
	       return member;
	   }

}
