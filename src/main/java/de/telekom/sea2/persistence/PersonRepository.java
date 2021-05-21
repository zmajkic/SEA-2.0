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
import java.sql.PreparedStatement;
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
	public boolean create(Person person) throws SQLException  {   // (Datentyp Person Variable person)
		PreparedStatement preparedStatement = 
				connection.prepareStatement("insert into personen (ID, ANREDE, VORNAME, NACHNAME) values (?,?,?,?)");
		
		long id = person.getId();
		Salutation salutation = person.getSalutation();  //person.getSalutation().toByte();
		byte salutationByte = salutation.toByte();
		String firstname = person.getFirstname();
		String lastname = person.getLastname();
	
		preparedStatement.setLong(1, id);
		preparedStatement.setByte(2, salutationByte);
		preparedStatement.setString(3, firstname);
		preparedStatement.setString(4, lastname);
		
		boolean result = preparedStatement.execute();
		return result;
	}
	
	
	
	


	public boolean update(Person person) throws SQLException  {   //   
			PreparedStatement preparedStatement = 
					connection.prepareStatement("update personen set VORNAME=?, NACHNAME=? WHERE ID =?");
			
			long id = person.getId();
			Salutation salutation = person.getSalutation();  //person.getSalutation().toByte();
			byte salutationByte = salutation.toByte();
			String firstname = person.getFirstname();
			String lastname = person.getLastname();
		
			preparedStatement.setLong(3, id);
//			preparedStatement.setByte(2, salutationByte);
			preparedStatement.setString(1, firstname);
			preparedStatement.setString(2, lastname);
			
			boolean result = preparedStatement.execute();
			return result;
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
	
	
	
	
	
		
	
	
	
/** Personen löschen mit Person  **/
	public boolean delete(Person person) throws SQLException  {   //   
		long id = person.getId();	
		return delete(id);                    // return boolean von Methode id (true false)
	}

/** Personen löschen mit Person ID **/	
	public boolean delete(long id) throws SQLException  {         //   
		statement = connection.createStatement();
		boolean result = statement.execute("delete from personen where id=" + id);
		return result;				 	      // 
	}
	
	
	
	
	
	public boolean deleteAll()  {             //   
		return false;				 	      // 
	}
}    // Klasse schließen