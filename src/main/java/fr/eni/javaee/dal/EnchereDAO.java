package fr.eni.javaee.dal;

import java.util.List;

import fr.eni.javaee.bo.ArticleVendu;
import fr.eni.javaee.bo.Enchere;
import fr.eni.javaee.exceptions.BusinessException;

public interface EnchereDAO {
	public Enchere selectById(int id) throws BusinessException ;
	
	public List<Enchere>selectAll() ;

	void insert(Enchere enchere) throws BusinessException;

	void delete(Enchere enchere) throws BusinessException;
	
	
	
}
