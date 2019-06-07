package com.ibm.mra.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.ibm.mra.service.AccountServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
class AccountDaoTest {

AccountDaoImpl dao;
	
	@BeforeEach
	void metEveryTime() {
		dao = new AccountDaoImpl();
//		System.out.println("Runs for every test method called...");
	}

	@Test
	void test() {
		
		int expected = 463;
		int actual = dao.rechargeAccount("9823920123", 10);
		
		//assertEquals(expected, actual);
		
		assertAll(
				() -> assertEquals(expected, actual),
				() -> assertEquals(541, dao.rechargeAccount("9010210132", 20)),
				() -> assertEquals(662, dao.rechargeAccount("9010210133", 30))
				);
		//fail("Not yet implemented");
		
		
	}

}
