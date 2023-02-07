package fr.eni.javaee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.bo.Categorie;
import fr.eni.javaee.exceptions.BusinessException;

public class CategorieDAOJdbcImpl implements CategorieDAO {
	
	private static final String SELECT_ALL = "SELECT * FROM CATEGORIES;";
	private static final String SELECT_BY_ID = "SELECT * FROM CATEGORIES WHERE no_categorie=?";
	private static final String SELECT_BY_LIBELLE = "SELECT * FROM CATEGORIES WHERE libelle=?";

	@Override
	public Categorie selectById(int id) throws BusinessException {
		if (id <= 0) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.SELECT_ID_INCORRECT);
		}
		
		Categorie resultat = null;
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			PreparedStatement pst = conx.prepareStatement(SELECT_BY_ID);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				resultat= new Categorie(
						rs.getInt("no_categorie"),
						rs.getString("libelle")
						);
						
			}
			
			rs.close();
			pst.close();
			conx.commit();
		
		}
		catch (SQLException e) {
			System.out.println("La catégorie avec id = "+id+" n'existe pas.");
			e.printStackTrace();
		}
		return resultat;
	}
	
	@Override
	public Categorie selectByLibelle(String libelle) throws BusinessException {
		if (libelle.isEmpty()) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.SELECT_CATEGORIE_LIBELLE_INCORRECT);
		}
		
		Categorie resultat = null;
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			PreparedStatement pst = conx.prepareStatement(SELECT_BY_LIBELLE);
			
			pst.setString(1, libelle);
			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				resultat= new Categorie(
						rs.getInt("no_categorie"),
						rs.getString("libelle")
						);						
			}
			
			rs.close();
			pst.close();
			conx.commit();
		
		}
		catch (SQLException e) {
			System.out.println("La catégorie avec libelle = "+libelle+" n'existe pas.");
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public List<Categorie> selectAll() {
		
		List<Categorie>listeResultat=new ArrayList<Categorie>() ;
		

		try ( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			Statement pst = conx.createStatement();
			
			ResultSet rs = pst.executeQuery(SELECT_ALL);
			
			while (rs.next()) {
				Categorie categorie = new Categorie(
						rs.getInt("no_categorie"),
						rs.getString("libelle")
						);
				listeResultat.add(categorie);				
			}
			
			rs.close();
			pst.close();
			conx.commit();
			
		} catch (SQLException e) {
			System.out.println("La requête en base de selection de toutes les catégories a échoué.");
			e.printStackTrace();
		}
		return listeResultat;
	}

}
