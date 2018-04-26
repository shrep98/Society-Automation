

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Society;

/**
 * Servlet implementation class UpdateSociety
 */
@WebServlet("/UpdateSociety")
public class UpdateSociety extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSociety() {
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
		Society s= new Society();
        s.Soc_Id = request.getParameter("Soc_Id");
        s.Name = request.getParameter("Name");
        s.TimeForm= Integer.parseInt(request.getParameter("TimeForm"));
        s.Age = Integer.parseInt(request.getParameter("Age"));
        s.Street=request.getParameter("Street");
        s.City=request.getParameter("City");
        s.Pincode = Integer.parseInt(request.getParameter("Pincode"));
        try {
			boolean flag  = Society.updateSociety(s);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Society.jsp");
	        if(flag)
	            request.setAttribute("update_society", "Society information updated successfully");
	        else
	            request.setAttribute("update_society", "Society information updation failed");
	        dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
