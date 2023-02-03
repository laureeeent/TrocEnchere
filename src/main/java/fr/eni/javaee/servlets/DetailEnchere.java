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
import fr.eni.javaee.bo.ArticleVendu;
import fr.eni.javaee.bo.Utilisateur;


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
		

		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		
		int enchereEnCours;
		String ancienEncherisseur;
		String vendeur;
		
		ancienEncherisseur=request.getParameter("vendeur");
		vendeur= request.getParameter("vendeur");
		enchereEnCours= Integer.parseInt(request.getParameter("enchereEnCours"));
		
	}

}
