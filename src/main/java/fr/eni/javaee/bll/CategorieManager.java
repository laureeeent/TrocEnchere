package fr.eni.javaee.bll;

import java.util.List;

import fr.eni.javaee.bo.Categorie;
import fr.eni.javaee.dal.CategorieDAO;
import fr.eni.javaee.dal.DAOFactory;
import fr.eni.javaee.exceptions.BusinessException;

public class CategorieManager {
	
	private CategorieDAO categorieDAO = null;
	
	public CategorieManager () {
		categorieDAO = DAOFactory.getCategorieDAO();
	}
	
	public List <Categorie> selectionnerToutesLesCategories(){
		
		return this.categorieDAO.selectAll() ;
	}
	
	public Categorie selectionnerByID (int id)throws BusinessException {
		
		return this.categorieDAO.selectById(id);
		
	}

}
