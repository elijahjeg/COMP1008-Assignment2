public class Student extends Person {
    // Constructor
    Student(String name, String id, String email){
        super(name, id, email); // Call the Person constructor with the given arguments

    }

    // Overrides the abstract method
    public String getDetails(){
        return String.format(
            "Student %s:\nID: %s\nEmail Address: %s",
            getName(), getId(), getEmail()
        );
    }
}
