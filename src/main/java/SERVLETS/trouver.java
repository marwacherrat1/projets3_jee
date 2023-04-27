package SERVLETS;

import java.io.IOException;
import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */

public class trouver extends jakarta.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;

	private recDao recDa;
    

    public void init() throws ServletException {
        daofactory daoFactory = daofactory.getInstance();

        this.recDa = (recDao) daoFactory.getrecDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//pour modifier les infos du recruteur on aurra besoin de voir ces informations et les afficher a l'admin
		daofactory daoFactory = daofactory.getInstance();
        this.recDa = (recDao) daoFactory.getrecDao();
		int idr = Integer.parseInt(request.getParameter("idr"));
		String s=request.getParameter("s");
		request.setAttribute("s", s);
		//recuperer infos recruteur à modifier
		
		request.setAttribute("recruteur", recDa.un(idr));
		request.setAttribute("page","administrateur");
        this.getServletContext().getRequestDispatcher("/WEB-INF/modifier_recruteur.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    
}
