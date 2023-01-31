package fr.eni.tpprisedenotes.exception;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Integer> codeErreurs;
	
	public BusinessException() {
		super();
		codeErreurs = new ArrayList<Integer>();
	}
	
	public BusinessException(String message) {
		super();
		codeErreurs = new ArrayList<Integer>();
	}
	public void ajouterCodeErreur(int code) {
		if ( !(this.codeErreurs.contains(code)) ) {
			codeErreurs.add(code);
		}
	}
	
	public List<Integer> getCodeErreurs() {
		return codeErreurs;
	}

}
