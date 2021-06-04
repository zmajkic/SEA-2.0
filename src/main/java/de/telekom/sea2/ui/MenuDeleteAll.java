package de.telekom.sea2.ui;

import java.util.ArrayList;

import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;

public class MenuDeleteAll {

	private PersonRepository personRepository;

	public MenuDeleteAll(PersonRepository a_personRepository) {
		this.personRepository = a_personRepository;
	}

	/**
	 * SelectAll
	 * 
	 * @return
	 **/
	public void deleteAllPersons() {
		boolean result;
		try {
			result = personRepository.deleteAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
