package fr.eni.javaee.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.bll.ArticleManager;
import fr.eni.javaee.bll.EnchereManager;
import fr.eni.javaee.bll.UtilisateurManager;
import fr.eni.javaee.bo.ArticleVendu;
import fr.eni.javaee.bo.Enchere;
import fr.eni.javaee.bo.Utilisateur;
import fr.eni.javaee.exceptions.BusinessException;


@WebServlet("/DetailEnchere")
public class DetailEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DetailEnchere() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/JSP/detailEnchere.jsp");
		rs.forward(request, response);
	}

	/*traitement que doit faire la servlet:
	 * 	- insert dans la table ENCHERE (récupérer no_utilisateur, no_article, date du submit, montant_enchere)
	 * 	- update la table ARTICLES_VENDUS (prix_vente)
	 * 	- update la table UTILISATEURS (credit en moins pour l'encherisseur, credit en plus pour l'ancien encherisseur)
	 * 
	 * */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		
		
		LocalDateTime dateEnchere=LocalDateTime.now();
		int noArticle;
		int ancienPrix;
		int enchereEnCours;
		int noAncienEncherisseur;
		String vendeur;
		
		List<String> listeMessagesErreur = new ArrayList<>();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		ArticleManager articleManager = new ArticleManager();
		EnchereManager enchereManager = new EnchereManager();
		
		noArticle = Integer.parseInt(request.getParameter("noArticle"));
		enchereEnCours= Integer.parseInt(request.getParameter("enchereEnCours"));
		noAncienEncherisseur=Integer.parseInt(request.getParameter("no_ancien_encherisseur"));
		vendeur= request.getParameter("vendeur");
		ancienPrix=Integer.parseInt(request.getParameter("meilleure_offre"));
		
		//contrôler si l'enchérisseur a suffisamment de crédit
		if(user.getCredit() < enchereEnCours) {
			listeMessagesErreur.add(MessagesErreurServlets.ERREUR_CREDIT_INSUFFISANT);
		}
		
		if (listeMessagesErreur.size() > 0) {
			request.setAttribute("listeMessagesErreur", listeMessagesErreur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/detailEnchere.jsp"); //TODO afficher la liste erreur sur la JSP
			rd.forward(request, response);
		}
		
		else {
			Enchere enchere = new Enchere(user.getNoUtilisateur(),noArticle,dateEnchere,enchereEnCours);
			enchereManager.ajouterEnchere(enchere);
			ArticleVendu article = null;
			
			try {
				article = articleManager.selectionnerByID(noArticle);
				articleManager.modifierPrixArticle(article);
				Utilisateur ancienUtilisateur = null;
				ancienUtilisateur = utilisateurManager.selectionnerUtilisateurParID(noAncienEncherisseur);
				user.setCredit((user.getCredit() - enchereEnCours));
				ancienUtilisateur.setCredit((ancienUtilisateur.getCredit()+ancienPrix));
			
				utilisateurManager.modifierCreditUtilisateur(user);
				utilisateurManager.modifierCreditUtilisateur(ancienUtilisateur);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("ServletRedirectionAccueil");
			rd.forward(request, response);
	}
		
	}
}
