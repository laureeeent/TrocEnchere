package fr.eni.javaee.bll;

import fr.eni.javaee.bo.Retrait;
import fr.eni.javaee.dal.RetraitDAO;
import fr.eni.javaee.exceptions.BusinessException;

public class RetraitManager {
	
	private RetraitDAO retraitDAO = null;

	public void ajouterRetrait(Retrait retrait) {

		try {
			retraitDAO.insert(retrait);
		} catch (BusinessException be) {
			be.printStackTrace();
		}
	}

	public Retrait selectionnerRetraitParID(int id) throws BusinessException {

		Retrait retrait = null;

		retrait = this.retraitDAO.selectById(id);

		return retrait;

	}
	
	public void modifierRetrait(Retrait retrait) {
		try {
			retraitDAO.update(retrait);
		}
		catch (BusinessException be) {
			be.printStackTrace();
		}
	}
	
	public void supprimerRetrait(Retrait retrait) throws BusinessException {
		retraitDAO.delete(retrait);
	}

}
