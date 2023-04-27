package SERVLETS;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.octest.beans.administrateu;

import dao.candidatDao;
import dao.daofactory;
import dao.offredao;
import dao.postulationDao;
import dao.recDao;
import dao.admdao;
import dao.admdaoimpl;

public class Logina extends HttpServlet {
private static final long serialVersionUID = 1L;
       
	
    private daofactory daoFactory ;
	private recDao recd;
	private candidat c;
	private candidatDao cdo;
	private offredao odao;
	private postulationDao pdao;
	private administrateu a;
	private admdao adao;
   
    
    public void init() throws ServletException 
    {
    	this.daoFactory = daofactory.getInstance();
    	this.recd= (recDao) daoFactory.getrecDao();
    	this.adao=daoFactory.getadmdao();
         this.cdo = daoFactory.getcandidatDao();
         this.odao=daoFactory.getoffredao();
         this.pdao=daoFactory.getpostulationDao();

    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("logina.jsp");;
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email=request.getParameter("email");
		String password=request.getParameter("password");
		this.a= new administrateu();
		boolean flag=adao.Check_login_ass(email, password);
		
		if(flag) {
				
				
			    a =adao.getadministrateurByEmail(email);
				
				 HttpSession session = request.getSession();             
				 
	             session.setAttribute("ida",a.getId()); 
	             session.setAttribute("nom", a.getNom());
	             session.setAttribute("prenom",a.getPrenom());
	             session.setAttribute("mail",a.getMail());
	             session.setAttribute("passwd",a.getPasswd());
	             session.setAttribute("tel",a.getTel());     


	     		request.getRequestDispatcher("all").forward(request, response);

			}
			else {
			//si l'email ou mot de passe est incorrecte	
				request.setAttribute("message","email ou mot de passe est incorrecte");
				request.getRequestDispatcher("/logina.jsp").forward(request, response);
			}
			


		}
	
}