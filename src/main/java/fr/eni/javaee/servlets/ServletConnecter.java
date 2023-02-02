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
import fr.eni.javaee.exceptions.BusinessException;

/**
 * Servlet implementation class ServletConnecter
 */
@WebServlet("/ServletConnecter")
public class ServletConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/JSP/login.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rep_Identifiant = request.getParameter("identifiant");
		String rep_Mdp = request.getParameter("mot_de_passe");
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur user = null;
		try {
			user = utilisateurManager.getUtilisateur(rep_Identifiant);
		} catch (BusinessException e) {
			for (int code : e.getCodeErreurs()) {
				System.out.println(code);
			}
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		RequestDispatcher rs = null;
		
		
		if( user == null ) {
			rs = request.getRequestDispatcher("./WEB-INF/JSP/login.jsp");
			request.setAttribute("messageErreur", "Identifiant inconnu");
		}
		
		else if(utilisateurManager.isPwdCorrect(user, rep_Mdp) ) {
			rs = request.getRequestDispatcher("ServletRedirectionAccueil");
			session.setAttribute("utilisateur", user);
			request.setAttribute("messageErreur", "Vous êtes connecté");
		}
		
		else {
			rs = request.getRequestDispatcher("./WEB-INF/JSP/login.jsp");
			request.setAttribute("messageErreur", "mot de passe incorrect.");
		}
		
		rs.forward(request, response);
	}

}
