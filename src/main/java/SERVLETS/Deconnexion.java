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

/**
 * Servlet implementation class login_Association
 */
public class Deconnexion extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
    public Deconnexion() {
        super();

    }
    


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		HttpSession session=request.getSession();
		session.invalidate();//destruction de la session
		request.getRequestDispatcher("p1").forward( request, response ); //retour à la premiere page via la servlet p1
		
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	doGet(request, response);
	
	}

}


