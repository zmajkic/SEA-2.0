// **********************************
// *                                *
// * Ruft SeminarApp auf            *
// *                                *
// **********************************


package de.telekom.sea2;

import java.sql.SQLException;

class Main {
	public static void main(String[] args) {        // pom.xml -> 	<mainClass>de.telekom.sea-2.0.Main</mainClass>
//		SeminarApp seminarApp = new SeminarApp();   // erzeugen der Objekt-Instanz der SeminarApp
//		 seminarApp.run(args);						// run Methode aus der SeminarApp Klasse
		
		
		
		
		SeminarApp seminarApp = new SeminarApp();	// erzeugt Objekt-Instanz mit der SeminarApp
		try {
			seminarApp.run(args);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}
}