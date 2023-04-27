package SERVLETS;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.daofactory;
import dao.recDao;

/**
 * Servlet implementation class ajoutpostulation
 */
public class ajoutpostulation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ajoutpostulation() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("ido",Integer.parseInt(request.getParameter("ido")));//pour savoir de quel offre s'agit il.
		String s=request.getParameter("s");
		request.setAttribute("s", s);
		request.getRequestDispatcher("/postuler.jsp").forward( request, response );// interface par laquelle candidat entre la lettre.
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
