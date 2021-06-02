package edu.m2i.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import edu.m2i.connexion.ConnexionBdd;
import edu.m2i.entities.User;

public class UserDaoImpl implements UserDao{
	private ConnexionBdd connexionBdd;
	
	@Override
	public void addUserMock(User user) {
		System.out.println("User " + user.toString() + " est ajouté avec succès");		
	}

	@Override
	public void addUser(User user) {	
		connexionBdd =  new ConnexionBdd();
		Connection connexion = connexionBdd.connexion;
		
		try {
			PreparedStatement prepareStatement = connexion.prepareStatement(
					"INSERT INTO `user`(`nom`, `prenom`, `login`, `password`) VALUES ('" +		
					user.getNom() + "', '" +
					user.getPrenom() + "', '" +
					user.getLogin() + "', '" +
					user.getPassword() + "')");
			prepareStatement.executeUpdate();
			System.out.println("User " + user.toString() + " est ajouté avec succès");
			connexion.close();
			System.out.println("Connexion user fermée");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean findUserByLoginPassword(String login, String password) {		
		boolean isAuthentificationOK = false;
		connexionBdd =  new ConnexionBdd();
		Connection connexion = connexionBdd.connexion;
		
		try {
			PreparedStatement prepareStatement = connexion.prepareStatement(
					"SELECT * FROM `user` " +
					"WHERE login = '" + login + "' AND password = '" + password + "'");
			ResultSet resultat = prepareStatement.executeQuery();
			if (resultat.next()) {
				isAuthentificationOK = true;
				System.out.println("Authentification OK");
				connexion.close();
				System.out.println("Connexion authentification fermée");
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isAuthentificationOK;
	}
}
