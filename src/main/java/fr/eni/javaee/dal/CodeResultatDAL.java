package fr.eni.javaee.dal;

public abstract class CodeResultatDAL {
	
	/**
	 * Echec général quand tentative d'ajouter un objet null
	 */
	public static final int INSERT_OBJET_NULL=10000;
	
	/**
	 * Echec général quand tentative de supprimer un objet null
	 */
	public static final int DELETE_OBJET_NULL=10001;
	
	/**
	 * Echec général quand tentative de mettre a jour un objet null un objet null
	 */
	public static final int UPDATE_OBJET_NULL=10002;
	
	/**
	 * Echec général quand tentative de récuperer la note où id <= 0.
	 */
	public static final int SELECT_ID_INCORRECT=10003;

}
