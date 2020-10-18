
/**
 * This class represents an individual voter including
 * personal information about them.
 */
public class VoterRL implements Comparable<VoterRL> {
	
	private int birthday;		//YYYYMMDD
	private char party;			//D for Democrat, R for Republican, I for Independent, N for none
	private String name;		//Lastname, Firstname
	
	/**
	 * Creates a voter with all information provided
	 * @param birthday - year, month, and day of birth
	 * @param party    - political affiliation
	 * @param name     - first and last name
	 */
	public VoterRL(int birthday, char party, String name) {
		
		this.birthday = birthday;
		this.name = name;
		this.party = party;
	}
	
	/**
	 * Creates a voter using only their birthday
	 * @param birthday - year, month, and day of birth
	 */
	public VoterRL(int birthday) {
		this.birthday = birthday;
		this.name = null;
		this.party = 'N';
	}
	
	/**
	 * Accessor for voter's birthday
	 * @return int birthday
	 */
	public int getBirthday() {
		return birthday;
	}
	
	/**
	 * Accessor for voter's party
	 * @return char party
	 */
	public char getParty() {
		return party;
	}
	
	/**
	 * Accessor for voter's name
	 * @return String name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Compares voters based on their birthdays
	 * @param o - Some other Voter
	 * @return int - 1 if this voter is younger than the other,
	 * 			     -1 if this voter is older than the other,
	 * 				 and 0 if they share the same birthday
	 */
	@Override
	public int compareTo(VoterRL o) {
		if(this.getBirthday() > 0) {
			return 1;
		} else if(this.getBirthday() < 0) {
			return -1;
		} else
			return 0;
	}
	
	/**
	 * Returns a formatted version of the Voter's birthday,
	 * name, and party like so:
	 * 	20201810, LastName, FirstName, N
	 */
	@Override
	public String toString() {
		return birthday + ", " + name + ", " + party;
	}
	
}