import java.util.Date;


public class Voter implements Comparable<Voter>{
	
	//3 characteristics - Unique Birthdate, Party Affiliation, name
	
	private Date birthDate;
	private char party;
	private String name;
	
	public Voter(Date birthDate, char party, String name) {
		//int birthdate  = yyyymmdd
		this.birthDate = birthDate;
		this.name = name;
		this.party = party;
	}
	
	public Voter(Date birthDate) {
		this.birthDate = birthDate;
		this.name = null;
		this.party = 'p';
	}
	
	public String toString() {
		return birthDate+name+party;
	}
	
	public Date getBirthday() {
		return birthDate;
	}
	
	public char getParty() {
		return party;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Voter o) {
		if(getBirthday().compareTo(o.getBirthday()) > 0) {
			return 1;
		}else if(this.getBirthday().compareTo(o.getBirthday()) < 0) {
			return -1;
		}else
			return 0;
	}
	
	
}
