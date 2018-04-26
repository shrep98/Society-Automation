

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Visitor;

/**
 * Servlet implementation class UpdateVisitor
 */
@WebServlet("/UpdateVisitor")
public class UpdateVisitor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVisitor() {
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
		Visitor visitor = new Visitor();
		visitor.Visit_Id=Integer.parseInt(request.getParameter("Visit_Id"));
        visitor.FName = request.getParameter("FName");
        visitor.LName = request.getParameter("LName");
        visitor.Mob_No = request.getParameter("Mob_No");
        visitor.Address = request.getParameter("Address");
        
        try {
			boolean flag  = Visitor.updateVisitor(visitor);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Visitor.jsp");
	        if(flag)
	            request.setAttribute("update_visitor", "Visitor information updated successfully");
	        else
	            request.setAttribute("update_visitor", "Visitor information updation failed");
	        dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
