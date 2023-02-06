package fr.eni.javaee.bo;

import java.time.LocalDateTime;

public class Enchere {

	// - - - - - - - - - - - - - - attributs - - - - - - - - - - - - - -
	private int noEnchere; // égal à noArticle, sa clé pirmaire en base
	private LocalDateTime dateEnchère;
	private int montant_enchere;
	private Utilisateur acheteur;
	private ArticleVendu article;

	// - - - - - - - - - - - - - - - - - - constructeurs - - - - - - - - 
	
	public Enchere(int noEnchere, LocalDateTime dateEnchère, int montant_enchere, Utilisateur acheteur, ArticleVendu vente) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchère = dateEnchère;
		this.montant_enchere = montant_enchere;
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
		return "Enchere [dateEnchère=" + dateEnchère + ", montant_enchere=" + montant_enchere + ", acheteur=" + acheteur
				+ ", vente=" + article + "]";
	}

}
