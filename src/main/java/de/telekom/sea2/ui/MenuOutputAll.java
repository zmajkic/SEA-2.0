package de.telekom.sea2.ui;

import java.util.ArrayList;

import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;

public class MenuOutputAll {


	private PersonRepository personRepository;

	public MenuOutputAll (PersonRepository a_personRepository) {
		this.personRepository = a_personRepository;
	}
	
	
	
	
/** SelectAll  
 * @return **/
	public void outputAllPersons () {
		try {
			ArrayList<Person> personListAll = personRepository.getAll();
			for (int i = 0; i < personListAll.size(); i++) {
				Person person = (Person) personListAll.get(i);
				// System.out.println(person.getFirstname());
				String string = String.format("%s %s %s %s", person.getId(), person.getSalutation(),
						person.getFirstname(), person.getLastname());
				System.out.println(string);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
	
	

