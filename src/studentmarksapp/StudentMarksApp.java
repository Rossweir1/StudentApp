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
    static List<Course> courses = new ArrayList<>();
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
        //Test
        // Ask the user to input the values for a new course,
        // store in the course arrayList
        
        // Get the input from the user
        String courseID = Reader.readLine("Enter the Course's ID Number");
        String courseName = Reader.readLine("Enter the Courses's Name");

        // Create a student object
        Course course = new Course(courseID, courseName);

        // Save the course. If the save is succesful, it will return a value of true
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

        // List each course object to screen
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
        // TODO: Replace with code to add Assignment as per addStudent
        System.out.println("The menu addAssignment works");
    }

    public static void listAssignment() {
        // Replace with code to List Assignment as per listStudents
        System.out.println("The menu listAssignment works");
        
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
        
        if (Storage.getException() != null) {
            System.out.print(Storage.getException().getMessage());
        }

    }

}
