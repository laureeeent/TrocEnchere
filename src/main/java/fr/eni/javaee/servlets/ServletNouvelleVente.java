package fr.eni.javaee.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.bll.ArticleManager;
import fr.eni.javaee.bll.CategorieManager;
import fr.eni.javaee.bo.ArticleVendu;
import fr.eni.javaee.bo.Categorie;
import fr.eni.javaee.bo.Enchere;
import fr.eni.javaee.bo.Retrait;
import fr.eni.javaee.bo.Utilisateur;
import fr.eni.javaee.exceptions.BusinessException;

/**
 * Servlet implementation class ServletNouvelleVente
 */
@WebServlet("/ServletNouvelleVente")
public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rs = null;
		
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		
		
		if (user == null) {
			request.setAttribute("messageErreur", "Vous êtes déconnecté, veuillez vous reconnecter pour proposer un nouvelle vente");
			rs = request.getRequestDispatcher("/WEB-INF/JSP/erreurConnexionUtilisateur.jsp");
			rs.forward(request, response);
			
		}
		
		rs = request.getRequestDispatcher("/WEB-INF/JSP/nouvelleVente.jsp");
		CategorieManager categorieManager = new CategorieManager();
		request.setAttribute("listeCategories", categorieManager.selectionnerToutesLesCategories());
		
		
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rs = null;
		
		if ( request.getParameter("boutton_form").equals("annuler")) {
			rs = request.getRequestDispatcher("ServletRedirectionAccueil");
			rs.forward(request, response);
		}
		
		else if (request.getParameter("boutton_form").equals("enregistrer")) {
			HttpSession session = request.getSession();
			Utilisateur vendeur = (Utilisateur) session.getAttribute("utilisateur");
			
			if (vendeur == null) {
				request.setAttribute("messageErreur", "Vous êtes déconnecté, veuillez vous reconnecter pour proposer un nouvelle vente");
				rs = request.getRequestDispatcher("/WEB-INF/JSP/erreurConnexionUtilisateur.jsp");
				rs.forward(request, response);
			}
			
			
			CategorieManager categorieManager = new CategorieManager();
			ArticleManager articleManager = new ArticleManager();
			
			String nom_article = request.getParameter("input_article");
			String description = request.getParameter("input_description");
			String categorie = request.getParameter("input_categorie");
//			String image = request.getParameter("input_photo");
			int miseAPrix = Integer.parseInt(request.getParameter("input_mise_a_prix"));
			
			LocalDateTime dateDebutEnchere = LocalDateTime.parse(request.getParameter("input_date_debut_enchere"));
			LocalDateTime dateFinEnchere = LocalDateTime.parse(request.getParameter("input_date_fin_enchere"));
			
			System.out.println(dateDebutEnchere);
			
			String retraitRue = request.getParameter("input_rue");
			String codePostal = request.getParameter("input_code_postal");
			String ville = request.getParameter("input_ville");
			
			Retrait retrait = new Retrait(retraitRue, codePostal, ville);
			
			
			
			try {
				Categorie categorieArt = categorieManager.selectionnerParLibelle(categorie);
				ArticleVendu artAVendre = new ArticleVendu(nom_article, description, dateDebutEnchere, dateFinEnchere, miseAPrix, 0, "EC", vendeur, new ArrayList<Enchere>(), categorieArt, retrait);
				articleManager.ajouterArticle(artAVendre);
				if (artAVendre.getNoArticle() != 0 ) {
					request.setAttribute("messageVente", "L'article a bien été enregistré !");
				}
				else {
					request.setAttribute("messageVente", "Erreur lors de l'enregistrement");
				}
			} catch (BusinessException e) {
				for (int code : e.getCodeErreurs()) {
					System.out.println(code);
				}
				e.printStackTrace();
			}
			request.setAttribute("listeCategories", categorieManager.selectionnerToutesLesCategories());
			
			rs = request.getRequestDispatcher("/WEB-INF/JSP/nouvelleVente.jsp");
			rs.forward(request, response);
		}
		
		else if (request.getParameter("boutton_form").equals("annuler_vente")) {
			HttpSession session = request.getSession();
			Utilisateur vendeur = (Utilisateur) session.getAttribute("utilisateur");
			
			if (vendeur == null) {
				request.setAttribute("messageErreur", "Vous êtes déconnecté, veuillez vous reconnecter pour proposer un nouvelle vente");
				rs = request.getRequestDispatcher("/WEB-INF/JSP/erreurConnexionUtilisateur.jsp");
				rs.forward(request, response);
			}
			
			CategorieManager categorieManager = new CategorieManager();
			
			rs = request.getRequestDispatcher("/WEB-INF/JSP/nouvelleVente.jsp");
			request.setAttribute("listeCategories", categorieManager.selectionnerToutesLesCategories());
			rs.forward(request, response);
		}

		

		
		
		
		

	}

}
