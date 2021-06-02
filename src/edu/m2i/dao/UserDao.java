package edu.m2i.dao;

import edu.m2i.entities.User;

public interface UserDao {
	void addUserMock(User user);
	
	/**
	 * Ajourter un user dans la bdd
	 * @param user
	 */
	void addUser(User user);
	
	/**
	 * Recherche par login et mdp.
	 * @param login
	 * @param password
	 * @return
	 */
	User findUserByLoginPassword(String login, String password); 
}
