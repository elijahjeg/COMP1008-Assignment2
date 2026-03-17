import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main (String[] args){
        // Create a new scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Create Student and instructor objects and test polymorphism
        Person student1 = new Student("Elijah Jegede", "S-1238", "abc@gmail.com");
        Person student2 = new Student("Jane Doe", "S-6789", "email@hotmail.com");
        Person instructor = new Instructor("Alex Smith", "I-2043", "name@domain.com");

        // Test the getDetails() method
        System.out.println(student1.getDetails());
        System.out.println(student2.getDetails());
        System.out.println(instructor.getDetails());

        System.out.println("---------");
        // Create a student
        boolean stop = false;
        String name;
        String id;
        String email;
        Student userStudent;

        // Initialize an ArrayList to store student objects
        ArrayList<Student> studentList = new ArrayList<Student>();
        while (!stop){
            System.out.println(
                "Choose one of the following options:\n" +
                "   [1] Add a new student\n" +
                "   [2] Remove a student by ID\n" +
                "   [3] Display all students\n" +
                "   [4] Search a student by ID or name\n" +
                "   [5] Quit"
            );
            
            // Trim any whitespace
            String option = scanner.nextLine().trim();

            switch (option){
                // Add a new student
                case ("1"):
                    // Get user input; trim to remove any whitespace
                    System.out.print("Enter student's name: ");
                    name = scanner.nextLine().trim();

                    System.out.print("Enter student ID: ");
                    id = scanner.nextLine().trim();

                    System.out.print("Enter student's email: ");
                    email = scanner.nextLine().trim();
            
                    try {
                        userStudent = new Student(name, id, email);
                        // We got valid input, now we can display the new student and add it to the list
                        System.out.println("------------");
                        System.out.println(userStudent.getDetails());

                        studentList.add(userStudent);
                    }

                    catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                // Remove a student by ID
                case ("2"):
                    System.out.print("Enter an ID to remove: ");
                    String userId = scanner.nextLine().trim();

                     // If it's empty prompt user again until a value is provided
                    while(userId.isEmpty()){
                        System.out.print("Blank value cannot be accepted. Try again: ");
                        userId = scanner.nextLine().trim();
                    }                    

                    boolean found = false;
                    for (int i = 0; i < studentList.size(); i++){
                        Student student = studentList.get(i);
                        if (student.getId().equals(userId)){
                            studentList.remove(i);
                            System.out.println("Student successfully removed");
                            found = true;
                        }
                    }

                    if (!found){
                        System.out.println("No student found with that ID");
                    }
                    break;

                case ("4"):
                    System.out.print("Enter a name or ID to search: ");
                    String userInput = scanner.nextLine().trim();

                    // If it's empty prompt user again until a value is provided
                    while(userInput.isEmpty()){
                        System.out.print("Blank value cannot be accepted. Try again: ");
                        userInput = scanner.nextLine().trim();
                    }

                    boolean foundStudent = false;

                    // Loop over the list of students
                    for (Student student : studentList){
                        if (student.getName().equals(userInput) || student.getId().equals(userInput)){
                            System.out.println("Found student:");
                            System.out.println(student.getDetails());
                            foundStudent = true;
                            break;
                        }
                    }

                    if (!foundStudent){
                        System.out.println("No student found with that name or ID");
                    }
                    break;

                default: // If anything other than a valid option is entered let the user know
                    System.out.println("You must enter an option between 1 and 5");
            }
        }
    }
}