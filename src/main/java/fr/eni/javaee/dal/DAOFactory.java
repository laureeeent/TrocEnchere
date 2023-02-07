package fr.eni.javaee.dal;

public abstract class DAOFactory {
	
	private static UtilisateurDAO utilisateurDAO = null;
	private static CategorieDAO categorieDAO = null;
	private static ArticleVenduDAO articleDAO = null;
	private static EnchereDAO enchereDAO = null;
	
	
	public static UtilisateurDAO getUtilisateurDAO() {
		if (utilisateurDAO == null) {
			utilisateurDAO = new UtilisateurDAOJdbcImpl();
		}
		return utilisateurDAO;
	}
	
	public static CategorieDAO getCategorieDAO() {
		if (categorieDAO == null) {
			categorieDAO = new CategorieDAOJdbcImpl();
		}
		return categorieDAO;
		
	}

	public static ArticleVenduDAO getArticleDAO() {
		if (articleDAO == null) {
			articleDAO = new ArticleVenduDAOJdbcImpl();
		}
		return articleDAO;
	}
	
	public static EnchereDAO getEnchereDAO() {
		if (enchereDAO == null) {
			enchereDAO = new EnchereDAOJdbcImpl();
		}
		return enchereDAO;
	}
	

}
