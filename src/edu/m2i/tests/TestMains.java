package edu.m2i.tests;

import com.mysql.jdbc.Connection;

import edu.m2i.connexion.ConnexionBdd;

public class TestMains {

	public static void main(String[] args) {
		// Test connexion bdd
		ConnexionBdd connexionBdd = new ConnexionBdd();
		Connection connexion = connexionBdd.connexion;
	}

}
