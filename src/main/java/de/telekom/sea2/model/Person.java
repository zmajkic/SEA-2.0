package de.telekom.sea2.model;

import de.telekom.sea2.lookup.Salutation;

public class Person {
	
	private long id = -1;
	private Salutation salutation;
    private String firstname;
    private String lastname;
	
    
// Constructor         
	public Person(Salutation salutation, String firstname, String lastname) {
	//	this.id = id;
		this.salutation = salutation;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
// Constructor         	
	public Person(String salutation, String firstname, String lastname) {
	//	this.id = id;
		this.salutation = Salutation.fromString(salutation);
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
// Constructor    	
	public Person(long id, Salutation salutation, String firstName, String lastName) {
		this.id = id;
		this.salutation = salutation;
		this.firstname = firstName;
		this.lastname = lastName;
	}
	
// Constructor    	
	public Person(long id, String salutation, String firstName, String lastName) {
		this.id = id;
		this.salutation = Salutation.fromString(salutation);
		this.firstname = firstName;
		this.lastname = lastName;
	}
	
	
	
// Constructor         	
		public Person() {
		}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Salutation getSalutation() {
		return salutation;
	}
	public void setSalutation(Salutation salutation) {
		this.salutation = salutation;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
   
}