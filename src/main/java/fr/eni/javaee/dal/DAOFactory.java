package fr.eni.javaee.dal;

public abstract class DAOFactory {
	
	private static UtilisateurDAO utilisateurDAO = null;
	
	public static UtilisateurDAO getUtilisateurDAO() {
		if (utilisateurDAO == null) {
			utilisateurDAO = new UtilisateurDAOJdbcImpl();
		}
		return utilisateurDAO;
	}

}
