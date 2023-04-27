package SERVLETS;

import java.io.IOException;

import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class recherche extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
    private offredao odao;
    private recDao rdao;
	private postulationDao pdao;
    public void init() throws ServletException {
        daofactory daoFactory = daofactory.getInstance();
        this.odao =  daoFactory.getoffredao();
        this.rdao=(recDao) daoFactory.getrecDao();
        this.pdao=daoFactory.getpostulationDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		daofactory daoFactory = daofactory.getInstance();
        this.odao=  daoFactory.getoffredao();
        this.rdao=(recDao) daoFactory.getrecDao();
		String rech=request.getParameter("rech");
		String s="candidat";
		 HttpSession session = request.getSession();
    	 int i=(int)session.getAttribute("idc");
    	 request.setAttribute("postulations",pdao.listerpostulation_candidat(i));
		request.setAttribute("s", s);
		request.setAttribute("rech", rech);
		request.setAttribute("offres", odao.recherche_titre(rech,i));

        this.getServletContext().getRequestDispatcher("/WEB-INF/offresentreprise_recherche.jsp").forward(request, response);


	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    
}