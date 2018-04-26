

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Visitor;

/**
 * Servlet implementation class DeleteVisitor
 */
@WebServlet("/DeleteVisitor")
public class DeleteVisitor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteVisitor() {
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
		int Visit_Id = Integer.parseInt(request.getParameter("Visit_Id"));
		 try {
				boolean flag  = Visitor.deleteVisitor(Visit_Id);
				
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("Visitor.jsp");
		        if(flag)
		            request.setAttribute("delete_visitor", "Visitor information deleted successfully");
		        else
		            request.setAttribute("delete_visitor", "Visitor information delete failed");
		        dispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
