package fr.eni.javaee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import fr.eni.javaee.bo.ArticleVendu;
import fr.eni.javaee.bo.Enchere;
import fr.eni.javaee.bo.Retrait;
import fr.eni.javaee.bo.Utilisateur;
import fr.eni.javaee.exceptions.BusinessException;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	private static final LocalDateTime VALEUR_DEFAUT_DATE = LocalDateTime.of(1900, 01, 01, 00, 00, 00, 00);
	private static final String SELECT_BY_ID = "SELECT e.no_article,montant_enchere,e.no_utilisateur,date_enchere FROM ENCHERES as e RIGHT OUTER JOIN ARTICLES_VENDUS as a ON e.no_article = a.no_article WHERE a.no_article = ?;";
	private static final String INSERT = "INSERT INTO ENCHERES (no_utilisateur,no_article,date_enchere,montant_enchere)"
			+"VALUES(?,?,?,?)";
	private static final String DELETE = "DELETE FROM ENCHERES WHERE no_article=?;";
	
	@Override
	public void delete(Enchere enchere ) throws BusinessException {
		if (enchere == null) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.DELETE_OBJET_NULL);
		}

		try (Connection conx = ConnectionProvider.getConnection()) {
			conx.setAutoCommit(false);
			PreparedStatement pst = conx.prepareStatement(DELETE);

			pst.setInt(1, enchere.getNoEnchere());

			pst.executeUpdate();

			conx.commit();
			pst.close();
		} catch (SQLException e) {
			System.out.println("Echec de la suppresion de l'enchère " + enchere.toString() + " en base.");
			e.printStackTrace();
		}

	}
	
	@Override
	public void insert(Enchere enchere) throws BusinessException {
		if (enchere == null) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.INSERT_OBJET_NULL);
		}
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			PreparedStatement pst = conx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
		
			pst.setObject(1, enchere.getAcheteur());
			pst.setObject(2, enchere.getVente());
			pst.setTimestamp(3, java.sql.Timestamp.valueOf(enchere.getDateEnchère()));
			pst.setInt(4,enchere.getMontant_enchere());
			
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				enchere.setNoEnchere(1);
			}
		
		rs.close();
		pst.close();
		conx.commit();
		
	} catch (SQLException se) {
		System.out.println("L'insertion en base de l'enchère = "+enchere.toString()+" a échouée");
		se.printStackTrace();
	}
}

		

	
	@Override
	public Enchere selectById(int id) throws BusinessException {
		if (id <= 0) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.SELECT_ID_INCORRECT);
		}
		
		Enchere res = null;
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			PreparedStatement pst = conx.prepareStatement(SELECT_BY_ID);
			pst.setInt(1,id);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				LocalDate date_debut_date = null;
				LocalTime date_debut_time = null;
				LocalDateTime date_enchere = null;
				if (rs.getDate("date_enchere")!=null) {
					date_debut_date = rs.getDate("date_enchere").toLocalDate();
				}
				if (rs.getTime("date_enchere")!=null) {
					 date_debut_time = rs.getTime("date_enchere").toLocalTime();
				}
				if (date_debut_date!=null && date_debut_time!=null) {
					 date_enchere = LocalDateTime.of(date_debut_date, date_debut_time);
				}
				if (date_enchere==null) {
					date_enchere= VALEUR_DEFAUT_DATE;
				}
				

				UtilisateurDAOJdbcImpl util = new UtilisateurDAOJdbcImpl();
				Utilisateur user = util.selectById(rs.getInt("no_utilisateur"));
				
				ArticleVenduDAOJdbcImpl art_vendu = new ArticleVenduDAOJdbcImpl();
				ArticleVendu article = art_vendu.selectById(rs.getInt("no_article"));
				
				res = new Enchere(
							user,
							article,
							date_enchere,
							rs.getInt("montant_enchere")
						);
				
			}
	} catch (SQLException e) {
		System.out.println("echec de la requête de selection d'une enchère où l'id = "+ id+ " a échouée");
		e.printStackTrace();
	}
		return res;
		}

	@Override
	public List<Enchere> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
