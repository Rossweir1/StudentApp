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
public class CalcDegreeANScaleTest {
    
    public CalcDegreeANScaleTest() {
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
     * Test of getAbbreviatedMark method, of class CalcDegreeANScale.
     */
    @Test
    public void testGetAbbreviatedMark() {
        System.out.println("getAbbreviatedMark");
        CalcDegreeANScale testObj = new CalcDegreeANScale(0, true);
        // initialising with a zero, should return an empty string
        String expResult = "";
        String result = testObj.getAbbreviatedMark();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFullDesc method, of class CalcDegreeANScale.
     */
    @Test
    public void testGetFullDesc() {
        System.out.println("getFullDesc");
        CalcDegreeANScale testObj = new CalcDegreeANScale(0, true);
        // initialising with a zero, should return an error string
        String expResult = "Cannot determin. Value must be between 1 and 23";
        String result = testObj.getFullDesc();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getHonours method, of class CalcDegreeANScale.
     */
    @Test
    public void testGetHonours() {
        System.out.println("getHonours");
        CalcDegreeANScale testObj = new CalcDegreeANScale(0, true);
        // initialising with a zero, should return an empty string
        String expResult = "";
        String result = testObj.getHonours();
        assertEquals(expResult, result);

    }
    
    @Test
    public void testGetAbbreviatedMark_withAggScale() {
        System.out.println("getAbbreviatedMark_withAggScale");
        CalcDegreeANScale testObj = new CalcDegreeANScale(9, true);
        // initialising with a mark, should return a value
        String expResult = "MF1";
        String result = testObj.getAbbreviatedMark();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFullDesc method, of class CalcDegreeANScale.
     */
    @Test
    public void testGetFullDesc_withAggScale() {
        System.out.println("getFullDesc_withAggScale");
        CalcDegreeANScale testObj = new CalcDegreeANScale(16, true);
        // initialising with a mark, should return a string
        String expResult = "Very Good";
        String result = testObj.getFullDesc();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getHonours method, of class CalcDegreeANScale.
     */
    @Test
    public void testGetHonours_withAggScale() {
        System.out.println("getHonours_withAggScale");
        CalcDegreeANScale testObj = new CalcDegreeANScale(22, true);
        // initialising with a mark, should return a string
        String expResult = "1st";
        String result = testObj.getHonours();
        assertEquals(expResult, result);

    }
    
    @Test
    public void testGetAbbreviatedMark_withPCScale() {
        System.out.println("getAbbreviatedMark_withPCScale");
        CalcDegreeANScale testObj = new CalcDegreeANScale(45, false);
        // initialising with a mark, should return a value
        String expResult = "D2";
        String result = testObj.getAbbreviatedMark();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFullDesc method, of class CalcDegreeANScale.
     */
    @Test
    public void testGetFullDesc_withPCScale() {
        System.out.println("getFullDesc_withPCScale");
        CalcDegreeANScale testObj = new CalcDegreeANScale(58, false);
        // initialising with a mark, should return a string
        String expResult = "Good";
        String result = testObj.getFullDesc();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getHonours method, of class CalcDegreeANScale.
     */
    @Test
    public void testGetHonours_withPCScale() {
        System.out.println("getHonours_withPCScale");
        CalcDegreeANScale testObj = new CalcDegreeANScale(75, false);
        // initialising with a mark, should return a string
        String expResult = "1st";
        String result = testObj.getHonours();
        assertEquals(expResult, result);

    }
}
