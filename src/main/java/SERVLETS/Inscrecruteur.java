package SERVLETS;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.octest.beans.recruteur;

import dao.admdao;
import dao.candidatDao;
import dao.daofactory;
import dao.offredao;
import dao.postulationDao;
import dao.recDao;


public class Inscrecruteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private candidatDao objet;
	private recDao recDa;
	private offredao odao;
	private postulationDao pdao;
	private admdao adao;
	private recruteur r;
    

    public void init() throws ServletException {
        daofactory daoFactory = daofactory.getInstance();
        this.objet = daoFactory.getcandidatDao();
        this.recDa = (recDao) daoFactory.getrecDao();
        this.odao=daoFactory.getoffredao();
        this.pdao=daoFactory.getpostulationDao();
        this.adao=(admdao) daoFactory.getadmdao();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("Inscriptionrecruteur.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.r= new recruteur();
		r.setNom(request.getParameter("nom"));
        r.setDescription(request.getParameter("description"));
		r.setMail(request.getParameter("mail"));
        r.setAdresse(request.getParameter("adresse"));
		r.setPasswd(request.getParameter("passwd"));
		recDa.ajouter_rec(r);
		request.getRequestDispatcher("p1").forward( request, response );	}

}
