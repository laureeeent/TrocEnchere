package fr.eni.javaee.dal;

import java.util.List;

import fr.eni.javaee.bo.Categorie;
import fr.eni.javaee.exceptions.BusinessException;

public interface CategorieDAO {
	
	public Categorie selectById(int id) throws BusinessException ;
	
	public List<Categorie>selectAll() ;
	
}
