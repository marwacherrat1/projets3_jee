package SERVLETS;

import java.io.IOException;

import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */

public class trouveroffre extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
    private offredao odao;
    private recDao rdao;
    public void init() throws ServletException {
        daofactory daoFactory = daofactory.getInstance();
        this.odao =  daoFactory.getoffredao();
        this.rdao=(recDao) daoFactory.getrecDao();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//trouver l'offre choisis pour etre modifié pour qu'on puisse afficher ces infos afin de les modifier si on veut
		
		daofactory daoFactory = daofactory.getInstance();
        this.odao=  daoFactory.getoffredao();
        this.rdao=(recDao) daoFactory.getrecDao();
		String s=request.getParameter("s");
		request.setAttribute("s", s);
		int ido = Integer.parseInt(request.getParameter("ido"));
		request.setAttribute("offre", odao.un(ido));

        this.getServletContext().getRequestDispatcher("/WEB-INF/modifier_offre.jsp").forward(request, response);


	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    
}