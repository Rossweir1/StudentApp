/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmarksapp;

/**
 *
 * @author CHawkins
 */
public class CalcDegreeANScale {

    // May ultimately place this function in the Assignment Class,
    // but have not build that yet
    public static String CalcAlphaNumericValue(int mark) {

        String result;
        
        if (mark <= 0) {
            result = "Cannot determin. Value must be between 1 and 23";
        } else if (mark < 2) {
                result = "QF";
            } else if (mark < 5) {
                result = "BF";
            } else if (mark < 7) {
                result = "CF";
            } else if (mark == 7) {
                result = "M3"; 
            } else if (mark == 8 ) {
                result = "M2"; 
            } else if (mark == 9 ) {
                result = "M1"; 
            } else if (mark == 10 ) {
                result = "D3"; 
            } else if (mark == 11 ) {
                result = "D2"; 
            } else if (mark == 12 ) {
                result = "D1"; 
            } else if (mark == 13 ) {
                result = "C3"; 
            } else if (mark == 14 ) {
                result = "C2"; 
            } else if (mark == 15 ) {
                result = "C1"; 
            } else if (mark == 16 ) {
                result = "B3"; 
            } else if (mark == 17 ) {
                result = "B2"; 
            } else if (mark == 18 ) {
                result = "B1"; 
            } else if (mark == 19 ) {
                result = "A5"; 
            } else if (mark == 20 ) {
                result = "A4"; 
            } else if (mark == 21 ) {
                result = "A3"; 
            } else if (mark == 22 ) {
                result = "A2"; 
            } else if (mark == 23 ) {
                result = "A1"; 
            } else {
                result = "Cannot determin. Value must be between 1 and 23";
            }
        
        return result;
    }

}
