package fr.eni.javaee.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.bll.ArticleManager;
import fr.eni.javaee.bll.CategorieManager;
import fr.eni.javaee.bo.Utilisateur;
import fr.eni.javaee.exceptions.BusinessException;

/**
 * Servlet implementation class ServletFiltreAcceuil
 */
@WebServlet("/ServletFiltreAcceuil")
public class ServletFiltreAcceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String categorie = request.getParameter("categorie");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/index.jsp");
		
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		if (user == null) {
			rd = request.getRequestDispatcher("/WEB-INF/JSP/erreurConnexionUtilisateur.jsp");
			rd.forward(request, response);
		}
		else {
			ArticleManager articleManager = new ArticleManager();
			CategorieManager categorieManager = new CategorieManager();
			
			String choixEnchere = request.getParameter("choix");
			
			
			if (choixEnchere.equals("achats")) {
				String filtreEC = (request.getParameter("EC") );
				String filtreUserEnchereEC = request.getParameter("mes_encheres");
				String filtreUserEnchereRemportee = request.getParameter("mes_encheres_remportees");
				System.out.println("EC:"+filtreEC+", mesEncheres:"+filtreUserEnchereEC+", mesEncheresRemportees"+filtreUserEnchereRemportee);
				try {
					if (filtreEC != null ) {
						
						request.setAttribute("listeArticlesEC", articleManager.selectionnerByEtat("EC"));
						
					}
					if (filtreUserEnchereEC != null ) {
						request.setAttribute("listeArticlesEnchereUser", articleManager.selectionnerEnchereUser(user, "EC"));
					}
					if (filtreUserEnchereRemportee != null) {
						request.setAttribute("listeArticlesEnchereUserRemportee", articleManager.selectionnerEnchereUser(user, "remportee"));
						System.out.println( articleManager.selectionnerEnchereUser(user, "remportee") );
					}
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("listeCategories", categorieManager.selectionnerToutesLesCategories());
				rd.forward(request, response);
			}
			
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
