

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Expense;
/**
 * Servlet implementation class UpdateExpense
 */
@WebServlet("/UpdateExpense")
public class UpdateExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateExpense() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Expense expense =new Expense();
        expense.Soc_Id = request.getParameter("Soc_Id");
        expense.Exp_Id = Integer.parseInt(request.getParameter("Exp_Id"));
        expense.Status = request.getParameter("Status");
        expense.Date = request.getParameter("Date");
        try {
			boolean flag  = Expense.updateExpense(expense);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Expense.jsp");
	        if(flag)
	            request.setAttribute("update_expense", "Visitor information updated successfully");
	        else
	            request.setAttribute("update_expense", "Visitor information updation failed");
	        dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
