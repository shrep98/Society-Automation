

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Visits;

/**
 * Servlet implementation class AddVisits
 */
@WebServlet("/AddVisits")
public class AddVisits extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVisits() {
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
		Visits visit = new Visits();
        visit.Soc_Id = request.getParameter("Soc_Id");
        visit.Visit_Id = Integer.parseInt(request.getParameter("Visit_Id"));
        visit.Flat_No = Integer.parseInt(request.getParameter("Flat_No"));
        visit.Wing =request.getParameter("Wing");
        visit.Visit_Time = request.getParameter("Visit_Time");
        visit.Exit_Time =request.getParameter("Exit_Time");
        try {
			boolean flag  = Visits.insertVisits(visit);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Visits.jsp");
	        if(flag)
	            request.setAttribute("add_visits", "true");
	        else
	            request.setAttribute("add_visits", "false");
	        dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
