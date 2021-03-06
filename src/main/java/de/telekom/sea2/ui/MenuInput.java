package de.telekom.sea2.ui;

import java.sql.SQLException;
import java.util.Scanner;

import de.telekom.sea2.lookup.Salutation;
import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;

public class MenuInput {

	private PersonRepository personRepository;

	public MenuInput(PersonRepository a_personRepository) {
		this.personRepository = a_personRepository;
	}

	// Eingabe einer einzutragenden Person
	public void inputPerson() throws ClassNotFoundException, SQLException {
		boolean result = false;
		Person person = new Person();

		Scanner scanner = new Scanner(System.in); // muss nur einmal aufgerufen werden
		System.out.print("Anrede eingeben: ");

		String salutation;
		do {
			System.out.println("Anrede eingeben(MR/MRS/OTHER/ABBRUCH): ");
			salutation = scanner.nextLine();
			System.out.println(salutation);

			if (!Salutation.isOk(salutation) && !salutation.equals("ABBRUCH")) {
				System.out.println("Falsche Eingabe... nur MR/MRS/OTHERS/ABBRUCH erlaubt");
			}

			if (salutation.equals("ABBRUCH")) {
				break;
			}

		} while (!Salutation.isOk(salutation));

		if (salutation.equals("ABBRUCH")) {
			return;
		}

		person.setSalutation(Salutation.fromString(salutation));
		System.out.println("Vorname eingeben:");
		person.setFirstname(scanner.nextLine());
		System.out.println("Nachname eingeben:");
		person.setLastname(scanner.nextLine());
		try {
			result = personRepository.create(person); // ??? Ohne 'new' -> static ???
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		if (result == true) {
			System.out.println("Teilnehmer wurde erfolgreich angelegt.");
		} else {
			System.out.println("Teilnehmer wurde nicht angelegt!");
		}

		
	}

}