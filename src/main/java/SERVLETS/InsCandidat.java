package SERVLETS;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.octest.beans.candidat;

import dao.admdao;
import dao.candidatDao;
import dao.daofactory;
import dao.offredao;
import dao.postulationDao;
import dao.recDao;

/**
 * Servlet implementation class InsCandidat
 */
public class InsCandidat extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private candidatDao objet;
	private recDao recDa;
	private offredao odao;
	private postulationDao pdao;
	private admdao adao;
	private candidat c;
    

    public void init() throws ServletException {
        daofactory daoFactory = daofactory.getInstance();
        this.objet = daoFactory.getcandidatDao();
        this.recDa = (recDao) daoFactory.getrecDao();
        this.odao=daoFactory.getoffredao();
        this.pdao=daoFactory.getpostulationDao();
        this.adao=(admdao) daoFactory.getadmdao();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("ACC.jsp");	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.c= new candidat();
		c.setNom(request.getParameter("nom"));
		c.setPrenom(request.getParameter("prenom"));
		c.setMail(request.getParameter("mail"));
		c.setTel(request.getParameter("tel"));
		c.setCompetences(request.getParameter("competences"));
		c.setProjets(request.getParameter("projets"));
		c.setDiplomes(request.getParameter("diplomes"));
		c.setLangues(request.getParameter("langues"));
		c.setAge(Integer.parseInt(request.getParameter("age")));
		c.setPaswd(request.getParameter("pswd"));
		objet.ajouter(c);
		request.getRequestDispatcher("p1").forward( request, response );	}
	}