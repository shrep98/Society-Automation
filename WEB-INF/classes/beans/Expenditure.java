package beans;

import java.sql.ResultSet;
import java.util.ArrayList;

import database.Select;
import database.Update;

public class Expenditure {
	   public int Exp_Id;
	   public int Amount;
	   public String Type;
	   
	   
	   
	   public static boolean insertExpenditure(Expenditure expenditure) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Insert into expenditure(Exp_Id,Amount,Type)"+ 
	       "values('"+expenditure.Exp_Id+"','"+expenditure.Amount+"','"+expenditure.Type+"')";
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   public static boolean updateExpenditure(Expenditure expenditure) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Update expenditure"
	    		   +" set Amount = '"+expenditure.Amount+"' , Type = '"+expenditure.Type+"' where Exp_Id ='"+expenditure.Exp_Id+"'";
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   
	   public static boolean deleteExpenditure(int Exp_Id) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Delete from expenditure"
	    		   + " where Exp_Id = "+Exp_Id;
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	  
	   public static ArrayList<Expenditure> getAllExpenditure() throws Exception
	   {
	       ArrayList<Expenditure> expenditureList = new ArrayList<Expenditure>();
	       Expenditure expenditure;
	       String query = "Select Exp_Id,Amount,Type from expenditure";
	       ResultSet rs = Select.execute(query);
	       while(rs.next())
	       {
	    	   expenditure=new Expenditure();
	    	   expenditure.Exp_Id=rs.getInt("Exp_Id");
	    	   expenditure.Amount=rs.getInt("Amount");
	    	   expenditure.Type=rs.getString("Type");
	          
	    	   expenditureList.add(expenditure);
	       }
	       
	       return expenditureList;
	   }
	   public static Expenditure getExpenditureById(int Exp_Id) throws Exception
	   {
		   Expenditure expenditure = null;
	       String query = "Select Exp_Id,Amount,Type from expenditure where Exp_Id="+Exp_Id;
	       ResultSet rs = Select.execute(query);
	       if(rs.next())
	       {
	    	   expenditure =new Expenditure();
	    	   expenditure.Exp_Id=rs.getInt("Exp_Id");
	    	   expenditure.Amount=rs.getInt("Amount");
	    	   expenditure.Type=rs.getString("Type");
	          
	       }
	       
	       return expenditure;
	    }
}




