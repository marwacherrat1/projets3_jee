package SERVLETS;

import java.io.IOException;

import com.octest.beans.offre;
import com.octest.beans.recruteur;

import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Test
 */

public class modifieroffre extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
    private offredao odao;
    private recDao rdao;
    private offre offr;
    public void init() throws ServletException {
        daofactory daoFactory = daofactory.getInstance();
        this.odao =  daoFactory.getoffredao();
        this.rdao=(recDao) daoFactory.getrecDao();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperation des informations offre et modification à l'aide de fct modifier_offre
		
		daofactory daoFactory = daofactory.getInstance();
        this.odao=  daoFactory.getoffredao();
        this.rdao=(recDao) daoFactory.getrecDao();
        HttpSession session = request.getSession();   
        int idr=(int)session.getAttribute("idr");
		int ido = Integer.parseInt(request.getParameter("idoffre"));
		this.offr=new offre();
		offr.setCompetence(request.getParameter("competence"));
		offr.setDateoffre(request.getParameter("dateoffre"));
		offr.setDelai(request.getParameter("delai"));
		offr.setDescription(request.getParameter("description"));
		offr.setId_entreprise(idr);
		offr.setIdoffre(ido);
		offr.setTitre(request.getParameter("titre"));
        odao.modifier_offre(offr);
		
		request.getRequestDispatcher("recruteur").forward( request, response );
		


	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    
}