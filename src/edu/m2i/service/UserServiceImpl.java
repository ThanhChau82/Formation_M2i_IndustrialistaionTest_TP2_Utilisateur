package edu.m2i.service;

import edu.m2i.dao.UserDao;
import edu.m2i.dao.UserDaoImpl;
import edu.m2i.entities.User;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();	
	
	@Override
	public void inscrireUserMock(User user) {
		userDao.addUserMock(user);		
	}

	@Override
	public void inscrireUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public boolean authentifierUser(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void consulterUser(User user) {
		// TODO Auto-generated method stub
		
	}

	

}
