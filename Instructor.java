public class Instructor extends Person {
    // Constructor
    Instructor (String name, String id, String email){
        super(name, id, email);
    }

    // Overrides the abstract method
    public String getDetails(){
        return String.format(
            "Instructor %s:\nInstructor ID: %s\nEmail Address: %s",
            getName(), getId(), getEmail()
        );
    }

    // Regex implementation for instructor IDs
    protected String getIdRegex(){
        return "^I-\\d{4}$";
    }
}
