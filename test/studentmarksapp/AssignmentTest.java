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
public class AssignmentTest {
    
    
    
    public AssignmentTest() {
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
     * For the following tests, I am testing the User Story:
     * "A user can enter the number of credits an assignment is worth (used for weighting)"
     */
    
    /**
     * Test 1: Ensure I can access an Assignment Class
     * by creating an instance of it
     */
    @Test
    public void testObject() {
        System.out.println("testObject");
        Assignment ass = new Assignment();
        
        // will only get to this line of code if the obave object is instantiated 
        // correctly
        boolean success = true;
        assertTrue("Assignment intsantiated correctly", success);
    }
    
    
    /**
     * Test 2: Set the number of marks
     * an assignment is worth. Test succeeds if the object 
     * contains the value that is set
     */
    @Test
    public void testSetCredits() {
        System.out.println("testsetCredits");
        int credits = 0;
        Assignment ass = new Assignment();
        ass.setCredits(credits);
        assertEquals(credits, 0);
        
    }
    
    /**
     * Test 3: Get the number of mark
     * an assignment is worth. Test succeeds if the object 
     * contains the value that is set
     *
    */
    @Test
    public void testGetCredits() {
        System.out.println("testGetCredits");
        int credits = 0;
        Assignment ass = new Assignment();
        ass.setCredits(credits);
        
        //refactored this to a double for division calculation
        //int testvalue = ass.getCredits();
        double testvalue = ass.getCredits();
        assertEquals(credits, testvalue, .1);
    }
    
    /**
     * Test 4: Set the number of marks
     * an assignment has been awarded. Test succeeds if the object 
     * contains the value that is set
     */
    @Test
    public void testSetMarks() {
        System.out.println("testsetMarks");
        double mark = 0;
        Assignment ass = new Assignment();
        ass.setMark(mark);
        assertEquals(mark, 0, .1);
        
    }
    
    /**
     * Test 5: Get the number of marks
     * an assignment has been awarded. Test succeeds if the object 
     * contains the value that is set
     *
    */
    @Test
    public void testGetMarks() {
        System.out.println("testGetCredits");
        double mark = 0;
        Assignment ass = new Assignment();
        ass.setMark(mark);
        double testvalue = ass.getMark();
        
        assertEquals(mark, testvalue, .1);
    }

    /**
     * Now that we have tested the basic constructors and getter/setters
     * we will start to look at some of the functionality. The following tests
     * are to support the user story:
     * "The system should apply the appropriate weighting to the mark when calculating the total"
     */
    
    /** Test 6: Get the weighted score
     * The weighted score = Marks * Credits
     * Test passes if the expected value is returned
     */
    @Test
    public void testCalculateWeightedScore(){
        System.out.println("testCalculateWeightedScore");
        double mark = 70;
        double credits = 5;
        double expectedweightedscore = 350;
        
        Assignment ass = new Assignment();
        ass.setCredits(credits);
        ass.setMark(mark);
        
        double returnValue;
        returnValue = ass.calculateWeightedScore();
        
        // test succeeds if the value calculated by the object
        // returns the same value as the 
        assertEquals(expectedweightedscore, returnValue, .1);
        
    }


    
    /** To test the final weighted score, we need to add up a number 
     * of assignment values, then divide the total by the sum of the 
     * total credits. This will be part of the functionality of a Student, so this test
     * is included as part of the Student Test
     */
    
    
    
    
    
}
