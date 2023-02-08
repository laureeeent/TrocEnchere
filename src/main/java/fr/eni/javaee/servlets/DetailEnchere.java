package fr.eni.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.bll.EnchereManager;
import fr.eni.javaee.bo.Utilisateur;
import fr.eni.javaee.exceptions.BusinessException;

@WebServlet("/DetailEnchere")
public class DetailEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DetailEnchere() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/JSP/detailEnchere.jsp");
		rs.forward(request, response);
	}

	/*
	 * traitement que doit faire la servlet: - insert dans la table ENCHERE
	 * (récupérer no_utilisateur, no_article, date du submit, montant_enchere) -
	 * update la table ARTICLES_VENDUS (prix_vente) - update la table UTILISATEURS
	 * (credit en moins pour l'encherisseur, credit en plus pour l'ancien
	 * encherisseur)
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		EnchereManager enchereManager = new EnchereManager();
		
		if (user != null) {
			
			int noArticle = Integer.parseInt(request.getParameter("noArticle"));
			int ancienPrix = Integer.parseInt(request.getParameter("meilleure_offre"));
			int enchereEnCours = Integer.parseInt(request.getParameter("enchereEnCours"));
			int noAncienEncherisseur = Integer.parseInt(request.getParameter("no_ancien_encherisseur"));

			List<String> listeMessagesErreur = new ArrayList<>();

			// contrôler si l'enchérisseur a suffisamment de crédit
			if (user.getCredit() < enchereEnCours) {
				listeMessagesErreur.add(MessagesErreurServlets.ERREUR_CREDIT_INSUFFISANT);
			}

			if (listeMessagesErreur.size() > 0) {
				request.setAttribute("listeMessagesErreur", listeMessagesErreur);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/detailEnchere.jsp"); // TODO afficher la
																										// liste erreur sur
																										// la JSP
				rd.forward(request, response);
			} else {
				try {
					if (noAncienEncherisseur == 0) {
						enchereManager.ajouterEnchere(noArticle, enchereEnCours, user);
					} else {
						enchereManager.ajouterEnchere(noArticle, enchereEnCours, user, noAncienEncherisseur, ancienPrix);
					}
				} catch (BusinessException e) {
					for (int code : e.getCodeErreurs()) {
						System.out.println("code erreur : " + code);
					}
					e.printStackTrace();
				}

			}
			RequestDispatcher rd = request.getRequestDispatcher("ServletRedirectionAccueil");
			rd.forward(request, response);
		}
		// L'utilisateur n'est pas connecté quand il tente d'accèder à l'enchère
		else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/erreurConnexionUtilisateur.jsp");
			rd.forward(request, response);
		}
	}
}
