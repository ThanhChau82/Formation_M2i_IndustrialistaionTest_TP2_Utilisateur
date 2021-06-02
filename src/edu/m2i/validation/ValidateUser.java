package edu.m2i.validation;

public class ValidateUser {
	/**
	 * Tous les champs de type chaine doivent �tre non null
	 * @param chaines
	 * @return
	 */
	public boolean verifChaineNonNull(String... chaines) {
		boolean isNonNull = true;
		for (String string : chaines) {
			if (string != null && !string.isBlank()) {
				isNonNull = isNonNull && true;
			} else {
				isNonNull = isNonNull && false;
			}
		}
		return isNonNull;		
	} 
}
