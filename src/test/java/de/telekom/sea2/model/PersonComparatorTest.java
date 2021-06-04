package de.telekom.sea2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.telekom.sea2.lookup.Salutation;

public class PersonComparatorTest {

	private PersonComparator cut; // class under test

	@BeforeEach // diese Methode for jedem test ausführen
	void setup() {
		cut = new PersonComparatorImpl();
	}

	@Test
	void compare_test() {

		// Arrange
		Person person1 = new Person(Salutation.MR,"Hans","Meiser");
		Person person2 = new Person(Salutation.MR,"Hans","Meiser");

		// Act
		int ergebnis = cut.compare(person1, person2);
		System.out.println(ergebnis);
		// Assert
		assertEquals(0, ergebnis);
	}
	
	
	
	@Test
	void compare_less_test() {

		// Arrange
		Person person1 = new Person(Salutation.MR,"Hans","Meiser");
		Person person2 = new Person(Salutation.MR,"Hans","Neubauer");

		// Act
		int ergebnis = cut.compare(person1, person2);
		System.out.println(ergebnis);
		// Assert
		assertEquals(-1, ergebnis);
	}
	
	
	@Test
	void compare_greater_test() {

		// Arrange		
		Person person1 = new Person(Salutation.MR,"Hans","Neubauer");
		Person person2 = new Person(Salutation.MR,"Hans","Meiser");

		// Act
		int ergebnis = cut.compare(person1, person2);
		System.out.println(ergebnis);
		// Assert
		assertEquals(1, ergebnis);
	}

	
	
	@Test
	void compare_nongreater_test() {

		// Arrange
		Person person1 = new Person(Salutation.MR,"Hans","Muster");
		Person person2 = new Person(Salutation.MR,"Hans","Mustermann");

		// Act
		int ergebnis = cut.compare(person1, person2);
		System.out.println(ergebnis);
		// Assert
		assertEquals(-1, ergebnis);
	}
	
	
	

	@AfterEach
	void teardown() {
		cut = null;

	}

}
