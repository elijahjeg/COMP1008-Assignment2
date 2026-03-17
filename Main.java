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
        while (!stop){ // Loop until stop is equal to false
            System.out.println(
                "Choose one of the following options:\n" +
                "   [1] Add a new student\n" +
                "   [2] Remove a student by ID\n" +
                "   [3] Display all students\n" +
                "   [4] Search a student by ID or name\n" +
                "   [5] Add a course to a student's courses\n" +
                "   [6] Drop a student's course\n" +
                "   [7] Quit"
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

                        // Sort the studentList alphabetically
                        boolean added = false;
                        for (int i = 0; i < studentList.size(); i++){
                            if (studentList.get(i).getName().compareTo(userStudent.getName()) > 0){ // Above zero, after alphabetically
                                studentList.add(i, userStudent);
                                added = true;
                                break;
                            }
                        }

                        if (!added)
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

                    // Don't use getStudent() here because we need the index to remove it from the list
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
                
                // Display all students
                case ("3"):
                    if (studentList.isEmpty()){
                        System.out.println("There are no student entries.");
                    }

                    else {
                         System.out.println("---------\n");
                        for (Student student : studentList){
                            System.out.println(student.getDetails());
                            System.out.println("\n---------");
                        }
                    }

                    break;

                case ("4"):
                    // Try to get the student, if the method raises an error show the message to the user
                    try {
                        Student student = getStudent(studentList, scanner);
                        System.out.println("Found student:");
                        System.out.println(student.getDetails());
                    }
                    catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                
                // Add a course
                case ("5"):
                    // Try to get the student with the helper method, if not found print to console
                    Student student;
                    try {
                        student = getStudent(studentList, scanner);
                        }
                    catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                        break; // Break so the user can confirm they have the right ID/Name
                    }
                    // Go forever until a valid course code is entered
                    while (true){
                        try {
                            System.out.print("Enter the course code: ");
                            String courseCode = scanner.nextLine().trim();
                            student.addCourse(courseCode);
                            break;
                        }
                        catch (IllegalArgumentException e){ // Course format is invalid
                            System.out.println(e.getMessage());
                        }
                    }

                    // Course successfully added
                    System.out.println(String.format("Added course to %s's list of courses.", student.getName()));
                    break;
                
                // Remove a student's course
                case ("6"):
                    // To avoid duplicate variables
                    Student studentCourseRemove;
                    try {
                        studentCourseRemove = getStudent(studentList, scanner);
                        }
                    catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                        break; // Break so the user can confirm they have the right ID/Name
                    }
                    // Go forever until a valid course code is entered
                    String courseCode;
                    boolean removed = false;
                    while (true){
                        try {
                            System.out.print("Enter the course code: ");
                            courseCode = scanner.nextLine().trim();
                            removed = studentCourseRemove.removeCourse(courseCode);
                            break;
                        }
                        catch (IllegalArgumentException e){ // Course format is invalid
                            System.out.println(e.getMessage());
                        }
                    }

                    if (removed)
                        System.out.println(String.format("Dropped %s from %s's list of courses.", courseCode, studentCourseRemove.getName()));
                    else
                        System.out.println(String.format("%s was not found in %s's list of courses.", courseCode, studentCourseRemove.getName()));

                    break;

                // Quit
                case ("7"):
                    System.out.println("Quitting...");
                    stop = true; // Set stop to true to end the while loop
                    // Close the scanner when we're done
                    scanner.close();
                    break;
                default: // If anything other than a valid option is entered let the user know
                    System.out.println("You must enter an option between 1 and 5");
            }
        }
    }


    static Student getStudent(ArrayList<Student> studentList, Scanner scanner){
            System.out.print("Enter a name or ID to search: ");
            String userInput = scanner.nextLine().trim();

            // If it's empty prompt user again until a value is provided
            while(userInput.isEmpty()){
                System.out.print("Blank value cannot be accepted. Try again: ");
                userInput = scanner.nextLine().trim();
            }

            // Loop over the list of students
            for (Student student : studentList){
                if (student.getName().equals(userInput) || student.getId().equals(userInput)){
                    return student;
                }
            }

            // If student is not found, raise an exception that will be handled in main
            throw new IllegalArgumentException("No student found with that name or ID");
    }
}