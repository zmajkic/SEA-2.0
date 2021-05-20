// **********************************
// *                                *
// * Ruft SeminarApp auf            *
// *                                *
// **********************************


package de.telekom.sea2;

class Main {
	public static void main(String[] args) {        // pom.xml -> 	<mainClass>de.telekom.sea-2.0.Main</mainClass>
		SeminarApp seminarApp = new SeminarApp();   // erzeugen der Objekt-Instanz der SeminarApp
		seminarApp.run(args);						// run Methode aus der SeminarApp Klasse
	}
}