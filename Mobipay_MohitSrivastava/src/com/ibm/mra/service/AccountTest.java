package com.ibm.mra.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class AccountTest {
	
	AccountServiceImpl service;
	
	@BeforeEach
	void metEveryTime() {
		service = new AccountServiceImpl();
//		System.out.println("Runs for every test method called...");
	}

	@Test
	void test() {
		
		boolean expected = true;
		boolean actual = service.validateMobile("9823920123");
		
		//assertEquals(expected, actual);
		
		assertAll(
				() -> assertEquals(expected, actual),
				() -> assertEquals(false, service.validateMobile("12345")),
				() -> assertEquals(false, service.validateMobile("67890"))
				);
		//fail("Not yet implemented");
		
		
	}

}
