package SERVLETS;

import java.io.IOException;

import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */

public class offreprecis extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
    private offredao odao;
    private recDao rdao;
    public void init() throws ServletException {
        daofactory daoFactory = daofactory.getInstance();
        this.odao =  daoFactory.getoffredao();
        this.rdao=(recDao) daoFactory.getrecDao();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//details offre dont le candidat a postulé
		daofactory daoFactory = daofactory.getInstance();
        this.odao=  daoFactory.getoffredao();
        this.rdao=(recDao) daoFactory.getrecDao();
		String s=request.getParameter("s");
		request.setAttribute("s", s);
		//recuperer id offre 
		int ido = Integer.parseInt(request.getParameter("ido"));
		
		//recuperer details offre
		request.setAttribute("offre",odao.un(ido));
		
		//recuper detail d'entreprise auquel l'offre appartient en donnant id_entreprise de l'offre id=ido à la fonction un du dao lié au recruteur.
		
		request.setAttribute("recruteur",rdao.un((odao.un(ido).getId_entreprise())));
		request.setAttribute("user", request.getParameter("user"));
		 this.getServletContext().getRequestDispatcher("/WEB-INF/offreprecis.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    
}
