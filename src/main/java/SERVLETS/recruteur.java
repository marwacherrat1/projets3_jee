package SERVLETS;

import java.io.IOException;
import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Test
 */

public class recruteur extends jakarta.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    private candidatDao candidatDao;
	private recDao recDa;
	private offredao odao;
	private postulationDao pdao;
    

    public void init() throws ServletException {
        daofactory daoFactory = daofactory.getInstance();
        this.candidatDao = daoFactory.getcandidatDao();
        this.recDa = (recDao) daoFactory.getrecDao();
        this.odao=daoFactory.getoffredao();
        this.pdao=daoFactory.getpostulationDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();   
		request.setAttribute("candidats", candidatDao.lister());
		int idr=(int) session.getAttribute("idr");
		request.setAttribute("offres", odao.lister_offres(idr));
		request.setAttribute("postulations",pdao.listerpostulation_entreprise(idr));
        this.getServletContext().getRequestDispatcher("/WEB-INF/rec.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    
}

