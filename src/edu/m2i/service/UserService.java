package edu.m2i.service;

import edu.m2i.entities.User;

public interface UserService {
	/**
	 * Inscription
	 * @param user
	 */
	void inscrireUser(User user);
	
	/**
	 * Authentification
	 * @param login
	 * @param password
	 * @return
	 */
	boolean authentifierUser(String login, String password);
	
	/**
	 * Consultation
	 * @param user
	 */
	void consulterUser(User user);
}
