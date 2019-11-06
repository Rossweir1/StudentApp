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

    @Test
    public void testIsEmpty(){
        Student s = new Student();
        boolean retValue = s.isEmpty();
        
        // Test should return true, because Student has not been assigned any values
        assertTrue("Student is empty", retValue);
    }
    
    @Test
    public void testEmptyAfterAssigningFName(){
        Student s = new Student();
        s.setFirstName("Craig");
        boolean retValue = s.isEmpty();
        
        //Test should return false because student now has a first name
        assertFalse("Student is not empty", retValue);
        
    }
    
    @Test
    public void testEmptyAfterAssigningSName(){
        Student s = new Student();
        s.setSurname("Hawkins");
        boolean retValue = s.isEmpty();
        
        //Test should return false because student now has a last name
        assertFalse("Student is not empty", retValue);
        
    }
    
    @Test
    public void testEmptyAfterAssigningMatricId(){
        Student s = new Student();
        s.setMatriculationId("G1007678");
        boolean retValue = s.isEmpty();
        
        //Test should return false because student now has a last name
        assertFalse("Student is not empty", retValue);
        
    }
    
    @Test
    public void testConstructor(){
        Student s = new Student();
        boolean retValue = s.isEmpty();
        
        // Test should return true, because Student has not been assigned any values
        // through its constructor
        assertTrue("Student is empty", retValue);
    } 
    
    @Test
    public void testConstructorWithValues(){
        Student s = new Student("Bilbo", "Baggins", "G888675");
        boolean retValue = s.isEmpty();
        
        // Test should return true, because Student has been assigned any values
        // through its constructor
        assertFalse("Student is not empty", retValue);
    } 
    
    @Test
    public void testSaveMethodIsCalled(){
        Student s = new Student("Frodo", "Baggins", "GZ1");
        boolean retValue = s.Save();
        
        //Test should return true if Save method called
        assertTrue("Save Method succeeded", retValue);
        
        // Note, the test record wont be saved to file, as the apps finalise method
        // is not called
        
    }
    
    @Test
    public void testToString_ReturnsEmptyString(){
        Student s = new Student();
        
        // Test should return true because nothing has been assigned to the student
        assertEquals(s.toString(), "");
    }
    
    @Test
    public void testToString(){
        Student s = new Student("Gandalf", "The Grey", "GZ2");
        String expected = "Gandalf The Grey, Matriculation No.: GZ2";
        
        // Test should return true because the expected string matches the toString() Method
        assertEquals(expected, s.toString());
    } 
    
    
}
