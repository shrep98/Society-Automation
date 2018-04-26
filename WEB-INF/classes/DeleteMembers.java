

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Members;

/**
 * Servlet implementation class DeleteMembers
 */
@WebServlet("/DeleteMembers")
public class DeleteMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMembers() {
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
		int Mem_Id = Integer.parseInt(request.getParameter("Mem_Id"));
		 try {
				boolean flag  = Members.deleteMembers(Mem_Id);
				
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("Members.jsp");
		        if(flag)
		            request.setAttribute("delete_members", "Member information deleted successfully");
		        else
		            request.setAttribute("delete_members", "Memberr information delete failed");
		        dispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
