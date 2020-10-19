// --== CS400 File Header Information ==--
// Name: Connor William Dyjach
// Email:dyjach@wisc.edu
// Team: CB
// TA: Yeping
// Lecturer: Gary Dahl
// Notes to Grader:

import static org.junit.jupiter.api.Assertions.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;

class VoterDatabaseTestSuite {

  /**
   * FOR DATA WRANGLERS: Tests the Voter class constructors and methods
   */
  @Test
  void voterTest() {
    
    Voter completeVoter = new Voter(createDate(20010725), 'D', "Connor"); //Voter(Date, char, String)
    
    // 1. Get values that the Voter was created with 
    
    if (!completeVoter.getName().equals("Connor")) {
      fail("The name that was returned did not match the name that Voter was " + "created with");
    }
    
    if (!(completeVoter.getParty() == 'D')) {
      fail("The party that was returned did not match the party that the Voter was " + "created with");
    }
    
    if (!(completeVoter.getBirthday().equals(createDate(20010725)))) {
      fail("The birthday that was returned did not match the birthday that the Voter was " + "created with");
    }
    
    Voter incompleteVoter = new Voter (createDate(20010825)); //Voter(Date)
    
    if (!(incompleteVoter.getName() == null)) {
      fail("The name that was returned did not match the name that Voter was " + "created with");
    }
    
    if (!(incompleteVoter.getParty() == 'p')) {
      fail("The party that was returned did not match the party that the Voter was " + "created with");
    }
    
    if (!(incompleteVoter.getBirthday().equals(createDate(20010825)))) {
      fail("The birthday that was returned did not match the birthday that the Voter was " + "created with");
    }

  }
  
  /*
   * FOR BACK END DEVELOPERS: Tests getVoter method, add method
   */
  @Test
  void getVoterTest() {
    // try to get an existing voter

    VoterDatabase voterDatabase = new VoterDatabase();

    Voter a = new Voter(createDate(20010725), 'D', "Connor");
    Voter b = new Voter(createDate(20010726), 'D', "Joe");
    Voter c = new Voter(createDate(20010724), 'D', "Bob");


   
    voterDatabase.insertVoter(20010726, "Joe", 'D');
    voterDatabase.insertVoter(20010725, "Connor", 'D');
    voterDatabase.insertVoter(20010724,"Bob", 'D');



    if (!(voterDatabase.getVoter(20010725).getBirthday().equals(a.getBirthday()))
        || !(voterDatabase.getVoter(20010725).getParty() == 'D')
        || !(voterDatabase.getVoter(20010725).getName().equals(a.getName()))) {
      fail(voterDatabase.getVoter(20010725).toString() + " VS " + a.toString());
    }

    try {

      voterDatabase.getVoter(19990826);

    } catch (Exception e) {

      return;
    }
    fail("cannot get a voter that DNE");

  }

  /*
   * FOR BACK END DEVELOPERS: Tests size
   */
  @Test
  void getSizeTest() {

    VoterDatabase voterDatabase = new VoterDatabase();

    if (voterDatabase.getVoterDatabaseSize() != 0) {
      fail("Size is incorrect");
    }

    voterDatabase.insertVoter(20010725, "Connor", 'D');

    if (voterDatabase.getVoterDatabaseSize() != 1) {
      fail("Size is incorrect");
    }


  }
  
  /*
   * FOR BACK END DEVELOPERS: Tests size
   */
  @Test
  void collisionTest() {
    
    VoterDatabase voterDatabase = new VoterDatabase();
    
    Voter a = new Voter(createDate(20010725), 'D', "Connor");
    Voter b = new Voter(createDate(20010725), 'D', "Connor");
    
    voterDatabase.insertVoter(20010725, "Connor", 'D');
    
    if (voterDatabase.insertVoter(20010725, "Connor", 'D')) {
      fail("The voter should NOT be added to the database");
    }
    
    
  }
  



  /*
   * This method creates a date format.
   * 
   * @Author Abhijeet Manohar
   */
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
