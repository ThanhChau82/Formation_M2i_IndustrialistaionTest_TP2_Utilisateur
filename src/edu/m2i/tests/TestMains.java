package edu.m2i.tests;

import com.mysql.jdbc.Connection;

import edu.m2i.connexion.ConnexionBdd;
import edu.m2i.entities.User;
import edu.m2i.validation.ValidateUser;

public class TestMains {

	public static void main(String[] args) {
		// Test connexion bdd
		ConnexionBdd connexionBdd = new ConnexionBdd();
		Connection connexion = connexionBdd.connexion;
		
		User user = new User("Chau", "Thanh", "login", "mdp");
		ValidateUser validateUser = new ValidateUser();
		if (validateUser.verifChaineNonNull(user.getNom(), user.getPrenom(), user.getLogin(), user.getPassword())) {
			System.out.println("User valide");
		} else {
			System.out.println("User non valide");
		}
	}

}
