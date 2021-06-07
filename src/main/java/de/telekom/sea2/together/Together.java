package de.telekom.sea2.together;

public class Together<T, U> { // T & U sind Generische-Datentypen-Platzhalter

	private T t;
	private U u;

	public boolean join(T t, U u) {
		this.t = t;
		this.u = u;
		return true;
	}

	public Together() {
	}
	
	public Together(T t, U u) {
		this.t = t;
		this.u = u;
	}

	public void testMethode() {
	Together<String, String> together = new Together<String, String>();
	together.join("Erika","Hans" ); 
	}

	@Override
	public String toString(){
		
		return String.format("%s, %s",t.toString(), u.toString() );
		//return (t.toString() + " " + u.toString());
	}
		
	public int hashCode() {
		return (t.hashCode()+u.hashCode() );
	}
	
	public boolean equals(Object obj) {
		return obj.equals(this);
 	}
	
	public boolean split() {
		this.t=null;
		this.u=null;
		return true;
 	}

	public T getT() {
		return t;
	}

	public U getU() {
		return u;
	}
}	
	
//	class - name -> Together
//	methods -> join() und split()
//	weitere Methoden: equals(), hashCode(), toString()
//	join(T t, U u)
//	boolean join(T t, U u)
//	Konstruktor: Together(T t, U u)
//	Defaultkonstruktor Together()
//	getter, setter


