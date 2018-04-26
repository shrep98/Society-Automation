

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Pays;
/**
 * Servlet implementation class AddPays
 */
@WebServlet("/AddPays")
public class AddPays extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPays() {
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
		Pays pay = new Pays();
        pay.Soc_Id= request.getParameter("Soc_Id");
        pay.Flat_No=Integer.parseInt(request.getParameter("Flat_No"));
        pay.Wing= request.getParameter("Wing");
        pay.Status= request.getParameter("Status");
        pay.Date= request.getParameter("Date");
        
        try {
			boolean flag  = Pays.insertPays(pay);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Pays.jsp");
	        if(flag)
	            request.setAttribute("add_pays", "true");
	        else
	            request.setAttribute("add_pays", "false");
	        dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
	}

}
