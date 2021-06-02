package edu.m2i.tests;

import edu.m2i.entities.User;
import edu.m2i.service.UserService;
import edu.m2i.service.UserServiceImpl;
import edu.m2i.validation.ValidateUser;

public class TestMains {	

	public static void main(String[] args) {
		// Test connexion bdd		
		UserService userService = new UserServiceImpl();
		if (userService.authentifierUser("login", "mdp")) {
			// Si authentifier user ok
			System.out.println("Authentification OK");
			testAjouterUser(userService);
		} else {
			System.out.println("Authentification KO");
		}
		
	}

	private static void testAjouterUser(UserService userService) {
		ValidateUser validateUser = new ValidateUser();
		User user = new User("Chau", "Thanh", "test", "test");
		if (validateUser.verifChaineNonNull(user.getNom(), user.getPrenom(), user.getLogin(), user.getPassword())) {
			
			userService.inscrireUser(user);
			System.err.println("Ajout user OK");
		} else {
			System.out.println("User non valide");
		}
	}

}
