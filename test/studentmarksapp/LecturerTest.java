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
public class LecturerTest {
    
    public LecturerTest() {
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
     * Test of getLecturerId method, of class Lecturer.
     */
    @Test
    public void testGetLecturerId() {
        System.out.println("testGetLecturerId");
        Lecturer lecturer = new Lecturer("Legolas","The Elf","L6");
        String expResult = "L6";
        String result = lecturer.getLecturerId();
        
        //Test should pass as Expected Result is returned
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setLecturerId method, of class Lecturer.
     */
    @Test
    public void testSetLecturerId() {
        System.out.println("testSetLecturerId");
        Lecturer lecturer = new Lecturer("Gimli","Gloin","L4");
        lecturer.setLecturerId("L5");
        
        String expResult = "L5";
        String result = lecturer.getLecturerId();
        //Test should pass as Expected Result is returned
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFirstName method, of class Lecturer.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("testGetFirstName");
        Lecturer lecturer = new Lecturer("Willy", "Wonka", "L3");
        String expResult = "Willy";
        String result = lecturer.getFirstName();
        
        // Test should pass as expected name is returned
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setFirstName method, of class Lecturer.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("testSetFirstName");
        String firstName = "Frodo";
        Lecturer lecturer = new Lecturer("Bilbo","Baggins","L7");
        lecturer.setFirstName(firstName);
        
        String expResult = firstName;
        String result = lecturer.getFirstName();
        
        // Test should pass as expected name is returned
        assertEquals(expResult, result);
    }

    /**
     * Test of getSurname method, of class Lecturer.
     */
    @Test
    public void testGetSurname() {
        System.out.println("testGetSurname");
        Lecturer lecturer = new Lecturer("Frodo","Baggins","L8");
        String expResult = "Baggins";
        String result = lecturer.getSurname();
        
        // Test should pass as expected name is returned
        assertEquals(expResult, result);
    }

    /**
     * Test of setSurname method, of class Lecturer.
     */
    @Test
    public void testSetSurname() {
        System.out.println("setSurname");
        String surname = "Skywalker";
        Lecturer lecturer = new Lecturer("Han","Solo","L9");
        lecturer.setSurname(surname);
        String expResult = surname;
        String result = lecturer.getSurname();
        
        // Test should pass as expected name is returned
        assertEquals(expResult, result);
    }

    /**
     * Test of FullName method, of class Lecturer.
     */
    @Test
    public void testFullName() {
        System.out.println("FullName");
        Lecturer lecturer = new Lecturer("Darth","Vader","L9");
        String expResult = "Darth Vader";
        String result = lecturer.FullName();
        
        // Test should pass as expected name returned
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isEmpty method, of class Lecturer.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("testIsEmpty");
        Lecturer lecturer = new Lecturer();
        boolean expResult = true;
        boolean result = lecturer.isEmpty();
        
        // Test should pass as no values passed in constructor, so should be empty
        assertEquals(expResult, result);
        
    }

    /**
     * Test of Save method, of class Lecturer.
     */
    @Test
    public void testSave() {
        System.out.println("testSave");
        Lecturer lecturer = new Lecturer();
        boolean expResult = true;
        boolean result = lecturer.Save();
        
        // Test should pass as Save returns true if called
        assertEquals(expResult, result);
        
        //Note, the record will not be saved to file as this occurs when the application exits
    }

    /**
     * Test of toString method, of class Lecturer.
     */
    @Test
    public void testToString() {
        System.out.println("testToString");
        Lecturer lecturer = new Lecturer("R2","D2","L10");
        String expResult = "R2 D2, Lecturer No.: L10";
        String result = lecturer.toString();
        
        // Test should pass as the correct String is returned
        assertEquals(expResult, result);
        
    }

    /**
     * Test of hashCode method, of class Lecturer.
     */
    @Test
    public void testHashCode() {
        System.out.println("testHashCode");
        Lecturer instance = new Lecturer("C3","PO","L11");
        int expResult = 74939;
        int result = instance.hashCode();
        
        // Test should pass as the correct Hash Code is returned 
        assertEquals(expResult, result);
        
    }

    /**
     * Test of equals method, of class Lecturer.
     */
    @Test
    public void testEquals() {
        System.out.println("testEquals");
        Lecturer lec1 = new Lecturer("Han","Solo","L1");
        Lecturer lec2 = new Lecturer("Luke","Skywalker", "L1");
        boolean expResult = true;
        boolean result = lec2.equals(lec1);
        
        //Test should pass as true, as the Equals function is based solely on
        // the lecturer id
        assertEquals(expResult, result);
        
    }
    
}
