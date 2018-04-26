

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Needs;

/**
 * Servlet implementation class AddNeeds
 */
@WebServlet("/AddNeeds")
public class AddNeeds extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNeeds() {
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
		 Needs need = new Needs();
         need.Soc_Id=request.getParameter("Soc_Id");
         need.Work_Id=Integer.parseInt(request.getParameter("Work_Id"));
         need.Flat_No=Integer.parseInt(request.getParameter("Flat_No"));
         need.Wing=request.getParameter("Wing");
         need.Date=request.getParameter("Date");
         try {
 			boolean flag  = Needs.insertNeeds(need);
 			
 			
 			RequestDispatcher dispatcher = request.getRequestDispatcher("Needs.jsp");
 	        if(flag)
 	            request.setAttribute("add_needs", "true");
 	        else
 	            request.setAttribute("add_needs", "false");
 	        dispatcher.forward(request, response);
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}

        
	}

}
