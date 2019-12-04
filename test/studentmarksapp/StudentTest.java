/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmarksapp;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CHawkins
 */
public class StudentTest {
    
    public StudentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isEmpty method, of class Student if no values passed to constructor.
     */
    @Test
    public void testIsEmpty(){
        Student s = new Student();
        boolean retValue = s.isEmpty();
        
        // Test should return true, because Student has not been assigned any values
        assertTrue("Student is empty", retValue);
    }
    
    /**
     * Test of isEmpty method, of class Student if First Name is set.
     */
    @Test
    public void testEmptyAfterAssigningFName(){
        Student s = new Student();
        s.setFirstName("Craig");
        boolean retValue = s.isEmpty();
        
        //Test should return false because student now has a first name
        assertFalse("Student is not empty", retValue);
        
    }
    /**
     * Test of isEmpty method, of class Student if a Surname is Set.
     */
    @Test
    public void testEmptyAfterAssigningSName(){
        Student s = new Student();
        s.setSurname("Hawkins");
        boolean retValue = s.isEmpty();
        
        //Test should return false because student now has a last name
        assertFalse("Student is not empty", retValue);
        
    }
    
    /**
     * Test of isEmpty method, of class Student a value is passed.
     */
    @Test
    public void testEmptyAfterAssigningMatricId(){
        Student s = new Student();
        s.setMatriculationId("G1007678");
        boolean retValue = s.isEmpty();
        
        //Test should return false because student now has a last name
        assertFalse("Student is not empty", retValue);
        
    }
    
    /**
     * Test of Constructor, of class Student if no values passed.
     */
    @Test
    public void testConstructor(){
        Student s = new Student();
        boolean retValue = s.isEmpty();
        
        // Test should return true, because Student has not been assigned any values
        // through its constructor
        assertTrue("Student is empty", retValue);
    } 
    
    /**
     * Test of Constructor, of class Student
     */
    @Test
    public void testConstructorWithValues(){
        Student s = new Student("Bilbo", "Baggins", "G888675");
        boolean retValue = s.isEmpty();
        
        // Test should return true, because Student has been assigned any values
        // through its constructor
        assertFalse("Student is not empty", retValue);
    } 
    
    /**
     * Test of Save method, of class Student
     */
    @Test
    public void testSaveMethodIsCalled(){
        Student s = new Student("Frodo", "Baggins", "GZ1");
        boolean retValue = s.Save();
        
        //Test should return true if Save method called
        assertTrue("Save Method succeeded", retValue);
        
        // Note, the test record wont be saved to file, as the apps finalise method
        // is not called
        
    }
    
    /**
     * Test of toString method, of class Student if empty string passed.
     */
    @Test
    public void testToString_ReturnsEmptyString(){
        System.out.println("testToString_ReturnsEmptyString");
        Student s = new Student();
        
        // Test should return true because nothing has been assigned to the student
        assertEquals(s.toString(), "");
    }
    
    /**
     * Test of toString method, of class Student.
     */
    @Test
    public void testToString(){
        System.out.println("testToString");
        Student s = new Student("Gandalf", "The Grey", "GZ2");
        String expected = "Gandalf The Grey, Matriculation No.: GZ2";
        
        // Test should return true because the expected string matches the toString() Method
        assertEquals(expected, s.toString());
    } 
    
    /**
     * Test of hashCode method, of class Student.
     */
    @Test
    public void testHashCode() {
        System.out.println("testHashCode");
        Student student = new Student("Bob","Hope","GA6");
        int expResult = 70635; //This id the generated hash code for rhe above values
        int result = student.hashCode();
        
        // Test should return true as correct Hash Code used
        assertEquals(expResult, result);
        
    }
    
    /**
     * This test follows on from the Assignment Tests. In order to test the final weighted
     * score, we need a number of assignments. Assignments will ultimately be stored on file,
     * but for the purpose of this test, will be stored in a List Object within the Student class.
     * Data will be mocked for the purpose of passing the tests
     * 
     * This is to test the user Story "The system should be able to calculate the final weighted mark 
     * based on all marks entered."
     */
    
    /**
     * Test 1. Add an assignment to a student
     */
    @Test
    public void testAddAssignment(){
        System.out.println("testAddAssignment");
        Assignment ass = new Assignment();
        Student student = new Student();
        student.addAssignment(ass);
        
        // This line of code will only be reached if the assignment is sucessfully added
        boolean success = true;
        assertTrue("Assignment added",success);
    }
    
    /**
     * Test 2. Get the Weighted Total
     * Initially just test the function is called correctly
     */
    @Test
    public void testWeightedTotal() {
        System.out.println("testAddAssignment");
        Assignment ass = new Assignment();
        Student student = new Student();
        student.addAssignment(ass);
        
        double expectedValue = 0;
        double actualValue;
        actualValue = student.calculateWeightedTotal();
        
        // Initially this should return 0, because no code has yet to be 
        // implemented to calculate the value. Will also work after code has been implemented
        // as no values assigned to the assignment
        assertEquals(expectedValue, actualValue, 0.1);
    }
    
    /**
     * Test 3. Get the Weighted Final Score
     * Test when a single assignment has been added
     */
    @Test
    public void testWeightedTotalWithValues() {
        System.out.println("testWeightedTotalWithValues");
        Assignment ass = new Assignment();
        Student student = new Student();
        ass.setCredits(10);
        ass.setMark(5);
        student.addAssignment(ass);
       
        /*
        The weighted total = 5 (mark) * 10 (credits) / 10 (sum of credits) = 5  
        */
        double expectedValue = 5;
        double actualValue;
        actualValue = student.calculateWeightedTotal();
        
        // Test succeeds if the returned result is within .1 if the expected result
        assertEquals(expectedValue, actualValue, 0.1);
    }
    
    /**
     * Test 4. Get the Weighted total Score
     * Test when multiple assignments have been added.
     * For the purpose of testing, the assignment data will be mocked
     * by adding a number of assignments manually to the student class
     */
   @Test
   public void testWeightedTotalWithMultipleValues() {
        System.out.println("testWeightedTotalWithMultipleValues");
        Student student = new Student();
        
        
        Assignment ass1 = new Assignment();
        ass1.setCredits(10);
        ass1.setMark(65);
        student.addAssignment(ass1);
        
        Assignment ass2 = new Assignment();
        ass2.setCredits(15);
        ass2.setMark(67);
        student.addAssignment(ass2);
        
        Assignment ass3 = new Assignment();
        ass3.setCredits(10);
        ass3.setMark(62);
        student.addAssignment(ass3);
        
        Assignment ass4 = new Assignment();
        ass4.setCredits(5);
        ass4.setMark(48);
        student.addAssignment(ass4);
        
        Assignment ass5 = new Assignment();
        ass5.setCredits(10);
        ass5.setMark(74);
        student.addAssignment(ass5);
        
        /** Expected value is
         *  65 * 10 = 650
         *  67 * 15 = 1005
         *  62 * 10 = 620
         *  48 * 5  = 240
         *  74 * 10 = 740
         *           -----
         *           3300
         * 
         * 3300 / Sum of Credits (50) = 65.1
         */ 
       
        double expectedValue = 65.1;
        double actualValue;
        
        actualValue = student.calculateWeightedTotal();
        
        // Test succeeds if the returned result is within .1 if the expected result
        assertEquals(expectedValue, actualValue, 0.1);
    }

    
}
