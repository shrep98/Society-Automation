package beans;


import java.sql.ResultSet;
import java.util.ArrayList;

import database.Select;
import database.Update;

public class Pays {
	   public String Soc_Id;
	   public int Flat_No;
	   public String Wing;
	   public String Status;
	   public String Date;
	   
	   public static boolean insertPays(Pays pay) throws Exception
	   {
	       int rows=0;
	       
	       String query = "Insert into pays(Soc_Id,Flat_No,Wing,Status,Date)"+ 
	       "values('"+pay.Soc_Id+"','"+pay.Flat_No+"','"+pay.Wing+"','"+pay.Status+"','"+pay.Date+"')";
	       System.out.println(query);
	       rows = Update.execute(query);
	       
	       return rows==1;
	   }
	   public static ArrayList<Pays> getAllPays() throws Exception
	   {
	       ArrayList<Pays> payList = new ArrayList<Pays>();
	       Pays pay;
	       String query = "Select Soc_Id,Flat_No,Wing,Status,Date from pays ";
	       ResultSet rs = Select.execute(query);
	       while(rs.next())
	       {
	           pay = new Pays();
	           pay.Soc_Id=rs.getString("Soc_Id");
	           pay.Flat_No=rs.getInt("Flat_no");
	           pay.Wing=rs.getString("Wing");
	           pay.Status=rs.getString("Status");
	           pay.Date=rs.getString("Date");
	           
	           payList.add(pay);
	       }
	       
	       return payList;
	   }


}
