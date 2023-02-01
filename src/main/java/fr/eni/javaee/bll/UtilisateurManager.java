package fr.eni.javaee.bll;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.javaee.bo.Utilisateur;
import fr.eni.javaee.dal.DAOFactory;
import fr.eni.javaee.dal.UtilisateurDAO;
import fr.eni.javaee.exceptions.BusinessException;

public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO = null;
	
	public UtilisateurManager() {
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public Utilisateur getUtilisateurByPseudo(String entree) {
		Utilisateur res = null;
		if ( isPseudo(entree) ) {
			try {
				res = utilisateurDAO.selectByPseudo(entree);
			} catch (BusinessException be) {
				be.printStackTrace();
			}
			
		} else if ( isEmail(entree) ) {
			try {
				res = utilisateurDAO.selectByEmail(entree);
			} catch (BusinessException be) {
				be.printStackTrace();
			}
		}
		
		return res;
	}
	
	public boolean isPseudo(String entree) {
		Pattern pattern = Pattern.compile("[abc]+");
		Matcher matcher = pattern.matcher(entree);
		
		return false;
	}
	
	public boolean isEmail(String entree) {
		return false;
	}
	
	public boolean isPwdCorrect(Utilisateur user, String password) {
		if (user.getMotDePasse().equals(password)) {
			return true;
		}
		return false;
	}

	public boolean isPseudoInBase(String pseudo) {
		boolean resultat = false;
		try {
			return utilisateurDAO.isPseudoInBase(pseudo);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		return resultat;
	}
	
	public boolean isPseudoValid(String pseudo) {
		return false;
	}
	
	public boolean isEmailInBase(String email) {
		boolean resultat = false;
		try {
			resultat =  utilisateurDAO.isEmailInBase(email);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		return resultat;
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
