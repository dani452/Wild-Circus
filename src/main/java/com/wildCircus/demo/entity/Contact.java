package com.wildCircus.demo.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Contact {

	 
    // Replace with your email here:  
    public static final String MY_EMAIL = "lrwaikikibeach001@gmail.com";
 
    // Replace password!!
    public static final String MY_PASSWORD = "Wildcodeschool45";
 
    // And receiver!
    public static final String FRIEND_EMAIL = "dasilva505@gmail.com";
 
    
    
    @NotBlank
    @Pattern(regexp = "[\\p{L} '-]+", message = "Enter a good firstname")
    	private String firstname;
    @NotBlank
    @Pattern(regexp = "[\\p{L} '-]+", message = "Enter a good lastname")
    	private String lastname;
    @NotBlank
    	private String evenement;
    @NotBlank
    @Pattern(regexp = "(^((\\+)33|0)[1-9](\\d{2}){4}$)", message = "Enter a good phone number")
    	private String phone;
    @NotBlank
    	private String message;
    @NotBlank
    @Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "Enter a good mail")
    	private String mail;
    	
    	
    	
    	public Contact() {
    		
    	}

	public Contact(String firstname, String lastname, String evenement, String phone, String message, String mail) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.evenement = evenement;
		this.phone = phone;
		this.message = message;
		this.mail = mail;
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

	public String getEvenement() {
		return evenement;
	}

	public void setEvenement(String evenement) {
		this.evenement = evenement;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
