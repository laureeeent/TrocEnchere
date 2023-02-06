package fr.eni.javaee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.javaee.bo.Categorie;
import fr.eni.javaee.bo.Retrait;
import fr.eni.javaee.bo.Utilisateur;
import fr.eni.javaee.exceptions.BusinessException;

public class RetraitDAOJdbcImpl implements RetraitDAO {
	
	private static final String SELECT_BY_ID = "SELECT * FROM RETRAITS WHERE no_article=?;";
	private static final String INSERT = "INSERT INTO RETRAITS rue,code_postal,ville VALUES (?,?,?);";
	private static final String UPDATE = "UPDATE RETRAITS set rue=?, code_postal=?, ville=? WHERE no_article=?;";
	private static final String DELETE = "DELETE FROM RETRAITS WHERE no_article=?;";

	@Override
	public void insert(Retrait retrait) throws BusinessException {
		
	}

	@Override
	public Retrait selectById(int id) throws BusinessException {
		if (id <= 0) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.SELECT_ID_INCORRECT);
		}
		
		Retrait retrait = null;
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			PreparedStatement pst = conx.prepareStatement(SELECT_BY_ID);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				retrait= new Retrait(
						rs.getString("rue"),
						rs.getString("codePostal"),
						rs.getString("ville")
						);
						
			}
			
			rs.close();
			pst.close();
			conx.commit();
		
		}
		catch (SQLException e) {
			System.out.println("Le lieu de retrait n'est pas disponible car la vente de l'article n° "+id+" n'existe pas.");
			e.printStackTrace();
		}
		return retrait;
	}
	

	@Override
	public void update(Retrait retrait) throws BusinessException {
		if (retrait == null) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.UPDATE_OBJET_NULL);
		}
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			PreparedStatement pst = conx.prepareStatement(UPDATE);
			
			
			pst.setString(1, retrait.getRue());
			pst.setString(2, retrait.getCodePostal());
			pst.setString(3, retrait.getVille());
			
			pst.executeUpdate();
			
			pst.close();
			conx.commit();
		} catch (SQLException e) {
			System.out.println("Echec de la mise a jour du retrait de l'article : "+retrait.getNoArticleVendu()+"");
			e.printStackTrace();
		}
			
	}
		

	@Override
	public void delete(Retrait retrait ) throws BusinessException {
		if (retrait == null) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.DELETE_OBJET_NULL);
		}

		try (Connection conx = ConnectionProvider.getConnection()) {
			conx.setAutoCommit(false);
			PreparedStatement pst = conx.prepareStatement(DELETE);

			pst.setInt(1, retrait.getNoArticleVendu());

			pst.executeUpdate();

			conx.commit();
			pst.close();
		} catch (SQLException e) {
			System.out.println("Echec de la suppresion du retrait " + retrait.toString() + " en base.");
			e.printStackTrace();
		}

	}

}
