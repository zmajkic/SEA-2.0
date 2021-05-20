// **********************************
// *                                *
// * Enum für Anrede                *
// *                                *
// **********************************

package de.telekom.sea2.lookup;

public enum Salutation {

	MR, MRS, OTHER;

	public static Salutation fromString(String string) {

		switch (string.toUpperCase()) {

		case "MR":
		case "MISTER":
		case "HERR":
			return MR;

		case "MRS":
		case "MS":
		case "FRAU":
			return MRS;

		case "OTHERS":
		case "DRIVERS":
			return OTHER;

		}
		return null;

	}

}

/*
 * Salutations: Dear Sir Mrs. Ms. Mr. Other
 */
