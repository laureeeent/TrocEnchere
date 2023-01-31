package fr.eni.javaee.bo;

public class Retrait {

	// - - - - - - - - - - - - - - attributs - - - - - - - - - - - - - -

	private String rue;
	private String codePostal;
	private String ville;
	private int noArticleVendu;

	// - - - - - - - - - - - - - - - - - - constructeurs - - - - - - - - - - - - - -
	
	public Retrait(String rue, String codePostal, String ville, int noArticleVendu) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.noArticleVendu = noArticleVendu;
	}

	public Retrait() {
		super();
	}

	// - - - - - - - - - - - - - - - - - - getters & setters - - - - - - - - - - - -

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getNoArticleVendu() {
		return noArticleVendu;
	}

	public void setNoArticleVendu(int noArticleVendu) {
		this.noArticleVendu = noArticleVendu;
	}

	// - - - - - - - - - - - - - - - - - - toString - - - - - - - - - - - -
	@Override
	public String toString() {
		return "Retrait [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", noArticleVendu="
				+ noArticleVendu + "]";
	}
}
