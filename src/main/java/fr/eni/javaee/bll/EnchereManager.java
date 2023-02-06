package fr.eni.javaee.bll;

import fr.eni.javaee.bo.Enchere;
import fr.eni.javaee.dal.EnchereDAO;
import fr.eni.javaee.exceptions.BusinessException;

public class EnchereManager {
	
	private EnchereDAO enchereDAO = null;
	
	
	public void ajouterEnchere(Enchere enchere) {
		
		try {
			enchereDAO.insert(enchere);
		}
		catch (BusinessException be) {
			be.printStackTrace();
		}
	}

}
