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
import fr.eni.javaee.bo.Utilisateur;
import fr.eni.javaee.exceptions.BusinessException;

public class EnchereDAOJdbcImpl implements EnchereDAO {

	private static final String SELECT_BY_ID = null;

	@Override
	public Enchere selectById(int id) throws BusinessException {
		if (id <= 0) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.SELECT_ID_INCORRECT);
		}
		
		Enchere res = null;
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			PreparedStatement pst = conx.prepareStatement(SELECT_BY_ID);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				LocalDate date_debut_date = rs.getDate("date_enchere").toLocalDate();
				LocalTime date_debut_time = rs.getTime("date_enchere").toLocalTime();
				LocalDateTime date_enchere = LocalDateTime.of(date_debut_date, date_debut_time);

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
		return null;
		}

	@Override
	public List<Enchere> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Enchere selectByMontant(int int1) {
		// TODO Auto-generated method stub
		return null;
	}
}