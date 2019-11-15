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
public class UserTest {
    
    public UserTest() {
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
        System.out.println("getLecturerId");
        Lecturer instance = new Lecturer();
        String expResult = "";
        String result = instance.getLecturerId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLecturerId method, of class Lecturer.
     */
    @Test
    public void testSetLecturerId() {
        System.out.println("setLecturerId");
        String LecturerId = "";
        Lecturer instance = new Lecturer();
        instance.setLecturerId(LecturerId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class Lecturer.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Lecturer instance = new Lecturer();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class Lecturer.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        Lecturer instance = new Lecturer();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSurname method, of class Lecturer.
     */
    @Test
    public void testGetSurname() {
        System.out.println("getSurname");
        Lecturer instance = new Lecturer();
        String expResult = "";
        String result = instance.getSurname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSurname method, of class Lecturer.
     */
    @Test
    public void testSetSurname() {
        System.out.println("setSurname");
        String surname = "";
        Lecturer instance = new Lecturer();
        instance.setSurname(surname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of FullName method, of class Lecturer.
     */
    @Test
    public void testFullName() {
        System.out.println("FullName");
        Lecturer instance = new Lecturer();
        String expResult = "";
        String result = instance.FullName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class Lecturer.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Lecturer instance = new Lecturer();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Save method, of class Lecturer.
     */
    @Test
    public void testSave() {
        System.out.println("Save");
        Lecturer instance = new Lecturer();
        boolean expResult = false;
        boolean result = instance.Save();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Lecturer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Lecturer instance = new Lecturer();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Lecturer.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Lecturer instance = new Lecturer();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Lecturer.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Lecturer instance = new Lecturer();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
