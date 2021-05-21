// **********************************
// *                                *
// * SeminarApp             *
// *                                *
// **********************************

package de.telekom.sea2;

import java.util.ArrayList;
import java.sql.SQLException;

import de.telekom.sea2.lookup.Salutation;
import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;

public class SeminarApp {
	public void run(String[] args) {

		PersonRepository personRepository = new PersonRepository();
		
		
		
		
		// SelectById
		try {
			personRepository.dbInit();
			Person person = personRepository.get(3);
			String string = String.format("%s %s %s %s", person.getId(), person.getSalutation(), person.getFirstname(),
					person.getLastname());
			System.out.println(string);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
		// DeleteById
		try {
			boolean result = personRepository.delete(11);  // ID 
		} catch (Exception e) {
			e.printStackTrace();
		}

		// DeleteById
		try {
			boolean result = personRepository.delete(12);  // ID 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// DeleteById
		try {
			boolean result = personRepository.delete(13);  // ID 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		/** 	CreateByPerson **/
		boolean result;
		long id =			11L;
		String salutation=	"MR";
		String firstName=	"Peter";
		String lastName=	"Hoeppner";
		Person person = new Person (id, salutation, firstName, lastName);
		try {
			result = personRepository.create(person);
			System.out.println("___________________________________________________________________");	
			System.out.println(result);
			System.out.println("___________________________________________________________________");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			long id1 = 12L;
			Person person1 = new Person();
			person1.setId(id1);
			person1.setSalutation(Salutation.OTHER);
			person1.setFirstname("Maxi");
			person1.setLastname("Mustermann");
			result = personRepository.create(person1);
			long id2 = 13L;
			Person person2 = new Person(id2,"MRS","Maxline","Mustermann");
			result = personRepository.create(person2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		
		
		
		
		
		
		
		
		
		// SelectAll
		try {
			ArrayList personListAll = personRepository.getAll();
			for (int i = 0; i < personListAll.size(); i++) {
				person = (Person) personListAll.get(i);
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