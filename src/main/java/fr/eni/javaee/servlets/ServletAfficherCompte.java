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
//import javax.servlet.http.HttpSession;
//
//import fr.eni.javaee.bll.UtilisateurManager;
//import fr.eni.javaee.bo.Utilisateur;
//import fr.eni.javaee.exceptions.BusinessException;
import fr.eni.javaee.exceptions.BusinessException;

/**
 * Servlet implementation class AfficherCompte
 */
@WebServlet("/ServletAfficherCompte")
public class ServletAfficherCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String pseudo = (String) request.getAttribute("param_pseudo");
		RequestDispatcher rs = null;

		
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		UtilisateurManager utilsateurManager = new UtilisateurManager();
		Utilisateur userAffichage = null;
		String param_pseudo = null;
		if (pseudo != null) {
	
		try {
			userAffichage = utilsateurManager.getUtilisateur(pseudo);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		param_pseudo = userAffichage.getPseudo();
		
		if (user != null) {
				if (user.getPseudo().equals(param_pseudo)) {
					request.setAttribute("param_pseudo",param_pseudo);
					rs = request.getRequestDispatcher("./WEB-INF/JSP/pageAffichagePseudo.jsp");
					rs.forward(request, response);
					System.out.println("c'est le meme gars normalement");
				}else {
					request.setAttribute("autre_profil", userAffichage);
					session.getAttribute("utilisateur");
					System.out.println("c'est PAS le meme gars normalement");
					rs = request.getRequestDispatcher("./WEB-INF/JSP/pageAffichagePseudo.jsp");
					rs.forward(request, response);
				}
				}
			}
		

//		try {
//			userAffichage = utilsateurManager.getUtilisateur( (String)request.getAttribute("utilisateurAffichage_nom") );
//			request.setAttribute("utilisateurAffichage", userAffichage);
//			
//		} catch (BusinessException e) {
//			for (int code : e.getCodeErreurs()) {
//				System.out.println(code);
//			}
//			e.printStackTrace();
//		}
		
//		RequestDispatcher rs = null;
//		HttpSession session = request.getSession();
//		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
//		String util = request.getParameter("pseudo");
//		System.out.println(util);
		
		if (user == null) {
			rs = request.getRequestDispatcher("/WEB-INF/JSP/erreurConnexionUtilisateur.jsp");
			rs.forward(request, response);
		}
		if (pseudo==null) {
		System.out.println("pas de pseudo donc meme gars afficher");
		request.setAttribute("pseudo", pseudo);
		rs = request.getRequestDispatcher("./WEB-INF/JSP/pageAffichagePseudo.jsp");
		rs.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
