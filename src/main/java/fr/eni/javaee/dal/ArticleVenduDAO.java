package fr.eni.javaee.dal;

import java.util.List;

import fr.eni.javaee.bo.ArticleVendu;
import fr.eni.javaee.exceptions.BusinessException;

public interface ArticleVenduDAO {
	
	public void insert(ArticleVendu data) throws BusinessException;
	
	public void delete(ArticleVendu data) throws BusinessException;
	
	public void updateMontantEnchere(ArticleVendu data) throws BusinessException;
	
	public ArticleVendu selectById(int id) throws BusinessException;
	
	public List<ArticleVendu> selectAll();

	List<ArticleVendu> selectByEtat(String etat) throws BusinessException;

}
