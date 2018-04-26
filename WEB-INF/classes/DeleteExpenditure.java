

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Expenditure;

/**
 * Servlet implementation class DeleteExpenditure
 */
@WebServlet("/DeleteExpenditure")
public class DeleteExpenditure extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteExpenditure() {
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
		int Exp_Id = Integer.parseInt(request.getParameter("Exp_Id"));
		
		try {
			boolean flag  = Expenditure.deleteExpenditure(Exp_Id);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Expenditure.jsp");
	        if(flag)
	            request.setAttribute("delete_expenditure", "Expenditure information deleted successfully.");
	        else
	            request.setAttribute("delete_expenditure", "Expenditure information delete Failed.");
	        dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}

}
