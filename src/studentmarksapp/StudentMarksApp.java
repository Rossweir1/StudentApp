package studentmarksapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    static List<Course> courses = new ArrayList();
    static StudentMarksApp app = new StudentMarksApp(); // Required for the MenuBuilder Class

    public static void main(String[] args) {
        try {
            //Populate the Array List from storage if there is a file present
            ArrayList<Student> retrieve
                    = Storage.<ArrayList<Student>>retrieve("student database", true);
            if (retrieve != null) {
                students = retrieve;
            }
            
            //Populate the Array List from storage if there is a file present
            ArrayList<Lecturer> retrieveUser
                    = Storage.<ArrayList<Lecturer>>retrieve("user database", true);
            if (retrieveUser != null) {
                lecturers = retrieveUser;
            }
            
            // TODO: Create one of above for each class
                 ArrayList<Course> retrieveCourse
                    = Storage.<ArrayList<Course>>retrieve("course database", true);
            if (retrieveCourse != null) {
                courses = retrieveCourse;
            }
            
            
            
            // Start Up the system
            System.out.println("Welcome to the Student Marks Application");

            //Generate the menu items        
            MenuItem a = new MenuItem("A", "Student Details", app, "studentDetails");
            MenuItem b = new MenuItem("B", "User (Lecturer) Details", app, "userDetails");
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

    public static void studentDetails() {
        // SubMenu for Student Details
        MenuItem a = new MenuItem("A", "Add Student", app, "addStudent");
        MenuItem b = new MenuItem("B", "List Students", app, "listStudents");
        MenuBuilder.displayMenuOnce("Select from the following choices", a, b);
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

    public static void userDetails() {
        // The SubMenu for Lecturer Details
        MenuItem a = new MenuItem("A", "Add User (lecturer) ", app, "addUser");
        MenuItem b = new MenuItem("B", "List Users (Lecturers)", app, "listUser");
        MenuBuilder.displayMenuOnce("Select from the following choices", a, b);
    }

    public static void addUser() {
        // TODO: Replace with code to add Lecturer as per addStudent
        System.out.println("The menu addUser works");
    }

    public static void listUser() {
        // Replace with code to List Users as per listStudents
        System.out.println("The menu listUser works");
        
    }
    
    public static void courseDetails() {
        // SubMenu for Course Details
        MenuItem a = new MenuItem("A", "Add Course", app, "addCourse");
        MenuItem b = new MenuItem("B", "List Courses", app, "listCourse");
        MenuBuilder.displayMenuOnce("Select from the following choices", a, b);
    }
    
    public static void addCourse() {
        // TODO: Replace with code to add Course as per addStudent
        System.out.println("The menu addCourse works");
    }

    public static void listCourse() {
        // Replace with code to List Courses as per listStudents
        System.out.println("The menu listCourse works");
        
        /*
        if (courses.isEmpty()) {
            System.out.println("There are no students saved to the database");
            return;
        }

        // List each course object to screen
        Course.forEach((cou) -> {
            System.out.println(cou);
        });
        
        */
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
        // TODO: Replace with code to add Assignment as per addStudent
        System.out.println("The menu addAssignment works");
    }

    public static void listAssignment() {
        // Replace with code to List Assignment as per listStudents
        System.out.println("The menu listAssignment works");
        
    }    
    
    public static void alphaConversion(){
        String amount = Reader.readLine("Enter the Mark from 1 to 23");
        //int amountVal = amount.
        //String convertedValue = CalcDegreeANScale.CalcAlphaNumericValue(amount);
        
                
    }

    @Override
    public void finalise() {

        if (!students.isEmpty()) {
            Storage.save((Serializable) students, "student database", true);
        }

        if (!lecturers.isEmpty()) {
            Storage.save((Serializable) lecturers, "user database", true);
        }   
        
        // TODO: Add methods to save the other objects
        if (!courses.isEmpty()) {
            Storage.save((Serializable) courses, "course database", true);
        } 
        
        if (Storage.getException() != null) {
            System.out.print(Storage.getException().getMessage());
        }

    }

}
