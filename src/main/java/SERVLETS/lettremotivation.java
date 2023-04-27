package SERVLETS;

import java.io.IOException;

import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */

public class lettremotivation extends jakarta.servlet.http.HttpServlet {
	
	private static final long serialVersionUID = 1L;
	



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
       // cette servlet pour afficher la lettre de motivation que le candidat à saisi lors de postulation à un offre .
		
		String lettremotivation = request.getParameter("lettremotivation");
		request.setAttribute("lettremotivation",lettremotivation);
		String user=request.getParameter("user");
		String s=request.getParameter("s");
		request.setAttribute("s", s);
		request.setAttribute("user",user);
		
		 this.getServletContext().getRequestDispatcher("/WEB-INF/lmotivation.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    
}
