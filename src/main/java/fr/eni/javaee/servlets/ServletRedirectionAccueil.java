package fr.eni.javaee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
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
import fr.eni.javaee.bo.Utilisateur;

/**
 * Servlet implementation class ServletRedirectionAccueil
 */
@WebServlet("/ServletRedirectionAccueil")
public class ServletRedirectionAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		
		CategorieManager categorieManager = new CategorieManager();
		List<Categorie> listeCategories = categorieManager.selectionnerToutesLesCategories();
		request.setAttribute("listeCategories", listeCategories);

		ArticleManager articleManager = new ArticleManager();
		List<ArticleVendu> liste_EnchereEC = articleManager.selectionnerByEtat("EC", 0);
		request.setAttribute("listeArticles", liste_EnchereEC);
		
		List<ArticleVendu> listeEncheresFinies = articleManager.selectionnerByEtat("VD", 0);
		request.setAttribute("listeEncheresFinies", listeEncheresFinies);
		


		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/index.jsp");

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
