package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListMusicStudent;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String act = request.getParameter("doThisToItem");
		String path = "/viewAllItemsServlet";
		ListMusicStudentHelper dao = new ListMusicStudentHelper();
		if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListMusicStudent itemToDelete = dao.searchForStudentById(tempId);
				dao.deleteStudent(itemToDelete);
			} catch (NumberFormatException e) {
				System.out.println("You forgot to choose a Student");
			}
			} else if(act.equals("edit")) {
						try{
							Integer tempId = Integer.parseInt(request.getParameter("id"));
							ListMusicStudent studentToEdit = dao.searchForStudentById(tempId);
							request.setAttribute("studentToEdit", studentToEdit);
							path = "/edit-student.jsp";
						}catch(NumberFormatException e) {
							System.out.println("You forgot to choose a Student");
						}
					}else if(act.equals("add")) {
								path = "/index.html";
							}
		getServletContext().getRequestDispatcher(path).forward(request, response);

	}

}
