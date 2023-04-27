package SERVLETS;

import java.io.IOException;
import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */

public class trouvercandidat extends jakarta.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;

	private candidatDao cdao;
    

    public void init() throws ServletException {
        daofactory daoFactory = daofactory.getInstance();

        this.cdao =  daoFactory.getcandidatDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//trouver candidat pour afficher a l'admin ces infos
		
		daofactory daoFactory = daofactory.getInstance();
        this.cdao =  daoFactory.getcandidatDao();
		int idc = Integer.parseInt(request.getParameter("idc"));
		request.setAttribute("candidat", cdao.un(idc));
		String s=request.getParameter("s");
		request.setAttribute("s", s);
        this.getServletContext().getRequestDispatcher("/WEB-INF/modifier_candidat.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    
}
