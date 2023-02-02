package fr.eni.javaee.dal;

import java.util.List;

import fr.eni.javaee.bo.Enchere;
import fr.eni.javaee.exceptions.BusinessException;

public interface EnchereDAO {
	public Enchere selectById(int id) throws BusinessException ;
	
	public List<Enchere>selectAll() ;
	
	public Enchere selectByMontant(int int1);
}
