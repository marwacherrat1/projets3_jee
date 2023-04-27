package SERVLETS;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.octest.beans.offre;
import com.octest.beans.postulation;

import dao.daofactory;
import dao.offredao;
import dao.postulationDao;
public class postulerservlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;

	    private postulationDao pd;
		private postulation p;


	    public void init() throws ServletException {
	        daofactory daoFactory = daofactory.getInstance();
	        
	        this.pd=daoFactory.getpostulationDao();
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	daofactory daoFactory = daofactory.getInstance();
    this.pd=daoFactory.getpostulationDao();
    this.p=new postulation();
    HttpSession session = request.getSession();   
    int id=(int)session.getAttribute("idc");
    p.setId_postulant(id);
    p.setId_offre(Integer.parseInt(request.getParameter("ido")));
    p.setLettremotivation(request.getParameter("motivation"));
 	pd.ajouter(p);
 	//a travers cette fonction on ajoute une postulation du candidat d'id =idc à l'offre d'id= ido et de lettre de motivation "motivation"  	
    request.getRequestDispatcher("candidat").forward( request, response );
    //on revient au menu(profil candidat)
		  
 	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
