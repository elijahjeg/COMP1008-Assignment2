import java.util.ArrayList;

public class Student extends Person {
    // Declare the courses property
    private ArrayList<String> courses;

    // Constructor
    Student(String name, String id, String email){
        super(name, id, email); // Call the Person constructor with the given arguments
        courses = new ArrayList<String>(); // Initialize a new ArrayList for the courses to get added later
    }

    // Overrides the abstract method
    public String getDetails(){
        return String.format(
            "Student %s:\nStudent ID: %s\nEmail Address: %s",
            getName(), getId(), getEmail()
        );
    }

    // Regex implementation for student IDs
    protected String getIdRegex(){
        return "S-\\d{4}";
    }

    public ArrayList<String> getCourses(){
        return courses;
    }

    public void addCourse(String course){
        course = course.toUpperCase(); // So it's case insensitive
        if (!course.matches("[A-Z]{4}[0-9]{4}")){ // Ex. COMP1008
            throw new IllegalArgumentException("Invalid course code; it should follow the format: COMP1008");
        }
        // Valid course code, add it to the students courses
        courses.add(course);
    }

    // Method overloading here to either remove by course code or index
    public void removeCourse(String course){
        courses.remove(course);
    }

    public void removeCourse(int index){
        courses.remove(index);
    }

    // Get course by index
    public void getCourse(int index){
        courses.get(index);
    }
}
