package com.blog.models;

public class User 
{
	// Attributes ;
	private int id ; 
	private String username; 
	private String password; 
	private String email;

	// Constructor ;
	public User(int id , String username , String password , String email)
	{
		this.id = id ; 
		this.username = username;
		this.password = password;
		this.email    = email;
	}
	
	// Getters ;
	public String GetUsername() {return this.username;}
	public String GetPassword() {return this.password;}
	public String Getemail() {return this.email;}
	public int GetId() {return this.id;}
	
	// Setters ;
	public void SetUsername(String Username){this.username = Username;}
	public void SetPassword(String Password){this.password = Password;}
	public void Setemail(String Email) {this.email = email;}
	public void SetID(int Id) {this.id = id;}
	
	
	

}
