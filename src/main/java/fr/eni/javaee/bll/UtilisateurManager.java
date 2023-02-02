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
	
	public Utilisateur getUtilisateur(String entree) throws BusinessException {
		Utilisateur res = null;
		if ( isPseudo(entree) ) {
			res = utilisateurDAO.selectByPseudo(entree);
			
		} else if ( isEmail(entree) ) {
			res = utilisateurDAO.selectByEmail(entree);

		}
		
		return res;
	}
	
	public boolean isPseudo(String entree) {
		boolean res = false;
		
		Pattern alphaNumeric = Pattern.compile("[a-zA-Z0-9]{3,30}");
		Matcher alphaNumericMatcher = alphaNumeric.matcher(entree);
		
		Pattern hasCaractere = Pattern.compile("[^a-zA-Z0-9]{1,}+");
		Matcher hasCaractereMatcher = hasCaractere.matcher(entree);
		if (alphaNumericMatcher.find()) {
			res = true;
		}
		if (hasCaractereMatcher.find()) {
			res = false;
		}
		
		return res;
	}
	
	public boolean isEmail(String entree) {
		boolean res = false;
		
		Pattern aro = Pattern.compile("[a-z0-9.-]+@[a-z-]+.[a-z]+$");
		Matcher alphaNumericMatcher = aro.matcher(entree);
		
		if (alphaNumericMatcher.find()) {
			res = true;
		}
		else {
			
			res = false;
		}
		return res;
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
