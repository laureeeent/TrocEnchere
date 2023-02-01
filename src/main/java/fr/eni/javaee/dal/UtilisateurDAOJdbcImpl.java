package fr.eni.javaee.dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.bo.ArticleVendu;
import fr.eni.javaee.bo.Enchere;
import fr.eni.javaee.bo.Utilisateur;
import fr.eni.javaee.exceptions.BusinessException;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String INSERT = "INSERT INTO UTILISATEURS"
			+ "(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur)"
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?);";
	
	private static final String UPDATE = "UPDATE UTILISATEURS "
			+ "set pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, "
			+ "code_postal=?, ville=?, mot_de_passe=?, credit=?, administrateur=? "
			+ "WHERE no_utilisateur=?;";

	private static final String DELETE = "DELETE * FROM UTILISATEURS WHERE no_utilisateur=?;";
	private static final String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur=?";
	private static final String SELECT_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo=?";
	private static final String SELECT_BY_EMAIL = "SELECT * FROM UTILISATEURS WHERE email=?";
	private static final String SELECT_ALL = "SELECT * FROM UTILISATEURS;";
	
	@Override
	public void insert(Utilisateur data) throws BusinessException {
		if (data == null) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.INSERT_OBJET_NULL);
		}
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			
			PreparedStatement pst = conx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, data.getPseudo());
			pst.setString(2, data.getNom());
			pst.setString(3, data.getPrenom());
			pst.setString(4, data.getEmail());
			pst.setString(5, data.getTelephone());
			pst.setString(6, data.getRue());
			pst.setString(7, data.getCodePostal());
			pst.setString(8, data.getVille());
			pst.setString(9, data.getMotDePasse());
			pst.setInt(10, data.getCredit());
			if (data.isAdministrateur()) {
				pst.setInt(11, 1);
			}
			else { pst.setInt(11, 0);}
			
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			
			if (rs.next()) {
				data.setNoUtilisateur(rs.getInt("no_utilisateur"));
			}
			
			conx.commit();
			rs.close();
			pst.close();
		} catch (SQLException e) {
			System.out.println("Echec de l'insertion de l'utilisateur "+data.toString()+" dans la base.");
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Utilisateur data) throws BusinessException {
		if (data == null) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.UPDATE_OBJET_NULL);
		}
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			PreparedStatement pst = conx.prepareStatement(UPDATE);
			
			pst.setString(1, data.getPseudo());
			pst.setString(2, data.getNom());
			pst.setString(3, data.getPrenom());
			pst.setString(4, data.getEmail());
			pst.setString(5, data.getTelephone());
			pst.setString(6, data.getRue());
			pst.setString(7, data.getCodePostal());
			pst.setString(8, data.getVille());
			pst.setString(9, data.getMotDePasse());
			pst.setInt(10, data.getCredit());
			if (data.isAdministrateur()) {
				pst.setInt(11, 1);
			}
			else { pst.setInt(11, 0); }
			pst.setInt(12, data.getNoUtilisateur());
			
			pst.executeUpdate();
			
			pst.close();
			conx.commit();
		} catch (SQLException e) {
			System.out.println("Echec de la mise a jour de l'utitilisateur "+data.toString()+"");
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Utilisateur data) throws BusinessException {
		if (data==null) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.DELETE_OBJET_NULL);
		}
		
		try( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			PreparedStatement pst = conx.prepareStatement(DELETE);
			
			pst.setInt(1, data.getNoUtilisateur());
			
			pst.executeUpdate();
			
			pst.close();
			conx.commit();
		} catch (SQLException e) {
			System.out.println("Echec de la suppresion de l'utilisateur "+data.toString()+" en base.");
			e.printStackTrace();
		}

	}

	@Override
	public Utilisateur selectById(int id) throws BusinessException {
		if (id <= 0) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.SELECT_ID_INCORRECT);
		}
		
		Utilisateur resultat = null;
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			PreparedStatement pst = conx.prepareStatement(SELECT_BY_ID);
			
			pst.setInt(1, id);
			
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
			System.out.println("La requête de sélection en base où id = "+id+" a échoué.");
			e.printStackTrace();
		}
		
		return resultat;
	}
	
	@Override
	public Utilisateur selectByPseudo(String pseudo) throws BusinessException {
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
	
	
	@Override
	public Utilisateur selectByEmail(String email) throws BusinessException {
		if (email.isEmpty()) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.SELECT_BY_EMAIL_INCORRECT);
		}
		
		Utilisateur resultat = null;
		System.out.println("vous êtes passé ici");
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			PreparedStatement pst = conx.prepareStatement(SELECT_BY_EMAIL);

			
			pst.setString(1, email);
			
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
			System.out.println("La requête de sélection en base où email = "+email+" a échoué.");
			e.printStackTrace();
		}
		
		return resultat;
	}
	
	
	@Override
	public List<Utilisateur> selectAll() {
		
		ArrayList<Utilisateur> listeResultat = new ArrayList<Utilisateur>();
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			Statement pst = conx.createStatement();
			
			ResultSet rs = pst.executeQuery(SELECT_ALL);
			
			while (rs.next()) {
				boolean admin;
				if (rs.getInt("administrateur") == 1) {
					admin = true;
				}
				else { admin = false; }
				Utilisateur utilisateur = new Utilisateur(
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
				listeResultat.add(utilisateur);
			}
			
			rs.close();
			pst.close();
			conx.commit();
			
		} catch (SQLException e) {
			System.out.println("La requête en base de selection de tout les utilisateur a échoué.");
			e.printStackTrace();
		}
		
		return listeResultat;
	}
	
	@Override
	public boolean isPseudoInBase(String pseudo) throws BusinessException {
		if (pseudo.isEmpty()) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.SELECT_BY_PSEUDO_INCORRECT);
		}
		
		boolean resultat = false;
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			PreparedStatement pst = conx.prepareStatement(SELECT_BY_PSEUDO);
			
			pst.setString(1, pseudo);
			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				if (rs.getString("pseudo").equals(pseudo)) {
					resultat = true;
				}
				else {
					resultat = false;
				}
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
	
	
	
	@Override
	public boolean isEmailInBase(String email) throws BusinessException {
		if (email.isEmpty()) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.SELECT_BY_EMAIL_INCORRECT);
		}
		
		boolean resultat = false;
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			PreparedStatement pst = conx.prepareStatement(SELECT_BY_EMAIL);
			
			pst.setString(1, email);
			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				if (rs.getString("email").equals(email)) {
					resultat = true;
				}
				else {
					resultat = false;
				}
			}
			
			rs.close();
			pst.close();
			conx.commit();
			
		} catch (SQLException e) {
			System.out.println("La requête de sélection en base où email = "+email+" a échoué.");
			e.printStackTrace();
		}
		
		return resultat;
	}



}
