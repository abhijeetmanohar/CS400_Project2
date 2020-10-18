import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@SuppressWarnings("unused")
public class BackEnd {
	//Create an instance of RBT
	RedBlackTree<Voter> database;
	int size;
	
	public BackEnd() {
		database = new RedBlackTree<Voter>();
		size = 0;
	}
	
	public boolean addVoter(int birthdate, String name, char party) {
		Date formattedBirthDate;
		if(createDate(birthdate) != null) {
			formattedBirthDate = createDate(birthdate);
		}else {
			return false;
		}
		
		Voter voter  = new Voter(formattedBirthDate, party, name);
		try {
			database.insert(voter);
			size++;
			return true;
		}catch(IllegalArgumentException ex) {
			return false;
		}catch(Exception ex) {
			return false;
		}	
	}
	
	public Voter getVoter(int birthdate) {
		//1. Visit each node.
		//2. Upon visiting, compare birthdates.
		//3. if same, return true;
		
		//Creating a valid date first.
		Date formattedBirthDate;
		if(createDate(birthdate) != null) {
			formattedBirthDate = createDate(birthdate);
		}else {
			formattedBirthDate = null;
		}
		//When it's incorrectly parsed. 
		if(formattedBirthDate == null)
			return null;
		
		Voter voterDetails = traverseBST(database.root, formattedBirthDate);
		return voterDetails;
	}
	

	private Voter traverseBST(RedBlackTree.Node<Voter> root, Date birthdate) {
		//1. Traverse all the way left.
		//2. Traverse root.
		//3. Traverse right.
		
		Voter foundVoter = null;
		RedBlackTree.Node<Voter> currentNode = root;
		while(currentNode != null) {
			if(currentNode.data.compareTo(new Voter(birthdate)) == 0) {
				foundVoter = currentNode.data;
			}
			else if(currentNode.data.compareTo(new Voter(birthdate)) < 0) {
				//left subtree
				currentNode = currentNode.leftChild;
			}else {
				//right subtree
				currentNode = currentNode.rightChild;
			}
		}
		return foundVoter;	
	}
	


	public int voterDBSize() {
		return size;
	}
	
	//This method creates a date format. 
	public Date createDate(int birthDate) {
		try {
		int year = birthDate/10000;
		int month = (birthDate%10000)/100;
		int date = birthDate%100;
		String formattedDate = year+"-"+month+"-"+date; //Creates a fromatted date.
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(formattedDate);
		}catch(java.text.ParseException ex) {
			return null;
		}
	}
}
