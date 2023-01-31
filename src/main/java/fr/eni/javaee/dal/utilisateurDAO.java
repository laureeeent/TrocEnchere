package fr.eni.javaee.dal;

import java.util.List;

import fr.eni.javaee.bo.Utilisateur;
import fr.eni.tpprisedenotes.exception.BusinessException;

public interface utilisateurDAO {
	
	public void insert(Utilisateur data) throws BusinessException ;
	
	public void update(Utilisateur data) throws BusinessException ; 
	
	public void delete(Utilisateur data) throws BusinessException ;
	
	public Utilisateur selectById(Utilisateur data) throws BusinessException ;
	
	public List<Utilisateur> selectAll();

}
