package studentmarksapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//The Following import a Utility set of classes used for the purpose of 
//cretating a menu system, and creating serializable objects that can be 
//saved to file. This is courtesy of Chi, who supplied this utility
//in the first year.
import uod.gla.io.Storage;
import uod.gla.menu.MenuBuilder;
import uod.gla.menu.MenuItem;
import uod.gla.menu.Finalisable;
import uod.gla.util.Reader;

public class StudentMarksApp implements Finalisable {

    static List<Student> students = new ArrayList<>();
    static List<Lecturer> lecturers = new ArrayList<>();
    static List<Course> courses = new ArrayList<>();
    static List<Assignment> assignments = new ArrayList();
    
    static StudentMarksApp app = new StudentMarksApp(); // Required for the MenuBuilder Class

    public static void main(String[] args) {
        try {
            //Populate the Student List from storage if there is a file present
            ArrayList<Student> retrieve
                    = Storage.<ArrayList<Student>>retrieve("student database", true);
            if (retrieve != null) {
                students = retrieve;
            }
            
            //Populate the Lecturer List from storage if there is a file present
            ArrayList<Lecturer> retrieveLecturer
                    = Storage.<ArrayList<Lecturer>>retrieve("lecturer database", true);
            if (retrieveLecturer != null) {
                lecturers = retrieveLecturer;
            }
            
            // Populate the Course List from storage if there is a file present
            ArrayList<Course> retrieveCourse
                    = Storage.<ArrayList<Course>>retrieve("course database", true);
            if (retrieveCourse != null) {
                courses = retrieveCourse;
            }
            
            //Populate the Lecturer List from storage if there is a file present
            ArrayList<Assignment> retrieveAssignment
                    = Storage.<ArrayList<Assignment>>retrieve("assignment database", true);
            if (retrieveAssignment != null) {
                assignments = retrieveAssignment;
            }
            
            
            // Start Up the system
            System.out.println("Welcome to the Student Marks Application");

            //Generate the menu items        
            MenuItem a = new MenuItem("A", "Student Details", app, "studentDetails");
            MenuItem b = new MenuItem("B", "Lecturer Details", app, "lecturerDetails");
            MenuItem c = new MenuItem("C", "Course Details", app, "courseDetails");
            MenuItem d = new MenuItem("D", "Module Details", app, "moduleDetails");
            MenuItem e = new MenuItem("E", "Assignment Details", app, "assignmentDetails");
            MenuItem f = new MenuItem("F", "Alphanumeric Conversion", app, "alphaConversion");
            
            // Display the Menu, and link it to the finalise method, by using the app variable
            MenuBuilder.displayMenu(app, a, b, c, d, e, f);
            
            // On shut down, store the values in the list on file (in the storage folder)
            app.finalise();

        } catch (Exception ex) {
            System.out.println("An unexpected error has occured " + ex.getMessage() + "\n The application will close now");
        }

    }

    public static void alphaConversion(){
        // SubMenu for the Marks Conversion
        MenuItem a = new MenuItem("A", "Use the Associated Aggregate Scale", app, "enterAssoMark");
        MenuItem b = new MenuItem("B", "Use the percentage scale", app, "enterPCMark");
        MenuBuilder.displayMenuOnce("Select from the following choices", a, b);
    }
    
    public static void enterAssoMark(){
        // Get the input from the user
        int mark = Reader.readInt("Enter a mark between 1 & 23", 1, 23);
        CalcDegreeANScale calc = new CalcDegreeANScale(mark, true);
        
        String shortDesc = calc.getAbbreviatedMark();
        String longDesc = calc.getFullDesc();
        String honours = calc.getHonours();
        
        System.out.println("The Mark is classified as " + shortDesc);
        System.out.println("The Mark is described as " + longDesc);
        System.out.println("The honours class is " + honours);
    }
    
    public static void enterPCMark(){
        // Get the input from the user
        int mark = Reader.readInt("Enter a mark between 1 & 100", 1, 100);
        CalcDegreeANScale calc = new CalcDegreeANScale(mark, false);
        
        String shortDesc = calc.getAbbreviatedMark();
        String longDesc = calc.getFullDesc();
        String honours = calc.getHonours();
        
        System.out.println("The Mark is classified as " + shortDesc);
        System.out.println("The Mark is described as " + longDesc);
        System.out.println("The honours class is " + honours);
    }


