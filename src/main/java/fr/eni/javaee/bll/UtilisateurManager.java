package fr.eni.javaee.bll;

import fr.eni.javaee.bo.Utilisateur;
import fr.eni.javaee.dal.DAOFactory;
import fr.eni.javaee.dal.UtilisateurDAO;
import fr.eni.javaee.exceptions.BusinessException;

public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO = null;
	
	public UtilisateurManager() {
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public Utilisateur getUtilisateur(String pseudo) {
		Utilisateur res = null;
		
		try {
			res = utilisateurDAO.selectByPseudo(pseudo);
		}
		catch (BusinessException be) {
			be.printStackTrace();
		}
		
		return res;
	}
	
	public boolean isPwdCorrect(Utilisateur user, String password) {
		if (user.getMotDePasse().equals(password)) {
			return true;
		}
		return false;
	}

	public void ajouterUtilisateur(Utilisateur user) {
		try {
			utilisateurDAO.insert(user);
		}
		catch (BusinessException be) {
			be.printStackTrace();
		}
	}
}
