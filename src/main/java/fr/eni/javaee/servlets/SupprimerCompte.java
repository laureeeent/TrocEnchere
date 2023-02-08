package fr.eni.javaee.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.bll.UtilisateurManager;
import fr.eni.javaee.bo.Utilisateur;
import fr.eni.javaee.dal.UtilisateurDAO;
import fr.eni.javaee.dal.UtilisateurDAOJdbcImpl;

/**
 * Servlet implementation class SupprimerCompte
 */
@WebServlet("/SupprimerCompte")
public class SupprimerCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		String submit=null;
		String submitDelete="Supprimer mon compte";
		request.setCharacterEncoding("UTF-8");
		submit=request.getParameter("submit");
		if (submit.equals(submitDelete)) {
			Utilisateur usernull = null;
			user = utilisateurManager.supprimerUtilisateur(user);
			usernull = user;
			if (usernull == null) {
				session.setAttribute("utilisateur", usernull);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/redirectionCompteSupprimer.jsp");
				rd.forward(request, response);
			} else {
				session.setAttribute("utilisateur", usernull);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/redirectionCompteNonSupprimer.jsp");
				rd.forward(request, response);
			}
			
			
			
	}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