    public static void studentDetails() {
        // SubMenu for Student Details
        MenuItem a = new MenuItem("A", "Add Student", app, "addStudent");
        MenuItem b = new MenuItem("B", "List Students", app, "listStudents");
        MenuItem c = new MenuItem("C", "Add all assignments to all students (Testing only)", app, "addAssignments");
        MenuItem d = new MenuItem("d", "View Student Assignments", app, "showAssignments");
        MenuItem e = new MenuItem("e", "Mark an assignment", app, "listAssignmentsToMark");
        MenuBuilder.displayMenuOnce("Select from the following choices", a, b, c, d, e);
    }
    
    // Used for test purposes to add all assignments to a student
    // In a later sprint it would be expected that an assignment would be added to 
    // a course. By being enrolled on that course, the student would inherit the assignments
    // that are part of that course
    public static void addAssignments(){
        students.forEach((stu) -> {
            stu.addAssignments();
        }); 
    }
    
    public static void addStudent() {
        //Test
        // Ask the user to input the values for a new student,
        // store in the students arrayList
        
        // Get the input from the user
        String firstName = Reader.readLine("Enter the Student's First Name");
        String surname = Reader.readLine("Enter the Student's Surname");
        String matricNo = Reader.readLine("Enter the student's Matriculation No.");

        // Create a student object
        Student student = new Student(firstName, surname, matricNo);

        // Save the student. If the save is succesful, it will return a value of true
        if (student.Save()){
            System.out.println("A new student (" + student.FullName()
                    + ") has been successfully created!");
        } else {
            System.out.println("A student with this Matriculation Number (" + student.getMatriculationId() + ")has already been entered.");
            System.out.println("Adding student abandoned");
        }

    }

    public static void listStudents() {
        
        if (students.isEmpty()) {
            System.out.println("There are no students saved to the database");
            return;
        }

        // List each student object to screen
        students.forEach((stu) -> {
            System.out.println(stu);
        });               
    }

    public static void lecturerDetails() {
        // The SubMenu for Lecturer Details
        MenuItem a = new MenuItem("A", "Add Lecturer ", app, "addLecturer");
        MenuItem b = new MenuItem("B", "List Lecturers", app, "listLecturer");
        MenuBuilder.displayMenuOnce("Select from the following choices", a, b);
    }

    public static void addLecturer() {
        //Test
        // Ask the user to input the values for a new Lecturer,
        // store in the lecturer arrayList
        
        // Get the input from the user
        String firstName = Reader.readLine("Enter the Lecturer's First Name");
        String surname = Reader.readLine("Enter the Lecturer's Surname");
        String lecturerID = Reader.readLine("Enter the Lecturer's ID no.");

        // Create a lecturer object
        Lecturer lecturer = new Lecturer(firstName, surname, lecturerID);

        // Save the lecturer. If the save is succesful, it will return a value of true
        if (lecturer.Save()){
            System.out.println("A new lecturer (" + lecturer.FullName()
                    + ") has been successfully created!");
        } else {
            System.out.println("A lecturer with this Lecturer ID (" + lecturer.getLecturerId()+ ")has already been entered.");
            System.out.println("Adding lecturer abandoned");
        }
    }

    public static void listLecturer() {
        if (lecturers.isEmpty()) {
            System.out.println("There are no lecturers saved to the database");
            return;
        }

        // List each lecturer object to screen
        lecturers.forEach((lec) -> {
            System.out.println(lec);
        });
        
    }
    
    public static void courseDetails() {
        // SubMenu for Course Details
        MenuItem a = new MenuItem("A", "Add Course", app, "addCourse");
        MenuItem b = new MenuItem("B", "List Courses", app, "listCourse");
        MenuBuilder.displayMenuOnce("Select from the following choices", a, b);
    }
    
    public static void addCourse() {
        
        // Ask the user to input the values for a new assignment,
        // store in the assignment arrayList
        
        // Get the input from the user
        String courseID = Reader.readLine("Enter the Course's ID Number");
        String courseName = Reader.readLine("Enter the Courses's Name");

        // Create a student object
        Course course = new Course(courseID, courseName);

        // Save the assignment. If the save is succesful, it will return a value of true
        if (course.Save()){
            System.out.println("A new course (" + course.getCourseName()
                    + ") has been successfully created!");
        } else {
            System.out.println("A course with this ID Number (" + course.getCourseId() + ")has already been entered.");
            System.out.println("Adding course abandoned");
        }
    }

    public static void listCourse() { 
        if (courses.isEmpty()) {
            System.out.println("There are no courses saved to the database");
            return;
        }

        // List each assignment object to screen
        courses.forEach((cou) -> {
            System.out.println(cou);
        });
        
        
    }
    
