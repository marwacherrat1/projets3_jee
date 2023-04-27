package SERVLETS;

import java.io.IOException;

import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */

public class supprimeroffre extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
    private offredao odao;
    private recDao rdao;
    
    public void init() throws ServletException {
    	
        daofactory daoFactory = daofactory.getInstance();
        this.odao =  daoFactory.getoffredao();
        this.rdao=(recDao) daoFactory.getrecDao();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		daofactory daoFactory = daofactory.getInstance();
        this.odao=  daoFactory.getoffredao();
        this.rdao=(recDao) daoFactory.getrecDao();

		int ido = Integer.parseInt(request.getParameter("ido"));
		//supprimer offre choisis
		odao.deletoffre(ido);
		
		request.getRequestDispatcher("recruteur").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    
}