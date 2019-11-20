/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmarksapp;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author jsoutar
 */
public class Course implements Serializable{
    // <editor-fold defaultstate="collapsed" desc="variables">

    private String courseName;
    private String courseId;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Properties">
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Course() {
    }

    public Course(String cId, String cName) {
        
        this.courseName = cName;
        
        this.courseId = cId;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methods">
    boolean isEmpty() {

        boolean retValue = false;

        if (courseName == null && courseId == null) {
            //CH: 29/10 Changed this to a null test, as more accurate than an empty string test    
            //if ("".equals(firstName) && "".equals(courseName) && "".equals(courseId)) {
            retValue = true;
        }

        return retValue;

    }

    public boolean Save() {

        if (!StudentMarksApp.courses.contains(this)) {
            StudentMarksApp.courses.add(this);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString(){

        // CH: added the test for empty returning an empty string so that could pass
        // the testToString_ReturnsEmptyString test
        if (!this.isEmpty()) {
            return "Course Id: " + courseId + ", " + courseName;
        } else {
            return "";
        }

    }

    // required for the equals
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.courseId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        // Do a simple check against the Matriulation No
        // as 2 students might have the same name, but different matric numbers
        if (obj instanceof Course) {
            final Course other = (Course) obj;
            return Objects.equals(this.courseId, other.courseId);
        } else {
            return false;
        }

    }
    // </editor-fold>
}
