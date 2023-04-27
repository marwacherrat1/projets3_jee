package SERVLETS;

import java.io.IOException;

import com.octest.beans.candidat;
import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Test
 */

public class modifsoncomptecandid extends jakarta.servlet.http.HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private daofactory daoFactory ;
	private recDao recd;
	private candidat c;
	private candidatDao candidatda;
	private offredao odao;
	private postulationDao pdao;
   
    
    public void init() throws ServletException 
    {
    	this.daoFactory = daofactory.getInstance();
    	this.recd= (recDao) daoFactory.getrecDao();
    	
         this.candidatda = daoFactory.getcandidatDao();
         
         this.odao=daoFactory.getoffredao();
         this.pdao=daoFactory.getpostulationDao();

    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		daofactory daoFactory = daofactory.getInstance();
        this.candidatda = daoFactory.getcandidatDao();
        this.c=new candidat();
//recuperation des informations du candidat a partir du formulaire
        
     	c.setIdc(Integer.parseInt(request.getParameter("idc")));
     	c.setNom(request.getParameter("nom"));
 		c.setMail(request.getParameter("mail"));
 		c.setAge(Integer.parseInt(request.getParameter("age")));
 		c.setPrenom(request.getParameter("prenom"));
 		c.setTel(request.getParameter("tel"));
 		c.setLangues(request.getParameter("langues"));
 		c.setPaswd(request.getParameter("paswd"));
 		c.setProjets(request.getParameter("projets"));
 		c.setDiplomes(request.getParameter("diplomes"));
 		c.setCompetences(request.getParameter("competences"));
        candidatda.modifier_candidat(c);
        HttpSession session = request.getSession();             
// mis à jour de la session pour quel les modifications s'affiche lors de la session
        
        session.setAttribute("idc",c.getIdc()); 
        session.setAttribute("nom", c.getNom());
        session.setAttribute("prenom",c.getPrenom());
        session.setAttribute("mail",c.getMail());
        session.setAttribute("competences",c.getCompetences());
        session.setAttribute("diplomes",c.getDiplomes());
        session.setAttribute("langues",c.getLangues());
        session.setAttribute("paswd",c.getPaswd());
        session.setAttribute("projets",c.getProjets());
        session.setAttribute("tel",c.getTel());
        session.setAttribute("age",c.getAge());     
        
//recupperation des postulation du candidat connecté
        
    	request.setAttribute("postulations",pdao.listerpostulation_candidat(c.getIdc()));
    	
//recuperation des offres dont le candidat n'a pas postuler
    	
		request.setAttribute("offres", odao.lister_offresnonpostulé(c.getIdc()));
//envoyez tous ces infos  au jsp pour les afficher
		
		request.getRequestDispatcher("/WEB-INF/candidatprecis.jsp").forward(request, response);
		

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
    
}