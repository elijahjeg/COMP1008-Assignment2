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
        String coursesList = String.join(", ", courses); // Joins the courses list into a comma separated list
        if (coursesList.isEmpty())
            coursesList = "None";
        return String.format(
            "Student %s:\nStudent ID: %s\nEmail Address: %s\nCourses: %s",
            getName(), getId(), getEmail(), coursesList
        );
    }

    // Regex implementation for student IDs
    protected String getIdRegex(){
        return "^S-\\d{4}$";
    }

    public ArrayList<String> getCourses(){
        return courses;
    }

    public void addCourse(String course){
        course = course.toUpperCase(); // So it's case insensitive
        if (!course.matches("^[A-Z]{4}[0-9]{4}$")){ // Ex. COMP1008
            throw new IllegalArgumentException("Invalid course code; it should follow the format: COMP1008");
        }

        boolean added = false;
        // Valid course code, add it to the students courses, but sort alphabetically
        for (int i = 0; i < courses.size(); i++){
            if (courses.get(i).compareTo(course) > 0){ // Above zero, after alphabetically
                courses.add(i, course);
                added = true;
                break;
            }
        }

        // This mean its at the end alphabetically (or list is empty)
        if (!added)
            courses.add(course);
    }

    // Method overloading here to either remove by course code or index
    public boolean removeCourse(String course){
        return courses.remove(course); // Returns true if the course was in the list
    }

    public String removeCourse(int index){
        return courses.remove(index); // Returns the removed course code
    }

    // Get course by index
    public void getCourse(int index){
        courses.get(index);
    }
}
