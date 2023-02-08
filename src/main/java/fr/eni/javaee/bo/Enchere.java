package fr.eni.javaee.bo;

import java.time.LocalDateTime;

public class Enchere {

	// - - - - - - - - - - - - - - attributs - - - - - - - - - - - - - -
	private int noEnchere; // égal à noArticle, sa clé pirmaire en base
	private LocalDateTime dateEnchere;
	private int montantEnchere;
	private Utilisateur acheteur;
	private ArticleVendu article;

	// - - - - - - - - - - - - - - - - - - constructeurs - - - - - - - - 
	
	public Enchere(int noEnchere, LocalDateTime dateEnchere, int montant_enchere, Utilisateur acheteur, ArticleVendu vente) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montant_enchere;
		this.acheteur = acheteur;
		this.article = vente;
	}

	public Enchere() {
		super();
	}
	

	public Enchere(Utilisateur utilisateur, ArticleVendu article, LocalDateTime date_enchere, int montant_enchere) {
		this.acheteur = utilisateur;
		this.article = article;
		this.acheteur = utilisateur;

		this.montantEnchere = montant_enchere;
		
	}
	
	
	
	public Enchere(int noEnchere, LocalDateTime dateEnchere, int montant_enchere, Utilisateur acheteur) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montant_enchere;
		this.acheteur = acheteur;
	}

	// - - - - - - - - - - - - - - - - - - getters & setters - - - - - - -





	public Enchere(int montant) {
		this.montantEnchere=montant;
	}


	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchère(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public Utilisateur getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}

	public ArticleVendu getVente() {
		return article;
	}

	public void setVente(ArticleVendu vente) {
		this.article = vente;
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
		return "Enchere [dateEnchere=" + dateEnchere + ", montant_enchere=" + montantEnchere + ", acheteur=" + acheteur
				+ " ]";
	}

}
