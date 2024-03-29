package fr.eni.javaee.dal;

import java.util.List;

import fr.eni.javaee.bo.Utilisateur;
import fr.eni.javaee.exceptions.BusinessException;

public interface UtilisateurDAO {
	
	public void insert(Utilisateur data) throws BusinessException ;
	
	public void update(Utilisateur data) throws BusinessException ; 
	
	public boolean delete(Utilisateur data) throws BusinessException ;
	
	public Utilisateur selectById(int id) throws BusinessException ;
	
	public List<Utilisateur> selectAll();

	Utilisateur selectByPseudo(String pseudo) throws BusinessException;
	
	boolean isPseudoInBase(String pseudo) throws BusinessException;

	boolean isEmailInBase(String email) throws BusinessException;

	Utilisateur selectByEmail(String pseudo) throws BusinessException;
	

	void updateCredit(Utilisateur data) throws BusinessException;
	
	 
	

}
