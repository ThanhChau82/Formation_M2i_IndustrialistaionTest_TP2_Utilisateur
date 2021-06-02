package edu.m2i.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import edu.m2i.connexion.ConnexionBdd;
import edu.m2i.entities.User;

public class UserDaoImpl implements UserDao{
	private ConnexionBdd connexionBdd =  new ConnexionBdd();
	
	@Override
	public void addUserMock(User user) {
		System.out.println("User " + user.toString() + " est ajouté avec succès");		
	}

	@Override
	public void addUser(User user) {		
		Connection connexion = connexionBdd.connexion;
		
		try {
			PreparedStatement prepareStatement = connexion.prepareStatement(
					"INSERT INTO `user`(`id`, `nom`, `prenom`, `login`, `password`) VALUES ('" +		
					user.getNom() + "', '" +
					user.getPrenom() + "', '" +
					user.getLogin() + "', '" +
					user.getPassword() + ")");
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
	public User findUserByLoginPassword(String login, String password) {
		return null;
	}
}
