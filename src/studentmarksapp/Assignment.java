/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmarksapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Assignment implements Serializable{
    // <editor-fold defaultstate="collapsed" desc="variables">
    private int mark;
    private int credits;
    private String id;
    private String description;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Assignment() {
        
        
        
    }
    
    public Assignment(String id, int credits, String description) {
        this.id = id;
        this.description = description;
        this.credits = credits;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Properties">
    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methods">
    
    public int calculateWeightedScore(){
        return mark * credits;
    }
    
    public boolean Save() {

        if (!StudentMarksApp.assignments.contains(this)) {
            StudentMarksApp.assignments.add(this);
            return true;
        } else {
            return false;
        }

    }
    
    boolean isEmpty() {

        boolean retValue = false;

        if (id == null && description == null && credits == 0) {
            //CH: 29/10 Changed this to a null test, as more accurate than an empty string test    
            retValue = true;
        }

        return retValue;

    }
    
    @Override
    public String toString() { 
        
        //return firstName + " " + surname + ", Matriculation No.: " + matriculationId;
       
        // CH: added the test for empty returning an empty string so that could pass
        // the testToString_ReturnsEmptyString test
        
        String marks;
        
        if (mark == 0){
            marks = "Unmarked";
        } else {
            marks = Integer.toString(mark);
        }
        
        if (!this.isEmpty()) {
         return  "Assignment Id: " + id + ": " + description + " (" + credits + " credits), Marks: " + marks;      
        } else {
            return "";
        }

    }
    
    
    // </editor-fold>
}

        