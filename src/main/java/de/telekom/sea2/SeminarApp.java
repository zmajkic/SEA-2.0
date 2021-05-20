// **********************************
// *                                *
// * SeminarApp             *
// *                                *
// **********************************



package de.telekom.sea2;
import java.util.ArrayList;
import java.sql.SQLException;

import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;

public class SeminarApp {
	public void run(String[] args)  {
		
	
		
		
		PersonRepository personRepository = new PersonRepository();
		try {
			personRepository.dbInit();
			Person person = personRepository.get(1);
			String string = String.format("%s %s %s %s",
					person.getId(),
					person.getSalutation(),
					person.getFirstname(),
					person.getLastname()
					);
			System.out.println(string);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		PersonRepository personRepositoryAll = new PersonRepository();
		try {
			personRepositoryAll.dbInit();
			ArrayList personListAll = personRepositoryAll.getAll();
	
			for (int i = 0; i < personListAll.size(); i++) {
			
				Person person = (Person)personListAll.get(i);
				
				
		//		System.out.println(person.getFirstname());
				
				
			String string = String.format("%s %s %s %s",
					person.getId(),
					person.getSalutation(),
					person.getFirstname(),
					person.getLastname()
					);
			
			
			
			System.out.println(string);
			
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}