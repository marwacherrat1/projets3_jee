package SERVLETS;

import java.io.IOException;

import com.octest.beans.recruteur;

import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */

public class AJOUTC extends jakarta.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    private candidatDao candidatDao;
	private recDao recDa;
	private recruteur rec;    

    public void init() throws ServletException {
        daofactory daoFactory = daofactory.getInstance();
        this.candidatDao = daoFactory.getcandidatDao();
        this.recDa = (recDao) daoFactory.getrecDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		daofactory daoFactory = daofactory.getInstance();
        this.recDa = (recDao) daoFactory.getrecDao();
        this.rec=new recruteur();
        	
        	rec.setNom(request.getParameter("nom"));
    		rec.setMail(request.getParameter("mail"));
    		rec.setAdresse(request.getParameter("addresse"));
    		rec.setPasswd(request.getParameter("passwd"));
    		rec.setDescription(request.getParameter("description"));
    		recDa.ajouter_rec(rec);
    		request.getRequestDispatcher("all").forward( request, response );
    		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    
}
