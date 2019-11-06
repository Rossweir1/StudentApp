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

    @Test
    public void testCalcAlphaNumeric_withZero(){
        int testValue = 0;
        
        // Test should return true when 0 is passed
        assertEquals(CalcDegreeANScale.CalcAlphaNumericValue(testValue), "Cannot determin. Value must be between 1 and 23");
    }
    
    @Test
    public void testCalcAlphaNumeric_WithNumberOutsideRange(){
        int testValue = 24;
        // The max value is 23;
        
        // Test should return "Value must be lower than 24" when 0 is passed
        assertEquals(CalcDegreeANScale.CalcAlphaNumericValue(testValue), "Cannot determin. Value must be between 1 and 23");
        
    }
    
}
