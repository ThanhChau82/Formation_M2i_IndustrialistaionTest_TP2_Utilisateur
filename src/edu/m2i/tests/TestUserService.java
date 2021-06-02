package edu.m2i.tests;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import edu.m2i.dao.UserDao;
import edu.m2i.entities.User;
import edu.m2i.service.UserServiceImpl;

public class TestUserService {
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Mock
	private UserDao userDaoMock;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);		
	}
	
	@Test
	public void testAddUserOK() {
		User user = new User("Chau", "Thanh", "login", "mdp");
		userServiceImpl.inscrireUserMock(user);
		verify(userDaoMock, times(1)).addUserMock(user);
	}
	
}
