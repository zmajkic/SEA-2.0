package de.telekom.sea2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {

	private Person cut; // class under test

	
	
	@BeforeEach // diese Methode for jedem test ausführen
	void setup() {
		cut = new Person();
	}

	
	@Test
	void setFirstname_test() {
//	fail();
//	Assertions.fail();
	
		
	//Arrange
	cut.setFirstname("Baharak");
	//A cc-   aaassasdqwerttgtzzg	1237hhhjxdcfcccfüct
	var result = cut.getFirstname();
	//Assert
		assertEquals("Baharak", result);
	
	}



	
	@AfterEach
	void teardown() {
		cut = null;

	}

}
