package fr.eni.javaee.servlets;

import java.io.IOException;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

<<<<<<< HEAD
		int numArt =  Integer.parseInt(request.getParameter("id"));
		System.out.println("numart = "+numArt);
=======
		String id_article = request.getParameter("id");
		int numArt =  Integer.parseInt(id_article);
		System.out.println("num: "+ numArt);

>>>>>>> branch 'main' of https://github.com/laureeeent/TrocEnchere.git
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");;
		if (user != null){
			RequestDispatcher rs = request.getRequestDispatcher("./WEB-INF/JSP/detailEnchere.jsp");		
			
			ArticleManager articleManager = new ArticleManager();
			ArticleVendu artById = null;
			try {
				artById = articleManager.selectionnerByID(numArt);
<<<<<<< HEAD
				System.out.println(artById.getEnchere().getAcheteur().getPseudo());
=======
				System.out.println("article :" +artById);
>>>>>>> branch 'main' of https://github.com/laureeeent/TrocEnchere.git
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("articleById", artById);
<<<<<<< HEAD
			
=======
			System.out.println(artById);
>>>>>>> branch 'main' of https://github.com/laureeeent/TrocEnchere.git
			rs.forward(request, response);
		}else {
			RequestDispatcher rs = request.getRequestDispatcher("ServletConnecter");
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
