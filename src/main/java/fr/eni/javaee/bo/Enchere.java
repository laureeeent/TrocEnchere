package fr.eni.javaee.bo;

import java.time.LocalDateTime;

public class Enchere {

	// - - - - - - - - - - - - - - attributs - - - - - - - - - - - - - -

	private LocalDateTime dateEnchère;
	private float montant_enchere;
	private Utilisateur acheteur;
	private ArticleVendu vente;

	// - - - - - - - - - - - - - - - - - - constructeurs - - - - - - - - - - - - - -
	public Enchere(LocalDateTime dateEnchère, float montant_enchere, Utilisateur acheteur, ArticleVendu vente) {
		super();
		this.dateEnchère = dateEnchère;
		this.montant_enchere = montant_enchere;
		this.acheteur = acheteur;
		this.vente = vente;
	}

	public Enchere() {
		super();
	}

	// - - - - - - - - - - - - - - - - - - getters & setters - - - - - - - - - - - -

	public LocalDateTime getDateEnchère() {
		return dateEnchère;
	}

	public void setDateEnchère(LocalDateTime dateEnchère) {
		this.dateEnchère = dateEnchère;
	}

	public float getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(float montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public Utilisateur getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}

	public ArticleVendu getVente() {
		return vente;
	}

	public void setVente(ArticleVendu vente) {
		this.vente = vente;
	}

	// - - - - - - - - - - - - - - - - - - toString - - - - - - - - - - - -

	@Override
	public String toString() {
		return "Enchere [dateEnchère=" + dateEnchère + ", montant_enchere=" + montant_enchere + ", acheteur=" + acheteur
				+ ", vente=" + vente + "]";
	}

}