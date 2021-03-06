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
import de.telekom.sea2.ui.MenuInput;
import de.telekom.sea2.ui.MenuOutputAll;

public class SeminarApp {
	public void run(String[] args) throws ClassNotFoundException, SQLException  {

		PersonRepository personRepository = new PersonRepository();
		personRepository.dbInit();
				
//// SelectById
//		try {
//			Person person = personRepository.get(3);
//			String string = String.format("%s %s %s %s", person.getId(), person.getSalutation(), person.getFirstname(),
//					person.getLastname());
//			System.out.println(string);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//						
//		
//// DeleteById
//		try {
//	//		boolean result = personRepository.delete(11);  // ID 
//			boolean result = personRepository.delete(personRepository.maxId());  // ID 
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	
		
					
		
// Person in die Datenbank eintragen
//		String salutation=	"MR";
//		String firstName=	"Roland";
//		String lastName=	"Hoeppner";
//		Person person = new Person (salutation, firstName, lastName);
//		try {
//	
//			boolean result = personRepository.create(person);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	

		Person person = new Person();
		boolean result;	
		
		
/** 	CreateByPerson **/
		MenuInput menuInput = new MenuInput(personRepository);
		menuInput.inputPerson();		
		
		
		
/** Output All **/
		MenuOutputAll menuOutputAll = new MenuOutputAll(personRepository);
		menuOutputAll.outputAllPersons();
		
		
		

		
		
		
/** SelectAll  **/
		try {
			ArrayList<Person> personListAll = personRepository.getAll();
			for (int i = 0; i < personListAll.size(); i++) {
				person = (Person) personListAll.get(i);
				// System.out.println(person.getFirstname());
				String string = String.format("%s %s %s %s", person.getId(), person.getSalutation(),
						person.getFirstname(), person.getLastname());
	//			System.out.println(string);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}