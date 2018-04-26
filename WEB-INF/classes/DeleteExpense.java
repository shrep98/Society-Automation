

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Expense;
/**
 * Servlet implementation class DeleteExpense
 */
@WebServlet("/DeleteExpense")
public class DeleteExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteExpense() {
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
		String Soc_Id = request.getParameter("Soc_Id");
		int Exp_Id = Integer.parseInt(request.getParameter("Exp_Id"));
		try {
			boolean flag  = Expense.deleteExpense(Soc_Id,Exp_Id);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Expense.jsp");
	        if(flag)
	            request.setAttribute("delete_expense", "expense information deleted successfully");
	        else
	            request.setAttribute("delete_expense", "expense information delete failed");
	        dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
