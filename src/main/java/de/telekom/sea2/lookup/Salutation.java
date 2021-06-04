// **********************************
// *                                *
// * Enum für Anrede                *
// *                                *
// **********************************
package de.telekom.sea2.lookup;

public enum Salutation {

	MRS, MR, OTHER;

//	private static final String MRS_VALUE = "MRS";

	
	public static Salutation fromString(String string) {

		switch (string.toUpperCase()) {

		case "MR":
		case "MISTER":
		case "HERR":
		case "H":
		case "M":
			return MR;

		case "MRS":
		case "MS":			
		case "FRAU":
		case "F":
		case "W":
			return MRS;

		case "OTHERS":
		case "DRIVERS":
			return OTHER;
		}
		throw new IllegalArgumentException("Unexpected case!");
	}
	

	public static boolean isOk(String string) {
		switch (string.toUpperCase()) {
//		case MRS_VALUE:
		case "MRS":
		case "MISSES":
		case "FRAU":
		case "W":
		case "MR":
		case "MISTER":
		case "HERR":			
		case "M":
		case "OTHER":
		case "OTHERS":
		case "DIVERS":
		case "D":
			return true;
		default:
			return false;	// Falsche Eingabe
		}
	}
	
	
		
	public static Salutation fromByte(Byte bite) {

		switch (bite) {

		case 0:
		return MRS;

		case 1:
		return MR;

		case 2:
		return OTHER;
		}
		throw new IllegalArgumentException("Unexpected case!");
	}
	
	@Override
	public String toString () { 
		switch (this) {
		case MRS:
		return "Mrs";
		case MR:
		return "Mr";
		case OTHER:
		return "Other";
		default:
			throw new IllegalArgumentException("Unexpected case!");	// Fehlerfall wenn Daten "Manipuliert"
		}
	}

	public Byte toByte() { 
		switch (this) {
		case MRS:
		return 0;
		case MR:
		return 1;
		case OTHER:
		return 2;
		default:
			throw new IllegalArgumentException("Unexpected case!");	// Fehlerfall wenn Daten "Manipuliert"
		}
	}
	
	
}

/*
 * Salutations: Dear Sir Mrs. Ms. Mr. Other
 */
