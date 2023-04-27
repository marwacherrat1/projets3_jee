package SERVLETS;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import com.octest.beans.offre;

import dao.daofactory;
import dao.offredao;

public class ajout_offre extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    private offredao od;
		private offre o;
		public int validation=0;
		public int ido;
	        


    public void init() throws ServletException {
	        daofactory daoFactory = daofactory.getInstance();
	        this.od = daoFactory.getoffredao();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		daofactory daoFactory = daofactory.getInstance();
        this.od = daoFactory.getoffredao();
        this.o=new offre();
        HttpSession session = request.getSession();   
        int validation =Integer.parseInt(request.getParameter("validation"));

		if (validation == 1)
		  { 
			int id=(int)session.getAttribute("idr");
            o.setTitre(request.getParameter("titre"));
    		o.setId_entreprise(id);
    		o.setCompetence(request.getParameter("competences"));
    		o.setDelai(request.getParameter("delai"));
    		o.setDescription(request.getParameter("description"));
    		o.setDateoffre(request.getParameter("date"));
    		//l'offre s'ajoute avec succès
        	od.ajouter(o);
        	request.getRequestDispatcher("recruteur").forward( request, response );
		  }
		
		 if(validation == 0)
    		{
			int ido = Integer.parseInt(request.getParameter("ido"));
			//offre choisis sera supprimé par l'administrateur
    		od.deletoffre(ido);
    		request.getRequestDispatcher("all").forward( request, response );
    		}
    		
    		
    		
    		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
