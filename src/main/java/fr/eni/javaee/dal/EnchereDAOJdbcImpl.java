package fr.eni.javaee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.javaee.bo.ArticleVendu;
import fr.eni.javaee.bo.Enchere;
import fr.eni.javaee.bo.Utilisateur;
import fr.eni.javaee.exceptions.BusinessException;

public class EnchereDAOJdbcImpl {

	public Enchere selectByMontant(String string) {
		if (pseudo.isEmpty()) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.SELECT_BY_PSEUDO_INCORRECT);
		}
		
		Utilisateur resultat = null;
		System.out.println("vous êtes passé ici");
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			PreparedStatement pst = conx.prepareStatement(SELECT_BY_PSEUDO);

			
			pst.setString(1, pseudo);
			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				boolean admin;
				if (rs.getInt("administrateur") == 1) {
					admin = true;
				}
				else { admin = false; }
				resultat = new Utilisateur(
								rs.getInt("no_utilisateur"),
								rs.getString("pseudo"),
								rs.getString("nom"),
								rs.getString("prenom"),
								rs.getString("email"),
								rs.getString("telephone"),
								rs.getString("rue"),
								rs.getString("code_postal"),
								rs.getString("ville"),
								rs.getString("mot_de_passe"),
								rs.getInt("credit"),
								admin,
								new ArrayList<ArticleVendu>(),
								new ArrayList<Enchere>()
							);
						
			}
			
			rs.close();
			pst.close();
			conx.commit();
			
		} catch (SQLException e) {
			System.out.println("La requête de sélection en base où pseudo = "+pseudo+" a échoué.");
			e.printStackTrace();
		}
		
		return resultat;
}
	}
