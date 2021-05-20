// **********************************
// *                                *
// * Create Read Update Delete      *
// *         Methoden               *
// *                                *
// *                                *
// **********************************

package de.telekom.sea2.persistence;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.telekom.sea2.model.Person;

public class PersonRepository {               // Klasse öffnen

// DB Parameter	
	final static String DRIVER = "org.mariadb.jdbc.Driver";    // DRIVER definieren für MariaDB
	final static String URL = "jdbc:mysql://localhost:3306/seadb?user=seauser&password=seapass";

	Connection connection;                     // variable connection Typ java.sql.Connecton 
	Statement statement;                       // variable  statement Typ java.sql.Statement sql statement
	ResultSet resultSet;                       // variable  resultset Typ java.sql.ResultSet 

// DB-Init
	public void dbInit() throws ClassNotFoundException, SQLException {   // Methode öffnen
		Class.forName(DRIVER);	                  // DRIVER = Argument  Datenbank Treiber laden
		connection = DriverManager.getConnection(URL); //
	}                                         // Methode schließen
	
	
// Sichbarkeit Rückgabewert Methodenname (Parameter) {Methoden-Funktion}
	public boolean create(Person person)  {   // (Datentyp Person Variable person)
		return false;
	}
// getPerson über Id
	public Person get(long id) throws SQLException  {             // Person abfrage anhand der ID 
		statement = connection.createStatement();                 // DB connection 
		resultSet = statement.executeQuery("select * from personen where id =" + id);  // 
		
		while (resultSet.next()) {
			System.out.println("ID       : " + resultSet.getInt(1)); // ID
			System.out.println("Anrede   : " + resultSet.getInt(2)); // Anrede
			System.out.println("Vorname  : " + resultSet.getString(3)); // Vorname
			System.out.println("Nachname : " + resultSet.getString(4)); // Nachname
			System.out.println(""); // Leer
		}
		
		return null;				
		
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