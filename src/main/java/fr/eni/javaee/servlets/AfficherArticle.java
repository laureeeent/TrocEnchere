package fr.eni.javaee.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.bll.ArticleManager;
import fr.eni.javaee.bll.CategorieManager;
import fr.eni.javaee.bo.ArticleVendu;
import fr.eni.javaee.bo.Categorie;
import fr.eni.javaee.bo.Utilisateur;
import fr.eni.javaee.exceptions.BusinessException;

/**
 * Servlet implementation class AfficherArticle
 */
@WebServlet("/AfficherArticle")
public class AfficherArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_article = request.getParameter("id");
		String submit = request.getParameter("select_article");
		int numArt = Integer.parseInt(id_article);
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		


		if (!submit.equals("Voir l'enchère")) {
			session.setAttribute("utilisateur", user);
			request.setAttribute("param_pseudo", submit);
			RequestDispatcher rs = request.getRequestDispatcher("ServletAfficherCompte");
			rs.forward(request, response);
		} else {
			ArticleManager articleManager = new ArticleManager();
			List<ArticleVendu> liste_EnchereEC = articleManager.selectionnerByEtat("EC", 0);
			List<ArticleVendu> liste_EnchereCR = articleManager.selectionnerByEtat("CR", 0);
			List<ArticleVendu> liste_EnchereVD = articleManager.selectionnerByEtat("VD", 0);
			List<ArticleVendu> liste_EnchereRT = articleManager.selectionnerByEtat("RT", 0);
			
			List<ArticleVendu> listeTousLesArticles = new ArrayList<ArticleVendu>();
			listeTousLesArticles.addAll(liste_EnchereEC);
			listeTousLesArticles.addAll(liste_EnchereCR);
			listeTousLesArticles.addAll(liste_EnchereVD);
			listeTousLesArticles.addAll(liste_EnchereRT);
			
			
			request.setAttribute("listeArticles", listeTousLesArticles);
			RequestDispatcher rs = request.getRequestDispatcher("./WEB-INF/JSP/detailEnchere.jsp");
			session.setAttribute("utilisateur", user);

			ArticleVendu artById = null;
			try {
				artById = articleManager.selectionnerByID(numArt);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("articleById", artById);

			rs.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
