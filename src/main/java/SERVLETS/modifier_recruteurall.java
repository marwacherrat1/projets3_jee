package SERVLETS;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.octest.beans.recruteur;

import dao.daofactory;
import dao.recDao;

/**
 * Servlet implementation class modifier_recruteuradm
 */
public class modifier_recruteurall extends HttpServlet {
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
             
            
            rec.setIdr(Integer.parseInt(request.getParameter("idr")));
        	rec.setNom(request.getParameter("nom"));
    		rec.setMail(request.getParameter("mail"));
    		rec.setAdresse(request.getParameter("addresse"));
    		rec.setPasswd(request.getParameter("passwd"));
    		rec.setDescription(request.getParameter("description"));
    		 
    		recDa.modifier_rec(rec);
    		
        	request.getRequestDispatcher("all").forward( request, response );

    		
    		
    		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    
}