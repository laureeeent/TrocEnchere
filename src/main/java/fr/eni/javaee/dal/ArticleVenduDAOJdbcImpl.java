package fr.eni.javaee.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.eni.javaee.bo.ArticleVendu;
import fr.eni.javaee.exceptions.BusinessException;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
	
	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS"
						+ "(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, image)"
						+ " VALUES(?,?,?,?,?,?,?,?,?) ";

	@Override
	public void insert(ArticleVendu data) throws BusinessException {
		if (data == null) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.INSERT_OBJET_NULL);
		}
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			PreparedStatement pst = conx.prepareStatement(INSERT);
			
			pst.setString(1, data.getNomArticle());
			pst.setString(2, data.getDescription());
			pst.setString(3, INSERT);
			
			
			
		} catch (SQLException se) {
			System.out.println("L'insertion en base où article vendu = "+data.toString()+" a échoué");
			se.printStackTrace();
		}
		
	}

	@Override
	public void delete(ArticleVendu data) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArticleVendu data) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArticleVendu selectById(ArticleVendu data) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleVendu> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArticleVendu selectByEtat(ArticleVendu data) throws BusinessException {
		ArticleVendu ec = data;
		return ec;
	}
	

}
