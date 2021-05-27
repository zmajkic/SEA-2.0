package de.telekom.sea2.ui;

import java.sql.SQLException;
import java.util.Scanner;

import de.telekom.sea2.lookup.Salutation;
import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;

public class MenuInput {

	private PersonRepository personRepository;

	public MenuInput (PersonRepository a_personRepository) {
		this.personRepository = a_personRepository;
	}
	
	// Eingabe einer einzutragenden Person
	public void inputPerson() throws ClassNotFoundException, SQLException {
		boolean result = false;
		Person person = new Person();
//		System.out.println(person.getId());	//
		Scanner scanner = new Scanner(System.in);	// muss nur einmal aufgerufen werden
		System.out.print("Anrede eingeben: ");
		try {
			person.setSalutation(Salutation.fromString(scanner.nextLine())); // Anrede.fromString() nicht nötig wegen import
		}
		catch (Exception e) {
			System.out.println("Falsche Eingabe... nur FRAU/HERR/DIVERS erlaubt");
			return;
		}
		System.out.println(person.getSalutation()); //
		System.out.print("Vorname eingeben: ");
		person.setFirstname(scanner.nextLine());
		System.out.println(person.getFirstname());	//
		System.out.print("Nachname eingeben: ");
		person.setLastname(scanner.nextLine());
		System.out.println(person.getLastname());	//
//		PersonRepository personRepository = new PersonRepository();	// Wird ersetzt durch Konstruktor mit Übergabe
//		personRepository.dbInit();									// Wird ersetzt durch Konstruktor mit Übergabe
		try {
			result = personRepository.create(person);	// Ruft create() auf mit der übergebenen personRepository
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		if (result == true) {
			System.out.println("Teilnehmer wurde erfolgreich angelegt.");
		} else {
			System.out.println("Teilnehmer wurde nicht angelegt!");
		}
	}
	
}