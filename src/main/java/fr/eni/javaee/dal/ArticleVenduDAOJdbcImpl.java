package fr.eni.javaee.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import fr.eni.javaee.bo.ArticleVendu;
import fr.eni.javaee.bo.Categorie;
import fr.eni.javaee.bo.Enchere;
import fr.eni.javaee.bo.Utilisateur;
import fr.eni.javaee.exceptions.BusinessException;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
	private static final int VALEUR_DEFAUT_INT = 0;
	
	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS"
						+ "(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente, image)"
						+ " VALUES(?,?,?,?,?,?,?,?,DEFAULT,?) ";
	
	private static final String SELECT_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article=?;";
	private static final String SELECT_ARTICLE_ENCHERE_BY_ETAT = "SELECT nom_article, prix_initial, date_fin_enchere, pseudo,montant_enchere, etat_vente,image, no_categorie,"
						+ " a.no_article FROM ARTICLES_VENDUS as a LEFT OUTER JOIN ENCHERES as e ON a.no_article = e.no_article INNER JOIN UTILISATEURS as u on a.no_utilisateur=u.no_utilisateur "
						+ "WHERE etat_vente= ?";
	private static final String SELECT_ARTICLE_ENCHERE_BY_ETAT_CATEGORIE = "SELECT nom_article, prix_initial, date_fin_enchere, pseudo,montant_enchere, etat_vente,image, no_categorie,"
						+ " a.no_article FROM ARTICLES_VENDUS as a LEFT OUTER JOIN ENCHERES as e ON a.no_article = e.no_article INNER JOIN UTILISATEURS as u on a.no_utilisateur=u.no_utilisateur "
						+ "WHERE etat_vente= ? and no_categorie=?;";
	private static final String SELECT_BY_ID_ENCHERES = "SELECT * FROM ENCHERES WHERE no_article = ?";
	private static final String SELECT_ENCHERES_OUVERTES_USER = "SELECT nom_article, description, prix_initial, date_debut_enchere, date_fin_enchere, pseudo, e.no_utilisateur AS no_acheteur, a.no_utilisateur AS no_vendeur, montant_enchere, no_categorie, etat_vente,image,"
			+ " a.no_article FROM ARTICLES_VENDUS as a INNER JOIN ENCHERES as e ON a.no_article = e.no_article INNER JOIN UTILISATEURS as u on a.no_utilisateur=u.no_utilisateur "
			+ "WHERE etat_vente= 'EC' AND e.no_utilisateur = ?;";
	private static final String SELECT_ENCHERES_OUVERTES_USER_CATEGORIE = "SELECT nom_article, description, prix_initial, date_debut_enchere, date_fin_enchere, pseudo, e.no_utilisateur AS no_acheteur, a.no_utilisateur AS no_vendeur, montant_enchere, no_categorie, etat_vente,image,"
			+ " a.no_article FROM ARTICLES_VENDUS as a INNER JOIN ENCHERES as e ON a.no_article = e.no_article INNER JOIN UTILISATEURS as u on a.no_utilisateur=u.no_utilisateur "
			+ "WHERE etat_vente= 'EC' AND e.no_utilisateur = ? AND no_categorie = ?;";
	private static final String SELECT_ENCHERES_REMPORTEES_USER = "SELECT nom_article, description, prix_initial, date_debut_enchere, date_fin_enchere, pseudo, e.no_utilisateur AS no_acheteur, a.no_utilisateur AS no_vendeur, montant_enchere, etat_vente, no_categorie, image,"
			+ " a.no_article FROM ARTICLES_VENDUS as a INNER JOIN ENCHERES as e ON a.no_article = e.no_article INNER JOIN UTILISATEURS as u on a.no_utilisateur=u.no_utilisateur "
			+ "WHERE (etat_vente= 'VD' OR etat_vente='RT') AND e.no_utilisateur=?;";
	private static final String SELECT_ENCHERES_REMPORTEES_USER_CATEGORIE = "SELECT nom_article, description, prix_initial, date_debut_enchere, date_fin_enchere, pseudo, e.no_utilisateur AS no_acheteur, a.no_utilisateur AS no_vendeur, montant_enchere, etat_vente, no_categorie, image,"
			+ " a.no_article FROM ARTICLES_VENDUS as a INNER JOIN ENCHERES as e ON a.no_article = e.no_article INNER JOIN UTILISATEURS as u on a.no_utilisateur=u.no_utilisateur "
			+ "WHERE (etat_vente= 'VD' OR etat_vente='RT') AND e.no_utilisateur=? AND no_categorie=?;";
	
	private static final String SELECT_VENTES_USER_EC = "SELECT * FROM ARTICLES_VENDUS WHERE no_utilisateur=? AND etat_vente='EC';";
	
	private static final String UPDATE_MONTANT_ENCHERE = "UPDATE ARTICLES_VENDUS set prix_vente=? WHERE no_article=? "	;
	private static final String UPDATE = " UPDATE ARTICLES_VENDUS SET nom_article=?, description=?, date_debut_enchere=?, date_fin_enchere=?,"
						+ "prix_initial=?, no_categorie=?, etat_vente=?, image=?;";

	
	
	
	
	
	private static final LocalDateTime VALEUR_DEFAUT_DATE = LocalDateTime.of(1900, 01, 01, 00, 00, 00, 00);
	private static final Enchere VALEUR_DEFAUT_ENCHERE = new Enchere(0);
	private static final Utilisateur VALEUR_DEFAUT_UTILISATEUR = new Utilisateur("Pas de pseudo");
	private static final String VALEUR_DEFAUT_STRING = "";
	

	@Override
	public void insert(ArticleVendu data) throws BusinessException {
		if (data == null) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.INSERT_OBJET_NULL);
		}
		
		RetraitDAOJdbcImpl retraitDAOJdbcImpl = new RetraitDAOJdbcImpl();
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			PreparedStatement pst = conx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
				
			pst.setString(1, data.getNomArticle());
			pst.setString(2, data.getDescription());
			pst.setTimestamp(3, Timestamp.valueOf(data.getDateDebutEncheres()));
			pst.setTimestamp(4, Timestamp.valueOf(data.getDateFinEncheres()));
			pst.setInt(5, data.getMiseAPrix());
			pst.setNull(6, 0);
			pst.setInt(7, data.getVendeur().getNoUtilisateur());
			pst.setInt(8, data.getCategorieArticle().getNoCategorie());
			pst.setString(9, data.getImage());
			
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				data.setNoArticle(rs.getInt(1));
			}
			
			rs.close();
			pst.close();
			conx.commit();
			
			data.getLieuRetrait().setNoArticleVendu(data.getNoArticle());
			retraitDAOJdbcImpl.insert(data.getLieuRetrait());
			

			

			
		} catch (SQLException se) {
			System.out.println("L'insertion en base où article vendu = "+data.toString()+" a échoué");
			se.printStackTrace();
		}
		
	}

	@Override
	public void delete(ArticleVendu data) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	
	public void update(ArticleVendu data) throws BusinessException {
		if (data==null) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.UPDATE_OBJET_NULL);
		}
		
		RetraitDAOJdbcImpl retraitDAOJdbcImpl = new RetraitDAOJdbcImpl();
		//nom_article=?, description=?, date_debut_enchere=?, date_fin_enchere=?,"
		//+ "prix_initial=?, no_categorie=?, etat_vente=?, image=?;
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			PreparedStatement pst = conx.prepareStatement(UPDATE);
			
			pst.setString(1, data.getNomArticle());
			pst.setString(2, data.getDescription());
			pst.setTimestamp(3, Timestamp.valueOf(data.getDateDebutEncheres()));
			pst.setTimestamp(4, Timestamp.valueOf(data.getDateFinEncheres()));
			pst.setInt(5, data.getMiseAPrix());
			pst.setInt(6, data.getCategorieArticle().getNoCategorie());
			pst.setString(7, data.getEtatVente());
			pst.setString(8, data.getImage());
			
			pst.executeQuery();
			
			pst.close();
			conx.commit();
			
			retraitDAOJdbcImpl.insert(data.getLieuRetrait());
			
		} catch (SQLException e) {
			System.out.println("La mise à jour de l'article = "+data+" en base a échoué.");
			e.printStackTrace();
		}
	}

	@Override
	public void updateMontantEnchere(ArticleVendu data) throws BusinessException {
		if (data == null) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.UPDATE_OBJET_NULL);
		}
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			conx.setAutoCommit(false);
			PreparedStatement pst = conx.prepareStatement(UPDATE_MONTANT_ENCHERE);
			
			
			pst.setInt(1, data.getPrixVente());
			pst.setInt(2, data.getNoArticle());
			
			pst.executeUpdate();
			
			pst.close();
			conx.commit();
		} catch (SQLException e) {
			System.out.println("Echec de la mise a jour de l'enchère de : "+data.getNomArticle()+"");
			e.printStackTrace();
		}	
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
				
				UtilisateurDAOJdbcImpl util = new UtilisateurDAOJdbcImpl();
				Utilisateur user = util.selectById(rs.getInt("no_utilisateur"));
			
				
				CategorieDAOJdbcImpl e = new CategorieDAOJdbcImpl();
				Categorie cat = e.selectById(rs.getInt("no_categorie"));
				

				res = new ArticleVendu(
							rs.getInt("no_article"),
							rs.getString("nom_article"),
							rs.getString("description"),
							date_debut,
							date_fin,
							rs.getInt("prix_initial"),
							rs.getInt("prix_vente"),
							rs.getString("etat_vente"),
							user,
							cat,
							rs.getString("image")
						);

				PreparedStatement pstEnchere = conx.prepareStatement(SELECT_BY_ID_ENCHERES);
				pstEnchere.setInt(1, res.getNoArticle());
				pstEnchere.executeQuery();
				ResultSet rs2 = pstEnchere.getResultSet();
				//Si on trouve une enchère avec no_article=res.no_article
				if (rs2.next()) {
					LocalTime dateEnchereTime = rs2.getTime(3).toLocalTime();
					LocalDate dateEnchereDate = rs2.getDate(3).toLocalDate();
					LocalDateTime dateEnchere = LocalDateTime.of(dateEnchereDate, dateEnchereTime);
					Utilisateur acheteur = util.selectById(rs2.getInt("no_utilisateur"));
					Enchere enchere = new Enchere( res.getNoArticle(), dateEnchere, rs2.getInt("montant_enchere"), acheteur, res);
					
					res.setEnchere(enchere);
				}
				
				
				pst.close();


			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public List<ArticleVendu> selectEnchereUser(Utilisateur user, String filtre, int noCategorie) throws BusinessException {
		if (user == null ) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.SELECT_ID_INCORRECT);
		}
		String requete = "";
		if (filtre.equals("EC") && noCategorie <= 0) {
			requete = SELECT_ENCHERES_OUVERTES_USER;
		}
		else if (filtre.equals("EC") && noCategorie > 0) {
			requete = SELECT_ENCHERES_OUVERTES_USER_CATEGORIE;
		}
		else if (filtre.equals("remportee") && noCategorie <=0) {
			requete = SELECT_ENCHERES_REMPORTEES_USER;
		}
		else if (filtre.equals("remportee") && noCategorie >0) {
			requete = SELECT_ENCHERES_REMPORTEES_USER_CATEGORIE;
		}
		
		List<ArticleVendu> listeArticle = new ArrayList<ArticleVendu>();
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			
			PreparedStatement pst = conx.prepareStatement(requete);
			pst.setInt(1, user.getNoUtilisateur());
			if (noCategorie > 0) {
				pst.setInt(2, noCategorie);
			}
			
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();
			while (rs.next()) {
				ArticleVendu art = null;
				
				LocalDate date_debut_date = rs.getDate("date_debut_enchere").toLocalDate();
				LocalTime date_debut_time = rs.getTime("date_debut_enchere").toLocalTime();
				LocalDateTime date_debut = LocalDateTime.of(date_debut_date, date_debut_time);
				
				LocalDate date_fin_date = rs.getDate("date_fin_enchere").toLocalDate();
				LocalTime date_fin_time = rs.getTime("date_fin_enchere").toLocalTime();
				LocalDateTime date_fin = LocalDateTime.of(date_fin_date, date_fin_time);
			
				UtilisateurDAOJdbcImpl util = new UtilisateurDAOJdbcImpl();
				Utilisateur vendeur = util.selectByPseudo(rs.getString("pseudo"));
				CategorieDAOJdbcImpl e = new CategorieDAOJdbcImpl();
				Categorie cat = e.selectById(rs.getInt("no_categorie"));
				

				art = new ArticleVendu(
							rs.getInt("no_article"),
							rs.getString("nom_article"),
							rs.getString("description"),
							date_debut,
							date_fin,
							rs.getInt("prix_initial"),
							rs.getInt("montant_enchere"),
							rs.getString("etat_vente"),
							vendeur,
							cat,
							rs.getString("image")
						);

				PreparedStatement pstEnchere = conx.prepareStatement(SELECT_BY_ID_ENCHERES);
				pstEnchere.setInt(1, art.getNoArticle());
				pstEnchere.executeQuery();
				ResultSet rs2 = pstEnchere.getResultSet();
				//Si on trouve une enchère avec no_article=art.no_article
				
				if (rs2.next()) {
					LocalTime dateEnchereTime = rs2.getTime(3).toLocalTime();
					LocalDate dateEnchereDate = rs2.getDate(3).toLocalDate();
					LocalDateTime dateEnchere = LocalDateTime.of(dateEnchereDate, dateEnchereTime);
					Enchere enchere = new Enchere( art.getNoArticle(), dateEnchere, rs2.getInt("montant_enchere"), user, art);
					
					art.setEnchere(enchere);
				}
				listeArticle.add(art);
			}
			
			pst.close();
		} catch (SQLException e) {
			System.out.println("La selection des enchères de l'utilisateur "+user+" en base a échoué.");
			e.printStackTrace();
		}
		return listeArticle;
	}
	
	

	@Override
	public List<ArticleVendu> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<ArticleVendu> selectVentesUserEC(Utilisateur user) throws BusinessException {
		if (user == null) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.SELECT_ID_INCORRECT);
		}
		
		List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			PreparedStatement pst = conx.prepareStatement(SELECT_VENTES_USER_EC);
			pst.setInt(1, user.getNoUtilisateur());
			
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();
			
			while (rs.next()) {
				ArticleVendu art = null;
				
				LocalDate date_debut_date = rs.getDate("date_debut_enchere").toLocalDate();
				LocalTime date_debut_time = rs.getTime("date_debut_enchere").toLocalTime();
				LocalDateTime date_debut = LocalDateTime.of(date_debut_date, date_debut_time);
				
				LocalDate date_fin_date = rs.getDate("date_fin_enchere").toLocalDate();
				LocalTime date_fin_time = rs.getTime("date_fin_enchere").toLocalTime();
				LocalDateTime date_fin = LocalDateTime.of(date_fin_date, date_fin_time);
				
				UtilisateurDAOJdbcImpl util = new UtilisateurDAOJdbcImpl();
			
				
				CategorieDAOJdbcImpl e = new CategorieDAOJdbcImpl();
				Categorie cat = e.selectById(rs.getInt("no_categorie"));
				

				art = new ArticleVendu(
							rs.getInt("no_article"),
							rs.getString("nom_article"),
							rs.getString("description"),
							date_debut,
							date_fin,
							rs.getInt("prix_initial"),
							rs.getInt("prix_vente"),
							rs.getString("etat_vente"),
							user,
							cat,
							rs.getString("image")
						);

				PreparedStatement pstEnchere = conx.prepareStatement(SELECT_BY_ID_ENCHERES);
				pstEnchere.setInt(1, art.getNoArticle());
				pstEnchere.executeQuery();
				ResultSet rs2 = pstEnchere.getResultSet();
				//Si on trouve une enchère avec no_article=res.no_article
				if (rs2.next()) {
					LocalTime dateEnchereTime = rs2.getTime(3).toLocalTime();
					LocalDate dateEnchereDate = rs2.getDate(3).toLocalDate();
					LocalDateTime dateEnchere = LocalDateTime.of(dateEnchereDate, dateEnchereTime);
					
					Utilisateur acheteur = util.selectById(rs2.getInt("no_utilisateur"));
					
					Enchere enchere = new Enchere( art.getNoArticle(), dateEnchere, rs2.getInt("montant_enchere"), acheteur, art);
					
					art.setEnchere(enchere);
				}
				listeArticles.add(art);
			}
			
		} catch (SQLException e) {
			System.out.println("La selection des ventes en cours de l'utilisateur "+user+" en base a échoué.");
			e.printStackTrace();
		}
		
		return listeArticles;
	}
	
	@Override
	public List<ArticleVendu> selectByEtat(String etat, int noCategorie) throws BusinessException {
		if (etat == null) {
			BusinessException be = new BusinessException();
			be.ajouterCodeErreur(CodeResultatDAL.SELECT_ID_INCORRECT);
		}
		
		List<ArticleVendu>  res = new ArrayList<ArticleVendu>();
		
		try ( Connection conx = ConnectionProvider.getConnection() ) {
			PreparedStatement pst = null;
			if (noCategorie == 0) {
				pst = conx.prepareStatement(SELECT_ARTICLE_ENCHERE_BY_ETAT);
				pst.setString(1, etat);
			}
			else {
				pst = conx.prepareStatement(SELECT_ARTICLE_ENCHERE_BY_ETAT_CATEGORIE);
				pst.setString(1, etat);
				pst.setInt(2, noCategorie);
			}
			
			
			
			ResultSet rs = pst.executeQuery();
			 // exploitation du resultat
			 while (rs.next()) {

				
				LocalDate date_fin_date = rs.getDate("date_fin_enchere").toLocalDate();
				LocalTime date_fin_time = rs.getTime("date_fin_enchere").toLocalTime();
				LocalDateTime date_fin = LocalDateTime.of(date_fin_date, date_fin_time);
				
				UtilisateurDAOJdbcImpl util = new UtilisateurDAOJdbcImpl();
				Utilisateur user = util.selectByPseudo(rs.getString("pseudo"));
			
				
				EnchereDAOJdbcImpl e = new EnchereDAOJdbcImpl();
				Enchere ench = e.selectById(rs.getInt("no_article"));
				
				ArticleVendu art = new ArticleVendu(
							rs.getString("nom_article"),
							rs.getInt("prix_initial"),
							date_fin,
							user,							
							ench,
							rs.getString("etat_vente"),
							rs.getString("image"),
							rs.getInt("no_article")
						);

				if (art.getEnchere()== null) {
					art.setEnchere(VALEUR_DEFAUT_ENCHERE);
			
				}
				if (art.getImage()== null) {
					art.setImage(VALEUR_DEFAUT_STRING);
			
				}
				res.add(art);
	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	
	}
}
