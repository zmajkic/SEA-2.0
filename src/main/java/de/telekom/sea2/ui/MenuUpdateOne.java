package de.telekom.sea2.ui;

import java.sql.SQLException;
import java.util.Scanner;

import de.telekom.sea2.lookup.Salutation;
import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;

public class MenuUpdateOne {

	private PersonRepository personRepository;

	public MenuUpdateOne(PersonRepository a_personRepository) {
		this.personRepository = a_personRepository;
	}

// Update einer einzutragenden Person
	public void updatePerson() throws ClassNotFoundException, SQLException {
		boolean result = false;
		Person person = new Person();

		Scanner scanner = new Scanner(System.in); // muss nur einmal aufgerufen werden
		System.out.print("ID zum updaten eingeben: ");
		String stringID = scanner.nextLine();
		int id = Integer.parseInt(stringID);

		try {

			person = personRepository.get(id);
			String string = String.format("%s %s %s %s", person.getId(), person.getSalutation(), person.getFirstname(),
					person.getLastname());
			System.out.println(string);

		} catch (NullPointerException ee) {
			System.out.println("ID nicht vergeben!");
		} catch (Exception e) {

			e.printStackTrace();

		}

		// person.setId(id);

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
			result = personRepository.update(person); // ??? Ohne 'new' -> static ???
		} catch (SQLException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}
		;
		if (result == true) {
			System.out.println("Teilnehmer wurde erfolgreich aktualisiert!");
		} else {
			System.out.println("Teilnehmer wurde nicht aktualisiert!");
		}

	}
}
