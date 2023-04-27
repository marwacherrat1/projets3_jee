package SERVLETS;

import java.io.IOException;

import com.octest.beans.candidat;
import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */

public class modifier_candidat extends jakarta.servlet.http.HttpServlet {
	 private static final long serialVersionUID = 1L;
	 private candidat c;
	private candidatDao candidatda;    


	    public void init() throws ServletException {
	        daofactory daoFactory = daofactory.getInstance();
	        this.candidatda = daoFactory.getcandidatDao();
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		daofactory daoFactory = daofactory.getInstance();
     this.candidatda = daoFactory.getcandidatDao();
     this.c=new candidat();
     String s=request.getParameter("s");
     	c.setIdc(Integer.parseInt(request.getParameter("idc")));
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
        candidatda.modifier_candidat(c);
    	request.getRequestDispatcher("all").forward( request, response );
    		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    
}
