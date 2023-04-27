package SERVLETS;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.candidatDao;
import dao.daofactory;

/**
 * Servlet implementation class cv
 */
public class cv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private candidatDao candidatDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cv() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {
        daofactory daoFactory = daofactory.getInstance();
        this.candidatDao = daoFactory.getcandidatDao();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		daofactory daoFactory = daofactory.getInstance();
        this.candidatDao = daoFactory.getcandidatDao();
		int idc = Integer.parseInt(request.getParameter("idc"));
		candidatDao.un(idc);
		String s=request.getParameter("s");
		request.setAttribute("s", s);
		//recuperer infos de candidat precis
		request.setAttribute("candidat", candidatDao.un(idc));
		//user contient le nom de user(session)
		request.setAttribute("user",request.getParameter("user"));
	    this.getServletContext().getRequestDispatcher("/WEB-INF/cv.jsp").forward(request, response);
			
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
