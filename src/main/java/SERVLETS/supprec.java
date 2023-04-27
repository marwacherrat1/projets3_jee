package SERVLETS;

import java.io.IOException;
import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */

public class supprec extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
    private recDao reDao;

    public void init() throws ServletException {
        daofactory daoFactory = daofactory.getInstance();
        this.reDao = (dao.recDao) daoFactory.getrecDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		daofactory daoFactory = daofactory.getInstance();
        this.reDao = (recDao) daoFactory.getrecDao();
		int idr = Integer.parseInt(request.getParameter("idr"));
		reDao.delete_rec(idr);
		request.getRequestDispatcher("all").forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    
}
