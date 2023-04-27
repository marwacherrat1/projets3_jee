package SERVLETS;

import jakarta.servlet.ServletException;  
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import dao.candidatDao;
import dao.daofactory;
import dao.offredao;
import dao.postulationDao;
import dao.recDao;
import com.octest.beans.recruteur;

public class Login extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
    

	
    private daofactory daoFactory ;
	private recDao recd;
	private recruteur rec;
	private candidatDao candidatDao;
	private offredao odao;



	private postulationDao pdao;
    public Login() {
        super();
        
    }
    
    
    public void init() throws ServletException 
    {
    	this.daoFactory = daofactory.getInstance();
    	this.recd= (recDao) daoFactory.getrecDao();
        this.candidatDao = daoFactory.getcandidatDao();
        this.odao=daoFactory.getoffredao();
        this.pdao=daoFactory.getpostulationDao();

    }
	
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		response.sendRedirect("login.jsp");	
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//1) lire les donnés saisie
		PrintWriter out = response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		rec=new recruteur();
		
		boolean flag=recd.Check_login_ass(email, password);
		if(flag) {
			
			
		     rec = recd.getrecruteurByEmail(email);
			 HttpSession session = request.getSession();             
             session.setAttribute("idr", rec.getIdr()); 
             session.setAttribute("nom", rec.getNom());
             session.setAttribute("adresse", rec.getAdresse());
             session.setAttribute("description", rec.getDescription());
             session.setAttribute("mail", rec.getMail());
             session.setAttribute("passwd",rec.getPasswd());
             
     		request.setAttribute("candidats", candidatDao.lister());
    	    int id=(int)session.getAttribute("idr");
    		request.setAttribute("offres", odao.lister_offres(id));
    		// lister les postulations d'une entreprise précis
    		
    		request.setAttribute("postulations",pdao.listerpostulation_entreprise(id));
     		request.getRequestDispatcher("/WEB-INF/rec.jsp").forward(request, response);

		}
		else {
			//affichage d'erreur si mot de passe ou e-mail est incorrecte
			
			request.setAttribute("message","email ou mot de passe est incorrecte");
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		}
		


}

}



