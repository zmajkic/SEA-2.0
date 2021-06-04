package de.telekom.sea2.ui;

import java.sql.SQLException;
import java.util.Scanner;

import de.telekom.sea2.lookup.Salutation;
import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;

public class MenuDeleteOne {

	private PersonRepository personRepository;

	public MenuDeleteOne(PersonRepository a_personRepository) {
		this.personRepository = a_personRepository;
	}

// Löschen einer einzutragenden Person
	public void deletePerson() throws ClassNotFoundException, SQLException {
		boolean result = false;
		Person person = new Person();

		Scanner scanner = new Scanner(System.in); // muss nur einmal aufgerufen werden
		System.out.print("ID zum löschen eingeben: ");
		String stringID = scanner.nextLine();
		int id = Integer.parseInt(stringID);

		try {
			person = personRepository.get(id);
			String string = String.format("%s %s %s %s", person.getId(), person.getSalutation(), person.getFirstname(),
					person.getLastname());
			System.out.println(string);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			result = personRepository.delete(id);
		} catch (SQLException ee) {

			ee.printStackTrace();
		}
		;
		if (result == true) {
			System.out.println("Teilnehmer wurde erfolgreich gelöscht!");
		} else {
			System.out.println("Teilnehmer wurde nicht gelöscht!");
		}

	}
}
