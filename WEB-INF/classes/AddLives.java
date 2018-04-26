

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Lives;

/**
 * Servlet implementation class AddLives
 */
@WebServlet("/AddLives")
public class AddLives extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLives() {
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
		Lives lives = new Lives();
        lives.Soc_Id=request.getParameter("Soc_Id");
        lives.Mem_Id=Integer.parseInt(request.getParameter("Mem_Id"));
        lives.Flat_No=Integer.parseInt(request.getParameter("Flat_No"));
        lives.Wing=request.getParameter("Wing");
        
        try {
			boolean flag  = Lives.insertLives(lives);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Lives.jsp");
	        if(flag)
	            request.setAttribute("add_lives", "true");
	        else
	            request.setAttribute("add_lives", "false");
	        dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
