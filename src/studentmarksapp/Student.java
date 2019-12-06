
package studentmarksapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static studentmarksapp.StudentMarksApp.assignments;

public class Student implements Serializable {
    // <editor-fold defaultstate="collapsed" desc="variables">

    private String firstName;
    private String surname;
    private String matriculationId;
    private List<Assignment> assignmentList = new ArrayList<>();

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Properties">
    public String getMatriculationId() {
        return matriculationId;
    }

    public void setMatriculationId(String matriculationId) {
        this.matriculationId = matriculationId;
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

    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Student() {
    }

    public Student(String fName, String lName, String matNo) {
        this.firstName = fName;
        this.surname = lName;
        this.matriculationId = matNo;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methods">
    boolean isEmpty() {

        boolean retValue = false;

        if (firstName == null && surname == null && matriculationId == null) {
            //CH: 29/10 Changed this to a null test, as more accurate than an empty string test    
            //if ("".equals(firstName) && "".equals(surname) && "".equals(matriculationId)) {
            retValue = true;
        }

        return retValue;

    }

    public boolean Save() {

        if (!StudentMarksApp.students.contains(this)) {
            StudentMarksApp.students.add(this);
            return true;
        } else {
            return false;
        }

    }

    // creates a string shoing the assignments linked to the student
    // in a list format
    public String listAssignments() {
        String assigList = "";
        for (int i = 0; i < assignmentList.size(); i++) {
            Assignment ass = assignmentList.get(i);
            assigList += "\n " + ass.toString();
        }

        return assigList;
    }

    @Override
    public String toString() {

        //return firstName + " " + surname + ", Matriculation No.: " + matriculationId;
        // CH: added the test for empty returning an empty string so that could pass
        // the testToString_ReturnsEmptyString test
        if (!this.isEmpty()) {

            return firstName + " " + surname + ", Matriculation No.: " + matriculationId;
        } else {
            return "";
        }

    }

    // required for the equals
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.matriculationId);
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
        if (obj instanceof Student) {
            final Student other = (Student) obj;
            return Objects.equals(this.matriculationId, other.matriculationId);
        } else {
            return false;
        }

    }

    // adds an assignment to the Assignments List for the student
    public void addAssignment(Assignment ass) {
        this.assignmentList.add(ass);
        System.out.println("For " + this.toString() + " added: ");
        System.out.println(ass.getDescription());
    }

    /** This function creates the final weighted total for the student
     *  Within a loop, it takes each assignment object from the assignments List
     *  For each one:
     *      - Calculate the weighted total (marks * credits)
     *      - Keep a cumulative sum of credits
     *  Once Loop is complete
     *      - (Sum of weighted marks) / (Sum of credits) 
     * @return a double value
     */
    public double calculateWeightedTotal() {

        int wmarks = 0;
        int credits = 0;
        double finalValue = 0;

        // Only calculate the weighted total if the assignment has a mark
        for (int i = 0; i < assignmentList.size(); i++) {
            Assignment ass = assignmentList.get(i);
            if (ass.getMark() != 0) {
                wmarks += ass.calculateWeightedScore();
                credits += ass.getCredits();
            }

        }

        // Need to avoid a division by 0
        if (credits > 0) {
            finalValue = wmarks / credits;
        }

        return finalValue;

    }

    // Used for test purposes to add all assignments to a student
    // In a later sprint it would be expected that an assignment would be added to 
    // a course. By being enrolled on that course, the student would inherit the assignments
    // that are part of that course
    public void addAssignments() {
        if (assignments.isEmpty()) {
            System.out.println("There are no assignments saved to the database");
            return;
        }

        // List each assignment object to screen
        assignments.forEach((ass) -> {
            addAssignment(ass);

        });
    }


    // </editor-fold>
}
