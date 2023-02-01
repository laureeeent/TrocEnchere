package fr.eni.javaee.dal;


import fr.eni.javaee.bo.Retrait;
import fr.eni.javaee.exceptions.BusinessException;

public interface RetraitDAO {
	
	public void insert (Retrait retrait)throws BusinessException ;
	
	public Retrait selectById(int id)throws BusinessException ;
	
	public void update(Retrait retrait) throws BusinessException;

}
