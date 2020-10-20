// --== CS400 File Header Information ==--
// Name: Casey Boehlke
// Email: cboehlke@wisc.edu
// Team: CB
// TA: Yeping
// Lecturer: Florian Heimerl
// Notes to Grader: None

import static org.junit.jupiter.api.Assertions.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;

class VoterDatabaseTestSuite {

  /**
   * Meant for use by Front End Developers
   * 
   * These tests are for the Voter class, specifically testing the two different constructors and
   * the getter methods.
   */
  @Test
  void voterTest() {

    // This is me, Casey Boehlke. My data will be used to test the methods.
    Voter voter = new Voter(createDate(20010117), 'D', "Casey Boehlke");

    if (!voter.getName().equals("Casey Boehlke")) {
      fail("The name returned and the name used to create the object did not match.");
    }

    if (!(voter.getParty() == 'D')) {
      fail("The party returned and the party used to create the object did not match.");
    }

    if (!(voter.getBirthday().equals(createDate(20010117)))) {
      fail("The birth date returned and the birth date used to create the pbject did not match.");
    }

    // This voter object was only given a birth date, and should have the default data specified for
    // a voter with just a birth date.
    Voter birthdayVoter = new Voter(createDate(19680615));

    if (!(birthdayVoter.getName() == null)) {
      fail("The name returned and the name used to create the object did not match.");
    }

    if (!(birthdayVoter.getParty() == 'p')) {
      fail("The party returned and the party used to create the object did not match.");
    }

    if (!(birthdayVoter.getBirthday().equals(createDate(19680615)))) {
      fail("The birth date returned and the birth date used to create the pbject did not match.");
    }

  }

  /*
   * Meant for use by Back End Developers
   * 
   * This set of tests specifically tests the getVoter method and the add method.
   */
  @Test
  void getVoterTest() {

    BackEnd testBackEnd = new BackEnd();

    // This voter is me again. My data will once again be used to test the methods.
    Voter voter = new Voter(createDate(20010117), 'D', "Casey Boehlke");


    testBackEnd.addVoter(20010117, "Casey Boehlke", 'D');


    if (!(testBackEnd.getVoter(20010117).compareTo(voter) == 0)) {
      fail("'voter' should have been returned, but was not.");
    }

    if (!(testBackEnd.getVoter(19680615) == null)) {
      fail("This voter does not exist, and thus cannot be retrieved from the database.");
    }

  }

  /*
   * Meant for use by Back End Developers
   * 
   * These simple tests specifically test the size aspect of the voter database.
   */
  @Test
  void getSizeTest() {

    BackEnd testBackEnd = new BackEnd();

    testBackEnd.addVoter(20010117, "Casey Boehlke", 'D');

    if (testBackEnd.size != 1) {
      fail("The size at this moment should be one, but it is not.");
    }

    testBackEnd.addVoter(19690420, "John Doe", 'R');
    testBackEnd.addVoter(19700521, "Jane Doe", 'R');

    if (testBackEnd.size != 3) {
      fail("The size at this moment should be three, but it is not.");
    }


  }

  /*
   * This method creates a date format.
   * 
   * @Author Abhijeet Manohar
   */
  public Date createDate(int birthDate) {
    try {
      int year = birthDate / 10000;
      int month = (birthDate % 10000) / 100;
      int date = birthDate % 100;
      String formattedDate = year + "-" + month + "-" + date; // Creates a formatted date.

      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      return sdf.parse(formattedDate);
    } catch (java.text.ParseException ex) {
      return null;
    }
  }
}
