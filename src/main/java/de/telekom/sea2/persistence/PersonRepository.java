// **********************************
// *                                *
// * Create Read Update Delete      *
// *         Methoden               *
// *                                *
// *                                *
// **********************************

package de.telekom.sea2.persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import de.telekom.sea2.model.Person;

public class PersonRepository {               // Klasse öffnen

// DB 	
	final static String DRIVER = "org.mariadb.jdbc.Driver";    // DRIVER definieren für MariaDB
	final static String URL = "jdbc:mysql://localhost:3306/seadb?user=seauser&password=seapass";

	Connection connection;

	public void dbInit() throws ClassNotFoundException, SQLException {   // Methode öffnen
		Class.forName(DRIVER);	                  // DRIVER = Argument  Datenbank Treiber laden
		connection = DriverManager.getConnection(URL); //
		
	}                                         // Methode schließen
	
	
	
	
// Sichbarkeit Rückgabewert Methodenname (Parameter) {Methoden-Funktion}
	public boolean create(Person person)  {   // (Datentyp Person Variable person)
		return false;
	}
	
	public Person get(long id)  {             // Person abfrage anhand der ID 
		return null;						  //
	}
	
// Sichbarkeit Rückgabewert Methodenname 
	public Person[] getAll()  {               // rückgabe Array[] mit (*) allen Werten 
		return null;						  //
	}

	public boolean update(Person person)  {   //   
			return false;				 	  // 
	}

	public boolean delete(Person person)  {   //   
		long id = person.getId();	
		return delete(id);                    // return boolean von Methode id (true false)
	}
	
	public boolean delete(long id)  {         //   
		return false;				 	      // 
	}
	
	public boolean deleteAll()  {             //   
		return false;				 	      // 
	}
}    // Klasse schließen