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
public class CourseTest {
    
    public CourseTest() {
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
     * Test of IsEmpty method, of class Course.
     */
    @Test
    public void testIsEmpty(){
        System.out.println("testIsEmpty");
        Course c = new Course();
        boolean retValue = c.isEmpty();
        
        // Test should return true, because Course has not been assigned any values
        assertTrue("Course is empty", retValue);
    }
    
    /**
     * Test of IsEmpty method, if CourseId Set.
     */
    @Test
    public void testEmptyAfterCourseId(){
        Course c = new Course();
        c.setCourseId("C1");
        boolean retValue = c.isEmpty();
        
        //Test should return false because Course has an Id
        assertFalse("Course is not empty", retValue);
        
    }
    
    /**
     * Test of IsEmpty method, of class Course if Course Name is set.
     */
    @Test
    public void testEmptyAfterAssigningCourseName(){
        System.out.println("testEmptyAfterAssigningCourseName");
        Course c = new Course();
        c.setCourseName("IT Management");
        boolean retValue = c.isEmpty();
        
        //Test should return false because course has a course name
        assertFalse("Course is not empty", retValue);
        
    }
    
    
    /**
     * Test of GetCourseId of class Course.
     */
    @Test
    public void testGetCourseId() {
        System.out.println("tesrCourseId");
        Course c = new Course("C2","Engineering");
        String expResult = "C2";
        String result = c.getCourseId();
        
        // Test should return true as CourseId = C2.
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setCourseId method, of class Course.
     */
    @Test
    public void testSetCourseId() {
        System.out.println("testSetCourseId");
        String courseId = "C3";
        Course c = new Course();
        c.setCourseId(courseId);
        String expResult = "C3";
        String result = c.getCourseId();
        // Test should return true as CourseId = C2.
        assertEquals(expResult, result);
    }

    /**
     * Test of getCourseName method, of class Course.
     */
    @Test
    public void testGetCourseName() {
        System.out.println("getCourseName");
        Course course = new Course("C4", "Medicine");
        String expResult = "Medicine";
        String result = course.getCourseName();
        
        // Test should return true as CourseName = Medicine.
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setCourseName method, of class Course.
     */
    @Test
    public void testSetCourseName() {
        System.out.println("setCourseName");
        String courseName = "Biology";
        Course course = new Course();
        course.setCourseName(courseName);
        String expResult = courseName;
        String result = course.getCourseName();
        
        // Test should return true as CourseName = Medicine.
        assertEquals(expResult, result);
       
    }

    

    /**
     * Test of Save method, of class Course.
     */
    @Test
    public void testSave() {
        System.out.println("testSave");
        Course course = new Course();
        boolean expResult = true;
        boolean result = course.Save();
        
        //Test should return true if Save method called
        assertEquals(expResult, result);
        
        // Note, the test record wont be saved to file, as the apps finalise method
        // is not called
        
    }

    /**
     * Test of toString method, of class Course.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Course course = new Course("C5","Test Course");
        String expResult = "Course Id: C5, Test Course";
        String result = course.toString();
        
        // Test should pass as toString matches expected string
        assertEquals(expResult, result);
        
    }

    /**
     * Test of hashCode method, of class Course.
     */
    @Test
    public void testHashCode() {
        System.out.println("testHashCode");
        Course instance = new Course("C5","Science");
        int expResult = 2465; //This id the generated hash code for rhe above values
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of equals method, of class Course.
     */
    @Test
    public void testEquals() {
        System.out.println("testEquals");
        Course course1 = new Course("C1", "Test1");
        Course course2 = new Course("C1", "Test2");
        boolean expResult = true;
        boolean result = course1.equals(course2);
        
        //Note: this test should return true as the IsEquals method only checks to see 
        // if the CourseId Matches
        assertEquals(expResult, result);
        
    }
    
}
