package SERVLETS;

import java.io.IOException;
import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class all extends jakarta.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    private candidatDao candidatDao;
	private recDao recDa;
	private offredao odao;
	private postulationDao pdao;
	private admdao adao;
    

    public void init() throws ServletException {
        daofactory daoFactory = daofactory.getInstance();
        this.candidatDao = daoFactory.getcandidatDao();
        this.recDa = (recDao) daoFactory.getrecDao();
        this.odao=daoFactory.getoffredao();
        this.pdao=daoFactory.getpostulationDao();
        this.adao=(admdao) daoFactory.getadmdao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperer tous les candidats,recruteurs,les offres ,et les postulations.
		
		request.setAttribute("candidats", candidatDao.lister());
		request.setAttribute("recruteurs", recDa.lister_rec());
		request.setAttribute("offres", odao.lister());
		request.setAttribute("postulations",pdao.listerpostulation());
        this.getServletContext().getRequestDispatcher("/WEB-INF/page_admin.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    
}
