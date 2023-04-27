package SERVLETS;
import dao.offredao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.octest.beans.recruteur;

import dao.candidatDao;
import dao.daofactory;
import dao.offredao;
import dao.postulationDao;
import dao.recDao;
import com.octest.beans.candidat;
import com.octest.beans.offre;
import com.octest.beans.candidat;
public class Loginc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    private daofactory daoFactory ;
	private recDao recd;
	private candidat c;
	private candidatDao cdo;
	private offredao odao;
	private postulationDao pdao;
   
    
    public void init() throws ServletException 
    {
    	this.daoFactory = daofactory.getInstance();
    	this.recd= (recDao) daoFactory.getrecDao();
    	
         this.cdo = daoFactory.getcandidatDao();
         
         this.odao=daoFactory.getoffredao();
         this.pdao=daoFactory.getpostulationDao();

    }
	
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("loginc.jsp");	
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		this.c= new candidat();
		boolean flag=cdo.Check_login_ass(email, password);
		
		if(flag) {
				
				
			     c =cdo.getcandidatByEmail(email);
				
				 HttpSession session = request.getSession();             
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
	             
//recuperer postulations que le candidat a fait
	             
	         	request.setAttribute("postulations",pdao.listerpostulation_candidat(c.getIdc()));
	         	
//recuperer tous les offres que le candidat n'a pas postuler à
	         	
	    		request.setAttribute("offres", odao.lister_offresnonpostulé(c.getIdc()));
	     		request.getRequestDispatcher("/WEB-INF/candidatprecis.jsp").forward(request, response);
	     		

			}
			else {
//sinon on va rester sur la page de login en affichant un msg d'erreur 
				request.setAttribute("message","email ou mot de passe est incorrecte");
				request.getRequestDispatcher("/loginc.jsp").forward(request, response);
			}
			


		}
	}

