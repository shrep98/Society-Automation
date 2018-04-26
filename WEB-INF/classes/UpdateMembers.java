

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Members;

/**
 * Servlet implementation class UpdateMembers
 */
@WebServlet("/UpdateMembers")
public class UpdateMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMembers() {
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
		Members member = new Members();
        member.Mem_Id = Integer.parseInt(request.getParameter("Mem_Id"));
        member.FName = request.getParameter("FName");
        member.LName = request.getParameter("LName");
        member.Mob_No = request.getParameter("Mob_No");
        try {
			boolean flag  = Members.updateMembers(member);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Members.jsp");
	        if(flag)
	            request.setAttribute("update_members", "Member information updated successfully");
	        else
	            request.setAttribute("update_members", "Member information updation failed");
	        dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
