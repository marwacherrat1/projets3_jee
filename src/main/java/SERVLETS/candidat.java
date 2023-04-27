package SERVLETS;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.candidatDao;
import dao.daofactory;
import dao.offredao;
import dao.postulationDao;
import dao.recDao;

public class candidat extends HttpServlet {
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
		// TODO Auto-generated method stub
    	 HttpSession session = request.getSession();
    	 int i=(int)session.getAttribute("idc");
    	 request.setAttribute("postulations",pdao.listerpostulation_candidat(i));

 		request.setAttribute("offres", odao.lister_offresnonpostulé(i));

		request.getRequestDispatcher("/WEB-INF/candidatprecis.jsp").forward( request, response );	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}