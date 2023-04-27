package SERVLETS;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.octest.beans.candidat;
import com.octest.beans.recruteur;

import dao.candidatDao;
import dao.daofactory;
import dao.recDao;

/**
 * Servlet implementation class ajouter_candidat
 */
public class ajouter_candidat extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    private candidatDao candidatda;  
	    private candidat c;    


	    public void init() throws ServletException {
	        daofactory daoFactory = daofactory.getInstance();
	        this.candidatda = daoFactory.getcandidatDao();
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		daofactory daoFactory = daofactory.getInstance();
        this.candidatda = daoFactory.getcandidatDao();
        this.c=new candidat();
        	
        	c.setNom(request.getParameter("nom"));
    		c.setMail(request.getParameter("mail"));
    		c.setAge(Integer.parseInt(request.getParameter("age")));
    		c.setPrenom(request.getParameter("prenom"));
    		c.setTel(request.getParameter("tel"));
    		c.setMail(request.getParameter("Email"));
    		c.setLangues(request.getParameter("Langues"));
    		c.setPaswd(request.getParameter("paswd"));
    		c.setProjets(request.getParameter("projets"));
    		c.setDiplomes(request.getParameter("diplomes"));
    		c.setCompetences(request.getParameter("competences"));
    		candidatda.ajouter(c);
    		request.getRequestDispatcher("all").forward( request, response );
    		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
