package fr.eni.javaee.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.bll.UtilisateurManager;


@WebServlet("/AjoutCompte")
public class AjoutCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AjoutCompte() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo;
		String email;
		String prenom;
		String nom;
		String telephone;
		String rue;
		String ville;
		String codePostal;
		String mdp;
		String confirmationMdp;
		
		request.setCharacterEncoding("UTF-8");
		List<Integer> listeCodesErreur=new ArrayList<>();
		
		pseudo=request.getParameter("pseudo");
		email=request.getParameter("email");
		prenom=request.getParameter("prenom");
		nom=request.getParameter("nom");
		telephone=request.getParameter("telephone");
		rue=request.getParameter("rue");
		ville=request.getParameter("ville");
		codePostal=request.getParameter("codePostal");
		mdp=request.getParameter("mdp");
		confirmationMdp=request.getParameter("confirmationMdp");
		
		// TODO checker si le pseudo n'existe pas déja en base
		// TODO checker si pour le mail utilisé à la création il n'existe pas déjà un compte
		// TODO checker si pour le mail utilisé + le mot de passe renseigné, un compte n'existe pas déjà
		
		
		
		
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		
	}

}
