

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Workers;

/**
 * Servlet implementation class UpdateWorkers
 */
@WebServlet("/UpdateWorkers")
public class UpdateWorkers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateWorkers() {
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
		Workers worker =new Workers();
        worker.Work_Id = Integer.parseInt(request.getParameter("Work_Id"));
        worker.FName = request.getParameter("FName");
        worker.LName = request.getParameter("LName");
        worker.Mob_No = request.getParameter("Mob_No");
        worker.Address =request.getParameter("Address");
        worker.Type =request.getParameter("Type");
        

        try {
			boolean flag  = Workers.updateWorkers(worker);			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Workers.jsp");
	        if(flag)
	            request.setAttribute("update_workers", "Worker information updated succssfully");
	        else
	            request.setAttribute("update_workers", "Worker information update failed.");
	        dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
