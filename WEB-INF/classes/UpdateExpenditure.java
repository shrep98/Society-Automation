

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Expenditure;

/**
 * Servlet implementation class UpdateExpenditure
 */
@WebServlet("/UpdateExpenditure")
public class UpdateExpenditure extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateExpenditure() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost( request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   Expenditure expenditure=new Expenditure();
	 	   expenditure.Exp_Id=Integer.parseInt(request.getParameter("Exp_Id"));
	 	   expenditure.Amount=Integer.parseInt(request.getParameter("Amount"));
	 	   expenditure.Type=request.getParameter("Type");
	 	   
	 	  try {
				boolean flag  = Expenditure.updateExpenditure(expenditure);
				
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("Expenditure.jsp");
		        if(flag)
		            request.setAttribute("update_expenditure", "Expenditure information updated successfully.");
		        else
		            request.setAttribute("update_expenditure", "Expenditure information update Failed.");
		        dispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	}

}
