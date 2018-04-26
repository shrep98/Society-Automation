package beans;


import java.sql.ResultSet;
import java.util.ArrayList;
import database.Select;
import database.Update;

public class Expense {

	   public String Soc_Id;
	   public int Exp_Id;
	   public String Status;
	   public String Date;
	   
	   public static boolean insertExpense(Expense expense) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Insert into expense(Soc_Id,Exp_Id,Status,Date)"+ 
	       "values('"+expense.Soc_Id+"','"+expense.Exp_Id+"','"+expense.Status+"','"+expense.Date+"')";
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   
	   public static boolean updateExpense(Expense expense) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Update expense"
	    		   +" set Status = '"+expense.Status+"' , Date = '"+expense.Date+"'"
	    		   + " where Soc_Id = '"+expense.Soc_Id+"' and Exp_Id ="+ expense.Exp_Id;
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   
	   public static boolean deleteExpense(String Soc_Id,int Exp_Id) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Delete from expense"
	    		   + " where Soc_Id = " + Soc_Id+ "and Exp_Id = "+Exp_Id;
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   
	   public static ArrayList<Expense> getAllExpense() throws Exception
	   {
	       ArrayList<Expense> expenseList = new ArrayList<Expense>();
	       Expense expense;
	       String query = "Select Soc_Id,Exp_Id,Status,Date from expense";
	       ResultSet rs = Select.execute(query);
	       while(rs.next())
	       {
	           expense =new Expense();
	           expense.Soc_Id = rs.getString("Soc_Id");
	           expense.Exp_Id = rs.getInt("Exp_Id");
	           expense.Status = rs.getString("Status");
	           expense.Date = rs.getString("Date");
	          
	           expenseList.add(expense);
	       }
	       
	       return expenseList;
	   }
	   
	   public static Expense getExpenseById(String Soc_Id,int Exp_Id) throws Exception
	   {
	       Expense expense =null;
	       String query = "Select Status,date from expense where Exp_Id=" + Exp_Id + "and Soc_ID =" + Soc_Id;
	       ResultSet rs = Select.execute(query);
	       if(rs.next())
	       {
	    	   expense =new Expense();
	           expense.Soc_Id = rs.getString("Soc_Id");
	           expense.Exp_Id = rs.getInt("Exp_Id");
	           expense.Status = rs.getString("Status");
	           expense.Date = rs.getString("Date");
	         }
	       
	       return expense;
	   }


}
