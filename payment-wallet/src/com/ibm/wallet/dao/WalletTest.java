package com.ibm.wallet.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_CLASS)
class WalletTest {
	
	WalletDao waldao;

	
	@BeforeEach
	void metEveryTime() {
		waldao = new WalletDao();
//		System.out.println("Runs for every test method called...");
	}
	
	
	@Test
	void test() {
		
		boolean expected = true;
		boolean actual = waldao.withdraw(42601713, 20);
		
		//assertEquals(expected, actual);
		
		assertAll(
				() -> assertEquals(expected, actual),
				() -> assertEquals(true, waldao.withdraw(38050067, 40)),
				() -> assertEquals(true, waldao.withdraw(42601713, 30))
				);
		
		
		//fail("Not yet implemented");
	}

}
