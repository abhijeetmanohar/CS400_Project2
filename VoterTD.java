// --== CS400 File Header Information ==--
// Name: Timothy Eric Doughery
// Email: doughery@wisc.edu
// Team: CB
// TA: Yeping Wang
// Lecturer: Florian Heimerl
// Notes to Grader: <none>

import java.util.Scanner;
import java.util.Date;

/**
 * This class represents a voter and contains their 
 * relevant info. such as name, birth date, and 
 * party.
 * 
 * @author Tim. Eric Doughery
 */
public class VoterTD implements Comparable<VoterTD>{
	
	private String name; 			//should be last name, first name
	private Date birthDate;		//ideally should be submitted as MM/DD/YYYY
	private char party;				//'D' for democrat, 'R' for republican.
	
	/**
	 * Class constructor
	 * @param birthDate - the voter's date of birth
	 */
	public VoterTD(Date birthDate) {
		this.birthDate = birthDate;
		name = null;
		party = '0';
	}
	
	/**
	 * Class constructor
	 * 
	 * @param {String} name - represents the name of the voter.
	 * @param {int} birthDate - represents the voter's day of birth.
	 * @param {int} age - represents the voter's age.
	 * @param {char} party - represents the voter's political party.
	 */
	public VoterTD (Date birthDate, char party, String name) {
		this.birthDate = birthDate;
		
		//submits a capitalized version of the name.
		Scanner scannedName = new Scanner(name);
		String capitalizedName = "";
		String cur = "";
		while (scannedName.hasNext()) {
			cur += scannedName.next();
			capitalizedName += Character.toUpperCase(cur.charAt(0));
		}
		this.name = capitalizedName;
		scannedName.close();
		
		this.party = Character.toUpperCase(party);
	}
	
	/**
	 * Class constructor
	 * 
	 * @param {String} lName - represents the last name of the voter.
	 * @param {String} fName - represents the first name of the voter.
	 * @param {int} birthDate - represents the voter's day of birth.
	 * @param {int} age - represents the voter's age.
	 * @param {char} party - represents the voter's political party.
	 */
	public VoterTD (Date birthDate, String lName, String fName, char party) {
		this.birthDate = birthDate;
		
		//Submits a capitalized version of the name.
		String nName = lName + " " + fName;
		Scanner scannedName = new Scanner(nName);
		String capitalizedName = "";
		String cur = "";
		while (scannedName.hasNext()) {
			cur += scannedName.next();
			capitalizedName += Character.toUpperCase(cur.charAt(0));
		}
		this.name = capitalizedName;
		scannedName.close();
		
		this.party = Character.toUpperCase(party);
	}
	
	/**
	 * Retrieves and returns a voter's name.
	 * 
	 * @return the string that was submitted as the voter's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Retrieves and returns a voter's birth date
	 * 
	 * @return the integer that was submitted as the voter's day of birth.
	 */
	public Date getBirthday() {
		return birthDate;
	}
	
	/**
	 * Retrieves and returns a voter's political party.
	 * 
	 * @return the character that was submitted as the voter's party.
	 */
	public char getParty() {
		return party;
	}
	
	/**
	 * Returns a compiled list of relevant voter data.
	 * 
	 * @return a string composing of the voter's name, date of birth, and party.
	 */
	@Override
	public String toString() {
		String rString;
		rString = "Name: " + name + " Birth Date: " +  birthDate + " Party: " + party;
		return rString;
	}
	
	/**
	 * Compares the ages of two voters. If the voter parameter
	 * is older, return 1. If they're younger, return -1.
	 * If they're neither, they're the same age so return 0;
	 * 
	 * @param v - another voter object
	 * 
	 * @return an integer relating if one voter is older or younger than the other.
	 */
	public int compareTo(VoterTD v) {
		if (birthDate.compareTo(v.getBirthday()) > 0) {
			return 1;
		}
		else if (birthDate.compareTo(v.getBirthday()) < 0) {
			return -1;
		}
		return 0;
	}
}
