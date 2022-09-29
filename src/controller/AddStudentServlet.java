package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListMusicStudent;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/addStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String instrument = request.getParameter("instrument");
		ListMusicStudent ls = new ListMusicStudent(name, instrument);
		ListMusicStudentHelper dao = new ListMusicStudentHelper();
		dao.insertStudent(ls);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request,  response);
	}

}
