package de.telekom.sea2.ui;


import java.util.Scanner;

import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;

public class MenuOutputOne {

	private PersonRepository personRepository;

	public MenuOutputOne (PersonRepository a_personRepository) {
		this.personRepository = a_personRepository;
	}

/**  SelectOnePersonByID 	 **/
	
	public void outputPerson() {
		Scanner scanner = new Scanner(System.in);	// muss nur einmal aufgerufen werden
		System.out.print("Suche ID eingeben: ");
		String stringID = scanner.nextLine();
		int id = Integer.parseInt(stringID);
		
		try {
			Person person = personRepository.get(id);
			String string = String.format("%s %s %s %s", person.getId(), person.getSalutation(), person.getFirstname(),
					person.getLastname());
			System.out.println(string);

			
		} catch (NullPointerException ee) {
			System.out.println("ID nicht vergeben!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