    public static void moduleDetails() {
        // SubMenu for Module Details
        MenuItem a = new MenuItem("A", "Add Module", app, "addModule");
        MenuItem b = new MenuItem("B", "List Modules", app, "listModule");
        MenuBuilder.displayMenuOnce("Select from the following choices", a, b);
    }

    public static void addModule() {
        // TODO: Replace with code to add Modules as per addStudent
        System.out.println("The menu addModule works");
    }

    public static void listMoudule() {
        // Replace with code to List Modules as per listStudents
        System.out.println("The menu listModule works");
        
    }

    public static void assignmentDetails() {
        // SubMenu for Assignment Details
        MenuItem a = new MenuItem("A", "Add Assignment", app, "addAssignment");
        MenuItem b = new MenuItem("B", "List Assignments", app, "listAssignment");
        MenuBuilder.displayMenuOnce("Select from the following choices", a, b);
    }

    public static void addAssignment() {
        // Ask the user to input the values for a new assignment,
        // store in the assignment arrayList
        
        // Get the input from the user
        String assignmentID = Reader.readLine("Enter the assignment's ID Number");
        String assignmentDesc = Reader.readLine("Enter the assignment's Description");
        int assignmentCredits = Reader.readInt("Enter the credits the assignment is worth", 0, 120);
        // Create an assignment object
        Assignment assignment = new Assignment(assignmentID, assignmentCredits, assignmentDesc);

        // Save the assignment. If the save is succesful, it will return a value of true
        if (assignment.Save()){
            System.out.println("A new assignment (" + assignment.getDescription()
                    + ") has been successfully created!");
        } else {
            System.out.println("An assignment with this ID Number (" + assignment.getId()+ ")has already been entered.");
            System.out.println("Adding course abandoned");
        }
    }

    public static void listAssignment() {
        if (assignments.isEmpty()) {
            System.out.println("There are no assignments saved to the database");
            return;
        }

        // List each assignment object to screen
        assignments.forEach((ass) -> {
            System.out.println(ass);
        });
        
    }    
    
    
    
    public void showAssignments(){
        Student student = listStudentsForAssignments();
        System.out.println("Assignments being studied...");
        String assList =  student.listAssignments();
        System.out.println(assList);
        
        double currentMark;
        currentMark = student.calculateWeightedTotal();
        String weightedMark = String.format ("%.2f", currentMark);
        
        CalcDegreeANScale honours = new CalcDegreeANScale(currentMark, false);
        
        System.out.println("");
        System.out.println(student.FullName() + " currently has a weighted average mark of " + weightedMark);
        System.out.println("");
        System.out.println(student.getFirstName() + " is on target for a " + honours.getHonours());
    }
    
    public static void listAssignmentsToMark(){
        
        Student student = listStudentsForAssignments();
        Assignment assignment = listAssignmentsForStudent(student);
        String id = assignment.getId();
        int mark = Reader.readInt("Please enter the mark for the assignment (1-100)", 1, 100);
        assignment.setMark(mark);
        
    }
    
    
    public static Assignment listAssignmentsForStudent(Student student){
        
        if (student.getAssignmentList().isEmpty()) {
            System.out.println("Search Result: No assignments found");
            return null;}
         else {
            System.out.println("Assignments...");
            return Reader.readObject("Please select an assignment to mark",
                    student.getAssignmentList().toArray(new Assignment[0]));
        }
        
    }
    
    public static Student listStudentsForAssignments(){
        List<Student> studentsFound = new ArrayList<>();
        students.forEach((student) -> {
                    studentsFound.add(student);
                });
        
        if (studentsFound.isEmpty()) {
            System.out.println("Search Result: No students found");
            return null;}
         else {
            System.out.println("Students...");
            return Reader.readObject("Please select a student",
                    studentsFound.toArray(new Student[0]));
        }
        
    }
    

    @Override
    public void finalise() {

        if (!students.isEmpty()) {
            Storage.save((Serializable) students, "student database", true);
        }

        if (!lecturers.isEmpty()) {
            Storage.save((Serializable) lecturers, "lecturer database", true);
        }   
        
        // TODO: Add methods to save the other objects
        if (!courses.isEmpty()) {
            Storage.save((Serializable) courses, "course database", true);
        } 
        
        if (!assignments.isEmpty()) {
            Storage.save((Serializable) assignments, "assignment database", true);
        }
        
        if (Storage.getException() != null) {
            System.out.print(Storage.getException().getMessage());
        }

    }

}
