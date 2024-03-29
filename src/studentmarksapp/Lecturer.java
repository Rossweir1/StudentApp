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
 * @author csrmc
 */
public class Lecturer implements Serializable{
    // <editor-fold defaultstate="collapsed" desc="variables">

    private String firstName;
    private String surname;
    private String LecturerId;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Properties">
    public String getLecturerId() {
        return LecturerId;
    }

    public void setLecturerId(String LecturerId) {
        this.LecturerId = LecturerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String FullName() {
        return firstName + " " + surname;
    }

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Lecturer() {
    }

    public Lecturer(String fName, String lName, String lecNo) {
        this.firstName = fName;
        this.surname = lName;
        
        this.LecturerId = lecNo;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methods">
    boolean isEmpty() {

        boolean retValue = false;

        if (firstName == null && surname == null && LecturerId == null) {
            //CH: 29/10 Changed this to a null test, as more accurate than an empty string test    
            //if ("".equals(firstName) && "".equals(surname) && "".equals(LecturerId)) {
            retValue = true;
        }

        return retValue;

    }

    public boolean Save() {

        if (!StudentMarksApp.lecturers.contains(this)) {
            StudentMarksApp.lecturers.add(this);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {

        // CH: added the test for empty returning an empty string so that could pass
        // the testToString_ReturnsEmptyString test
        if (!this.isEmpty()) {
            return firstName + " " + surname + ", Lecturer No.: " + LecturerId;
        } else {
            return "";
        }

    }

    // required for the equals
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.LecturerId);
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
        if (obj instanceof Lecturer) {
            final Lecturer other = (Lecturer) obj;
            return Objects.equals(this.LecturerId, other.LecturerId);
        } else {
            return false;
        }

    }
    // </editor-fold>
}
