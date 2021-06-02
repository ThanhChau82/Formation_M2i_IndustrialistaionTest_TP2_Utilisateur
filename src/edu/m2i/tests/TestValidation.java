package edu.m2i.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.m2i.validation.ValidateUser;

public class TestValidation {
	private ValidateUser validateUser;
	
	@Before
	public void init() {
		validateUser = new ValidateUser();
	}
	
	@Test
	public void testVerifChaineNonNullOK() {
		assertTrue(validateUser.verifChaineNonNull("test", "test1", "test2"));
	}
	
	@Test
	public void testVerifChaineNonNullKO() {
		assertFalse(validateUser.verifChaineNonNull("test", "test1", null));
	}
}
