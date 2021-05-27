package de.telekom.sea2.ui;

import java.util.Scanner;

public class Menu {
	
	boolean listempty = true;
	private String result;
	
	Scanner scanner = new Scanner(System.in); // Initialisierung Scanner (Eingabe)
	
	// Zeigt die Menue-Auswahl an
	public void showMenu() {
		System.out.println("************ Menü  **************");
		System.out.println("* 1. Person anlegen              *");
		if (!(listempty)) {											// Prüfen ob Liste leer
			System.out.println("* 2. Person löschen              *");
			System.out.println("* 3. Person umbenennen           *");	
//			System.out.println("* 4. Person suchen               *");
			System.out.println("* 5. Personenliste anzeigen      *");
			System.out.println("* 6. Personenliste löschen       *");
			System.out.println("* 7. Testliste erzeugen          *");
		}		
//		System.out.println("* 8. Liste in Datei schreiben    *");
//		System.out.println("* 9. Liste von Datei einlesen    *");
		System.out.println("* Q. Eingabe verlassen           *");
		System.out.println("**********************************");
		System.out.println("* Bitte wählen Sie aus!          *");
		System.out.println("* [1, 2, 3, 4, 5, 6, 7, Q]       *");
		System.out.println("*********************************");
	}
	
	// Menueauswahl
	public void checkMenu(String input) { // privat - case Evaluierung und Ausfuehrungsaufruf
		switch (input) {
		case "1":
			System.out.println("Du hast 1 Person anlegen gewählt!");
//			MenuInput menuInput = new MenuInput(personRepository);
//			menuInput.inputPerson(); // Person anlegen
			break;
		case "2":
			System.out.println("Du hast 2 Person löschen gewählt!");
//			removePerson(); // Person löschen
			break;
		case "3": 
			System.out.println("Du hast 3 Person umbenennen gewählt!"); 
//	 		renamePerson(); // Person umbenennen 
	 		break;
//		case "4":
//			System.out.println("Du hast 4 Personensuche gewählt!");
//			inputsearch(); // Vornamensuche und Ergebnis anzeigen
//			break;
		case "5":
			System.out.println("Du hast 5 Personenliste anzeigen gewählt!");
//			listAllPersons(); // Personenliste anzeigen
			break;
		case "6":
			System.out.println("Du hast 6 Personenliste löschen gewählt!");
//			removeAll(); // Personenliste löschen
			break;
		case "7":
			System.out.println("Du hast 7 Testliste erzeugen gewählt!");
//			testListe(); // Test-Personenliste erstellen
			break;
		case "Q":
			System.out.println("Du hast Q / beenden gewählt"); 
			break;	// "Q" Als Auswahl eines sicheren Verlassens
		default:
			System.out.println("Du hast was anderes gewählt!");
			// break;
		}
	}
	public String inputMenu() { // privat - nimmt die Usereingabe entgegen -> scanner
		var input = scanner.nextLine();
		return input;
	}
	
	// haelt die Schleife bis zum Abbruch am Leben
	public void keepAsking() {
		do {
			showMenu();
			result = inputMenu();
			checkMenu(result);
		} while (!result.equals("Q"));
	}
	
}