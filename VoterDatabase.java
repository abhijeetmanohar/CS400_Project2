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
    // loads a number of default books to the library
    voterDatabase = new RedBlackTree<Voter>();
    this.size = 0;
  }


  public boolean insertVoter(int birthdate, String name, char party) {
    Date formatDate;
    if (createDate(birthdate) != null) {
      formatDate = createDate(birthdate);
    } else {
      return false;
    }

    Voter voter = new Voter(formatDate, party, name);
    try {
      voterDatabase.insert(voter);
      this.size++;
      return true;
    } catch (IllegalArgumentException ex) {
      return false;
    } catch (Exception ex) {
      return false;
    }
  }

  public Voter getVoter(int birthdate) {

    // Creating a valid date first.
    Date formatDate;
    if (createDate(birthdate) != null) {
      formatDate = createDate(birthdate);
    } else {
      formatDate = null;
    }
    // When it's incorrectly parsed.
    if (formatDate == null)
      return null;

    return traverseRBT(voterDatabase.root, formatDate);
  }

  private Voter traverseRBT(RedBlackTree.Node<Voter> root, Date birthdate) {
    
    RedBlackTree.Node<Voter> currentNode = root;
    if (currentNode == null) {
      throw new NoSuchElementException("There is no voter in the database");
    }
    if (currentNode.data.compareTo(new Voter(birthdate)) == 0) {
      return currentNode.data;
    } else if (currentNode.data.compareTo(new Voter(birthdate)) > 0) {
      // left subtree
      return traverseRBT(currentNode.leftChild, birthdate);
    } else {
      // right subtree
      return traverseRBT(currentNode.rightChild, birthdate);
    }
  }

  // This method creates a date format.
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
