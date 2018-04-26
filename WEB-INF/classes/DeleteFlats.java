

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Flats;

/**
 * Servlet implementation class DeleteFlats
 */
@WebServlet("/DeleteFlats")
public class DeleteFlats extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFlats() {
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
		int Flat_No = Integer.parseInt(request.getParameter("Flat_No"));
		String Wing =request.getParameter("Wing");
		 try {
				boolean flag  = Flats.deleteFlats(Soc_Id,Flat_No,Wing);
				
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("Flats.jsp");
		        if(flag)
		            request.setAttribute("delete_flats", "Flat information deleted successfully");
		        else
		            request.setAttribute("delete_flats", "Flat information delete failed");
		        dispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
