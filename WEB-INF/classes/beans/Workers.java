package beans;


import java.sql.ResultSet;
import java.util.ArrayList;

import database.Select;
import database.Update;

public class Workers {

	   public int Work_Id;
	   public String FName;
	   public String LName;
	   public String Mob_No;
	   public String Address;
	   public String Type;
	   
	   public static boolean insertWorkers(Workers worker) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Insert into workers(Work_Id,FName,LName,Mob_No,Address,Type)"+ 
	       "values('"+worker.Work_Id+"','"+worker.FName+"','"+worker.LName+"','"+worker.Mob_No+"','"+worker.Address+"','"+worker.Type+"')";
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   
	   public static boolean updateWorkers(Workers worker) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Update workers"
	    		   +" set FName = '"+worker.FName+"' , LName = '"+worker.LName+"' ,Mob_No = '"+worker.Mob_No+"', Address = '"+worker.Address+"',Type = '"+worker.Type+"'"	    		   
	    		   + " where Work_Id = "+worker.Work_Id;
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   
	   public static boolean deleteWorker(int Work_Id) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Delete from workers"
	    		   + " where Work_Id = "+Work_Id;
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   
	   public static ArrayList<Workers> getAllWorkers() throws Exception
	   {
	       ArrayList<Workers> workerList = new ArrayList<Workers>();
	       Workers worker;
	       String query = "Select Work_Id,FName,LName,Mob_No,Address,Type from workers";
	       ResultSet rs = Select.execute(query);
	       while(rs.next())
	       {
	           worker =new Workers();
	           worker.Work_Id = rs.getInt("Work_Id");
	           worker.FName = rs.getString("FName");
	           worker.LName = rs.getString("LName");
	           worker.Mob_No = rs.getString("Mob_No");
	           worker.Address = rs.getString("Address");
	           worker.Type = rs.getString("Type");
	           
	           workerList.add(worker);
	       }
	       
	       return workerList;
	   }
	   
	   public static Workers getWorkerById(int Work_Id) throws Exception
	   {
	       String query = "Select Work_Id,FName,LName,Mob_No,Address,Type from workers where Work_Id="+Work_Id;
	       ResultSet rs = Select.execute(query);
	       Workers worker = null;
		if(rs.next())
	       {
	    	   worker =new Workers();
	           worker.Work_Id = rs.getInt("Work_Id");
	           worker.FName = rs.getString("FName");
	           worker.LName = rs.getString("LName");
	           worker.Mob_No = rs.getString("Mob_No");
	           worker.Address = rs.getString("Address");
	           worker.Type = rs.getString("Type");
	           
	       }
	       
	       return worker;
	   }


}
