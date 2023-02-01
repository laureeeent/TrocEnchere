package fr.eni.javaee.bo;

import java.util.List;

public class Categorie {

	// - - - - - - - - - - - - - - attributs - - - - - - - - - - - - - -
	private int noCategorie;
	private String libelle;
	private List<ArticleVendu> articlesVendusParCategorie;

	// - - - - - - - - - - - - - - - - - - constructeurs - - - - - - - - - - - - - -

	public Categorie() {
		super();
	}

	public Categorie(int noCategorie, String libelle, List<ArticleVendu> articlesVendusParCategorie) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
		this.articlesVendusParCategorie = articlesVendusParCategorie;
	}

		public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}
	// - - - - - - - - - - - - - - - - - - getters & setters - - - - - - - - - - - -



	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<ArticleVendu> getArticlesVendusParCategorie() {
		return articlesVendusParCategorie;
	}

	public void setArticlesVendusParCategorie(List<ArticleVendu> articlesVendusParCategorie) {
		this.articlesVendusParCategorie = articlesVendusParCategorie;
	}

	
	// - - - - - - - - - - - - - - - - - - toString - - - - - - - - - - - -

	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + ", articlesVendusParCategorie="
				+ articlesVendusParCategorie + "]";
	}
}
