package SERVLETS;

import java.io.IOException;

import com.octest.beans.recruteur;

import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Test
 */

public class modifier_recruteurrecruteur extends jakarta.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    private recDao recDa;
	private recruteur rec;    

    public void init() throws ServletException {
        daofactory daoFactory = daofactory.getInstance();
        daoFactory.getcandidatDao();
        this.recDa = (recDao) daoFactory.getrecDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    daofactory daoFactory = daofactory.getInstance();
            this.recDa = (recDao) daoFactory.getrecDao();
            this.rec=new recruteur();
	       
            HttpSession session = request.getSession();             

            rec.setIdr(Integer.parseInt(request.getParameter("idr")));
        	rec.setNom(request.getParameter("nom"));
    		rec.setMail(request.getParameter("mail"));
    		rec.setAdresse(request.getParameter("addresse"));
    		rec.setPasswd(request.getParameter("passwd"));
    		rec.setDescription(request.getParameter("description"));
    		
    		//mis à jour de la session pour qu'on visualise les modifications lors de la session.
            
    		session.setAttribute("idr", rec.getIdr()); 
            session.setAttribute("nom", rec.getNom());
            session.setAttribute("adresse", rec.getAdresse());
            session.setAttribute("description", rec.getDescription());
            session.setAttribute("mail", rec.getMail());
            session.setAttribute("passwd",rec.getPasswd());

    		recDa.modifier_rec(rec);
    		
        	request.getRequestDispatcher("recruteur").forward( request, response );

    		
    		
    		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    
}
