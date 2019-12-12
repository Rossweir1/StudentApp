/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmarksapp;

/*
        The university has 2 marking scales, a straight percentage isAggScale, and a
        associated Aggregate isAggScale (marked between 1-23). There is an alphannueric value
        that is then applied to the mark awarded.
        This function will accept a mark, and the type of isAggScale 
        (0 = associated aggregate, 1 = percent) and return the alphanumeric value associated
        to the mark
 */

 /*
        Refactored this to change it from a static function returning a single string
        to a void method that sets both the abbreviated isAggScale value, and the full
        description, e.g "A5" = "Excellent". Now, the function is part of an object that has its own attributes
 */
public class CalcDegreeANScale {

    private double mark;
    private boolean isAggScale;
    private String abbreviatedMark;
    private String fullDesc;
    private String honours;

    // refactored this to accept a double, as this is the returned
    // value from the Student.calculateWeightedTotal function
    public CalcDegreeANScale(double mark, boolean isAggScale) {
        this.mark = mark;
        this.isAggScale = isAggScale;
        
        CalcAlphaNumericValue();
    }

    public String getAbbreviatedMark() {
        return abbreviatedMark;
    }

    public String getFullDesc() {
        return fullDesc;
    }

    public String getHonours() {
        return honours;
    }

    private void CalcAlphaNumericValue() {

        //String result;
        // refactored this s that it doesn't accept parameters, and returns a value,
        // but instead is called by the constructor, utilising the values passed
        // in upon initialisation
        // added a variable for isAggScale, to determin the type of isAggScale being used
        honours = "";
        fullDesc = "";
        abbreviatedMark = "";
        if (isAggScale) {
            if (mark <= 0) {
                //result = "Cannot determin. Value must be between 1 and 23";
           
                fullDesc = "Cannot determin. Value must be between 1 and 23";
            } else if (mark <= 2) {
                //result = "QF";
                abbreviatedMark = "BF";
                fullDesc = "Bad Fail";
            } else if (mark <= 5) {
                abbreviatedMark = "CF";
                fullDesc = "Clear Fail";
            } else if (mark <= 7) {
                abbreviatedMark = "MF3";
                fullDesc = "Marginal Fail";
            } else if (mark == 8) {
                abbreviatedMark = "MF2";
                fullDesc = "Marginal Fail";
            } else if (mark == 9) {
                abbreviatedMark = "MF1";
                fullDesc = "Marginal Fail";
            } else if (mark == 10) {
                abbreviatedMark = "D3";
                fullDesc = "Sufficient";
                honours = "3rd";
            } else if (mark == 11) {
                abbreviatedMark = "D2";
                fullDesc = "Sufficient";
                honours = "3rd";
            } else if (mark == 12) {
                abbreviatedMark = "D1";
                fullDesc = "Sufficient";
                honours = "3rd";
            } else if (mark == 13) {
                abbreviatedMark = "C3";
                fullDesc = "Good";
                honours = "2(II)";
            } else if (mark == 14) {
                abbreviatedMark = "C2";
                fullDesc = "Good";
                honours = "2(II)";
            } else if (mark == 15) {
                abbreviatedMark = "C1";
                fullDesc = "Good";
                honours = "2(II)";
            } else if (mark == 16) {
                abbreviatedMark = "B3";
                fullDesc = "Very Good";
                honours = "2(I)";
            } else if (mark == 17) {
                abbreviatedMark = "B2";
                fullDesc = "Very Good";
                honours = "2(I)";
            } else if (mark == 18) {
                abbreviatedMark = "B1";
                fullDesc = "Very Good";
                honours = "2(I)";
            } else if (mark == 19) {
                abbreviatedMark = "A5";
                fullDesc = "Excellent";
                honours = "1st";
            } else if (mark == 20) {
                abbreviatedMark = "A4";
                fullDesc = "Excellent";
                honours = "1st";
            } else if (mark == 21) {
                abbreviatedMark = "A3";
                fullDesc = "Excellent";
                honours = "1st";
            } else if (mark == 22) {
                abbreviatedMark = "A2";
                fullDesc = "Excellent";
                honours = "1st";
            } else if (mark == 23) {
                abbreviatedMark = "A1";
                fullDesc = "Excellent";
                honours = "1st";
            }
        } else if (mark <= 0) {
            //result = "Cannot determin. Value must be between 1 and 23";
            abbreviatedMark = "Cannot determin. Value must be between 1 and 23";
        } else if (mark <= 19.99) {
            //result = "QF";
            abbreviatedMark = "BF";
            fullDesc = "Bad Fail";
        } else if (mark <= 29.99) {
            abbreviatedMark = "CF";
            fullDesc = "Clear Fail";
        } else if (mark <= 33.99) {
            abbreviatedMark = "MF3";
            fullDesc = "Marginal Fail";
        } else if (mark <= 36.99) {
            abbreviatedMark = "MF2";
            fullDesc = "Marginal Fail";
        } else if (mark <= 39.99) {
            abbreviatedMark = "MF1";
            fullDesc = "Marginal Fail";
        } else if (mark <= 43.99) {
            abbreviatedMark = "D3";
            fullDesc = "Sufficient";
            honours = "3rd";
        } else if (mark <= 46.99) {
            abbreviatedMark = "D2";
            fullDesc = "Sufficient";
            honours = "3rd";
        } else if (mark <= 49.99) {
            abbreviatedMark = "D1";
            fullDesc = "Sufficient";
            honours = "3rd";
        } else if (mark <= 53.99) {
            abbreviatedMark = "C3";
            fullDesc = "Good";
            honours = "2(II)";
        } else if (mark <= 56.99) {
            abbreviatedMark = "C2";
            fullDesc = "Good";
            honours = "2(II)";
        } else if (mark <= 59.99) {
            abbreviatedMark = "C1";
            fullDesc = "Good";
            honours = "2(II)";
        } else if (mark <= 63.99) {
            abbreviatedMark = "B3";
            fullDesc = "Very Good";
            honours = "2(I)";
        } else if (mark <= 66.99) {
            abbreviatedMark = "B2";
            fullDesc = "Very Good";
            honours = "2(I)";
        } else if (mark <= 69.99) {
            abbreviatedMark = "B1";
            fullDesc = "Very Good";
            honours = "2(I)";
        } else if (mark <= 75.99) {
            abbreviatedMark = "A5";
            fullDesc = "Excellent";
            honours = "1st";
        } else if (mark <= 82.99) {
            abbreviatedMark = "A4";
            fullDesc = "Excellent";
            honours = "1st";
        } else if (mark <= 88.99) {
            abbreviatedMark = "A3";
            fullDesc = "Excellent";
            honours = "1st";
        } else if (mark <= 94.99) {
            abbreviatedMark = "A2";
            fullDesc = "Excellent";
            honours = "1st";
        } else if (mark <= 100) {
            abbreviatedMark = "A1";
            fullDesc = "Excellent";
            honours = "1st";
        }
    }

}
