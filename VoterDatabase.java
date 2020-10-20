// --== CS400 File Header Information ==--
// Name: Lindsay Dyjach
// Email: ldyjach@wisc.edu
// Team: CB
// TA: Yeping
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.NoSuchElementException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VoterDatabase {
  RedBlackTree<Voter> voterDatabase;
  private int size;


  /**
   * Class constructor
   * 
   * @param none
   */
  public VoterDatabase() {
    //creates a voter database
    voterDatabase = new RedBlackTree<Voter>();
    this.size = 0;
  }

  /**
   * Inserts a voter into the database given a birthdate, name, and political party data
   * 
   * @param birthdate is an int number that is the voter's birthday
   * @param name is a String of the voter's name
   * @param party is a char value representing the voter's political party associations
   * 
   * @return true if the voter is inserted succesfully into the database, else false
   */
  public boolean insertVoter(int birthdate, String name, char party) {
    //Date object
    Date formatDate;
    if (createDate(birthdate) != null) {
      formatDate = createDate(birthdate); //formats the int birthdate into a date
    } else {
      return false;
    }

    Voter voter = new Voter(formatDate, party, name);
    
    try {
      voterDatabase.insert(voter); //inserts the voter into the database
      this.size++;
      return true;
    } catch (IllegalArgumentException ex) {
      return false;
    } catch (Exception ex) {
      return false;
    }
  }

  /**
   * Gets a voter from the database when the birthday is searched for
   * 
   * @param birthdate is an int number that is the voter's birthday

   * 
   * @return foundVoter if voter is found
   */
  public Voter getVoter(int birthdate) {

    // Creating a valid date first.
    Date formatDate;
    
    if (createDate(birthdate) != null) {
      formatDate = createDate(birthdate); // formats the int birthdate into type date
    } else {
      formatDate = null;
    }
    // When it's incorrectly parsed.
    if (formatDate == null)
      return null;
    
    try {
      traverseRBT(voterDatabase.root, formatDate);
    }
    catch(NoSuchElementException e) {
      
    }
    return traverseRBT(voterDatabase.root, formatDate); //return the voter when looking through the entire tree for it
  }

  /**
   * Traverses the voter database (red black tree) in order to find the matching node as 
   * the birthdate of the user entered when trying to get/ lookup a voter
   * 
   * @param root is the root of the RedBlackTree
   * @param birthdate is a Date object that is the voter to gets birthdate
   * 
   * @return a voter object that is the one that matches the birthdate of the given voter
   */
  private Voter traverseRBT(RedBlackTree.Node<Voter> root, Date birthdate) {
    
    RedBlackTree.Node<Voter> currentNode = root;
    //no voter in the database so none can be gotten
    if (currentNode == null) {
      throw new NoSuchElementException("There is no voter in the database");
    }
    
    // if the current node matches that of that of the birthdate, return that node
    if (currentNode.data.compareTo(new Voter(birthdate)) == 0) {
      return currentNode.data;
      
      //if the current node does not match traverse down the subtrees
      
    } else if (currentNode.data.compareTo(new Voter(birthdate)) > 0) {
      // left subtree
      return traverseRBT(currentNode.leftChild, birthdate); //recursively traverse through left subtree
    } else {
      // right subtree
      return traverseRBT(currentNode.rightChild, birthdate); //recursively traverse through right subtree
    }
  }

  /**
   * Formats the int birthdate into a date object to be stored in the voterdatabase
   * 
   * @param birthdate is the int to be stored as a date
   * 
   * @return a formatted date object representing the voter's birthday
   */
  public Date createDate(int birthDate) {
    try {
      int year = birthDate / 10000;
      int month = (birthDate % 10000) / 100;
      int date = birthDate % 100;
      String formatDate = year + "/" + month + "/" + date; // Creates a formatted date.

      SimpleDateFormat formatted = new SimpleDateFormat("yyyy/MM/dd");
      return formatted.parse(formatDate);
    } catch (java.text.ParseException ex) {
      return null;
    }
  }



  /**
   * Gets the size of the voterDatabase.
   * 
   * @param none.
   * 
   * @return how many people are in the voter database.
   */
  public int getVoterDatabaseSize() {
    return this.size;
  }
}
