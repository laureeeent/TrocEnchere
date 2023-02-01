package fr.eni.javaee.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import fr.eni.javaee.bo.ArticleVendu;
import fr.eni.javaee.exceptions.BusinessException;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
	
	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS"
						+ "(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente, image)"
						+ " VALUES(?,?,?,?,?,?,?,?,DEFAULT,null) ";
	
	private static final String SELECT_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article=?;";

	@Override
	public void insert(ArticleVendu data) throws BusinessException {
		if (data == null) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.INSERT_OBJET_NULL);
		}
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			PreparedStatement pst = conx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			
			Date date_debut = Date.valueOf(data.getDateDebutEncheres().toString());
			Date date_fin = Date.valueOf(data.getDateFinEncheres().toString());
			
			pst.setString(1, data.getNomArticle());
			pst.setString(2, data.getDescription());
			pst.setDate(3, date_debut);
			pst.setDate(4, date_fin);
			pst.setInt(5, data.getMiseAPrix());
			pst.setInt(6, data.getPrixVente());
			pst.setInt(7, data.getVendeur().getNoUtilisateur());
			pst.setInt(8, data.getCategorieArticle().getNoCategorie());
			
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				data.setNoArticle(rs.getInt("no_article"));
			}
			
			rs.close();
			pst.close();
			conx.commit();
			
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
	public ArticleVendu selectById(int id) throws BusinessException {
		if (id <= 0) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.SELECT_ID_INCORRECT);
		}
		
		ArticleVendu res = null;
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			PreparedStatement pst = conx.prepareStatement(SELECT_BY_ID);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				LocalDate date_debut_date = rs.getDate("date_debut_enchere").toLocalDate();
				LocalTime date_debut_time = rs.getTime("date_debut_enchere").toLocalTime();
				LocalDateTime date_debut = LocalDateTime.of(date_debut_date, date_debut_time);
				
				LocalDate date_fin_date = rs.getDate("date_fin_enchere").toLocalDate();
				LocalTime date_fin_time = rs.getTime("date_fin_enchere").toLocalTime();
				LocalDateTime date_fin = LocalDateTime.of(date_fin_date, date_fin_time);
				
//				Utilisateur user = ArticleVenduDAO.
//				
//				res = new ArticleVendu(
//							rs.getInt("no_article"),
//							rs.getString("nom_article"),
//							rs.getString("description"),
//							date_debut,
//							date_fin,
//							rs.getInt("prix_initial"),
//							rs.getInt("prix_vente"),
//							rs.getInt("no_utilisateur")
//						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<ArticleVendu> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
