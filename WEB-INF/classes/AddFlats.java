

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Flats;

/**
 * Servlet implementation class AddFlats
 */
@WebServlet("/AddFlats")
public class AddFlats extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlats() {
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
		Flats flats =new Flats();
        flats.Soc_Id = request.getParameter("Soc_Id");
        flats.Flat_No = Integer.parseInt(request.getParameter("Flat_No"));
        flats.Wing =request.getParameter("Wing");
        flats.Floor = Integer.parseInt(request.getParameter("Floor"));
        flats.Owner = request.getParameter("Owner");
        flats.Maintenance = Integer.parseInt(request.getParameter("Maintenance"));
        
        try {
			boolean flag  = Flats.insertFlats(flats);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Flats.jsp");
	        if(flag)
	            request.setAttribute("add_flats", "true");
	        else
	            request.setAttribute("add_flats", "false");
	        dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}

}
