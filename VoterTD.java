// --== CS400 File Header Information ==--
// Name: Timothy Eric Doughery
// Email: doughery@wisc.edu
// Team: CB
// TA: Yeping Wang
// Lecturer: Florian Heimerl
// Notes to Grader: <none>

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
	private Date birthDate;		//ideally should be submitted as YYYY/MM/DD
	private char party;				//'D' for democrat, 'R' for republican, 'I' for independant
	
	/**
	 * Class constructor
	 * @param birthDate - the voter's date of birth
	 */
	public VoterTD(Date birthDate) {
		this.birthDate = birthDate;
		name = null;
		party = 'n';
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
		String nName = "";
		nName += Character.toUpperCase(name.charAt(0));
		for (int i = 1; i < name.length(); i++) {
			if (name.charAt(i-1) == ' ') {
				nName += Character.toUpperCase(name.charAt(i));
			}
			else {
				nName += name.charAt(i);
			}
		}
		this.name = nName.substring(0, nName.length());
		
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
		String cName = lName + " " + fName;
		String nName = "";
		nName += Character.toUpperCase(cName.charAt(0));
		for (int i = 1; i < cName.length(); i++) {
			if (cName.charAt(i-1) == ' ') {
				nName += Character.toUpperCase(cName.charAt(i));
			}
			else {
				nName += cName.charAt(i);
			}
		}
		this.name = nName.substring(0, nName.length());
	
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
	public String getParty() {
		String partyName = "";
		switch(party) {
			case 'D':
				partyName = "Democrat";
				break;
			case 'R':
				partyName = "Republican";
				break;
			case 'I':
				partyName = "Independant";
				break;
		}
		return partyName;
	}
	
	/**
	 * Returns a compiled list of relevant voter data.
	 * 
	 * @return a string composing of the voter's name, date of birth, and party.
	 */
	
	public String toString() {
		String rString;
		rString = "Name: " + name + " Birth Date: " +  birthDate + " Party: " + getParty();
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
		if (this.getBirthday().compareTo(v.getBirthday()) > 0) {
			return 1;
		}
		else if (this.getBirthday().compareTo(v.getBirthday()) < 0) {
			return -1;
		}
		return 0;
	}
}
