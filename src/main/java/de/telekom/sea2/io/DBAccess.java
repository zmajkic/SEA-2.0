package de.telekom.sea2.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;



public class DBAccess {	//	Class für die Abfrage des File mit username und userpass

	
	

	private String username;	//	Definition des String username
	private String userpass;	//	Definition des String userpass
	private final static String FILEPATH = "/Users/a298557/sea_eclipse_workspace/credentials";	//	Festlegung des Filepath für die Datei

	public DBAccess()  {
		try {
			List<String> lines = Files.readAllLines(Paths.get(FILEPATH));
			username = lines.get(0);	//	Zuweisung des Ergebnis aus dem Export des usernamen der Datei. Auslesen der ersten Zeile aus dem File
			userpass = lines.get(1);	//	Zuweisung des Ergebnis aus dem Export des userpass der Datei. Auslesen der zweiten Zeile aus dem File
	//		System.out.println(username);	//	Ausgabe username
	//		System.out.println(userpass);	//	Ausgabe userpass
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Quelle: https://www.educative.io/edpresso/reading-the-nth-line-from-a-file-in-java
	}
	
	public String getUsername() {
		return username;
	}

	public String getUserpass() {
		return userpass;
	}
	
	
	
	
	
	
	
	
//	FileReader fileReader;
//	BufferedReader bufferedReader;
//	public static String username;	//	Definition des String username
//	public static String userpass;	//	Definition des String userpass
//	private String filepath = "/home/sea5/eclipse-workspace/credentials";	//	Festlegung des Filepath für die Datei
//	
//	public DBAccess() throws Exception {
//		username = Username(filepath);	//	Zuweisung des Ergebnis aus dem Export des usernamen der Datei
//		userpass = Userpass(filepath);	//	Zuweisung des Ergebnis aus dem Export des userpass der Datei
//		System.out.println(username);	//	Ausgabe username
//		System.out.println(userpass);	//	Ausgabe userpass
//	}
//	
//	public String Username(final String filepath) throws Exception { // enthält Dateiname und Pfad
//		File file = new File(filepath); // java.io.File
//		fileReader = new FileReader(file); // Datei einlesen
//		bufferedReader = new BufferedReader(fileReader);
//		String username = Files.readAllLines(Paths.get(filepath)).get(0);	//	Auslesen der ersten Zeile aus dem File
//		// Quelle: https://www.educative.io/edpresso/reading-the-nth-line-from-a-file-in-java
//		return username;
//	}
//	public String Userpass(final String filepath) throws Exception { // enthält Dateiname und Pfad
//		File file = new File(filepath); // java.io.File
//		fileReader = new FileReader(file); // Datei einlesen
//		bufferedReader = new BufferedReader(fileReader);
//		String userpass = Files.readAllLines(Paths.get(filepath)).get(1);	//	Auslesen der zweiten Zeile aus dem File
//		// Quelle: https://www.educative.io/edpresso/reading-the-nth-line-from-a-file-in-java
//		return userpass;
	}

