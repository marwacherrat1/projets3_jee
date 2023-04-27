package SERVLETS;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.daofactory;
import dao.postulationDao;

public class supprimerpostulation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private postulationDao postd;

    public void init() throws ServletException {
        daofactory daoFactory = daofactory.getInstance();
        this.postd =daoFactory.getpostulationDao();    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		daofactory daoFactory = daofactory.getInstance();
        this.postd=  daoFactory.getpostulationDao();
		int idp= Integer.parseInt(request.getParameter("idpo"));
		postd.delete(idp);
		request.getRequestDispatcher("candidat").forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
