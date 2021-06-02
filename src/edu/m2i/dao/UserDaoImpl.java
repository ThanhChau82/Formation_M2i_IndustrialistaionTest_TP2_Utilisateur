package edu.m2i.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import edu.m2i.connexion.ConnexionBdd;
import edu.m2i.entities.User;

public class UserDaoImpl implements UserDao{
	private ConnexionBdd connexionBdd =  new ConnexionBdd();

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserByLoginPassword(String login, String password) {
		return null;
	}

}
