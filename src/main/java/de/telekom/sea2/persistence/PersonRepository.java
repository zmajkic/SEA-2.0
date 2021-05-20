// **********************************
// *                                *
// * Create Read Update Delete      *
// *         Methoden               *
// *                                *
// *                                *
// **********************************

package de.telekom.sea2.persistence;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.telekom.sea2.lookup.Salutation;
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
		connection = DriverManager.getConnection(URL); //   bei Methodenaufruf dbInit -> DB connection
	}                                         // Methode schließen
	
	
// Sichbarkeit Rückgabewert Methodenname (Parameter) {Methoden-Funktion}
	public boolean create(Person person)  {   // (Datentyp Person Variable person)
		return false;
	}
	
// getPerson über Id
	public Person get(long id) throws SQLException  {             // Person abfrage anhand der ID 
		statement = connection.createStatement();                 // Kanal erzeugen vom DB statement 
		resultSet = statement.executeQuery("select * from personen where id =" + id);  // 
		if (resultSet.next()){
			Person person = new Person(
					resultSet.getLong(1),
					Salutation.fromByte(resultSet.getByte(2)),
					resultSet.getString(3),
					resultSet.getString(4));
			return person;	
		} else {
			return null;
		}
	}
	
	
	
	
	
	
	public ArrayList getAll() throws SQLException {
		ArrayList arrayList = new ArrayList();
		statement = connection.createStatement();

		resultSet = statement.executeQuery("select * from personen");
		while (resultSet.next()) {
			
			Person person = new Person(resultSet.getLong(1), Salutation.fromByte(resultSet.getByte(2)), // konvertierung
					resultSet.getString(3), resultSet.getString(4));									// der Byte in
					arrayList.add(person);
		}
			return arrayList;
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