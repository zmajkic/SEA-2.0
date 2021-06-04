package de.telekom.sea2.model;

public class PersonComparatorImpl implements PersonComparator {

	@Override
	public int compare(Person person1, Person person2) {
		int ergebnis = 0;

		String p1nn = person1.getLastname();
		String p2nn = person2.getLastname();
		int mini = 0;

		if (p1nn.length() > p2nn.length()) {
			mini = p2nn.length();
		} else {
			mini = p1nn.length();
		}

		for (int i = 0; i < mini; i++) {
			if (p1nn.charAt(i) == p2nn.charAt(i)) {
				ergebnis = 0;
			} else {
				if (p1nn.charAt(i) > p2nn.charAt(i)) {
					ergebnis = 1;
					return ergebnis;
				} else {
					ergebnis = -1;
					return ergebnis;
				}

			}
		}
		if (p1nn.length() != p2nn.length()) {
			if (p1nn.length() > p2nn.length()) {
				ergebnis = 1;
			} else {
				ergebnis = -1;
			}
		}
		return ergebnis;
	}

}

//person1 ist kleiner als person2: -1
//person1 ist gleich wie person2: 0
//person1 ist größer als person2: 1