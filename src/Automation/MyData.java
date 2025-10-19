package Automation;

import java.util.Random;

public class MyData

{
	 boolean WantToSubscribe ;

	Random rand = new Random();
	
	String [] firstNames = {"Shatha" , "zainab" , "ayham" , "abdulrahman","ammar" , "sana"};
	String [] lastNames = {"mohammad","Mahmoud","ali","omar","noor","rami"};
	String domain = "@gmail.com";
	int randomNumberForTheEmail = rand.nextInt(9583);
	int randomFirstNameIndex = rand.nextInt(firstNames.length);
	int randomLastNameIndex = rand.nextInt(lastNames.length);
	
	String TheFirstName = firstNames[randomFirstNameIndex];
	String TheLastNames = lastNames[randomLastNameIndex];
	String TheEmail= TheFirstName+TheLastNames+randomNumberForTheEmail+domain;
	
	String telephoneNumber = "0792682544";
	String theFax = "232445";
	String theAdressOne = "Amman-Jordan";
	
	String LOGINNAME = TheFirstName+TheLastNames+randomNumberForTheEmail;
	String PostalCode = "374327";
	String Password = "P@$$word";
	
	int TheSelectIndex = rand.nextInt(1,10);
	
	 String ExpectedTextForSignUp = "YOUR ACCOUNT HAS BEEN CREATED!";
     String TheLogoutMsg = "You have been logged off your account. It is now safe to leave the computer.";
	 
      

}
