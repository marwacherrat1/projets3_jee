package SERVLETS;

import java.io.IOException;

import dao.candidatDao;
import dao.daofactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */

public class supp extends jakarta.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    private candidatDao candidatDao;

    public void init() throws ServletException {
        daofactory daoFactory = daofactory.getInstance();
        this.candidatDao = daoFactory.getcandidatDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		daofactory daoFactory = daofactory.getInstance();
        this.candidatDao = daoFactory.getcandidatDao();
		int idc = Integer.parseInt(request.getParameter("idc"));
		candidatDao.deleteC(idc);
		request.getRequestDispatcher("all").forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}