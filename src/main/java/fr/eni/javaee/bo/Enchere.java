package fr.eni.javaee.bo;

import java.time.LocalDateTime;

public class Enchere {

	// - - - - - - - - - - - - - - attributs - - - - - - - - - - - - - -
	private int noEnchere;
	private LocalDateTime dateEnchère;
	private int montant_enchere;
	private Utilisateur no_acheteur;
	private ArticleVendu no_article;

	// - - - - - - - - - - - - - - - - - - constructeurs - - - - - - - - 
	
	public Enchere(int noEnchere,LocalDateTime dateEnchère, int montant_enchere, Utilisateur acheteur, ArticleVendu vente) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchère = dateEnchère;
		this.montant_enchere = montant_enchere;
		this.no_acheteur = acheteur;
		this.no_article = vente;
	}

	public Enchere() {
		super();
	}
	
	public Enchere(int noUtilisateur, int noArticle, LocalDateTime dateEnchere, int enchereEnCours) {
		
	}
	
	public Enchere(Utilisateur utilisateur, ArticleVendu no_article, LocalDateTime date_enchere, int montant_enchere) {
		this.no_acheteur = no_utilisateur;
		this.no_article = no_article;
		this.no_acheteur = no_utilisateur;
		this.montant_enchere = montant_enchere;
		
	}
	// - - - - - - - - - - - - - - - - - - getters & setters - - - - - - -





	public Enchere(int montant) {
		this.montant_enchere=montant;
	}


	public LocalDateTime getDateEnchère() {
		return dateEnchère;
	}

	public void setDateEnchère(LocalDateTime dateEnchère) {
		this.dateEnchère = dateEnchère;
	}

	public int getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public Utilisateur getAcheteur() {
		return no_acheteur;
	}

	public void setAcheteur(Utilisateur acheteur) {
		this.no_acheteur = acheteur;
	}

	public ArticleVendu getVente() {
		return no_article;
	}

	public void setVente(ArticleVendu vente) {
		this.no_article = vente;
	}


	public int getNoEnchere() {
		return noEnchere;
	}

	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}

	// - - - - - - - - - - - - - - - - - - toString - - - - - - - - - - - -

	
	

	@Override
	public String toString() {
		return "Enchere [dateEnchère=" + dateEnchère + ", montant_enchere=" + montant_enchere + ", acheteur=" + no_acheteur
				+ ", vente=" + no_article + "]";
	}

}
