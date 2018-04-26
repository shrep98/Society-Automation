

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Workers;

/**
 * Servlet implementation class DeleteWorkers
 */
@WebServlet("/DeleteWorkers")
public class DeleteWorkers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteWorkers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int Work_Id = Integer.parseInt(request.getParameter("Work_Id"));
		 try {
				boolean flag  = Workers.deleteWorker(Work_Id);
				
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("Workers.jsp");
		        if(flag)
		            request.setAttribute("delete_workers", "Workers information deleted successfully");
		        else
		            request.setAttribute("delete_workers", "Workers information delete failed");
		        dispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
