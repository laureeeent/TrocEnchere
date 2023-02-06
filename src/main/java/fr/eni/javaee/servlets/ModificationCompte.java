package fr.eni.javaee.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.bll.UtilisateurManager;
import fr.eni.javaee.bo.Utilisateur;


@WebServlet("/ModificationCompte")
public class ModificationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ModificationCompte() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/modificationCompte.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		String submit=null;
		String submitUpdate="Enregistrer";
		String submitDelete="Supprimer mon compte";
		request.setCharacterEncoding("UTF-8");
		submit=request.getParameter("submit");

		if(submit.equals(submitUpdate)) {
		
			String pseudo;
			String email;
			String prenom;
			String nom;
			String telephone;
			String rue;
			String ville;
			String codePostal;
			String mdpActuel;
			String mdp;
			String confirmationMdp;
	
			List<String> listeMessagesErreur = new ArrayList<>();
			
			pseudo = request.getParameter("pseudo");
			email = request.getParameter("email");
			prenom = request.getParameter("prenom");
			nom = request.getParameter("nom");
			telephone = request.getParameter("telephone");
			rue = request.getParameter("rue");
			ville = request.getParameter("ville");
			codePostal = request.getParameter("codePostal");
			mdpActuel= request.getParameter("mdpActuel");
			mdp = request.getParameter("mdp");
			confirmationMdp = request.getParameter("confirmationMdp");
			
			//vérifier si le mot de passe actuel est le bon
			if (!utilisateurManager.isPwdCorrect(user, mdpActuel)){
				listeMessagesErreur.add(MessagesErreurServlets.ERREUR_SAISIE_MDP_ACTUEL);
			};
			//vérif' du nouveau mdp
			if (!mdp.equals(confirmationMdp)) {
				listeMessagesErreur.add(MessagesErreurServlets.ERREUR_MDP);
			}
			//vérifier si pseudo pas déjà en base
			if(!pseudo.equals(user.getPseudo())) {
				if (utilisateurManager.isPseudoInBase(pseudo)) {
					listeMessagesErreur.add(MessagesErreurServlets.ERREUR_PSEUDO_EXISTANT);
				}
			}
			if (listeMessagesErreur.size() > 0) {
				request.setAttribute("listeMessagesErreur", listeMessagesErreur);
				RequestDispatcher rd = request.getRequestDispatcher("/modificationCompte.jsp");
				rd.forward(request, response);
			} 
			if (mdp.isEmpty()&&confirmationMdp.isEmpty())
			{
				user.setPseudo(pseudo);
				user.setEmail(email);
				user.setPrenom(prenom);
				user.setNom(nom);
				user.setTelephone(telephone);
				user.setRue(rue);
				user.setVille(ville);
				user.setCodePostal(codePostal);
				user.setMotDePasse(mdpActuel);
				user.setCredit(user.getCredit());
				user.setAdministrateur(user.isAdministrateur());
				
				utilisateurManager.modifierUtilisateur(user);
				RequestDispatcher rd = request.getRequestDispatcher("ServletRedirectionAccueil");
				rd.forward(request, response);
			} else
			{	
				user.setPseudo(pseudo);
				user.setEmail(email);
				user.setPrenom(prenom);
				user.setNom(nom);
				user.setTelephone(telephone);
				user.setRue(rue);
				user.setVille(ville);
				user.setCodePostal(codePostal);
				user.setMotDePasse(mdp);
				user.setCredit(user.getCredit());
				user.setAdministrateur(user.isAdministrateur());
				
				utilisateurManager.modifierUtilisateur(user);
				RequestDispatcher rd = request.getRequestDispatcher("ServletRedirectionAccueil");
				rd.forward(request, response);
				
			}
			
					
		}  
			if (submit.equals(submitDelete)) {
				utilisateurManager.supprimerUtilisateur(user);
				Utilisateur userNull = null;
				session.setAttribute("utilisateur", userNull);
				RequestDispatcher rd = request.getRequestDispatcher("ServletRedirectionAccueil");
				rd.forward(request, response);
		}
	}

}
